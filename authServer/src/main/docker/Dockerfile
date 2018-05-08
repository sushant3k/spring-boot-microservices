FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} auth-server
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/auth-server/auth-server.jar"]