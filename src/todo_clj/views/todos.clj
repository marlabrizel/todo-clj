(ns todo_clj.views.todos
  (:use [hiccup.element]
        [hiccup.core]
        [hiccup.form]
        [ring.util.anti-forgery :as anti-CSRF])
  (:require [todo_clj.models.todo :as todo]
            [todo_clj.views.layout :as layout]))

(defn display-todos [todos]
  [:div {:class "todos"}
  (map
    (fn [todo]
      [:ul {:class "todo"}
        [:li "Description: "(h (:text todo))]
        [:li "Status: "(h (:status todo))]])
    todos)])

(defn new-todo-form []
  [:div {:class "form-control" :id "todo-form"}
    (form-to [:post "/"]
      (anti-CSRF/anti-forgery-field)
      (label "text" "What do you need to do?")
      (text-area "text")
      (submit-button "Enter"))])

(defn update []
  [:div {:class "form-control" :id "update-form"}
    (form-to [:put "/"]
      (anti-CSRF/anti-forgery-field)
      (submit-button "Update Status"))])

(defn index []
  (layout/application "Todo Clj"
    [:div {:class "header"}
      [:h1 "All ToDos"]]
    (display-todos (todo/all))
    (new-todo-form)))
