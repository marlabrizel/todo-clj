(ns todo-clj.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [todo_clj.views.layout :as layout]
            [todo_clj.views.todos :as todos]))

(defroutes app-routes
  (GET "/" [] (layout/application "Home" (todos/index)))
  (GET "/about" [] (resp/content-type (resp/resource-response  "about.html" {:root "public"}) "text/html"))
  (route/resources "/")
  (route/files "public")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
