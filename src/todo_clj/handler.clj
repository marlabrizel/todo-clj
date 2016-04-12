(ns todo-clj.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [todo_clj.views.layout :as layout]
            [todo_clj.controllers.todos :as controller]
            [todo_clj.views.todos :as view]))

(defroutes app-routes
  controller/app-routes
  (route/resources "/")
  (route/files "public")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
