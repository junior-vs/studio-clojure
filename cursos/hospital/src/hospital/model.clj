(ns hospital.model)


(def fila-vazia clojure.lang.PersistentQueue/EMPTY)

(defn novo-hopital []
  {
   :espera fila-vazia
   :lab1   fila-vazia
   :lab2   fila-vazia
   :lab3   fila-vazia
   })