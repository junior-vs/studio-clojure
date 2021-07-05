(ns estoque.aula5)

(def estoque { :mochila 10
              :camisa 5})

(println estoque)
(println "temos" (count estoque) "elementos")
(println "chaves são:" (keys estoque))
(println "valores são :" (vals estoque))

(println (assoc estoque :cadeira 3))

(println (assoc estoque :mochila 1))
(println estoque)

(println (update estoque :mochila inc))

(defn tira-dois
  [valor]
  (println "tirando um de " valor)
  (- valor 2))

(println (update estoque :mochila tira-dois))

(println (update estoque :mochila #(- % 3)))




(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})
(println pedido)
(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :lapis))
(println (get pedido :lapis {}));com valor default

(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido {})) ;com valor default

(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))
(println (update-in pedido [:mochila :quantidade] tira-dois))

; Treading first
(println pedido)
(println (-> pedido
             :mochila
             :quantidade))








