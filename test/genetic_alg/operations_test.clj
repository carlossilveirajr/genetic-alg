(ns genetic-alg.operations-test
  (:require [expectations :refer :all]
            [genetic-alg.operations :refer :all]))


;; two empty cromossome returns 1
(expect 1 (close-to [] []))

;; two non-identical cromossomes returns 0
(expect 0.0 (close-to [1] [2]))

;; half of the cromossome is identical
(expect 0.5 (close-to [1 2] [1 3]))

;; if a cromossome is close enough to target it returns true
(expect true (check-population [[1 2 3] [4 5 6]] [4 5 6] 1.0))

;; if no cromossome is close enough to target it returns false
(expect false (check-population [[1 2 3] [4 5 6]] [4 5 7] 1.0))

