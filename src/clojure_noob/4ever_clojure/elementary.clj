(ns clojure-noob.4ever-clojure.elementary)

; P1
(= true true)

; P2
(= (- 10 (* 2 3)) 4)

; P3
(= "HELLO WORLD" (.toUpperCase "hello world"))

; P4
(= (list :a :b :c) '(:a :b :c))

; P5
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

; P6
(= [:a :b :c] (list :a :b :c) 
   (vec '(:a :b :c)) (vector :a :b :c))

; P7
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

; P8
(= (set '(:a :b :c :d)) (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

; P9
(= #{1 2 3 4} (conj #{1 4 3} 2))
(= #{1 2 3 4} (conj #{1 4 3} 2 2))

; P10
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))