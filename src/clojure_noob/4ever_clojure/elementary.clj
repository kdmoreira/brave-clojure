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

; P37
(re-seq #"[A-Z]+" "bA1B3Ce ") ; => ("A", "B" "C")
(apply str '(1 2 3)) ; => "123"

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

; P52
(let [x (+ 1 1)] x) ; => 2

(= [2 4] (let [[a b c d e f g] (range)] [c e]))

; P57
(dec 10) ; => 9
(vector (dec 10)) ; => [9]
(conj [1 2] 3 4) ; => 1 2 3 4
(conj (vector (dec 10)) 8) ; => [9 8]
(when (> 1 0) "Greater!") ; => Greater!
(when (> 0 1) "Greater!") ; => nil
(= '(5 4 3 2 1) 
   ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

; P64
(= 15 (reduce + [1 2 3 4 5]))
(= 0 (reduce + []))
(= 6 (reduce + 1 [2 3]))

; P68
(= [7 6 5 4 3] (loop [x 5 result []]
                 (if (> x 0)
                   (recur (dec x) (conj result (+ 2 x)))
                   result)))

; P71
; thread first basic example
(defn sum10
  [n]
  (+ n 10))

(defn sub5
  [n]
  (- n 5))

(def my-n 20)

(-> my-n
    sum10
    sub5) ; => 25

; solution
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] reverse rest sort last)
   5)

; P72
; thread last example
(->> [1 2 3 4 5]
     (take 3)
     (map inc)) ; => (2 3 4)

(drop 2 [1 2 3 4]) ; => (3 4)

; solution
(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
   11)

; P134
(def map-p134 {:a 1 :b 2 :c nil})
(:d map-p134) ; => nil
(:c map-p134) ; => nil
(contains? map-p134 :c) ; => true
(= nil (:c map-p134)) ; => true

(defn nil-key?
  [key map]
  (if (contains? map key)
    (= nil (key map))
    false))

(true?  (nil-key? :a {:a nil :b 2}))
(false? (nil-key? :b {:a nil :b 2}))
(false? (nil-key? :c {:a nil :b 2}))