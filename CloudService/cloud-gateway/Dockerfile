FROM eclipse-temurin:17-jdk

VOLUME /tmp

ENV PORT 1919

EXPOSE 1919

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} cloud-gateway.jar

ENTRYPOINT ["java", "-jar","/cloud-gateway.jar"]


