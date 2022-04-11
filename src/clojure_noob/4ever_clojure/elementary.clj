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
; (= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}));

; P9
(= #{1 2 3 4} (conj #{1 4 3} 2))
(= #{1 2 3 4} (conj #{1 4 3} 2 2))

; P10
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

; P11
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

; P12
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

; P13
(= [20 30 40] (rest [10 20 30 40]))

; P14
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

; P15
(= ((fn doubles-number [x] (* x 2)) 2) 4)
(= ((fn [x] (* x 2)) 3) 6)
(= (#(* % 2) 11) 22)
(= ((partial * 2) 7) 14)

; P16
(= ((fn hello-world
      [name]
      (str "Hello, " name "!")) "Dave") "Hello, Dave!")
(= ((fn [name] 
      (str "Hello, " name "!")) "Jenn") "Hello, Jenn!")
(= (#(str "Hello, " % "!") "Rhea") "Hello, Rhea!")
(= ((fn [name] (apply str ["Hello, " name "!"])) "Rhea") "Hello, Rhea!")

; P17
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

; P18
(= [6 7] (filter #(> % 5) '(3 4 5 6 7)))

; P35
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

; P36
(= 10 (let [x 7, y 3, z 1] (+ x y)))
(= 4 (let  [x 7, y 3, z 1] (+ y z)))
(= 1 (let [x 7, y 3, z 1] z))