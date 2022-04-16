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