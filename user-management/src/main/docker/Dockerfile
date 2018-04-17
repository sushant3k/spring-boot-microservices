FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} user-management
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user-management/um.jar"]