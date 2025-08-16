# Etapa 1: Buid con Gradle y JDK 21 (Compilación)
FROM gradle:8.14.3-jdk21 AS buid
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar --no-daemon

# Etapa 2: Runtime con JDK 21 (Ejecución)
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=buid /app/build/libs/*.jar platzi-pizzeria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "platzi-pizzeria.jar"]