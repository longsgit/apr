#* I give you the jar file **spring-boot-more-on-rest-api-0.0.1.jar**
#* Install jdk 17
#* Copy this jar file to the location you want, in your machine
#* Run **java -jar spring-boot-more-on-rest-api-0.0.1.jar**

FROM openjdk:17
COPY target/spring-boot-more-on-rest-api-0.0.1.jar app.jar
#EXPOSE is not mandatory; It helps if you run from Docker Desktop UI
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]