(ns esunconsulting-bot.logger
  (:require [taoensso.timbre :as timbre]
            [mount.core :as mount]))

(mount/defstate ^{:on-reload :noop}
  looger-setting
  :start (timbre/merge-config!
          {:timestamp-opts
           {:timezone (java.util.TimeZone/getTimeZone "Asia/Taipei")}}))
