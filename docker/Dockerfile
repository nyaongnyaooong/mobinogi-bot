FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app

COPY src ./src
COPY build.gradle ./build.gradle
RUN gradle build --no-daemon

FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"] 