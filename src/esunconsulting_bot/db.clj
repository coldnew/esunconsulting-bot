(ns esunconsulting-bot.db
  (:require [esunconsulting-bot.db.core :as core]
            [esunconsulting-bot.db.migrations :as migrations]
            [taoensso.timbre :as timbre]))

(defn esunconsulting-add-link
  [link]
  (timbre/info "add link: " link "to database: esunconsulting")
  (core/esunconsulting-create-url! {:url link}))

(defn esunconsulting-contains-link?
  [link]
  (-> (core/esunconsulting-get-url {:url link})
      first
      boolean))

(defn migrate [args]
  (migrations/migrate args))