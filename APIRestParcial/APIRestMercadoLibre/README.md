# Proyecto de Detección de Mutantes

## Descripción

Este proyecto es una aplicación Spring Boot que permite detectar si un humano es mutante basado en su secuencia de ADN. Utiliza una arquitectura en capas con controladores, servicios y repositorios, y está diseñado para manejar solicitudes a través de una API REST.

## Estructura del Proyecto

- **Entidades**: Clases que representan los modelos de datos (por ejemplo, `Humano`, `Estadistica`).
- **Repositorios**: Interfaces que extienden `JpaRepository` para la interacción con la base de datos.
- **Servicios**: Clases que implementan la lógica de negocio y operaciones sobre las entidades.
- **Controladores**: Clases que manejan las solicitudes HTTP y responden con datos.

## Tecnologías Utilizadas

- **Spring Boot**: Para la construcción de la API REST.
- **JPA/Hibernate**: Para la gestión de la base de datos.
- **H2**: Como base de datos en memoria para pruebas y desarrollo.
- **Lombok**: Para la reducción del código boilerplate.
- **JUnit**: Para pruebas unitarias.
- **JaCoCo**: Para la cobertura de código.
- **JMeter**: Para realizar pruebas de carga y rendimiento.

## Cloud Computing

La aplicación está alojada en **Render**, donde se puede acceder a la API. Puedes encontrar la aplicación en el siguiente enlace:

[Acceder a la aplicación en Render](https://apirestmercadolibre-1.onrender.com)

Ademas para acceder a la base de datos se debe colocar el siguiente link (https://apirestmercadolibre-1.onrender.com/h2-console/)

## Pruebas

Se han realizado pruebas exhaustivas en la aplicación, incluyendo:

- **Pruebas Unitarias**: Usando JUnit para verificar la lógica de negocio y el comportamiento de los servicios.
- **Pruebas de Carga**: Usando JMeter para evaluar el rendimiento de la API bajo diferentes condiciones de carga.

## Instalación

Para instalar y ejecutar el proyecto localmente, sigue estos pasos:

1. Clona este repositorio.
2. Navega al directorio del proyecto.
3. Ejecuta `./gradlew bootRun` para iniciar la aplicación.

   La aplicación estará disponible en http://localhost:8080.

## Uso de la Aplicación

La aplicación expone varios endpoints para interactuar con las secuencias de ADN y las estadísticas de mutantes. A continuación se describen los usos de cada uno de los endpoints disponibles en la API.

### 1. Verificar si un Humano es Mutante

- **Endpoint**: `POST /mutantes`
- **Descripción**: Envía una secuencia de ADN y verifica si pertenece a un mutante.
- **Cuerpo de la Solicitud**:
    ```json
    {
      "dna": ["AAAAGTG", "CAGTGCC", "TGATATG", "GAATTGC", "CCCTTCG", "TGACTTG", "CACTACG"]
    }
    ```
- **Respuestas**:
    - **200 OK**: Si el humano es mutante.
        ```json
        {
          "mensaje": "El humano es un mutante."
        }
        ```
    - **403 Forbidden**: Si el humano no es mutante.
        ```json
        {
          "mensaje": "El humano no es un mutante."
        }
        ```

### 2. Obtener todas las Secuencias de ADN

- **Endpoint**: `GET /mutantes`
- **Descripción**: Obtiene todas las secuencias de ADN almacenadas en la base de datos.
- **Respuesta**:
    - **200 OK**: Lista de todas las entidades `Humano`.
        ```json
        [
          {
            "id": 1,
            "dna": ["AAAAGTG", "CAGTGCC", "TGATATG", "GAATTGC", "CCCTTCG", "TGACTTG", "CACTACG"],
            "esMutante": true
          },
          {
            "id": 2,
            "dna": ["AAGGTAG", "CAGTACC", "TGATCTG", "GAATTGA", "CCCTGCG", "TGACTTG", "CACTAGC"],
            "esMutante": false
          }
        ]
        ```

### 3. Obtener una Secuencia de ADN Específica

- **Endpoint**: `GET /mutantes/{id}`
- **Descripción**: Obtiene los detalles de una secuencia de ADN específica por ID.
- **Respuesta**:
    - **200 OK**: Detalles de la entidad `Humano` correspondiente al ID proporcionado.
        ```json
        {
          "id": 1,
          "dna": ["AAAAGTG", "CAGTGCC", "TGATATG", "GAATTGC", "CCCTTCG", "TGACTTG", "CACTACG"],
          "esMutante": true
        }
        ```
    - **404 Not Found**: Si no se encuentra la secuencia de ADN con el ID proporcionado.

### 4. Actualizar una Secuencia de ADN

- **Endpoint**: `PUT /mutantes/{id}`
- **Descripción**: Actualiza una secuencia de ADN específica por ID. Verifica si el humano es mutante antes de realizar la actualización.
- **Cuerpo de la Solicitud**:
    ```json
    {
      "dna": ["AAAAGTG", "CAGTGCC", "TGATATG", "GAATTGC", "CCCTTCG", "TGACTTG", "CACTACG"]
    }
    ```
- **Respuestas**:
    - **200 OK**: Si el humano es mutante y la actualización fue exitosa.
        ```json
        {
          "mensaje": "La secuencia de ADN ha sido actualizada exitosamente."
        }
        ```
    - **403 Forbidden**: Si el humano no es mutante y la actualización fue exitosa.
        ```json
        {
          "mensaje": "La secuencia de ADN ha sido actualizada, pero el humano no es mutante."
        }
        ```
    - **500 Internal Server Error**: Si ocurrió un error en la actualización.

### 5. Eliminar una Secuencia de ADN

- **Endpoint**: `DELETE /mutantes/{id}`
- **Descripción**: Elimina una secuencia de ADN específica por ID.
- **Respuestas**:
    - **204 No Content**: Si la eliminación fue exitosa.
    - **400 Bad Request**: Si ocurrió un error al intentar eliminar la secuencia.

### 6. Obtener Estadísticas de Mutantes

- **Endpoint**: `GET /stats`
- **Descripción**: Devuelve estadísticas sobre el número de humanos y mutantes.
- **Respuesta**:
    - **200 OK**: Estadísticas de humanos y mutantes.
        ```json
        {
          "cantidadHumanos": 10,
          "cantidadMutantes": 5,
          "ratio": 0.5
        }
        ```
