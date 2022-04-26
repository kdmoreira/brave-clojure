(ns clojure-noob.core-test
  (:require [clojure-noob.core :refer :all]
            [clojure-noob.under-test.functions :refer [my-sum, c->f]]
            [clojure.test :refer :all]
            [schema.core :as s]
            [schema.test :as st]))

(use-fixtures :once schema.test/validate-schemas)

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(deftest test-sum
  (testing "adds numbers"
    (is (= 3 (my-sum 1 2)))
    (is (= 6 (my-sum 1 2 3)))))

(test-sum)
(test-vars [#'test-sum])
(run-tests)

(deftest test-c->f
  (is (= 32 (c->f 0.0))))

; it doesn't fail even though we are passing a double
(test-c->f)

(use-fixtures :once)

(deftest test-c->f-v2
  (s/with-fn-validation
   (is (= 32 (c->f 0.0)))))

; now the schema violation appears as [(named (not (integer? 0.0)) c)]
(test-c->f-v2)