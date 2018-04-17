FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} zuul-proxy
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul-proxy/gateway.jar"]