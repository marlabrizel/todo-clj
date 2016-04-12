(ns todo_clj.views.todos
  (:use [hiccup.element]
        [hiccup.core]
        [hiccup.form])
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
      (label "text" "What do you need to do?")
      (text-area "text")
      (submit-button "Enter"))])

(defn index []
  (layout/application "Todo Clj"
    [:div {:class "header"}
      [:h1 "All ToDos"]]
    (display-todos (todo/all))
    (new-todo-form)))
