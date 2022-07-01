(ns clojure-noob.exercism.basic-test
  (:require [clojure-noob.exercism.basic :refer :all]
            [clojure.test :refer :all]))

(deftest expected-time-test
  (testing "returns the expected time which is 40"
    (is (= 40 expected-time))))

(deftest remaining-time-test
  (testing "returns remaining minutes according to actual time"
    (are [actual-time remaining] (= remaining (remaining-time actual-time))
      0, 40
      10, 30
      40, 0)))

(deftest prep-time-test
  (testing "returns how many minutes according to n of layers"
    (are [layers time] (= time (prep-time layers))
      0, 0
      1, 2
      2, 4)))

(deftest total-time-test
  (testing "returns the time spent working in the lasagna (remaining + prep time)"
    (are [num-layers actual-time total] 
         (= total (total-time num-layers actual-time))
      1, 0, 2
      2, 10, 14
      3, 40, 46)))