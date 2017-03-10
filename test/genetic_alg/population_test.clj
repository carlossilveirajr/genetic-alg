(ns genetic-alg.population_test
  (:require [clojure.test :refer :all]
            [genetic-alg.population :refer :all]))

(deftest create-cromossome-with-size-0
  (testing "Create cromossome with size 0 should return a vector with 0 integers"
    (is (= (count (create-cromossome 0)) 0))))

(deftest create-cromossome-with-size-n
  (testing "Create cromossome with size n should return a vector with n integers"
    (is (= (count (create-cromossome 10)) 10))))

(deftest create-population-with-size-0
  (testing "Create population with size 0 should return a vector with zero cromossomes"
    (is (= (count (create-population 0)) 0))))

(deftest create-population-with-size-1-cromossome-default-size
  (testing "Create population with 1 cormossome in the default size"
    (let [pop (create-population 1)]
      (is (= (count pop) 1))
      (is (= (count (get pop 0)) default-size)))))

(deftest create-population-with-size-n-cromossome-m-size
  (testing "Create a population with n cromossomes whose size is m"
    (let [pop (create-population 10 20)]
      (is (= (count pop) 10))
      (is (= (count (get pop 0)) 20)))))
