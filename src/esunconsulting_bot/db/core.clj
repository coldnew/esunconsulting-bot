(ns esunconsulting-bot.db.core
  (:require [yesql.core   :refer [defqueries]]
            [coldnew.config :refer [conf]]))

(def conn {:classname   "org.sqlite.JDBC"
           :subprotocol "sqlite"
           :subname     (conf :database)
           :user        "esunconsulting-bot"
           :password    ""})

(defqueries "sql/queries.sql" {:connection conn})
