(ns clojure-noob.ch05.exercises)
(require '[clojure.string :as s])

(defn analysis
  [text]
  (str "Character count: " (count text)))

(defn analyze-file
  [filename]
  (analysis (slurp filename)))

(def filename "resources/suspects.csv")
(analyze-file filename)

(def great-baby-name "Rosanthony")
great-baby-name ; => "Rosanthony"

(let [great-baby-name "Bloodthunder"]
  great-baby-name)
; => "Bloodthunder"

great-baby-name ; => "Rosanthony"

; RECURSION

(defn sum
  ([values] (sum values 0))
  ([values accumulator]
   (if (empty? values)
     accumulator
     (sum (rest values) (+ (first values) accumulator)))))

(sum [1 2 3 4])

; this is the recommended approach: use recur
; recur optimizes tail call
(defn sum-recur
  ([values] (sum values 0))
  ([values accumulator]
   (if (empty? values)
     accumulator
     (recur (rest values) (+ (first values) accumulator)))))

(sum-recur [1 2 3 4])

; FUNCTION COMPOSITION

; note that s stands for clojure.string, which
; appears as required in the beginning of the file
(defn clean
  [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(clean "My boa constrictor is so sassy lol!   ")

; COMP
((comp inc *) 2 3) ; => 7
((comp #(+ 6 %) *) 2 3) ; => 12

(def character
  {:name "Wall-e"
   :attributes {:intelligence 10
                :strength 5}})
(def c-int (comp :intelligence :attributes))

(c-int character) ; => 10

(int 3.2) ; => 3

; without comp
(defn spell-slots
  [char]
  (int (inc (/ (c-int char) 2))))

(spell-slots character)

; with comp, it's more readable
(def spell-slots-comp (comp int inc #(/ % 2) c-int))

(spell-slots-comp character)

(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))

((two-comp inc +) 2 2)

; MEMOIZE
(defn sleepy-identity
  "Returns the given value after 1 second"
  [x]
  (Thread/sleep 1000) x)

(sleepy-identity "Mr. Fantastico")

; the second time, the return is immediate
(def memo-sleepy-identity (memoize sleepy-identity))

(memo-sleepy-identity "Mr. Fantastico")
(memo-sleepy-identity "Mr. Fantastico")

; PegThing
(defn tri*
  "Generates a lazy sequence of triangular numbers"
  ([] (tri* 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
         (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))

(take 5 tri)

(defn triangular?
  "Is the number triangular? e.g. 1, 3, 6, 10, 15, etc"
  [n]
  (= n (last (take-while #(>= n %) tri))))

(triangular? 5)
(triangular? 6)

(defn row-tri
  "The triangular number at the end of row n"
  [n]
  (last (take n tri)))

(row-tri 1)
(row-tri 2)
(row-tri 3)

(defn row-num
  "Returns row number the position belongs to: pos 1 in row 1,
  positions 2 and 3 in row 2, etc"
  [pos]
  (inc (count (take-while #(> pos %) tri))))

(row-num 1)
(row-num 2)
(row-num 3)

(def my-map {:a {:aa 1} :b 2})
(get my-map :b)
(get-in my-map [:a :aa])

; ASSOC-IN
(assoc-in my-map [:a :aa] {:c 3}) ; => {:a {:aa {:c 3}}, :b 2}
(assoc-in my-map [:a] {:c 3}) ; => {:a {:c 3}, :b 2}

(into {:b 2} {:a 1})

(= 2 (+ 1 1)) ; => true
(not (= 2 (+ 1 1))) ; => false

(filter (fn [n] (< 5 (/ n 2))) [9 10 11])
; => (11)

; REM (remainder)
(filter #(not (= 0 (rem % 2))) [1 2 3 4])
; => (1 3)

(def my-numbers [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15])

(defn get-odd
  [numbers]
(filter #(not (= 0 (rem % 2))) numbers))

(get-odd my-numbers)

(defn get-divisible-by-n
  [numbers n]
  (filter #(= 0 (rem % n)) numbers))

(get-divisible-by-n my-numbers 3)
; => (3 6 9 12 15)

; using let
(defn odd-divisible-by-n
  [numbers n]
  (let [odd (get-odd numbers)]
    (get-divisible-by-n odd n)))

(odd-divisible-by-n my-numbers 3)
; => (3 9 15)

(defn my-odd?
  [n]
  (not (= 0 (rem n 2))))

(my-odd? 1)
(my-odd? 2)

; using comp
(defn get-divisible-by-5
  [numbers]
  (filter #(= 0 (rem % 5)) numbers))

((comp get-divisible-by-5 get-odd) my-numbers)
; => (5 15)

; SOME
(some even? [1 2 3]) ; => true
(some odd? [2 4 6]) ; => nil

; RANGE
(range 2 5) ; => (2 3 4)
(range 5) ; => (0 1 2 3 4 5)
(take 5 (range)) ; => (0 1 2 3 4)

; NTH
(nth [3 4 5 6] 2) ; => 5
(nth [0 1 2 3] 1) ; => 1

; DOSEQ
(doseq [x [1 2]
        y [1 2]]
  (println (* x y)))
; => 1 2 2 4

; READ-LINE
(def my-name (clojure.string/lower-case (clojure.string/trim (read-line))))
my-name