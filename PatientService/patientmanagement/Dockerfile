FROM eclipse-temurin:17-jdk

VOLUME /tmp

ENV PORT 9001

EXPOSE 9001

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} patient-service.jar

ENTRYPOINT ["java", "-jar","/patient-service.jar"]
