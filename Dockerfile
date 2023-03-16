FROM openjdk:17-slim
WORKDIR /app

COPY target/trains-app.jar /app/trains-app.jar

ENTRYPOINT java -jar /app/trains-app.jar