(ns genetic-alg.core
  (:require [genetic-alg.population :refer :all]))

(def target (create-population 100 50))
(def init (create-population 100 50))

(defn -main []
  (println "hello"))
