(ns loja.aula1)

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)))

(meu-mapa println ["daniela" "joao" "guilherme" "paulo" "ana"])


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do (funcao primeiro)
          (meu-mapa funcao (rest sequencia))))
    ))

(meu-mapa println ["daniela" "joao" "guilherme" "paulo" "ana"])
(meu-mapa println ["daniela" "joao" false "guilherme" "paulo" "ana"])


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do (funcao primeiro)
          (recur funcao (rest sequencia))))
    ))

(meu-mapa println ["daniela" "joao" "guilherme" "paulo" "ana"])
(meu-mapa println ["daniela" "joao" false "guilherme" "paulo" "ana"])