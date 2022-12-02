;product qty parse last element of line from sales table

(ns db
  (:require [clojure.string :as str]))

(defn print-entries-customer
  [entries]
  (def num-entries (count entries))
  )

(defn list-dict [entries]
  (def keysToBe (map #(clojure.edn/read-string (first %)) entries))
  (def values
    (for [item entries] (drop 1 item)))

  (def dict (zipmap keysToBe values))
  dict
  )

(defn bracketize-list [list]
  (str "[\"" (str/join "\" \"" list) "\"]"))

(defn print-dictionary
  "clean dictionary print customer/product"
  [dictionary]
  (doseq [[k v] dictionary]
    (println k "-" (bracketize-list v)))
  )


(defn read-file-parser
  "reads given file and parses"
  [filename]
  (let [file-contents (slurp filename)]
    (def file-contents-split (str/split-lines file-contents))
    )
  (def entries
        (for [line file-contents-split]
          (str/split line #"\|"))
         )
        entries
    )


(defn print-entries-product
  [entries]
  (def num-entries (count entries))
  (loop [count 0]
    (if (= count num-entries)
      (println "Listing complete!")
      ))

  )
