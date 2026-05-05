# Sistema de Gestión de Biblioteca

**Autor:** Manuel Vasco López

## Descripción del Proyecto
Este proyecto es una aplicación desarrollada en **Java 25** diseñada para la gestión integral de una biblioteca. El sistema permite realizar operaciones de persistencia sobre una colección de libros, facilitando su almacenamiento, consulta y mantenimiento de datos de manera eficiente.

La arquitectura se basa en el estándar **Jakarta Persistence (JPA)**, utilizando **ObjectDB** como motor de base de datos, lo que permite un manejo sencillo y rápido de los objetos sin necesidad de configurar complejos servidores SQL.

## Estructura del Código
El proyecto sigue una arquitectura modular para separar claramente las responsabilidades:

* **`modelo/Libro.java`**: POJO (Plain Old Java Object) que define la entidad `Libro`. Contiene los atributos básicos (título, autor, ISBN, etc.) y las anotaciones de Jakarta para su persistencia.
* **`DAO/LibroDAO.java`**: Capa de acceso a datos (Data Access Object). Encapsula todas las operaciones CRUD y las consultas personalizadas mediante JPQL.
* **`Main.java`**: Punto de entrada de la aplicación. Gestiona la conexión con la base de datos, inicializa los datos de prueba y ejecuta todas las consultas de demostración.

## Funcionalidades Implementadas
El sistema permite realizar las siguientes operaciones:

1.  **Gestión de registros:** Inserción de libros y borrado mediante identificador.
2.  **Consultas de filtrado:**
    * Obtención de todos los libros.
    * Búsqueda por género específico.
    * Búsqueda de libros por autor (búsqueda parcial).
    * Filtrado por año (libros desde el 2000).
    * Filtrado por stock (libros con menos de 3 ejemplares).
3.  **Estadísticas y Análisis:**
    * Cálculo del número total de libros.
    * Cálculo del precio medio de toda la biblioteca.
    * Identificación del libro más antiguo.
    * Listado de los 5 libros más caros.
    * Agrupaciones por género (cantidad de libros y precio medio).
    * Consulta de géneros con gran volumen de stock (más de 100 ejemplares).

## Persistencia de Datos
El proyecto utiliza un archivo local `biblioteca.odb` para almacenar la información.

- **Idempotencia:** El método `cargarDatosIniciales` incluido en el `Main` garantiza que los datos de prueba solo se inserten si la base de datos está vacía. Esto permite ejecutar la aplicación múltiples veces sin duplicar los registros existentes.

## Requisitos de Ejecución
- Java 25 o superior.
- Librerías de Jakarta Persistence.
- ObjectDB configurado en el proyecto.

---
*Desarrollado por Manuel Vasco López.*