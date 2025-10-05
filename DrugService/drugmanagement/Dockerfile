FROM eclipse-temurin:17-jdk

VOLUME /tmp

ENV PORT 9002

EXPOSE 9002

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} drug-service.jar

ENTRYPOINT ["java", "-jar","/drug-service.jar"]

