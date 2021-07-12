(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))


(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo: " resumo)
  (println "Ordenado: " (sort-by :total-gasto resumo))
  (println "Ordenado ao contrario" (reverse (sort-by :total-gasto resumo)))
  (println "Ordenado por usuario-id" (sort-by :usuario:id resumo))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))


(defn resumo-por-usuario [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :total-gasto)
       reverse))


(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario pedidos)]
  (println "Resumo por usuario: " resumo)
  (println "Resumo por usuario: " (first resumo))
  (println "Resumo por usuario: " (second resumo))
  (println "total" (count resumo))
  )

(defn top-2 [resumo]
  (take 2 resumo))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Top-2" (top-2 resumo))
  (println "> 500 filter" (filter #(> (:total-gasto %) 500) resumo))
  (println "> 500 filter empty not =>" (not (empty? (filter #(> (:total-gasto %) 500) resumo))))
  (println "> 500 some =>" (some #(> (:total-gasto %) 500) resumo))
  )


