(ns genetic-alg.operations)

(defn- count-identical-element
  ([cr1 cr2] (count-identical-element cr1 cr2 0))
  ([cr1 cr2 c]
      (if (= 0 (count cr1))
        c
        (let [[h1 & t1] cr1 [h2 & t2] cr2]
          (if (= h1 h2)
            (count-identical-element t1 t2 (inc c))
            (count-identical-element t1 t2 c))))))

(defn close-to
  ""
  [cr1 cr2] (if (and (empty? cr1) (empty? cr2))
              1
              (double (/ (count-identical-element cr1 cr2) (count cr1)))))

(defn check-population
  ""
  [pop cr closeness]
    (if (not-empty pop)
      (let [[c & rest] pop]
        (if (>= (close-to c cr) closeness)
          true
          (check-population rest cr closeness)))
      false))
