FROM openjdk:8-jdk-alpine

MAINTAINER Phea Soy

COPY target/spring-cloud-gateway-0.0.1-SNAPSHOT.jar /usr/app/app.jar

WORKDIR /usr/app

EXPOSE 8081:8081

ENTRYPOINT ["java","-jar","app.jar"]