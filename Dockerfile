FROM griefed/baseimage-ubuntu-jdk-8:2.0.0 AS builder

ARG BRANCH_OR_TAG=master

RUN \
  apt-get update && apt-get upgrade -y && \
  apt-get install -y \
    libatomic1 && \
  git clone \
    -b $BRANCH_OR_TAG \
      https://github.com/SuK-IT/ChatBot.git \
        /tmp/chatbot && \
  chmod +x /tmp/chatbot/gradlew* && \
  cd /tmp/chatbot && \
  ./gradlew about installQuasar cleanFrontend assembleFrontend copyDist build --info -x test && \
  ls -ahl ./build/libs/

FROM griefed/baseimage-ubuntu-jdk-8:2.0.0

LABEL maintainer="Griefed <griefed@griefed.de>"
LABEL description="Chatbot in Java as backend and Quasar as frontend."

ENV LOG4J_FORMAT_MSG_NO_LOOKUPS=true

RUN \
  echo "**** Bring system up to date ****" && \
  apt-get update && apt-get upgrade -y && \
  echo "**** Creating our folder(s) ****" && \
  mkdir -p \
    /app/chatbot/data && \
  echo "**** Cleanup ****" && \
    rm -rf \
      /root/.cache \
      /tmp/*

COPY --from=builder tmp/chatbot/build/libs/ChatBot.jar /app/chatbot/chatbot.jar

COPY root/ /

COPY backend/main/resources/dictionary.json /defaults/dictionary.json

VOLUME /config

EXPOSE 8080