(ns loja.aula3
  (:require [loja.db :as l.db]))

;(println (l.db/todos-os-pedidos))

;(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento: " elemento)
  (:usuario [elemento]))

;(println (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     vals
     (map count)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  [usuario (count pedidos)])


(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  {
   :usuario:id      usuario
   :total-de-pedido (count pedidos)
   })


(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(defn total-do-item
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn conta-total-por-usuario-gasto-totas-por-pedido
  [[usuario pedidos]]
  {
   :usuario:id      usuario
   :total-de-pedido (count pedidos)
   :total-gasto (total-dos-pedidos pedidos)})


(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario-gasto-totas-por-pedido)
     println)
