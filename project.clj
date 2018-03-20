(defproject esunconsulting-bot "0.1.0"
  :description "A bot to fetch esunconsulting link and set to telegram group"
  :url "https://github.com/coldnew/esunconsulting-bot"
  :license {:name "GNU Affero General Public License 3.0 (AGPL-3.0)"
            :url "https://www.gnu.org/licenses/agpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [coldnew/esunconsulting "0.1.0"]
                 [morse "0.4.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [migratus "1.0.6"]
                 [im.chit/hara.io.scheduler "2.5.10"]
                 [im.chit/hara.time.joda "2.2.17"]
                 [mount "0.1.12"]
                 [yesql "0.5.3"]
                 [coldnew/config "1.2.0"]
                 [org.clojure/core.async "0.4.474"]
                 [org.xerial/sqlite-jdbc "3.21.0.1"]]

  :plugins [[migratus-lein "0.2.6"]]

  :jvm-opts ["-Dclojure.compiler.direct-linking=true"]

  :migratus {:store :database}

  :profiles {:uberjar {:aot :all}}

  :main ^:skip-aot esunconsulting-bot.core)
