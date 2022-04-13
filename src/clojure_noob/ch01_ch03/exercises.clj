(ns clojure-noob.ch01-ch03.exercises)

(+ 1 1)

(* 2 5)

(- 4 3)

(+ (+ 2 2) 1)

(defn say-hello [name]
  (str "Hi, " name))

(say-hello "on the code again")

(map inc [1 2 3 4])

(reduce + [5 6 100])

(defn train
  []
  (println "Choo choo!"))

(train)

(str "It was the panda " "in the library " "whith a dust buster")

(+)

; CONTROL FLOW
(if true
  "This is a then form."
  "This is an optional else form.")

(if false
  "This if true."
  "Else if false.")

(if false
  "By Odin's Elbow!")

(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

(when true
  (println "Success!")
  "abra cadabra")

(nil? 1)

(nil? nil)

(if nil
  "Not the result"
  "nil is falsey")

(= 1 1)

(= 2 1)

(= nil nil)

; OR: first truthy value or last value
(or true "truthy string" false)
; => true

(or false nil)
; => nil

; AND: first falsey value or last truthy value
(and false nil true)
; => false

(and true "truthy string")
; => "truthy string"

; binding names to values
(def dog-names
  ["Kiara", "Meiling"])

dog-names

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))

(error-message :mild)

(+ 1/2 1/4)

(+ 1/2 1/2)

(- 1.5 0.5)

(def character-name "Uncle Hank")

(defn character-quote
  [name]
  (str "\"Hey, Buddy\" - " name))

(character-quote character-name)

; MAPS
(hash-map :number 1 :word "hello")

({:name "Karina" :surname "Moreira"} :surname)

({} :some-key)

(def basket
  {:food {:fruit "orange" :meat "chicken"} :drink "soda"})

(basket :drink)
(basket :food)

(get basket :food)
(get basket :tool "oops, not found")

; using keywords as functions
(:drink basket)

(:tool basket "not found")

(get-in basket [:food :meat])

; VECTORS
[3 2 1]

(get [3 2 1] 0)

(get [3 "a" {:name "Karina" :surname "Moreira"} false [1 2 3] nil] 2)

(vector "hello" 1 true)

; adds elements to the end of a vector
(conj [1 2 3] 4)
; => (1 2 3 4)

; LISTS
'(1 2 3 4)

