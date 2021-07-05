(ns estoque.aula6)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15
  [valor]
  (println "valor" valor) 15)

(println (map imprime-e-15 pedido))

;destruct
(defn imprime-e-15 [[chave valor]]
  (println chave "<<e>>" valor) 15)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos
  [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))


(defn preco-dos-produtos
  [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))

(defn total-dos-produtos
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-dos-produtos pedido))

(defn total-do-pedido
  [pedido]
  (->> pedido (map preco-dos-produtos)
       (reduce +)))

(println (total-dos-produtos pedido))

(defn preco-total-do-produto
  [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido2
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println "total:" (total-do-pedido2 pedido))

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(println pedido)
(defn gratuido1?
  [item]
  (<= (get item :preco 0) 0))

(println (filter gratuido1? pedido))

(println (filter gratuido1? (vals pedido)))

(defn gratuido2?
  [[chave item]]
  (<= (get item :preco 0) 0))

(println (filter gratuido? pedido))

(defn gratuido2?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println (filter gratuido? pedido))


(defn gratuido3?
  [item]
  (<= (get item :preco 0) 0))

(println "item gratuito: " (filter (fn [[chave item]] (gratuido3? item))pedido))
(println "item gratuito: " (filter #(gratuido3? (second %)) pedido))


