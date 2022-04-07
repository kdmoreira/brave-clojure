(ns clojure-noob.ch01-ch03.exercises)

(+ 1 1)

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