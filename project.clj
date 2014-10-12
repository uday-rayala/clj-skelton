(defproject clj-skelton "0.1.0-SNAPSHOT"
  :description "Skelton will provide dependencies between functions"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.analyzer.jvm "0.6.0"]]
  :plugins [[cider/cider-nrepl "0.8.0-SNAPSHOT"]]
  :main ^:skip-aot clj-skelton.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
