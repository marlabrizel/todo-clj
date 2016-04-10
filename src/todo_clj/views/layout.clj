(ns todo_clj.views.layout
  (:use [hiccup.page]))

(defn application [title & content]
  (html5
         [:head
          [:title title]
          (include-css "/css/styles.css")

          [:body
           [:div {:class "container"} content ]]]))
