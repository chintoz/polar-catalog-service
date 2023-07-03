FROM eclipse-temurin:17
WORKDIR workspace
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} polar-catalog-service.jar
ENTRYPOINT ["java", "-jar", "polar-catalog-service.jar"]