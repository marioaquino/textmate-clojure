#!/usr/bin/env cake run
(in-ns 'textmate)
(clojure.core/refer 'clojure.core)
(require '[clojure.java.io :as io])
(load-file (str (io/file (cake/*env* "TM_BUNDLE_SUPPORT") "utils.clj")))

(textmate/attempt
	#_(println (get-last-sexpr))
  (clojure.core/println
      "<pre>"
      (-> (get-last-sexpr)
          clojure.core/eval
          textmate/eval-in-file-ns
          textmate/str-nil
          textmate/htmlize)
      "</pre>"))