FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/eureka-sv-0.0.1.jar
COPY ${JAR_FILE} eureka-sv.jar
ENTRYPOINT ["java","-jar","eureka-sv.jar"]