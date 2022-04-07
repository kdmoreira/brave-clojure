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

;LISTS
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