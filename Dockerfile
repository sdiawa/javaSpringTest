FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY ./target/*.jar /javaSpring-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "javaSpring-0.0.1-SNAPSHOT.jar"]