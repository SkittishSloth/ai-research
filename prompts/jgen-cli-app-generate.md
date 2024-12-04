Let's create a Java CLI application that does code generation similar to Ruby on Rails. For example, I can do a command line "jgen new class HelloWorld". It will recognize the project structure, create the appropriately named class in the most recently used package. If instead I used "jgen new class io.github.skittishsloth.test.HelloWorld", it would create the appropriate package structure in the main source set (if needed), then place the new class in that package. Then all subsequent calls to "new class" would default to that package.

The other initial command is to add import statements to source files. This can be targeted to add imports to a specific class, or package, or the entire project. 

The user can specify a class to add the import for. If there's only one class in the project and class path for that matches, it's added. If there is a conflict, the user is asked to distinguish, with the options displaying the fully qualified class name, including package.

If the user doesn't specify a class to import, the application will read each source file and see which classes are missing imports. It will then add them - again, prompting the user if there's more than one option.

In addition to class imports, it should also recognize static imports, and when they're needed.