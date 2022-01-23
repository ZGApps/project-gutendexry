FROM openjdk:8-jdk-alpine

COPY /target/Gutendexry-0.0.1-SNAPSHOT.jar Gutendexry-0.0.1-SNAPSHOT.jar

# Expose port 5000 of the container
EXPOSE 5000

ENTRYPOINT ["java", "-jar", "/Gutendexry-0.0.1-SNAPSHOT.jar"]