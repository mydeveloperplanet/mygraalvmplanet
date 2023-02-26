FROM eclipse-temurin:17.0.5_8-jre-alpine
COPY target/mygraalvmplanet-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]