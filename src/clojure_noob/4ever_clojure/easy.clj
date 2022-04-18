(ns clojure-noob.4ever-clojure.easy)

; P19
; personal solution:
(defn my-last
  ([sequence]
   (if (empty? (rest sequence))
     (first sequence)
     (recur (rest sequence)))))

; one of the suggested solutions, nice one:
(= (reduce (fn [_ x] x) [1 2 3 4 5]) 5)

(= (my-last [1 2 3 4 5]) 5)
(= (my-last '(5 4 3)) 3)
(= (my-last ["b" "c" "d"]) "d")

; P20
(defn penultimate
  ([sequence]
   (if (= (count (rest sequence)) 1)
     (first sequence)
     (recur (rest sequence)))))

(= (penultimate [1 2 3 4 5]) 4)
(= (penultimate ["a" "b" "c"]) "b")
(= (penultimate [[1 2] [3 4]]) [1 2])

; P21
(defn nth-element [sequence nth]
  (last (take (+ nth 1) sequence)))

(= (nth-element '(4 5 6 7) 2) 6)
(= (nth-element [:a :b :c] 0) :a)
(= (nth-element [1 2 3 4] 1) 2)
(= (nth-element '([1 2] [3 4] [5 6]) 2) [5 6])

; P22
(defn count-seq [seq]
  (loop [iteration 0 sequence seq]
     (if (empty? sequence)
       iteration
       (recur (inc iteration) (rest sequence)))))

(count-seq '(1 2 3 3 1))

(= (count-seq '(1 2 3 3 1)) 5)
(= (count-seq "Hello World") 11)
(= (count-seq [[1 2] [3 4] [5 6]]) 3)
(= (count-seq '(13)) 1)
(= (count-seq '(:a :b :c)) 3)