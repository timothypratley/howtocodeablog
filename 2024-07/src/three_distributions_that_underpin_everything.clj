(ns three-distributions-that-underpin-everything
  (:require [scicloj.kindly.v4.kind :as kind]
            [tablecloth.api :as tc]))

;; https://www.youtube.com/watch?v=w4pWyvi1-wE

(defn data [ds]
  {:values (tc/rows ds :as-maps)})

(defn dist
  ([field] (dist field nil))
  ([field options] (dist field options :point))
  ([field options mark]
   [(if (map? mark) (merge-with merge {:type :point} mark) mark)
    (merge-with merge {:x {:field :idx
                           :sort  "-y"
                           :title "instance"
                           :axis  {:labels false}}
                       :y {:field field
                           :type  :quantitative}}
                options)]))

(defn hist [field]
  [:bar {:x {:field field
             :axis  {:grid false}
             :scale {:zero true}}
         :y {:aggregate :count
             :title     "count"}}])

(defn plot [title ds encodings]
  {:pre [(string? title) (tc/dataset? ds) (vector? encodings)]}
  (kind/vega-lite
    {:$schema "https://vega.github.io/schema/vega-lite/v5.json"
     :title   title
     :width   600
     :data    (data (tc/add-column ds :idx (range)))
     :layer   (vec (for [[mark encoding] encodings]
                     {:mark     mark
                      :encoding encoding}))}))

(defn distributions [data qualifier field]
  (kind/hiccup
    (let [prefix (str qualifier " " (name field))]
      [:div
       (plot (str prefix " distribution")
             data
             [(dist field {:x {:sort :idx}})])

       (plot (str prefix " distribution (sorted)")
             data
             [(dist field)])

       (plot (str prefix " frequency distribution")
             data
             [(hist field)])])))

;; Hello, code champs, number ninjas, and daring data divers!
;; It's your numchum Tim here trying to understand the mysteries of the universe.
;; Today, I'm going to attempt to simulate my three favourite statistical distributions.

;; > Pop quiz hotshot!
;; > 🎲 🎲 🎲 🎲 🎲 🎲
;; > If you roll six dice and add up their values, what do you get?

;; The least likely outcomes are 6 (all ones) and 36 (all sixes).
;; But everything in between can be made from multiple combinations.
;; I'd say the most likely answer is in the middle; 18.

;; > But what's about all the numbers in between those extremes?

;; Hmmm.
;; To really answer this we need to whip up a distribution.

;; I can simulate a die roll with a random number between 1 and 6.

(defn roll []
  (inc (rand-int 6)))

(repeatedly 20 roll)

;; Now let's roll a single die 1000 times and plot the results.

(def roll-data
  (tc/dataset {:roll (repeatedly 1000 roll)}))

(plot "Dice roll distribution"
      roll-data
      [(dist :roll {:x {:sort :idx}})])

;; A distribution shows all the numbers visually.
;; Each point is an observation of a roll.
;; The vertical position indicates the value of the roll,
;; the horizontal position indicates the order that it appeared in.

(plot "Dice roll distribution (sorted)"
      roll-data
      [(dist :roll)])

;; The order is not important, so sorting the distribution makes it easier to observe.

(plot "Dice roll frequency distribution"
      roll-data
      [(hist :roll)])

;; A frequency distribution summarizes the distribution.
;; This is great because it is even more compact, but on the downside it is a bit more abstract.

(distributions roll-data "Dice" :roll)

;; Seeing them all together to gives a good view of the dataset.
;; A single die roll is uniformly distributed, each outcome has the same frequency.

;; Now I want to roll 6 dice together and add up the values.

(defn roll-6 []
  (reduce + (repeatedly 6 roll)))

(repeatedly 20 roll-6)

;; Let's simulate 1000 of these

(def dice-data
  (tc/dataset {:score (repeatedly 10000 roll-6)}))

(distributions dice-data "Dice" :score)

;; This looks very familiar!
;; It's the normal distribution.

;; > A normal distribution occurs when independent variables are summed,
;; > regardless of the original distribution.
;; > This property is called the Central Limit Theorem.
;; > It bridges the gap between theoretical probability distributions and practical data analysis.

;; > The normal distribution shows up in test scores,
;; > human heights, and baseball batting averages.
;; > It arises from the aggregation of independent factors, where numerous small influences
;; > combine to produce a symmetric bell-shaped curve.
;; > It's everywhere, and it's beautiful in its simplicity and ubiquity.