(nth '(:a :b :c) 0)

(nth '(1 true :hello) 0)

(list 1 "two" {3 4})

; adds elements to the beginning of a list
(conj '(1 2 3) 4)
; => (4 1 2 3)

; SETS
#{"hello" 1 :bye}

(hash-set "hello" 1 :bye)

(hash-set 1 1 2 2)
; => #{1 2}

(conj #{:a :b} :z)

(conj #{:a :b} :b)

(set [1 1 2 2])

(contains? {:a :b} :a)
; => true

(contains? #{1 2} 3)
; => false

(:a #{:a :b})
; => :a

(get #{:a :b} :a)

(get #{1 2} 3)
; => nil

; FUNCTIONS
(first [1 2 3])

(or + -)
(or - +)

((or + -) 1 2 3)

((and (= 1 1) +) 1 2 3)
; => 6

((first [+ 0]) 1 2 3)
; => 6

(or (= 1 (+ 0 1)) (= 0 (+ 0 1)))
; => true

(and (= 1 (+ 0 1)) (= 0 (+ 0 1)))
; => false

(inc 1)

(map inc [1 2 3])

(+ (inc 2) (/ 10 (- 4 2)))
; => 8

(defn say-hi
  "Returns a greeting"
  [name]
  (str "Hello, " name "!"))

(say-hi "Karina")

; ARITY OVERLOADING
(defn operations
  ([n1]
   (str "The next number is " (inc n1)))
  ([n1 n2]
   (str "The sum of both numbers is " (+ n1 n2)))
  ([n1 n2 n3]
   (str "The sum of the first two numbers is "
        (if (= n3 (+ n1 n2))
          (str "equal to " n3 "!")
          (str "not equal to " n3 "!")))))

(operations 1)
(operations 1 2)
(operations 1 2 3)
(operations 1 2 4)

(defn animal-sounds
  "Describes animal sounds"
  ([pet sound]
   (str "The " pet " goes " sound))
  ([pet]
   (animal-sounds pet "zZzZz")))

(animal-sounds "dog" "woof")
(animal-sounds "dog")

; REST PARAMETER
(defn thing-in-basket
  [thing]
  (str thing " goes into the basket..."))

(thing-in-basket "an orange")

(defn stuff-in-basket
  [& stuff]
  (map thing-in-basket stuff))

(stuff-in-basket "an apple", "an umbrella", "a can")

(defn favorite-things
  [name & things]
  (str "Hi, I'm " name " and here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Karina" "books" "art" "films")

; DESTRUCTURING
(defn choices
  [[first second & unimportant]]
  (println (str "My first choice is " first))
  (println (str "My second choice is " second))
  (println (str "My unimportant choices are: "
                (clojure.string/join ", " unimportant))))

(choices ["pineapple" "melon" "manga" "apple"])

(defn pet-birds-v1
  [{conure :conure budgie :budgie}]
  (println (str "My conure is called " conure))
  (println (str "My budgie is called " budgie)))

(pet-birds-v1 {:conure "Duda" :budgie "Blue"})

(defn pet-birds-v2
  [{:keys [conure budgie]}]
  (println (str "My conure is called " conure))
  (println (str "My budgie is called " budgie)))

(pet-birds-v2 {:conure "Duda" :budgie "Blue"})

(def birds {:conure "Henri" :budgie "Beau" :macaw "Laila" :cockatiel "Duke"})

(defn pet-birds-v3
  [{:keys [conure budgie] :as birds}]
  (println (str "I have many birds: " birds))
  (println (str "My conure is called " conure))
  (println (str "My budgie is called " budgie)))

(pet-birds-v3 birds)

(defn number-comparison
  [x]
  (if (> x 10)
    "This number is greater than 10"
    "This is a small number"))

(number-comparison 2)

; ANONYMOUS FUNCTIONS
(map (fn [names] (str "Hi, " names))
     ["Darth Vader" "Mr. Magoo"])

((fn [x] (inc x)) 5)
((fn [x y] (+ x y)) 1 2)

(def square-multiplier (fn [x] (* x x)))
(square-multiplier 5)

#(* % 3)

(#(* % 3) 8)
; => 24

(map #(* % 2) [1 2])
(map #(str "Hello, " %) ["James" "John"])
(#(* %1 %2) 2 5)
(#(identity %&) 1 "x" :a)

; RETURNING FUNCTIONS
(defn multiplier-maker
  "Create a custom multiplier"
  [multiply-by]
  #(* % multiply-by))

(def by5 (multiplier-maker 5))

(by5 3)

; Passing functions as parameters
(defn multiply-something-by-2
  [function]
  (* 2 function))

(multiply-something-by-2 (+ 1 1))
(multiply-something-by-2 (inc 2))

; LET vs DEF
(let [x 3]
  x)

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

; global scope using DEF
(def x 0)
x ; => 0

; local scope using LET
(let [x 1] x) ; => 1
x ; => 0

(let [x (inc x)] x) ; => 1

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians]) ; => ["Pongo" ("Perdita" "Puppy 1" "Puppy 2")]

(into [] (set [:a :a])) ; => [:a]

; => let allows us to name things, thus simplifying the code
(into ["bananas"] ["apples" "oranges"])
; => ["bananas" "apples" "oranges"]

; => naming ["apples" "oranges"] vector
(let [fruit ["apples" "oranges"]]
  (into ["bananas"] fruit))
; => ["bananas" "apples" "oranges"]

; prints from 0 to 5 and prints "Goodbye!" in the end
(loop [iteration 0]
  (println "Iteration " iteration)
  (if (> iteration 4)
    (println "Goodbye!")
    (recur (inc iteration))))

; prints from 5 to 0 and finally prints "The end!"
(loop [number 5]
  (println "Number: " number)
  (if (< number 1)
    (println "The end!")
    (recur (- number 1))))

; more verbose
(defn rec-printer
  ([]
   (rec-printer 0))
  ([iteration]
   (println "Iteration" iteration)
   (if (> iteration 4)
     (println "Goodbye!")
     (rec-printer (inc iteration)))))

(rec-printer)

; REGEX
#"regular-expression"

(re-find #"^left-" "left-eye")
(re-find #"^left-" "cleft-chin")
(re-find #"some" "awesome")

(clojure.string/replace "ababa" #"a" "c")

(def dog-owner {:dog "Akita" :owner "Amanda"})

(defn owner-changer
  [entry]
  {:dog (:dog entry)
   :owner (clojure.string/replace (:owner entry) #"Amanda" "Karina")})

(owner-changer dog-owner)

; REDUCE
(+ (+ (+ 1 2) 3) 4)

(reduce + [1 2 3 4])

(reduce + 15 [1 2 3 4])
(reduce + 15 '(1 2 3 4))
(reduce + 15 #{1 2 3 4})

; EXERCISES
; EX1
(defn dog-barking
  []
  (str "Woof woof!"))
(dog-barking)

(def friends ["Mary" "David" "Anne"])
friends

(let [[employee & office-objects] '("Adam" "Pencil" "Eraser" "Pen")]
  [employee office-objects])

(def coordinates {:lat 120 :long 200})
(get coordinates :lat)

(def chosen-numbers (hash-set 1 3 1 4 5 3 4))
(contains? chosen-numbers 3)

; EX2
(defn hundred-adder
  [x]
  (+ x 100))
(hundred-adder 20)

; EX3
(defn dec-maker
  "Subtracts a given value"
  [subtraend]
  #(- % subtraend))

(def dec9 (dec-maker 9))
(dec9 10)

; EX4
(defn mapset
  [function collection]
  (into #{} (map function (set collection))))

(mapset inc [1 1 2 2])