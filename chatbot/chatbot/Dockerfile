FROM maven:3.9-eclipse-temurin-11 AS build

WORKDIR /app

COPY /pom.xml .
COPY /src ./src


RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=build /app/target/chatbot.jar .

EXPOSE 8080

CMD ["java", "-jar", "chatbot.jar"]