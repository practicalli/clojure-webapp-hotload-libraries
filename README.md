![Clojure REPL driven development with hotload of libraries](https://raw.githubusercontent.com/practicalli/graphic-design/live/clojure/clojure-repl-hotload-libraries.png)

# REPL driven development with hot-loading of Libraries
A simple web application server that is created using REPL driven development and hot-loading of libraries using `clojure.tools.deps.alpha`

> NOTE: `clojure.tools.deps.alpha.repl/add-libs` design is not finalized and may change at any time without notice.  If hot-loading stops working, check the [GitHub project](https://github.com/clojure/tools.deps.alpha) for changes.

* [Project Repository](https://github.com/practicalli/hot-loading)


## Usage
Start a REPL using the :alpha/hotload-libs alias from [practicalli/clojure-deps-edn](http://practicalli.github.io/clojure/clojure-tools/install/community-tools.html) user-level configuration

With Rebel Readline Terminal REPL UI with nREPL support:
```shell
clojure -M:alpha/hotload-libs:repl/rebel-nrepl
```

Or with Clojure nREPL editor support for Cider, Calva, Conjure, etc.
```shell
clojure -M:alpha/hotload-libs:middleware/cider-clj
```

Open the `src/practicalli/hot_loading.clj` file and evaluate each expression in turn that is contained within the `(comment ,,,)` rich commend block.

Alternatively, [use the `deps.edn` project configuration file to hotload libraries](https://practicalli.github.io/clojure/alternative-tools/clojure-tools/hotload-libraries.html#using-add-libs-with-project-configuration-file).


## Use cases to explore
1) building a web application and wish to try different html generation libraries, hiccup and sablono.  Hot load each of these libraries and try them out with the existing web application server.

## License
Copyright © 2021 Practicalli

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
