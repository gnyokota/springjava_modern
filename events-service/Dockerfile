FROM eclipse-temurin:latest

VOLUME /tmp

COPY target/*.jar events.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/events.jar"]