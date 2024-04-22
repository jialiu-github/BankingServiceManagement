FROM gradle:latest as builder

WORKDIR /app

COPY build.gradle .
COPY src ./src

RUN gradle build

FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar ./app.jar

EXPOSE 3000

CMD ["java", "-jar", "app.jar"]