# Sistema de Aprendizaje

Este proyecto es una plataforma de aprendizaje en línea que se adapta a las necesidades individuales de cada estudiante. Ofrece una variedad de cursos en diferentes disciplinas, cada uno compuesto por múltiples módulos y lecciones. También incluye herramientas para instructores, seguimiento de progreso de los estudiantes y rutas de aprendizaje personalizadas.

## Funcionalidades
- Catálogo de cursos y módulos de aprendizaje.
- Evaluación inicial de conocimientos y preferencias de aprendizaje.
- Generación de rutas de aprendizaje personalizadas.
- Sistema de seguimiento de progreso del estudiante.
- Herramientas para la creación y gestión de contenido por parte de los instructores.
- Evaluaciones adaptativas basadas en el rendimiento del estudiante.
- Sistema de comunicación entre estudiantes e instructores.
- Generación de informes de rendimiento y análisis de aprendizaje.

## Tecnologías Utilizadas

- **Java**: Versión 23
- **Spring Boot**: Versión 3.3.4
- **MongoDB Atlas**: Base de datos NoSQL
- **Thymeleaf**: Motor de plantillas para la interfaz
- **Spring Data MongoDB**: Integración con MongoDB
- **Spring Security**: Seguridad y autenticación (opcional)
- **Springdoc OpenAPI**: Documentación automática de la API con Swagger UI
- **Junit 5**: Pruebas unitarias

## Requisitos Previos

- JDK 23 instalado.
- MongoDB Atlas configurado.
- Maven instalado.

## Instalación y Ejecución

1. Clona el repositorio:
    ```bash
    git clone https://github.com/usuario/sistema-aprendizaje.git
    ```
2. Dirígete al directorio del proyecto:
    ```bash
    cd sistema-aprendizaje
    ```
3. Configura tu archivo `application.properties`:
    ```properties
    spring.data.mongodb.uri=mongodb+srv://<user>:<password>@cluster0.zr5m3.mongodb.net/sistemadeaprendizaje
    ```
4. Ejecuta el proyecto usando Maven:
    ```bash
    mvn spring-boot:run
    ```

5. Accede a la aplicación en [http://localhost:8080](http://localhost:8080).

## Documentación de la API

La API está documentada automáticamente usando **Springdoc OpenAPI**. Puedes acceder a la documentación Swagger UI en:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Endpoints Principales

#### **Catálogo de Cursos**
- **GET** `/api/cursos`  
  Devuelve todos los cursos disponibles.

- **POST** `/api/cursos`  
  Crea un nuevo curso.

- **GET** `/api/cursos/{id}`  
  Devuelve los detalles de un curso específico.

- **PUT** `/api/cursos/{id}`  
  Actualiza los detalles de un curso.

- **DELETE** `/api/cursos/{id}`  
  Elimina un curso.

#### **Evaluaciones**
- **POST** `/api/evaluaciones`  
  Crea una evaluación para un estudiante sobre un curso específico.

#### **Seguimiento de Progreso**
- **GET** `/api/estudiantes/{id}/progreso`  
  Devuelve el progreso del estudiante en todos sus cursos.

### Ejemplo de Uso - Crear Curso

```bash
curl -X POST "http://localhost:8080/api/cursos" \
  -H "Content-Type: application/json" \
  -d '{
  "nombre": "Curso de Programación",
  "modulos": [
    {
      "nombre": "Introducción a Java",
      "lecciones": [
        { "nombre": "Variables y Tipos de Datos", "contenido": "..." },
        { "nombre": "Estructuras de Control", "contenido": "..." }
      ]
    }
  ]
}'
```

# Informe Técnico
## Decisiones de Diseño
- Base de Datos NoSQL: Se utilizó MongoDB Atlas para manejar la estructura de cursos, módulos y lecciones como documentos embebidos, ya que este formato se adapta bien al contenido dinámico de los cursos.

- Spring Boot y Spring Data MongoDB: Permiten una fácil integración con MongoDB y ofrecen una estructura sólida para construir la API REST.

- Springdoc OpenAPI: Se seleccionó para generar automáticamente la documentación de la API con Swagger UI, lo que facilita las pruebas y la exploración de los endpoints.

# Desafíos
La generación de rutas de aprendizaje personalizadas basadas en las evaluaciones iniciales de los estudiantes fue un reto debido a la necesidad de ajustar dinámicamente el contenido.
Implementar un sistema de evaluación adaptativa que ajuste la dificultad del contenido con base en el desempeño del estudiante fue otro desafío importante.