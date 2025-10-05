FROM eclipse-temurin:17-jdk

VOLUME /tmp

ENV PORT 9004

EXPOSE 9004

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} druginteractionchecker-service.jar

ENTRYPOINT ["java", "-jar","/druginteractionchecker-service.jar"]
