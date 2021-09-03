# ChatBot

## About

ChatBot is a keyword-recognition-based Bot.
The backend is written in Java, using Spring Boot to deploy a webservice. 
The frontend is written in Quasar, a VueJS framework, using TypeScript instead of plain JS to ensure typesafety.

This is a small project for vocational school.

## Building

To build the project and recieve an executable exe/jar, execute 
`./ gradlew about installQuasar cleanFrontend assembleFrontend copyDist build createExe --info`
from the main directory of this repository. After the execution finishes, you'll have your `ChatBot.exe` and `ChatBot-x.x.x-SNAPSHOT.jar`
available in the `build/libs`-directory.  

# Getting Started

## Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Validation](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-validation)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

## Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

