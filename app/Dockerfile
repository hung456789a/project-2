FROM maven:3.8.7-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/call-api-job-1.0.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
