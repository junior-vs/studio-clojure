(ns lab01.alura3)

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado 1000)
(valor-descontado 100)


(defn deve-aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (deve-aplicar-desconto? 100))
(println (deve-aplicar-desconto? 1000))

(defn aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (aplicar-desconto? 100))
(println (aplicar-desconto? 1000))

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

(defn aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplicar? valor-bruto]
  (if (aplicar? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado aplicar-desconto? 1000)
(valor-descontado aplicar-desconto? 100)