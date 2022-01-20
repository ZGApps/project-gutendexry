FROM openjdk:8-jdk-alpine

COPY /target/Lombok-0.0.1-SNAPSHOT.jar Lombok-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/Lombok-0.0.1-SNAPSHOT.jar"]