FROM openjdk:17-alpine
VOLUME /tmp
ARG JAR_FILE=target/MP-Bank-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]