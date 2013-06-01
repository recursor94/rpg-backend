(ns bot-backend.core)
(use 'server.socket)
(import '(java.io BufferedReader InputStreamReader PrintWriter))


(def server
  (create-server
   9001
   (fn [in out]
     (binding
         [*in* (BufferedReader. (InputStreamReader. in))
          *out* (PrintWriter. out)]
       (loop [input []]
         (println input)
         (recur (conj input (read-line))))))))
