FROM gradle:jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon -x test

FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
COPY src/main/resources/application.yml /app/application.yml

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"] 