(ns lab01.aula4)

(def precos [10, 30, 700, 100, 200])

(println (precos 2))
(println (get precos 1))
(println (get precos 17 0))


(defn aplicar-desconto?
  [valor-bruto]
  (> valor-bruto 100))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplicar-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado 1000)
(valor-descontado 100)
(println (map valor-descontado precos))