FROM openjdk:8-jdk-alpine

COPY target/book-service-client.jar app.jar

EXPOSE 9091

CMD ["java", "-jar", "app.jar"]