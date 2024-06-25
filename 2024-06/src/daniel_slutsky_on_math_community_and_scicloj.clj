(ns daniel-slutsky-on-math-community-and-scicloj
  (:require [clojure.java.io :as io]
            [scicloj.kindly.v4.kind :as kind]
            [tablecloth.api :as tc])
  (:import (javax.imageio ImageIO)))

;; Today I'm chatting with Daniel Slutsky (https://github.com/daslu),
;; a mathematician and a community organiser at Scicloj.

(defn grid [n rows]
  (kind/hiccup
    (into [:div {:style {:display               "grid"
                         :grid-template-columns (str "repeat(" n ", 1fr)")
                         :gap                   10
                         :align-items           "center"
                         :justify-content       "center"
                         :text-align            "center"}}]
          (for [column rows]
            [:div column]))))

(kind/hiccup
  [:div
   [:h2 "Daniel Slutsky - Math, Community, and SciCloj"]
   (grid 2 [[:img {:src "https://avatars.githubusercontent.com/u/5673102?v=4"}]
            (grid 3 [[:img {:src "https://upload.wikimedia.org/wikipedia/commons/a/ae/Greek_lc_psi.svg"}]
                     [:img {:src "https://www.kindpng.com/picc/m/384-3840161_blue-community-icon-png-transparent-png.png"}]
                     [:img {:src "https://scicloj.github.io/sci-cloj-logo-transparent.png"}]])])])

;; Daniel, please tell us a little about your background?

;; You wrote a thesis on quantum probability; what is that?

(grid 1 [[:img {:src "https://www.researchgate.net/publication/291955373/figure/tbl1/AS:389118921068549@1469784588633/Relation-between-classical-and-quantum-probabilities-used-in-the-work-of-Leifer-and.png"}]])

;; What is SciCloj?

(grid 1 [[:a {:href "https://scicloj.github.io/"}
          "SciCloj"]])

;; What drew you to community organizing?

;; Why is SciCloj an important community to support?

;; When I look at SciCloj I see so many libraries that I'm not sure where to start,
;; is there one that stands out as something that I should try out first?

(grid 1 [[:a {:href "https://scicloj.github.io/docs/resources/libs/"}
          "SciCloj Libraries"]
         [:a {:href "https://github.com/orgs/scicloj/repositories?q=sort%3Astars"}
          "Github repositories by stars"]])

;; Could you give me an overview of some of the other notable projects?

;; Tablecloth is one that caught my attention, can you explain what's important about it?

(tc/dataset
  [["Tablecloth" "https://scicloj.github.io/tablecloth/"]]
  {:dataset-name "Tablecloth"})

;; How do people collaborate in the SciCloj community?

;; The Clojure community uses so many different communication channels; slack, reddit, clojureverse, ask-clojure, google group, zulip, reddit, stackoverflow.
;; Is community fragmentation a problem?

;; Is there a calendar of events and group meetings I can follow?

(grid 1 [[:a {:href "https://invertisment.gitlab.io/cljcalendar/"}
          "Clojure Event Calendar"]])

;; I only just realized that I can add it to my calendars with the ics url.

(ImageIO/read (io/file "google-calendar-setting.png"))

;; What are your hopes for the SciCloj community?

(kind/hiccup [:img {:src "https://blogsmedia.lse.ac.uk/blogs.dir/30/files/2022/10/Horizon-Work-image.png"}])

;; What does success look like for you personally?

;; Who has been your biggest inspiration or mentor, and why?

;; What’s the best piece of advice you’ve ever received?

;; Can you share a mistake you made early on and what you learned from it?

;; What advice would you give to someone starting out in Data Science?
