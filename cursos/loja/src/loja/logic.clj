(ns loja.logic)

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
   :total-gasto     (total-dos-pedidos pedidos)})


(defn resumo-por-usuario [pedidos]
  (->> pedidos
       (group-by :usuario)
       (map conta-total-por-usuario-gasto-totas-por-pedido)))