(ns esunconsulting-bot.scheduler
  (:require [esunconsulting-bot.db        :as db]
            ;; external
            [coldnew.esunconsulting :as  esunconsulting]
            [coldnew.config :refer [conf] :as config]
            [hara.time.joda]
            [hara.io.scheduler :as sch]
            [taoensso.timbre :as timbre]
            [clojure.core.async :as async :refer [<! chan go-loop put!]]
            [morse.api :as telegram]))

(declare send-info!)
(def scheduler
  (sch/scheduler
   ;; 玉山投顧
   {:esunconsulting {:handler (fn [_ _] (send-info!))
                     :schedule (:esunconsulting/schedule conf)
                     :params nil}}))

(defn start []
  (sch/start! scheduler)
  (timbre/info "start scheduler for esunconsulting-bot"))

(defn stop []
  (sch/stop! scheduler)
  (timbre/info "stop scheduler for esunconsulting-bot"))

;; 

(def ^:private
  channel (chan))

(defn build-result-map []
  (vec (into
        (into (esunconsulting/get-report 3)
              (esunconsulting/get-report 2))
        (esunconsulting/get-report 1))))

(defn send-info! []
  (timbre/info "--> esunconsulting scheduler trigger!!!!\n")
  (doseq [data (build-result-map)]
    (put! channel data)))

(defn to-message
  [col]
  (str "<b>" (:title col) "</b>\n" (:link col)))

;; event loop
(go-loop []
  (let [{:keys [title link] :as data} (<! channel)
        token (:esunconsulting/token conf)
        chat-id (:esunconsulting/chat-id conf)]
    (timbre/info "<<<<<  " data)
    (when (not (db/esunconsulting-contains-link? link))
      (telegram/send-text token chat-id {:parse_mode "HTML"} (to-message data))
      ;; Add link to db
      (db/esunconsulting-add-link (:link data)))
    (recur)))
