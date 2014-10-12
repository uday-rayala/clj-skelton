(ns clj-skelton.testing)

(defn first-fn [] (println "First"))
(defn second-fn []
  (first-fn)
  (println "Second"))
