FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} config-management
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-management/config-server.jar"]