# Gradle MultiModule Project

I'm currently working with a new gradle multi-module project, and I'm trying to centralize the configuration for all of the modules. I have all of the plugins and dependencies in a version catalog, but I'm having issues with the common configuration side of things - applying plugins and dependencies, configuring plugins, etc. This is something I would normally have done with a root-level build.gradle.kts file, but I know that's no longer considered a best practice.

The project is slightly complicated - there's a bit of a cross-dependency between the projects. One project - `core` - has all the main functionality. The other project, `laws`, provides logic for ensuring implementations of the stuff in `core` are correct. `laws` has an `api` dependency on `core`. However, `core` _also_ needs to make sure it's correct, so it has a test dependency on `laws`. At the moment, `laws` also has implementation dependencies on some other test-related projects - namely `assertj`. `core` has no implementation or api dependencies.

I'm trying to use various static analysis tools, like Checker Framework, Spotless, Spotbugs, ErrorProne, etc. to make sure the code is in good shape, and I want to make sure all projects have the same configuration for each tool.

I tried using a buildSrc directory, with convention plugins as pre-compiled script plugins, e.g. static-analysis.gradle.kts. In here, I'm applying the plugins for the various tools, configuring them, and adding some related dependencies - libraries associated with the tools - to the project applying the plugin.

I end up with several warnings about how `laws` is trying to mutate configurations (i.e. `:laws:errorProneJavac`, `:laws:checkerFrameworkAnnotatedJDK`, etc.) after the configuration has been "resolved or consumed". I'm using gradle 8.10.2, and the warning says that this will fail with an error in gradle 9.0. I've tried digging in and searching online without much luck. The best theory I have at the moment is that my convention plugin is creating a single instance of all of the configurations, and this is initially processed when building `core`. Then, when `laws` builds, since it depends on `core`, it's working with configurations that have already been processed.

I've tried creating a "normal" plugin - a class that extends `org.gradle.api.Plugin` - but I get the same results, even if e.g. `core` applies the script plugin and `laws` applies the "normal" plugin.

Is there some simple solution I'm missing here regarding plugin/project lifecycle? Or is there a better alternative, like doing some other kind of centralization? I know there's some alternative where you have a `build-logic` project instead of `buildSrc`, but I don't know if that'd be any better or not.
