(ns clojure-noob.under-test.functions
  (:require [schema.core :as s]
            [schema.test :as st]))

(defn my-sum [& numbers]
  (apply + (take 2 numbers)))

(my-sum 1 1)
(my-sum 1 1 1)

(s/defn c->f
        "Celsius to Fahrenheit"
        [c :- s/Int]
        (int (+ 32 (/ (* c 9) 5))))

(s/defschema Something {:a s/Int
                        :b s/Str})
