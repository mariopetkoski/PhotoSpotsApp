FROM openjdk:17
COPY target/locationapp.jar locationapp.jar
ENTRYPOINT ["java", "-jar", "/locationapp.jar"]