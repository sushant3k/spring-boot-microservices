FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} customer-management
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customer-management/cm.jar"]