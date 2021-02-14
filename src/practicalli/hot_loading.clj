;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; REPL driven development of a very simple Clojure webapp
;;
;; All the code has been written in side a rich comment block,
;; to be called by a developer using this code
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns practicalli.hot-loading
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]))

;; Rich comment block with redefined vars ignored
#_{:clj-kondo/ignore [:redefined-var]}
(comment
  ;; run REPL with :alpha/hotload-libs alias
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])

  ;; hotload the libraries required for the server
  (add-libs
    '{http-kit/http-kit {:mvn/version "2.5.1"}})
  ;; => (http-kit/http-kit)


  (require '[org.httpkit.server :as app-server])


  ;; What functions are ava
  (ns-publics (find-ns 'org.httpkit.server))

  ;; efine an entry point for the application
  (defn welcome-page
    [request]
    {:status  200
     :body    "Welcome to the world of Clojure CLI hotloading"
     :headers {}})

  ;; Start the application server
  (app-server/run-server #'welcome-page {:port (or (System/getenv "PORT") 8888)})

  ;; Visit http://localhost:8888/ to see the welcome-page

  ;; Hotload Hiccup to generate html for the welcome page
  (add-libs '{hiccup/hiccup {:mvn/version "2.0.0-alpha2"}})

  (require '[hiccup.core :as hiccup])
  (require '[hiccup.page :as hiccup-page])

  (defn page-template [content]
    (hiccup-page/html5
      {:lang "en"}
      [:head (hiccup-page/include-css "https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css")]
      [:body
       [:section {:class "hero is-info"}
        [:div {:class "hero-body"}
         [:div {:class "container"}
          [:h1 {:class "title"} (:title content) ]
          [:p {:class "subtitle"} (:sub-title content)]]]]]))

  ;; Check the page template returns HTML
  (page-template {:title     "Hotload Libraries in the REPL"
                  :sub-title "REPL driven development enables experimentation with designs"})


  ;; redefine the welcome page to call the page template
  (defn welcome-page
    [request]
    {:status  200
     :body    (page-template {:title     "Hotload Libraries in the REPL"
                              :sub-title "REPL driven development enables experimentation with designs"})
     :headers {}})



  ) ;; End of rich comment block
