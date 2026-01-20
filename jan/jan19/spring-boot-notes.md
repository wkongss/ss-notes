### The Spring Framework

 - Spring provides dependency injection via its Inversion of Control (IoC) container.
 - Dependencies are packaged by inheriting a BeanFactory class that is responsible for instantiating "beans" or "pogos" (Plain Old Java Object). Then, wherever necessary, the IoC will provide the context the required bean.
 - This factory design principle generally supports looser dependency coupling, reducing direct dependencies.

 - The IoC is a container that contains both the BeanFactory and the application context.

### Spring Boot

- Whereas Spring is a highly-customizable framework that allows for versatile usage whether it be cloud computing, web development, and so forth, Spring Boot is a default configuration that stresses "convention over configuration" in which much of the configuration is done for you, to what the maintainers feel are "Best practices", making it an "opinionated" library.

33:10