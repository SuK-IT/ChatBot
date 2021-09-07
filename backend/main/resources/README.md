# 1. ChatBot

## 1.1 About

ChatBot is a keyword-recognition-based Bot.
The backend is written in Java, using Spring Boot to deploy a webservice. 
The frontend is written in Quasar, a VueJS framework, using TypeScript instead of plain JS to ensure typesafety.

This is a small project for vocational school.

## 1.2 Building

To build the project and receive an executable exe/jar, execute 
`./gradlew about installQuasar cleanFrontend assembleFrontend copyDist build createExe --info`
from the main directory of this repository. After the execution finishes, you'll have your `ChatBot.exe` and `ChatBot-x.x.x-SNAPSHOT.jar`
available in the `build/libs`-directory.  3

## 1.3 Deploying

### 1.3.1 JAR

Deploying ChatBot from the JAR-file can be done by downloading the latest release from [the releases page](https://github.com/SuK-IT/ChatBot/releases/latest)
and executing it in any directory with `java -jar ChatBot-x.x.x.jar` where `x.x.x` represents the version you downloaded. Afterwards, head to `http://localhost:8080` in
your favorite webbrowser and you're good to go!

### 1.3.2 Docker

#### 1.3.2.1 Docker-Compose

Create a `docker-compose.yml`-file in your preferred location and add the following to it after editing it to your liking:

```yml
version: '3'
services:
  chatbot:
    image: ghcr.io/suk-it/chatbot:latest
    container_name: chatbot
    restart: unless-stopped
    environment:
      - TZ=Europe/Berlin # Your Timezone
      - PUID=1000 # Your user ID
      - PGID=1000 # your group ID
    volumes:
      - /path/to/dir/on/host:/config # Where you want to store config-data from the container on the host. Optional.
```

#### 1.3.2.1 Docker run

Run the following command, after editing it to your liking:

```bash
docker create \
  --name=chatbot \
  -e TZ=Europe/Berlin `# Your Timezone` \
  -e PUID=1000 `# Your user ID` \
  -e PGID=1000 `# Your group ID` \
  -v /path/to/dir/on/host:/config `# Where you want to store config-data from the container on the host. Optional.` \
  --restart unless-stopped \
  ghcr.io/suk-it/chatbot:latest
```

# 2. What got us started

## 2.1 Gradle and Spring Boot

### 2.1.1 Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Validation](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-validation)

### 2.1.2 Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### 2.1.3 Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## 2.2 Quasar Framework

### 2.2.1 Installation and creation of your first project

First, make sure you have Node >= 8 and NPM >= 5.

```bash
# install Quasar CLI:
$ npm install -g @quasar/cli

# generate a project folder
$ quasar create <folder_name>

$ cd my-project
$ npm install

# start developing your app
$ quasar dev

# Check CLI commands available:
$ quasar
```

### 2.2.2 Make your changes!

#### 2.2.2.1 Install the dependencies, if you changed any!
```bash
npm install
```

#### 2.2.2.2 Start the app in development mode (hot-code reloading, error reporting, etc.)
```bash
quasar dev
```

#### 2.2.2.3 Lint the files
```bash
npm run lint
```

#### 2.2.2.4 Build the app for production
```bash
quasar build
```

#### 2.2.2.5 Customize the configuration
See [Configuring quasar.conf.js](https://v2.quasar.dev/quasar-cli/quasar-conf-js).