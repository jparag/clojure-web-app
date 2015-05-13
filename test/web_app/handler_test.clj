(ns web-app.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [web-app.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "<!DOCTYPE html>\n<html><head><title>Locations: Home</title><link href=\"/css/styles.css\" rel=\"stylesheet\" type=\"text/css\"></head><div id=\"header-links\">[ <a href=\"/\">Home</a> | <a href=\"/add-location\">Add a Location</a> | <a href=\"/all-locations\">View All Locations</a> ]</div><h1>Home</h1><p>Webapp to store and display some 2D (x,y) locations.</p></html>"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
