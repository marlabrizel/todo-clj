(ns todo_clj.models.todo
  (:require [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/todo_clj"))

(defn all []
  (into [] (sql/query spec ["select * from todos"])))

(defn create [text, status]
  (sql/insert! spec :todos {:text text :status "todo"}))

(defn update-status [status]
  (sql/insert! spec :todos {:staus status}))
