# 📚 Sistema de Gestión de Biblioteca

Una aplicación REST API desarrollada con **Spring Boot** para gestionar un catálogo de libros. El sistema permite registrar, consultar, actualizar y eliminar libros de una biblioteca de forma fácil y eficiente.

## ✨ Características

- ✅ **Crear libros**: Registra nuevos libros en el sistema
- ✅ **Listar libros**: Obtiene el catálogo completo de libros
- ✅ **Buscar por ID**: Encuentra un libro específico por su identificador
- ✅ **Consultar disponibilidad**: Filtra libros disponibles para préstamo
- ✅ **Eliminar libros**: Remueve libros del catálogo
- ✅ **Estadísticas**: Obtiene el total de libros registrados
- ✅ **Base de datos persistente**: Usa MySQL para almacenar información

## 🔧 Requisitos Previos

Antes de ejecutar este proyecto, asegúrate de tener instalado:

- **Java 17** o superior
- **Maven 3.6+** (incluido con el proyecto)
- **MySQL 8.0+** ejecutándose localmente
- **Git** (opcional, para clonar el proyecto)

## 📥 Instalación

### 1. Clonar el proyecto

```bash
git clone <url-del-repositorio>
cd biblioteca
```

### 2. Crear la base de datos

Ejecuta este comando en tu cliente MySQL:

```sql
CREATE DATABASE biblioteca_db;
USE biblioteca_db;
```

### 3. Configurar las credenciales de base de datos

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql
```

### 4. Compilar el proyecto

```bash
# En Windows
mvnw.cmd clean install

# En Linux/Mac
./mvnw clean install
```

### 5. Ejecutar la aplicación

```bash
# En Windows
mvnw.cmd spring-boot:run

# En Linux/Mac
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 🚀 Uso de la API

### Endpoints Disponibles

#### 1️⃣ Registrar un Libro
**Método:** `POST` | **Endpoint:** `/libros`

```bash
curl -X POST http://localhost:8080/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Clean Code",
    "autor": "Robert Martin",
    "editorial": "Prentice Hall",
    "anioPublicacion": 2008,
    "disponible": true
  }'
```

#### 2️⃣ Obtener Todos los Libros
**Método:** `GET` | **Endpoint:** `/libros`

```bash
curl http://localhost:8080/libros
```

#### 3️⃣ Obtener Libro por ID
**Método:** `GET` | **Endpoint:** `/libros/{id}`

```bash
curl http://localhost:8080/libros/1
```

#### 4️⃣ Obtener Libros Disponibles
**Método:** `GET` | **Endpoint:** `/libros/disponibles`

```bash
curl http://localhost:8080/libros/disponibles
```

#### 5️⃣ Obtener Total de Libros
**Método:** `GET` | **Endpoint:** `/libros/total`

```bash
curl http://localhost:8080/libros/total
```

#### 6️⃣ Eliminar un Libro
**Método:** `DELETE` | **Endpoint:** `/libros/{id}`

```bash
curl -X DELETE http://localhost:8080/libros/1
```

## 📊 Modelo de Datos

### Entidad: Libro

```java
{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert Martin",
  "editorial": "Prentice Hall",
  "anioPublicacion": 2008,
  "disponible": true
}
```

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `id` | Long | Identificador único (autogenerado) |
| `titulo` | String | Título del libro |
| `autor` | String | Nombre del autor |
| `editorial` | String | Casa editorial |
| `anioPublicacion` | Integer | Año de publicación |
| `disponible` | Boolean | Disponibilidad para préstamo |

## 📁 Estructura del Proyecto

```
biblioteca/
├── src/
│   ├── main/
│   │   ├── java/cl/duoc/biblioteca/
│   │   │   ├── BibliotecaApplication.java     # Clase principal
│   │   │   ├── controller/
│   │   │   │   └── LibroController.java       # Controlador REST
│   │   │   ├── entity/
│   │   │   │   └── Libro.java                 # Entidad JPA
│   │   │   ├── repository/
│   │   │   │   └── LibroRepository.java       # Interfaz de acceso a datos
│   │   │   └── service/
│   │   │       └── LibroService.java          # Lógica de negocio
│   │   └── resources/
│   │       ├── application.properties         # Configuración
│   │       ├── static/                        # Archivos estáticos
│   │       └── templates/                     # Plantillas HTML
│   └── test/
│       └── java/.../BibliotecaApplicationTests.java
├── pom.xml                                    # Dependencias Maven
└── README.md                                  # Este archivo
```

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Descripción |
|------------|---------|------------|
| **Spring Boot** | 3.5.16 | Framework web de aplicaciones Java |
| **Spring Data JPA** | 3.5.16 | Acceso a datos con ORM Hibernate |
| **MySQL** | 8.0+ | Base de datos relacional |
| **Java** | 17+ | Lenguaje de programación |
| **Maven** | 3.6+ | Gestor de dependencias y construcción |

## 🐛 Solución de Problemas

### Error: "Connection refused" en MySQL

**Solución:** Verifica que el servidor MySQL está ejecutándose:

```bash
# En Windows
net start MySQL80

# En Linux
sudo systemctl start mysql
```

### Error: "Access denied for user 'root'"

**Solución:** Verifica las credenciales en `application.properties`

### Error: "Database biblioteca_db doesn't exist"

**Solución:** Crea la base de datos ejecutando:

```sql
CREATE DATABASE biblioteca_db;
```

## 📝 Ejemplo Completo de Uso

```bash
# 1. Registrar un nuevo libro
curl -X POST http://localhost:8080/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "The Pragmatic Programmer",
    "autor": "David Thomas",
    "editorial": "Addison-Wesley",
    "anioPublicacion": 1999,
    "disponible": true
  }'

# 2. Listar todos los libros
curl http://localhost:8080/libros

# 3. Buscar un libro por ID
curl http://localhost:8080/libros/1

# 4. Ver libros disponibles
curl http://localhost:8080/libros/disponibles

# 5. Obtener estadísticas
curl http://localhost:8080/libros/total
```

## 📞 Soporte y Contacto

Si encuentras problemas o tienes sugerencias, por favor abre un issue en el repositorio.

## 📄 Licencia

Este proyecto está disponible bajo la licencia MIT.

---

**Desarrollado con ❤️ en DUOC UC**

