(ns snippets.image.loading-and-displaying
  (:require [quil.snippet :refer [defsnippet]]
            [quil.core :as q]))

(defsnippet image {}
  (q/background 255)
  (let [gr (q/create-graphics 70 70)]
    (q/with-graphics gr
      (q/ellipse 35 35 70 70))

    (q/image gr 0 0)
    (q/image gr 100 0 100 70)))

(defsnippet image-mode {}
  (q/background 255)
  (let [gr (q/create-graphics 100 100)]
    (q/with-graphics gr
      (q/fill 0 0 255)
      (q/stroke 0 0 255)
      (q/rect 0 0 100 100))
    (q/stroke-weight 10)

    (q/image-mode :corner)
    (q/image gr 50 50)
    (q/point 50 50)

    (q/image-mode :center)
    (q/image gr 250 100)
    (q/point 250 100)

    (q/image-mode :corners)
    (q/image gr 350 50 400 150)
    (q/point 350 50)
    (q/point 400 150)))

(defsnippet load-image {}
  (let [im (q/load-image "https://cloud.github.com/downloads/quil/quil/quil.png")]
    (q/image im 0 0)))

(defsnippet resize-image {}
  (let [im (q/load-image "https://cloud.github.com/downloads/quil/quil/quil.png")]
    (q/image im 0 0)
    (q/resize im 50 50)
    (q/image im 0 0)))

(defsnippet mask-image {:renderer :p3d}
  (q/background 255)
  (let [gr (q/create-graphics 100 100 :p3d)
        gr2 (q/create-graphics 100 100 :p3d)
        mask (q/create-graphics 100 100 :p3d)]
    (q/with-graphics gr
      (q/background 0 0 255)
      (q/stroke-weight 3)
      (q/stroke 255 0 0)
      (q/line 0 0 100 100)
      (q/line 0 100 100 0))

    (q/with-graphics gr2
      (q/background 255)
      (q/stroke 0 255 0)
      (q/stroke-weight 5)
      (q/line 0 50 100 50)
      (q/line 50 0 50 100))

    (q/with-graphics mask
      (q/background 0)
      (q/stroke-weight 5)
      (q/no-fill)
      (q/stroke 255)
      (q/ellipse 50 50 10 10)
      (q/stroke 200)
      (q/ellipse 50 50 30 30)
      (q/stroke 150)
      (q/ellipse 50 50 50 50)
      (q/stroke 100)
      (q/ellipse 50 50 70 70)
      (q/stroke 50)
      (q/ellipse 50 50 90 90))

    (q/image gr 20 20)
    (q/image mask 140 20)
    (q/mask-image gr mask)
    (q/image gr 260 20)

    (q/image gr2 20 140)
    (q/image mask 140 140)
    (q/with-graphics gr2
      (q/mask-image mask))
    (q/image gr2 260 140)))

(defsnippet no-tint {}
  (q/background 255)
  (let [gr (q/create-graphics 100 100)]
    (q/with-graphics (q/create-graphics 100 100)
      (q/background 0 255)
      (q/fill 255)
      (q/ellipse 25 25 20 20)
      (q/fill 255 0 0)
      (q/ellipse 75 25 20 20)
      (q/fill 0 255 0)
      (q/ellipse 25 75 20 20)
      (q/fill 0 0 255)
      (q/ellipse 75 75 20 20))

    (q/with-graphics gr
      (q/background 0 0)
      (q/fill 255)
      (q/ellipse 50 50 70 70))

    (q/image gr 0 0)
    (q/tint 127 255 255)
    (q/image gr 100 0)
    (q/no-tint)
    (q/image gr 200 0)))

(defsnippet request-image
  {:setup (q/set-state! :image (q/request-image "https://cloud.github.com/downloads/quil/quil/quil.png"))}
  (if (zero? (.-width (q/state :image)))
    (q/text "Loading" 10 10)
    (q/image (q/state :image) 0 0)))

(defsnippet tint {}
  (q/background 127)
  (let [gr (q/create-graphics 100 100)]
    (q/with-graphics gr
      (q/background 0 0)
      (q/fill 255)
      (q/ellipse 25 25 40 40)
      (q/fill 255 0 0)
      (q/ellipse 75 25 40 40)
      (q/fill 0 255 0)
      (q/ellipse 25 75 40 40)
      (q/fill 0 0 255)
      (q/ellipse 75 75 40 40))

    (q/no-tint)
    (q/image gr 0 0)
    (q/tint 127)
    (q/image gr 120 0)
    (q/tint 255 127)
    (q/image gr 240 0)
    (q/tint 200 127 180)
    (q/image gr 0 120)
    (q/tint 200 127 180 127)
    (q/image gr 120 120)))

