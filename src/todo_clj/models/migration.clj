(ns todo_clj.models.migration
  (:require [clojure.java.jdbc :as sql]
            [todo_clj.models.todo :as todo]))

(defn migrated? []
 (-> (sql/query todo/spec
                [(str "select count(*) from information_schema.tables "
                      "where table_name='todos'")])
     first :count pos?))

(defn migrate []
 (when (not (migrated?))
   (print "Creating database structure...") (flush)
   (sql/db-do-commands todo/spec
                       (sql/create-table-ddl
                        :todos
                        [:id :serial "PRIMARY KEY"]
                        [:text :varchar "NOT NULL"]
                        [:status :varchar "NOT NULL"]
                        [:created_at :timestamp
                         "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]))
   (println " done")))
