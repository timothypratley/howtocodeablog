(ns daniel-slutsky-on-math-community-and-scicloj
  (:require [clojure.java.io :as io]
            [scicloj.kindly.v4.kind :as kind]
            [tablecloth.api :as tc])
  (:import (javax.imageio ImageIO)))

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

;; Today I'm chatting with Daniel Slutsky (https://github.com/daslu),
;; a mathematician and a community organiser at Scicloj.

;; * Masters in mathematics - thesis on quantum probability
;; * Software Engineer - built localized real estate portal
;; * A community organizer at SciCloj
;; * Creator of several data science libraries; Clay, Kindly, Noj
;; * Consulting

;; I got to know Daniel through many discussions about literate programming
;; and data visualization.

;; What's it like living in Tel Aviv right now?

(kind/md "
## Tel Aviv

![](https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcTMoWcuv_WN9L8Urv4Q9igJrv-p3sfnxiEP0Ec4eodpQsU2AUNeV09FeIB5SqpTB5BoAMBzt6MSoIvouoQVKU5iIbRoQdjACWBQHvq6sQ)")

;; > safe
;; > protesting
;; > teaching yoga

;;   Do you still have to go into bunkers every hour still?

;;   Are your movements restricted?

;; You wrote a thesis on quantum probability; what is that?

(kind/md "
## Quantum probability

![](https://www.researchgate.net/publication/291955373/figure/tbl1/AS:389118921068549@1469784588633/Relation-between-classical-and-quantum-probabilities-used-in-the-work-of-Leifer-and.png)")

;; >

;; What is SciCloj?

(grid 1 [[:a {:href "https://scicloj.github.io/"}
          "SciCloj"]])

;; > groups
;; > projects
;; > chat and discussions
;; > 1 on 1 meetings


;; Why is SciCloj an important community to support?

;; What sort of people are currently participating in SciCloj?

;; What drew you to community organizing?


;; When I look at SciCloj I see so many libraries that I'm not sure where to start,
;; is there one that stands out as something that I should try out first?

(grid 1 [[:a {:href "https://scicloj.github.io/docs/resources/libs/"}
          "SciCloj Libraries"]
         [:a {:href "https://github.com/orgs/scicloj/repositories?q=sort%3Astars"}
          "Github repositories by stars"]])

;; > Noj
;; > Tablecloth, tech.ml.data, arrays (typed structure), dtyped.next
;; > Neanderthal; working with arrays, and linear algebra, cpu/gpu, Blas, Lapack
;; > Deep diamond; building the structures of deep networks
;; > Visualization, creation of plots, display of plots, hanamicloth
;; > Clay and Kindly

;; Could you give me an overview of some of the other notable projects?

;; > In a couple of weeks will have a better answer to the question about libraries

;; Tablecloth is one that caught my attention, can you explain what's important about it?

(tc/dataset
  [["Tablecloth" "https://scicloj.github.io/tablecloth/" "Datasets shrink in memory through columnar storage and the use of primitive arrays, packed datetime types, and string tables."]
   ["Neanderthal" "https://neanderthal.uncomplicate.org/" "Fast native-speed matrix and linear algebra in Clojure"]
   ["Deep diamond" "https://github.com/uncomplicate/deep-diamond"
    "Fast tensors and neural network related computations based on the highly optimized native libraries and computation routines for both CPU and GPU."]
   ["Clay" "https://github.com/scicloj/clay" "Dynamic workflow of data visualization and literate programming"]]
  {:dataset-name "Tablecloth"})

;; If want to get descriptive statistics (mode, percentiles, linear regression, etc)

;; > Most are in Tablecloth, linear regression is in fastmath3

;; what are your plans for clay and kindly?


;; There are so many different communication channels available;
;; slack, reddit, clojureverse, ask-clojure, google group, zulip, reddit, stackoverflow.
;; Does this cause a community fragmentation a problem?

;; > People hang out in different spaces,
;; > we do what we can to reach out to everyone
;; > Zulip has been particularly useful;
;; > persistent, self-organizing, conversational, threads as topics

;; How can people get involved?

(kind/hiccup
  [:div
   [:h2 "Participating in SciCloj"]
   (grid 5 [
            [:img {:src "https://scicloj.github.io/sci-cloj-logo-transparent.png"}]
            [:svg {:xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 640 512"} [:path {:d "M88.2 309.1c9.8-18.3 6.8-40.8-7.5-55.8C59.4 230.9 48 204 48 176c0-63.5 63.8-128 160-128s160 64.5 160 128s-63.8 128-160 128c-13.1 0-25.8-1.3-37.8-3.6c-10.4-2-21.2-.6-30.7 4.2c-4.1 2.1-8.3 4.1-12.6 6c-16 7.2-32.9 13.5-49.9 18c2.8-4.6 5.4-9.1 7.9-13.6c1.1-1.9 2.2-3.9 3.2-5.9zM0 176c0 41.8 17.2 80.1 45.9 110.3c-.9 1.7-1.9 3.5-2.8 5.1c-10.3 18.4-22.3 36.5-36.6 52.1c-6.6 7-8.3 17.2-4.6 25.9C5.8 378.3 14.4 384 24 384c43 0 86.5-13.3 122.7-29.7c4.8-2.2 9.6-4.5 14.2-6.8c15.1 3 30.9 4.5 47.1 4.5c114.9 0 208-78.8 208-176S322.9 0 208 0S0 78.8 0 176zM432 480c16.2 0 31.9-1.6 47.1-4.5c4.6 2.3 9.4 4.6 14.2 6.8C529.5 498.7 573 512 616 512c9.6 0 18.2-5.7 22-14.5c3.8-8.8 2-19-4.6-25.9c-14.2-15.6-26.2-33.7-36.6-52.1c-.9-1.7-1.9-3.4-2.8-5.1C622.8 384.1 640 345.8 640 304c0-94.4-87.9-171.5-198.2-175.8c4.1 15.2 6.2 31.2 6.2 47.8l0 .6c87.2 6.7 144 67.5 144 127.4c0 28-11.4 54.9-32.7 77.2c-14.3 15-17.3 37.6-7.5 55.8c1.1 2 2.2 4 3.2 5.9c2.5 4.5 5.2 9 7.9 13.6c-17-4.5-33.9-10.7-49.9-18c-4.3-1.9-8.5-3.9-12.6-6c-9.5-4.8-20.3-6.2-30.7-4.2c-12.1 2.4-24.7 3.6-37.8 3.6c-61.7 0-110-26.5-136.8-62.3c-16 5.4-32.8 9.4-50 11.8C279 439.8 350 480 432 480z"}]]
            [:svg {:xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 640 512"} [:path {:d "M144 0a80 80 0 1 1 0 160A80 80 0 1 1 144 0zM512 0a80 80 0 1 1 0 160A80 80 0 1 1 512 0zM0 298.7C0 239.8 47.8 192 106.7 192h42.7c15.9 0 31 3.5 44.6 9.7c-1.3 7.2-1.9 14.7-1.9 22.3c0 38.2 16.8 72.5 43.3 96c-.2 0-.4 0-.7 0H21.3C9.6 320 0 310.4 0 298.7zM405.3 320c-.2 0-.4 0-.7 0c26.6-23.5 43.3-57.8 43.3-96c0-7.6-.7-15-1.9-22.3c13.6-6.3 28.7-9.7 44.6-9.7h42.7C592.2 192 640 239.8 640 298.7c0 11.8-9.6 21.3-21.3 21.3H405.3zM224 224a96 96 0 1 1 192 0 96 96 0 1 1 -192 0zM128 485.3C128 411.7 187.7 352 261.3 352H378.7C452.3 352 512 411.7 512 485.3c0 14.7-11.9 26.7-26.7 26.7H154.7c-14.7 0-26.7-11.9-26.7-26.7z"}]]
            [:svg {:xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 384 512"} [:path {:d "M64 464c-8.8 0-16-7.2-16-16V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm97 289c9.4-9.4 9.4-24.6 0-33.9s-24.6-9.4-33.9 0L79 303c-9.4 9.4-9.4 24.6 0 33.9l48 48c9.4 9.4 24.6 9.4 33.9 0s9.4-24.6 0-33.9l-31-31 31-31zM257 255c-9.4-9.4-24.6-9.4-33.9 0s-9.4 24.6 0 33.9l31 31-31 31c-9.4 9.4-9.4 24.6 0 33.9s24.6 9.4 33.9 0l48-48c9.4-9.4 9.4-24.6 0-33.9l-48-48z"}]]
            [:svg {:xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 448 512"} [:path {:d "M152 24c0-13.3-10.7-24-24-24s-24 10.7-24 24V64H64C28.7 64 0 92.7 0 128v16 48V448c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V192 144 128c0-35.3-28.7-64-64-64H344V24c0-13.3-10.7-24-24-24s-24 10.7-24 24V64H152V24zM48 192H400V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16V192z"}]]
            [:a {:href "https://invertisment.gitlab.io/cljcalendar/"}
             "Clojure Event Calendar"]])])

;; > there a calendar of events and group meetings

;; I can add the ics url to my Google calendar.

(ImageIO/read (io/file "google-calendar-setting.png"))

;; What are your hopes for the SciCloj community?

(kind/hiccup [:img {:src "https://blogsmedia.lse.ac.uk/blogs.dir/30/files/2022/10/Horizon-Work-image.png"}])

;; What does success look like for you personally?

;; > What we do is directed to a goal, but we don't know whether we get there
;; > Putting effort into something, even though we aren't sure what the result will be
;; > Intentional, positive, knowledge based communities.

;; Who has been your biggest inspiration or mentor, and why?

;; What’s the best piece of advice you’ve ever received?

;; Can you share a mistake you made early on and what you learned from it?

;; What advice would you give to someone starting out in Data Science?
