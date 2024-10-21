# Etapa de construcción
FROM alpine:latest as build

# Actualizar e instalar OpenJDK 17
RUN apk update && apk add openjdk17

# Copiar el contexto de construcción al contenedor
COPY . .

# Hacer el script gradlew ejecutable
RUN chmod +x ./gradlew

# Construir el archivo JAR
RUN ./gradlew bootJar --no-daemon

# Etapa de ejecución
FROM openjdk:17-alpine

# Exponer el puerto en el que la aplicación escucha
EXPOSE 9000

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build ./build/libs/APIRestMercadoLibre-0.0.1-SNAPSHOT.jar ./app.jar

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]