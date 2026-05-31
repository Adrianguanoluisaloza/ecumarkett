# Instalacion

## Requisitos

- JDK 23
- Maven
- XAMPP con MySQL activo
- NetBeans o un IDE compatible con formularios Swing

## Base de datos

La conexion actual apunta a una base local llamada `inventario2`.

## Pasos

1. Inicia MySQL desde XAMPP.
2. Crea la base de datos `inventario2` si no existe.
3. Abre el proyecto en NetBeans o ejecuta `mvn clean package`.
4. Ejecuta la clase principal definida en `pom.xml`.

## Nota

Si cambias de entorno, el archivo que controla la conexion es [src/main/java/Dao/conexion.java](https://github.com/Adrianguanoluisaloza/ecumarkett/blob/main/src/main/java/Dao/conexion.java).