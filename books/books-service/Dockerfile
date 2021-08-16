FROM openjdk:11-jre-slim
ADD target/books-service-0.0.1-SNAPSHOT.jar books-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/books-service.jar"]
