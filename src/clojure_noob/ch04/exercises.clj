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
((fn [x [y]] (+ x y)) 2 [2])
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

; LAZY SEQS
(def coords-database
  {0 {:lat 1, :long 2}
   1 {:lat 3, :long 4}})

(get coords-database 0)

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire? (map vampire-related-details social-security-numbers))))

(time (vampire-related-details 0))
(map vampire-related-details [0 1])

(time (identify-vampire (range 0 100000)))

; INFINITE SEQUENCES
(concat (take 8 (repeat "na")) ["Batman!"])

(take 3 (repeatedly (fn [] (rand-int 10))))

(cons 0 '(2 4 6))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))

; COLLECTIONS
(empty? [])
(empty? ["no!"])

(map identity [1])
(map identity {:lat 1 :long 2})

(into {} (map identity {:lat 1 :long 2}))
(into [] (map identity [1]))
(into #{} (map identity [1 1]))
(into [1] '(2 3))
(into {:lat 1} [[:long 2]]) ; => {:lat 1, :long 2}

(conj [0 [1]]) ; => [0 [1]]
(conj [0] [1]) ; => [0 [1]]
(conj [0] [1] [2]) ; => [0 [1] [2]]
(conj [0] 1 2) ; => [0 1 2]
(conj {:a 1} {:b 2}) ; => {:a 1 :b 2}
(conj {:a 1} [:b 2]) ; => {:a 1 :b 2}

(defn my-conj
  [target & additions]
  (into target additions))

(my-conj [1] 2 3 4)

; APPLY
(max 0 1 2) ; => 2

; max expects different arguments, but a vector
; is a single argument
(max [0 1 2]) ; => [0 1 2]

; apply explodes a seqable data structure
; like this vector, passing its values as arguments
(apply max [0 1 2]) ; => 2

; without apply before conj
(defn my-into-v1
  [target additions]
  (conj target additions))

(my-into-v1 [0] [1 2 3]) ; => [0 [1 2 3]]

; with apply
(defn my-into-v2
  [target additions]
  (apply conj target additions))

(my-into-v2 [0] [1 2 3]) ; => [0 1 2 3]

; PARTIAL
(defn add10-function
  [x]
  (+ x 10))
(add10-function 3)

(def add10 (partial + 10))
(add10 3) ; => 13
(add10 3 5) ; => 18

(def add-letters
  (partial conj ["a" "b" "c"]))

(add-letters "d" "e")
; => ["a" "b" "c" "d" "e"]

(defn my-partial
  [partialized-fn & args]
  (fn [& more-args]
    (apply partialized-fn (into args more-args))))

(def add20 (my-partial + 20))
(add20 3)

; logger without partial
(defn lousy-logger
  [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)))

(lousy-logger :warn "Red light ahead")

; logger with partial
(def warn (partial lousy-logger :warn))
(warn "Red light ahead")

; COMPLEMENT
(defn identify-humans-v1
  [social-security-numbers]
  (filter #(not (vampire? %))
          (map vampire-related-details social-security-numbers)))

; by using complement, it negates a boolean function
(def not-vampire? (complement vampire?))

(defn identity-humans-v2
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))

(defn my-complement
  [fun]
  (fn [& args]
    (not (apply fun args))))

(def my-pos? (complement neg?))
(my-pos? 1)
(my-pos? -1)