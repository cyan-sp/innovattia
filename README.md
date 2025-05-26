# Sistema de Gestión de Empleados

- Registro de empleados con generación de ID único
- Actualización de información de empleados (completa y parcial)
- Estructura jerárquica de empleados con relaciones jefe-subordinado
- Endpoints de API RESTful
- Base de datos H2 en memoria

## Stack

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **Base de datos H2**
- **Maven**

## Esquema de Base de Datos

### Estructura de la Tabla Empleados

```sql
CREATE TABLE IF NOT EXISTS employees (
    id VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    curp VARCHAR(255),
    position VARCHAR(255),
    immediate_boss_id VARCHAR(255),
    street VARCHAR(255),
    exterior_number VARCHAR(255),
    interior_number VARCHAR(255),
    neighborhood VARCHAR(255),
    municipality VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255)
);
```

### Empleados precargados 

```bash
John Doe (Manager - ID: 1)
├── Jane Smith (Developer - ID: 2)
└── Alice Johnson (Developer - ID: 3)
```

# Colección de Postman

Este proyecto incluye una colección de Postman para probar los endpoints de la API.

## Información de la Colección

- **ID de Postman**: 85f39ef4-052b-4ce2-a448-5c9946ae2252
- **Nombre**: Innovattia
- **Esquema**: [Esquema de Colección de Postman](https://schema.getpostman.com/json/collection/v2.0.0/collection.json)
- **ID del Exportador**: 43444216
- **Enlace de la Colección**: [Ver Colección](https://cyan-1027480.postman.co/workspace/eaaa7e00-39a0-44d1-814a-d90ed75eaf2f/collection/43444216-85f39ef4-052b-4ce2-a448-5c9946ae2252?action=share&source=collection_link&creator=43444216)

## Endpoints de la API

### Obtener Empleados

- **Método**: GET
- **URL**: `http://localhost:8080/api/employees`
- **Respuesta**:
    - **Estado**: 200 OK
    - **Content-Type**: application/json
    - **Cuerpo**:
      ```json
      [
          {
              "id": "1",
              "firstName": "John",
              "lastName": "Doe",
              "curp": "CURP123456",
              "position": "Manager",
              "immediateBossId": null,
              "address": {
                  "street": "123 Main St",
                  "exteriorNumber": "1",
                  "interiorNumber": null,
                  "neighborhood": "Downtown",
                  "municipality": "City Center",
                  "state": "State",
                  "country": "Country"
              },
              "subordinates": [
                  {
                      "id": "2",
                      "firstName": "mary",
                      "lastName": "jane",
                      "curp": "CURP654321",
                      "position": "Developer",
                      "immediateBossId": "1",
                      "address": {
                          "street": "456 Elm St",
                          "exteriorNumber": "2",
                          "interiorNumber": null,
                          "neighborhood": "Uptown",
                          "municipality": "City Center",
                          "state": "State",
                          "country": "Country"
                      },
                      "subordinates": []
                  },
                  {
                      "id": "3",
                      "firstName": "Alice",
                      "lastName": "Johnson",
                      "curp": "CURP789012",
                      "position": "Developer",
                      "immediateBossId": "1",
                      "address": {
                          "street": "789 Oak St",
                          "exteriorNumber": "3",
                          "interiorNumber": null,
                          "neighborhood": "Uptown",
                          "municipality": "City Center",
                          "state": "State",
                          "country": "Country"
                      },
                      "subordinates": []
                  }
              ]
          }
      ]
      ```

### Actualizar Empleado

- **Método**: PATCH
- **URL**: `http://localhost:8080/api/employees/2`
- **Cuerpo de la Solicitud**:
    ```json
    {
        "firstName": "mary",
        "lastName": "jane"
    }
    ```

## Construir imagen docker

Construye la imagen Docker desde el directorio raíz del proyecto:

```bash
docker build -t innovattia-app .
```


Ejecuta la aplicacion :

```bash
docker run -p 8080:8080 innovattia-app
```
