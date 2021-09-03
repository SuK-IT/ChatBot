FROM griefed/baseimage-ubuntu-jdk-8:1.0.5 AS builder
#    nodejs \
#    npm && \
RUN \
  apt-get update && apt-get upgrade -y && \
  apt-get install -y \
    libatomic1 && \
  git clone \
    -b master \
      https://github.com/SuK-IT/ChatBot.git \
        /tmp/chatbot && \
  chmod +x /tmp/chatbot/gradlew* && \
  cd /tmp/chatbot && \
  ./gradlew about installQuasar cleanFrontend assembleFrontend copyDist build --info -x test && \
  ls -ahl ./build/libs/

FROM griefed/baseimage-ubuntu-jdk-8:1.0.5
ENV S6_BEHAVIOUR_IF_STAGE2_FAILS=2

LABEL maintainer="Griefed <griefed@griefed.de>"
LABEL description="Chatbot in Java as backend and Quasar as frontend."

RUN \
  echo "**** Bring system up to date ****" && \
  apt-get update && apt-get upgrade -y && \
  echo "**** Creating our folder(s) ****" && \
  mkdir -p \
    /app/chatbot/data && \
  mkdir \
    /config && \
  echo "**** Cleanup ****" && \
    rm -rf \
      /root/.cache \
      /tmp/*

COPY --from=builder tmp/chatbot/build/libs/ChatBot.jar /app/chatbot/chatbot.jar

COPY root/ /

COPY backend/main/resources/dictionary.json /defaults/dictionary.json

VOLUME /config

EXPOSE 8080