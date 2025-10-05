FROM eclipse-temurin:17-jdk

VOLUME /tmp

ENV PORT 9003

EXPOSE 9003

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} authentication-service.jar

ENTRYPOINT ["java", "-jar","/authentication-service.jar"]
