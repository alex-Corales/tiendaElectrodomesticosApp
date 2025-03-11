FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/carritoCompras-0.0.1.jar
COPY ${JAR_FILE} app_carritoCompras.jar
ENTRYPOINT ["java", "-jar", "app_carritoCompras.jar"]