(ns app
  (:require [db])
  (:require [menu]))

  (def customerDB (db/list-dict (db/read-file-parser "src/cust.txt")))
  (def productDB (db/list-dict (db/read-file-parser "src/prod.txt")))
  (def salesDB (db/list-dict (db/read-file-parser "src/sales.txt")))

  (defn customerName
    [customerID]
    (def customerList (get customerDB (Integer/parseInt customerID)))
    (def customerName (first customerList))
    customerName
    )

  (defn productName
    [productID]
    (def productList (get productDB (Integer/parseInt productID)))
    (def productName (first (productList)))
    productName
    )



(def sales-db-process [])
  (defn process-choice [choice]
        (when (= choice "1")
          (db/print-dictionary customerDB)
          (menu/press-enter-to-continue)
          )
        (when (= choice "2")
          (db/print-dictionary productDB)
          (menu/press-enter-to-continue)
          )
        (when (= choice "3")
          (println salesDB)
          (menu/press-enter-to-continue)
          )
        (when (= choice "4")
          (println (get customerDB 0) )
          (menu/press-enter-to-continue)
          )
        (when (= choice "5")
          (println "Under Construction")
          (menu/press-enter-to-continue)
          )
        )

  (defn loop-display-menu [exit-option]
        (menu/display-menu)
        (def choice (read-line))

        (process-choice choice)

        (loop [count 0]
          (if (= choice exit-option)
            (println "Good-Bye!")
            (do
              (menu/display-menu)
              (def choice (read-line))
              (process-choice choice)
              (recur (inc count))))))



  (defn -main [ ]
        (println "Entering main program")
        (loop-display-menu "6")
        )


  (-main)