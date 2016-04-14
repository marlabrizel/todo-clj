(ns todo-clj.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [todo-clj.handler :as handler]))

(deftest test-app
  (testing "home endpoint"
    (let [response (handler/app (mock/request :get "/"))]
    (is (= (get-in response [:status]) 200))))

  (testing "about endpoint"
    (let [response (handler/app (mock/request :get "/about"))]
    (is (= (get-in response [:status]) 200))))

  (testing "a non-existant route"
    (let [response (handler/app (mock/request :get "/not-here"))]
    (is (= (get-in response [:status]) 404)))))
