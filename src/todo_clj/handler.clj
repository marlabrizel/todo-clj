(ns todo-clj.handler
(:require [compojure.core :refer :all]
          [compojure.route :as route]
          [ring.util.response :as resp]
          [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (resp/content-type (resp/resource-response  "index.html" {:root "public"}) "text/html"))
  (GET "/about" [] (resp/content-type (resp/resource-response  "about.html" {:root "public"}) "text/html"))
  (route/resources "/")
  (route/files "public")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
