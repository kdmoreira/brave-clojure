(ns clojure-noob.side-studies.studies.yaml-stuff
  (:require
   [yaml.core :as yaml]
   [clojure.java.io :as io]))

; same effect
(-> (io/file ".") .getAbsolutePath)
(-> (java.io.File. ".") .getAbsolutePath)

(def yaml-filepath
  "resources/yaml-example.yml")

(slurp yaml-filepath)
(.exists (io/file yaml-filepath))
(.exists (io/resource yaml-filepath))

(yaml/from-file (io/file yaml-filepath))
(:surname (yaml/from-file (io/file yaml-filepath)))
(yaml/generate-string (yaml/from-file (io/file yaml-filepath)))