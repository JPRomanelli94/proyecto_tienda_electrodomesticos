FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/api-gateway-0.0.1.jar
COPY ${JAR_FILE} api_gateway.jar
ENTRYPOINT ["java","-jar","api_gateway.jar"]