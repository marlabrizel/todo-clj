(ns todo_clj.views.todos
  (:use [hiccup.element]
        [hiccup.core])
  (:require [todo_clj.models.todo :as todo]))

(defn display-todos [todos]
  [:div {:class "todos"}
  (map
    (fn [todo]
      [:ul {:class "todo"}
        [:li (h (:text todo))]
        [:li (h (:status todo))]])
    todos )])

(defn index []
  [:div {:class "todo"}
    [:h1 "All ToDos"]
    (display-todos (todo/all))])
