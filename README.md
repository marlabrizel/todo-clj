# todo-clj

Todo-CLJ is my first-ever Clojure application.

To start a server, clone the repository and type the following:
```
$ lein ring server
```

This command will start a server on `localhost:3000`. Note that there is no need to stop and restart the server to load new code changes.

Run `lein uberjar` to compile a `.jar` file containing the code and its dependencies.

### Tools/Packages Used
- Compojure
- Ring
- Hiccup
- PostgreSQL
- Lein Ring

### Next Steps
Given that this is my first foray into Clojure, I've listed ideas for next steps and areas to explore below:
- Finish crud functionality
- Beef up the test suite
- Clean up the UI
- Add AJAX calls for various CRUD actions for better UX (eg create, update, delete)
- Experiment with an ORM like Korma to wrap raw SQL calls

### Insights
I enjoyed this project. Compojure struck me as being quite similar to Sinatra. I especially enjoyed using Hiccup for templating - the syntax was clean and reminded me a bit of HAML templates. I also appreciated that I didn't have to insert any pure HTML markup anywhere into my templates as opposed to say, ERB, which can sometimes involve a mix of Ruby and markup.

Error messages were generally helpful but occasionally obtuse. I develop mainly in vim (with some adventures in Atom), so I did not have the syntax assistance that an editor such as Emacs affords. This led to a few adventures trying to understand what the JVM was telling me only to discover that I, for example, forgot to properly close a vector.

Finally, it was fun to see what I could do in just a few days. As I mentioned, this was my first time writing Clojure on my own so I started at zero. It was a fun exercise to translate general understanding of HTTP, databases, and basic CRUD into an entirely new syntax and structure.
