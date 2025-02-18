# Build stage
FROM maven:3.8.8-eclipse-temurin-21 as build

RUN mkdir -p /build
WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean install -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-jammy
ARG APP_VERSION=1.0.0

WORKDIR /app
COPY --from=build /build/target/su-api-*.jar /app/

EXPOSE 8080
ENV JAR_VERSION=${APP_VERSION}
CMD java -jar su-api-${JAR_VERSION}.jar
