(ns menu)

(defn display-menu []
  (println "******************************")
  (println "| Sales Menu                 |")
  (println "| 1. Display Customer Table  |")
  (println "| 2. Display Product Table   |")
  (println "| 3. Display Sales Table     |")
  (println "| 4. Total Sales for Customer|")
  (println "| 5. Total Sales for Product |")
  (println "| 6. Exit                    |")
  (println "******************************")
  )


(defn press-enter-to-continue []
      (println "\nPress Enter to continue")
      (read-line)
      )