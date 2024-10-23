**HandlerMethodArgumentResolver** is a Strategy interface for resolving method parameters into argument values in the context of a given request.

**supportsParameter()** method checks whether the given method parameter is supported by this resolver.

**resolveArgument()** method resolves a method parameter into an argument value from a given request.
UseCase: Validating parameters, Preload parameter.

https://stackoverflow.com/questions/78819099/how-to-preload-common-resource-in-a-spring-boot-restcontroller/78822362#78822362
