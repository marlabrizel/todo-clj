(ns todo_clj.views.todos
  (:use [hiccup.element]
        [hiccup.core])
  (:require [todo_clj.models.todo :as todo]))
            [todo_clj.views.layout :as layout]))

(defn display-todos [todos]
  [:div {:class "todos"}
  (map
    (fn [todo]
      [:ul {:class "todo"}
        [:li "Description: "(h (:text todo))]
        [:li "Status: "(h (:status todo))]])
    todos)])

(defn index []
  [:div {:class "todo"}
    [:h1 {:class "header"} "All ToDos"]
    (display-todos (todo/all))])
  (layout/application "Todo Clj"
    [:div {:class "todo"}
      [:h1 {:class "header"} "All ToDos"]]
    (display-todos (todo/all))))
