(ns clojure-noob.ch04.exercises)

(map inc [1 2 3 4])
(map #(+ % 2) '(1 2 3 4))
(map #(str %) {:a 1 :b 2 :c 3})
(set (map inc [1 1 2 3 4]))

(def transformed-list (map #(+ % 2) '(1 2 3 4)))
transformed-list

(map #(println %) [1 2 3 4])

(defn titleize
  [topic]
  (str topic " for the Brave and True"))

(map titleize ["Puppies", "Kittens"])
(map titleize '("Puppies", "Kittens"))
(map #(titleize (second %)) 
     {:something "Paradise" :else "Hawaii"})

; SEQ
(seq '(1 2 3))
(seq [1 2 3])
(seq #{1 2 3})
(seq {:n1 1 :n2 2 :n3 3})

(into {} (seq {:a 1 :b 2 :c 3}))

; MAP
(map inc [1 2 3])
(map str ["a" "b" "c"] ["A" "B" "C"])
(map #(+ %1 %2) [1 2 3] [4 5 6])

(def hours-reading [1.0 1.5 0.5])
(def hours-watching-films [0.0 0.5 1.0])
(defn hours-entertainment
  [reading films]
  {:reading reading
   :films films})

(map hours-entertainment hours-reading hours-watching-films)

(defn total-hours-entertainment
  [reading films]
  (+ reading films))

(map total-hours-entertainment hours-reading hours-watching-films)

(def sum #(reduce + %))

(def avg #(/ (sum %) (count %)))

(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [1 2 3])
(stats [5 2 7 10])

(def people
  [{:name "Thomas" :nickname "Tommy"}
   {:name "James" :nickname "Jimmy"}
   {:name "William" :nickname "Billy"}])

(map #(:nickname %) people)

; ASSOC
; Takes a map and derives a new one
; by associating a given key to a given value
(assoc {:lat 1 :long 2} :lat 0)
; => {:lat 0 :long 2}

(assoc {:lat 1 :long 2} :lat (inc 3))
; => {:lat 4 :long 2}

(def coord {:lat 1 :long 2})
(assoc coord :lat (+ (get coord :lat) 3))
; => {:lat 4 :long 2}

(assoc {} :lat 1)
; => {:lat 1}

(assoc (assoc {} :lat 1) :long 2)
; => {:lat 1 :long 2}

((fn [x] (+ x 2)) 2)
((fn [x [y]] (+ x y)) 2[2])
((fn [x y] (+ x y)) 2 2)
; => 4

(defn coord-func [coord key]
  (assoc coord key (inc 3)))

(coord-func coord :lat)
; => {:lat 4 :long 2}

; REDUCE
(reduce + [1 2 3])
(reduce - [1 2 3])
(reduce str [1 2 3])

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})
; => {:max 31, :min 11}

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 4.1
         :critter 3.9})
; => {:human 4.1}

;TAKE, DROP, TAKE-WHILE, DROP-WHILE
(take 3 '(1 2 3 4 5))
(take 0 [1 2 3])

(drop 3 [1 2 3 4 5])
(drop 2 {:a 1 :b 2 :c 3})

(def hours-watching-tv
  [{:month 1 :day 1 :hours 4.5}
  {:month 1 :day 2 :hours 3}
  {:month 1 :day 3 :hours 1.5}
  {:month 1 :day 4 :hours 4}])

; using maps
(take-while #(> (:hours %) 2) hours-watching-tv)

(take-while #(< % 3) [1 2 3 4 5])
; => (1 2)

; returns the result as soon as the predicate is evaluated to false
(take-while #(= (+ % 1) 5) '(4 4 1 4 2))
; => (4 4)

; drops what evaluates as true and as soon as false
; is reached, it takes all the rest and returns it
(drop-while #(< % 3) [1 2 3 4 5 1 2])
; => (3 4 5 1 2)

; suppose you want to take numbers 3 and 4 only
(def take-drop-numbers [1 2 3 4 5])
(drop-while #(< % 3) take-drop-numbers) ; => (3 4 5)
(take-while #(< % 5) take-drop-numbers) ; => (1 2 3 4)

; by combining both, the innermost function returns (3 4 5), which
; is passed to the outermost function, that gets rid of (5)
(take-while #(< % 5) (drop-while #(< % 3) take-drop-numbers)) ; => (3 4)

; FILTER and SOME
(filter #(> (:hours %) 3) hours-watching-tv)

(filter #(< % 5) (filter #(> % 2) take-drop-numbers)) ; => (3 4)

(some #(> % 5) take-drop-numbers) ; => nil
(some #(< % 2) take-drop-numbers) ; => true

; this construction returns the first truthy valued encountered by the filter
(some #(and (> (:hours %) 4) %) hours-watching-tv)

; SORT and SORT-BY
(sort [3 2 1]) ; => (1 2 3)

(sort-by count ["aaa" "c" "bb"])
; => ("c" "bb" "aaa")

(sort ["aaa" "c" "bb"])
; => ("aaa" "bb" "c")

(sort-by - [3 4 5 1 2]) ; => (5 4 3 2 1)
(sort-by + [3 4 5 1 2]) ; => (1 2 3 4 5)

(concat [1 2] [3 4 5])
(concat (vector 1 2) [3 4 5])
(concat '(1 2) [3 4 5])
; => (1 2 3 4 5)