(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(defn gasto-bastante? [info-do-usuario]
  (> (:total-gasto info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "kee" (keep gasto-bastante? resumo))
  )