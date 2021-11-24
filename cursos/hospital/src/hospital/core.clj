(ns hospital.core
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))

(let [hospital-00 (h.model/novo-hopital)]
  (pprint hospital-00))


