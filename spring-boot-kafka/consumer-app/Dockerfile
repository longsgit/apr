FROM openjdk:17-alpine
COPY target/consumer-app-0.0.1.jar app.jar
ENV KAFKA_HOST "localhost"
ENV KAFKA_PORT 9092
ENTRYPOINT ["java", "-jar", "-Dspring.kafka.bootstrap-servers=${KAFKA_HOST}:${KAFKA_PORT}",  "/app.jar"]