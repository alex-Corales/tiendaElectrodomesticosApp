FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/producto-0.0.1.jar
COPY ${JAR_FILE} produc.jar
ENTRYPOINT ["java", "-jar", "produc.jar"]