(ns todo_clj.controllers.todos
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as resp]
            [todo_clj.views.layout :as layout]
            [todo_clj.views.todos :as view]
            [todo_clj.models.todo :as model]))

(defn create [text, status]
  (when-not (str/blank? text, status)
    (model/create text, status))
  (resp/redirect "/"))

(defroutes app-routes
  (GET  "/" [] (layout/application "Todo Clj" (view/index)))
  (GET "/about" [] (resp/content-type (resp/resource-response  "about.html" {:root "public"}) "text/html"))
  (POST "/" [text, status] (model/create text, status)))