;; > Let's try another game called "thrive":
;; >
;; > Flip a coin,
;; > if you get tails then you get nothing,
;; > if you get heads you get a dollar, and you get to flip again.

;; So just count the number of heads in a row?

;; > It sounded cooler the way I said it.

;; O.K. let's make a function that returns 1 or 0 randomly

(defn flip []
  (rand-int 2))

(repeatedly 20 flip)

;; And now keep flipping when we get a 1

(defn flip-thrive
  ([] (flip-thrive 1))
  ([n] (if (zero? (flip))
         n
         (flip-thrive (inc n)))))

(repeatedly 20 flip-thrive)

;; O.K. these seem reasonable numbers, let's look at the distribution

(def thrive-data
  (tc/dataset {:money (repeatedly 1000 flip-thrive)}))

(distributions thrive-data "Wealth" :money)

;; Hey, that looks like the Pareto!

;; > No, this is a Geometric distribution.
;; > But they are quite similar.
;; > Such distributions arise due to survival and cumulative advantage; getting another flip.

;; > The Pareto distribution is famously for the "80-20 rule"
;; > where "80% of the yield comes from 20% of the effort".
;; > This distribution appears in wealth distribution, sales, and social media.
;; > It's characterized by a small number of high performers and a long tail of outliers,
;; > occurring when success is distributed unevenly due to a cumulative advantage.
;; > Small initial differences can lead to large eventual disparities.

;; What is the principle behind a Pareto distribution?

;; > The Power Law.
;; > It is relationship between two quantities where one quantity varies as a power of another.
;; > It explains the occurrence of extreme events.

;; What if we get really crazy now, and do both flipping and rolling?

(defn flip-roll
  ([] (flip-roll (roll)))
  ([n] (if (zero? (flip))
         n
         (flip-roll (+ (roll) n)))))

(repeatedly 20 flip-roll)

(def flip-roll-data
  (tc/dataset {:views (repeatedly 1000 flip-roll)}))

(distributions flip-roll-data "YouTube" :views)

;; Hey that looks like the Poisson!

;; > No, this is a merger of normal and geometric distributions,
;; > but they are quite similar in shape.

;; Well that's wierd isn't it?
;; Could it be that distributions arise from simple mechanisms of choice,
;; summation of different variables, accumulation from surviving and thriving,
;; and combinations of these properties?

;; > It depends on the situation.
;; > Determining the precise causes of a distribution may be difficult.
;; > Sometimes that matters a lot.
;; > In 2007 it played a role in the credit crisis.
;; > Many financial models assumed normal distributions of returns.
;; > These models underestimated the likelihood and impact of extreme events
;; > and correlations during market stress.
;; > Others underestimated the risk of simultaneous defaults.
;; > These assumptions turned out to be wrong, and led to severe losses.

;; > On the other hand, often we just want to understand the general shape of the data,
;; > and think about the factors involved.

;; > The Poisson distribution models the number of events occurring within a fixed interval of time or space.
;; > It shows up in queues at the checkout, the number of goals a soccer team will score,
;; > the frequency of YouTube video views, and anywhere that the frequency of a repeating event is relevant.

;; We glossed over on a few things.
;; Dice don't occur in nature.
;; Dice can be constructed with binary choices.

(defn flip-36 []
  (reduce + (repeatedly 36 flip)))

(def flip-36-data
  (tc/dataset {:score (repeatedly 10000 flip-36)}))

(distributions flip-36-data "Flip 36" :score)

(defn flip-3 []
  (let [a (flip)
        b (flip)
        c (flip)]
    (+ (* a 4)
       (* b 2)
       (* c 1))))

(def flip-3-data
  (tc/dataset {:score (repeatedly 1000 flip-3)}))

(distributions flip-3-data "Flip 3" :score)

;; Uniform distribution from coin flips.
;; If we drop 0s and 7s, we are left with dice.

(defn flip-skewed []
  (let [x (flip)]
    (if (zero? x)
      (flip)
      x)))

(defn flip-skewed-36 []
  (reduce + (repeatedly 36 flip-skewed)))

(def flip-skewed-data
  (tc/dataset {:score (repeatedly 10000 flip-skewed-36)}))

(distributions flip-skewed-data "Flip skewed" :score)

;; The basic interactions lead to many distributions
