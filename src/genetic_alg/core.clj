(ns genetic-alg.core
  (:require [genetic-alg.population :refer :all]
            [genetic-alg.operations :refer :all]))

(def CROMOSSOME-SIZE 5)
(def POP-SIZE 4)

(def target (create-cromossome CROMOSSOME-SIZE))
(def init (create-population POP-SIZE CROMOSSOME-SIZE))

(defn -main []
  (def population init)
     (while (in-pop population target)
       (def population
         (evolute population target POP-SIZE CROMOSSOME-SIZE))
       )
     (doseq [i population] (println i))
     (println target)
  )
