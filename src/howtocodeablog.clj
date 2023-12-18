;; # How to Code a Blog
(ns howtocodeablog)

;; Literate programming is a fancy way to say I want to produce a document from code.

;; ## Some code

(+ 2 5)

;; ## Add a dev dependency on Clay v2

;; See https://clojars.org/org.scicloj/clay for current version info

;;```clojure
;;{:deps {}
;; :aliases {:dev {:deps {org.scicloj/clay {:mvn/version "2-alpha53"}}}}}
;;```

;; Make sure that you have the dev alias active in your project.

;; ## Configuring Clay v2

;; Add a file `clay.edn` to hold your Clay project options

;;```clojure
;;{:source-path ["src/howtocodeablog.clj"]
;; :show        false}
;;```

;; Show false is only if you don't want Clay to open a browser window and serve files to you.

;; ## Visualize!

;; We'll make table of the times tables:

^:kind/table
{:column-names [1 2 3 4 5 6 7 8 9 10 11 12]
 :row-vectors  (for [i (range 1 13)]
                 (for [j (range 1 13)]
                   (* i j)))}

;; ## Setting up REPL Commands

;; So that we don't need to call clay from the REPL,
;; we'll create two commands suitable for binding to a key:

;; ### Send a file to Clay2

;```clojure
;(do (require '[scicloj.clay.v2.api :as clay])
;    (clay/make! {:source-path ["~file-path"]}))
;```

;; ### Send a form to Clay2

;```clojure
;(do (require '[scicloj.clay.v2.api :as clay])
;    (clay/make! {:single-form '~form-before-caret
;                 :source-path ["~file-path"]}))
;```

;; Select the "Reload files" option if you want to use the embedded browser


;; Creating Keybindings:
;; assign a key combo for the REPL Command created

;; ## More visualization - a chart

^:kind/vega-lite
{:data     {:values (for [i (range 1 13)]
                      {:x i
                       :y (* i i)})}
 :mark     "point"
 :encoding {:x {:field :x :type "quantitative"}
            :y {:field :y :type "quantitative"}}}

;; ## Why?

;; We can keep our code with our prose.

;; ## Publishing

;; Push a git repo to Github, and setup hosting.

;; ## Conclusion

;; Now I can literate with Clay v2!
