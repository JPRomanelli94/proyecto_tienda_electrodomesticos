FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/trolleys-service-0.0.1.jar
COPY ${JAR_FILE} app_trolleys.jar
ENTRYPOINT ["java","-jar","app_trolleys.jar"]