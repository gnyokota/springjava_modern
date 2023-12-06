FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY target/*.jar registration.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","/registration.jar"]