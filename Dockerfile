# escape=\
# syntax=docker/dockerfile:1

FROM openjdk:21-jdk-slim

RUN mkdir -p /bot/plugins

COPY [ "build/libs/sharkbot.jar", "/bot/sharkbot.jar" ]

VOLUME [ "/bot/data" ]

WORKDIR /bot

ENTRYPOINT [ "java", "-Xmx1G", "-jar", "/bot/sharkbot.jar" ]
