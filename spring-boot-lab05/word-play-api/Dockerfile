FROM openjdk:17-alpine
COPY target/word-play-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV PALINDROME_API_HOST "localhost"
ENV PALINDROME_API_PORT 8080
ENTRYPOINT ["java", "-jar", "-Dpalindrome-api.host=${PALINDROME_API_HOST}", "-Dpalindrome-api.port=${PALINDROME_API_PORT}",  "/app.jar"]