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

### Empleados precargados 

John Doe (Manager - ID: 1)
├── Jane Smith (Developer - ID: 2)
└── Alice Johnson (Developer - ID: 3)