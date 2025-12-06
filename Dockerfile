# syntax=docker/dockerfile:1

# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /workspace

# Cache dependencies first
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

# Copy sources and build
COPY src ./src
RUN mvn -q -e -DskipTests clean package

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre-alpine
# Create non-root user
RUN addgroup -S app && adduser -S app -G app
USER app

WORKDIR /app
# Adjust jar name if your artifact differs
COPY --from=builder /workspace/target/*.jar app.jar

# Expose the port your app uses
EXPOSE 8080

# Pass JVM tuning as needed; keep entrypoint overridable
ENTRYPOINT ["java","-XX:+UseZGC","-XX:MaxRAMPercentage=75.0","-jar","/app/app.jar"]