FROM eclipse-temurin:17-jdk

VOLUME /tmp

ENV PORT 8761

EXPOSE 8761

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} service-registry.jar

ENTRYPOINT ["java", "-jar","/patient-service.jar"]


