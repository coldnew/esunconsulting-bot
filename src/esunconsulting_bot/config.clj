(ns esunconsulting-bot.config
  (:require [mount.core :refer [defstate]]
            [coldnew.config :as conf]))

(defstate env
  ;; make coldnew.config evaluate the config after load it
  :start (conf/enable-eval!))
