FROM openjdk:17-alpine

WORKDIR /app
COPY target/back-medic-0.0.1-SNAPSHOT.jar /app/back-medic.jar
EXPOSE 8080
CMD ["java", "-jar","back-medic.jar"]