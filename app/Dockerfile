FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/call-api-job-1.0.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
