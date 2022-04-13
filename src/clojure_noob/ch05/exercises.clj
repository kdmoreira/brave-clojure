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