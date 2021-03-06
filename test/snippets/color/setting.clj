(ns snippets.color.setting
  (:require [quil.snippet :refer [defsnippet]]
            [quil.core :as q]))

(defsnippet background {}
  (q/background 255 0 0)
  (let [gr (q/create-graphics 100 100)]
    (q/with-graphics gr
      (q/background 120))
    (q/image gr 0 0)

    (q/with-graphics gr
      (q/background 70 120))
    (q/image gr 70 70)

    (q/with-graphics gr
      (q/background 0 255 255))
    (q/image gr 140 140)

    (q/with-graphics gr
      (q/background 0 0 255 120))
    (q/image gr 210 210)))

(defsnippet background-image {}
  (let [gr (q/create-graphics (q/width) (q/height))]
    (q/with-graphics gr
      (q/background 0 120 120)
      (q/ellipse 250 250 300 300))

    (q/background-image gr)))

(defsnippet fill {}
  (q/background 0 0 255)

  (q/fill 120)
  (q/rect 0 0 100 100)

  (q/fill 80 120)
  (q/rect 70 70 100 100)

  (q/fill 0 255 0)
  (q/rect 140 140 100 100)

  (q/fill 255 0 0 120)
  (q/rect 210 210 100 100))

(defsnippet no-fill {}
  (q/background 255)

  (q/stroke 0)
  (q/fill 120)
  (q/rect 0 0 100 100)

  (q/no-fill)
  (q/rect 70 70 100 100))

(defsnippet no-stroke {}
  (q/background 255)

  (q/fill 120)
  (q/stroke 0)
  (q/rect 0 0 100 100)

  (q/no-stroke)
  (q/rect 70 70 100 100))

(defsnippet stroke {}
  (q/background 255)
  (q/stroke-weight 10)

  (q/stroke 120)
  (q/rect 0 0 100 100)

  (q/stroke 80 120)
  (q/rect 70 70 100 100)

  (q/stroke 0 255 0)
  (q/rect 140 140 100 100)

  (q/stroke 255 0 0 120)
  (q/rect 210 210 100 100))
