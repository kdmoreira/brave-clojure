(ns clojure-noob.exercism.basic-test
  (:require [clojure-noob.exercism.basic :refer :all]
            [clojure.test :refer :all]))

; EX 2 - LUCIAN LUSCIOU`S LASAGNA

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

; EX 3 - TRACKS ON TRACKS ON TRACKS

(deftest new-list-test
  (testing "Returns an empty list"
    (is (= '() (new-list)))))

(deftest add-language-test
  (testing "Adds a language to the beginning of the list"
    (is (= '("JavaScript" "Clojurescript")
           (add-language '("Clojurescript") "JavaScript")))))

(deftest first-language-test
  (testing "Returns the last added language"
    (is (= "Haskell" (first-language '("Haskell" "Python"))))))

(deftest remove-language-test
  (testing "Removes the first language from the list"
    (is (= '("Racket" "Scheme") 
           (remove-language '("Common Lisp" "Racket" "Scheme"))))))

(deftest count-languages-test
  (testing "Counts the language in the list"
    (are [count list]
         (= count (count-languages list))
      2, '("Racket" "Scheme")
      4, '("C#" "Racket" "Rust" "Ruby"))))

(deftest learning-list-test
  (testing "Creates an empty list, adds Clojure and Lisp, removes Lisp, adds
  Java and JavaScript, then finally returns a count of the total number
  of languages")
  (is (= 3 (learning-list))))