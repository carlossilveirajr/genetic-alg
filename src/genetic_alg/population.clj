(ns genetic-alg.population)

(def default-size 100)

(defn create-cromossome
  ""
  [number] (into []  (take number (repeatedly #(rand-int 9999)))))

(defn create-population
  ""
  ([size] (create-population size default-size))
  ([size, cromossome-size] (into [] (take size (repeatedly #(create-cromossome cromossome-size))))))
