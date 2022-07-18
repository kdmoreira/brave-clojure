(ns clojure-noob.exercism.basic)

; Lucian's Luscious Lasagna

;; 👋🏽 Hi there! Welcome to the Clojure Track.
;; The online test-runner is powered by babashka and the Small Clojure Interpreter (SCI).
;; Almost all language features are supported, with the exception of low-level constructs
;; like `deftype`, and certain Java classes. For more info, see:
;; https://github.com/babashka/babashka#differences-with-clojure

(def expected-time
  ;; Define the var here
  40)

(defn remaining-time
  "Takes the actual time in minutes the lasagna has been in the oven,
   and returns how many minutes the lasagna still has to remain in the oven."
  [actual-time]
  ;; Define the function body here
  (- expected-time actual-time))

(defn prep-time
  "Takes the number of layers added to the lasagna,
   and returns how many minutes you spent preparing the lasagna"
  [num-layers]
  (* num-layers 2))

(defn total-time
  "Takes the number of layers of lasagna and the actual time in minutes it has been in the oven.
   Returns how many minutes in total you've worked on cooking the lasagna"
  [num-layers actual-time]
  (+ actual-time (prep-time num-layers)))

; EX3 - TRACKS ON TRACKS ON TRACKS

(defn new-list
  "Creates an empty list of languages to practice."
  []
  '())

(defn add-language
  "Adds a language to the list."
  [lang-list lang]
  (conj lang-list lang))

(defn first-language
  "Returns the first language on the list."
  [lang-list]
  (first lang-list))

(defn remove-language
  "Removes the first language added to the list."
  [lang-list]
  (pop lang-list))

(defn count-languages
  "Returns the total number of languages on the list."
  [lang-list]
  (count lang-list))

(defn learning-list
  "Creates an empty list, adds Clojure and Lisp, removes Lisp, adds
  Java and JavaScript, then finally returns a count of the total number
  of languages."
  []
  (-> (new-list)
      (add-language "Clojure")
      (add-language "Lisp")
      (remove-language)
      (add-language "Java")
      (add-language "JavaScript")
      (count-languages)))