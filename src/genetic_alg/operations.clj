(ns genetic-alg.operations
  (:require [genetic-alg.population :refer :all]))

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

(defn in-pop
  ""
  [population cromossome]
    (check-population population, cromossome, 1))

(defn acc-close-to
  ""
  [cr1 cr2]
    (>= (close-to cr1 cr2) 0.8))

(defn evolute
  ""
  [pop target pop-size cromo-size]
    (def a (remove #(-> acc-close-to target) pop))
    (conj a (create-population (- pop-size (count a)) cromo-size))
  )