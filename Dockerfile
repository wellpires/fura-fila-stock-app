FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
WORKDIR /home/wellington/git-pessoal/fura-fila-stock-app/
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
