(ns clj-skelton.core
  (:require [clojure.tools.analyzer.jvm :as ana.jvm]
            [clojure.tools.analyzer.ast :as ast]
            [clojure.pprint :refer [pprint]])
  (:gen-class))

(defn with-vars [node]
  (let [children-vars (mapcat :vars (ast/children node))]
    (assoc node :vars (if (= :var (:op node))
                        (conj children-vars {:ns (get-in node [:env :ns])
                                             :name (:form node)})
                        children-vars))))


(defn analyse [ns]
  (let [root (ana.jvm/analyze-ns ns)
        defns (filter #(= :def (:op %)) root)]
    (map #(hash-map
           :ns (get-in % [:meta :env :ns])
           :name (get-in % [:name])
           :vars (get-in (ast/postwalk % with-vars) [:vars]))
         defns)))

(defn -main
  [& args]
  (pprint (analyse 'clj-skelton.testing)))
