# syntax=docker/dockerfile:1

# ---------- Etapa 1: compilar el servicio ----------
FROM eclipse-temurin:25-jdk AS build
ARG SERVICE
WORKDIR /workspace

# Se copia todo back/ (el .dockerignore descarta build, .gradle, .idea...)
COPY . .

# La caché de Gradle se conserva entre compilaciones para no volver a descargar dependencias
RUN --mount=type=cache,target=/root/.gradle \
    chmod +x gradlew \
    && ./gradlew --no-daemon :${SERVICE}:bootJar -x test \
    && cp "$(ls ${SERVICE}/build/libs/*.jar | grep -v plain)" /workspace/app.jar

# ---------- Etapa 2: imagen final, solo con el JRE ----------
FROM eclipse-temurin:25-jre
WORKDIR /app

# El servicio no corre como root
RUN useradd --system --no-create-home spring
USER spring

COPY --from=build /workspace/app.jar app.jar

ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]
