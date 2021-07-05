(ns estoque.aula3)


;Predicate
(defn aplica-desconto?
  "deve aplicar desconto"
  [valor-bruto]
  (println "Verificando se o valor bruto é maior que 100")
  (if (> valor-bruto 100)
    true
    ))

;Predicate
(defn mais-caro-que-100?
  "retorna true se for maio que 100"
  [valor-bruto]
  (> valor-bruto 100))

;(println (aplica-desconto? 100))
;(println (aplica-desconto? 1000))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 100))
(println (valor-descontado mais-caro-que-100? 1000))