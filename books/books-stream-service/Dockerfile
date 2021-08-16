FROM openjdk:11-jre-slim
ADD target/books-stream-service-0.0.1-SNAPSHOT.jar books-stream-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/books-stream-service.jar"]
