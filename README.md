# Ecumarkett

Ecumarkett es una aplicacion de escritorio hecha en Java para gestionar productos, categorias, clientes, proveedores, entradas, salidas y reportes. El proyecto nacio como una idea de aprendizaje y hoy queda ordenado como una base clara para mostrar, estudiar o seguir mejorando.

## Resumen

La aplicacion esta pensada para un flujo de inventario y venta sencillo:

1. Registrar usuarios y autenticarse.
2. Crear y mantener catalogos de productos, clientes, categorias y proveedores.
3. Controlar entradas y salidas de mercaderia.
4. Generar reportes impresos con JasperReports.

## Tecnologia usada

- Java 23
- Maven
- MySQL local con XAMPP
- Swing y formularios de NetBeans
- JasperReports
- JFreeChart
- FlatLaf para la interfaz

## Estructura del proyecto

```text
Ecumarkett/
|-- pom.xml
|-- README.md
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- com/
|   |   |   |   |-- ecumarket/
|   |   |   |   |   |-- Main.java
|   |   |   |   |-- mycompany/
|   |   |   |       |-- ecumarket/
|   |   |   |           |-- Ecumarket.java
|   |   |   |-- Dao/
|   |   |   |-- Extras/
|   |   |   |-- Formularios/
|   |   |   |-- Modelo/
|   |   |-- resources/
|   |   |   |-- Imagenes/
|   |   |-- reportes/
|   |   |   |-- *.jrxml
|   |   |   |-- *.jasper
|-- reportes/
|   |-- *.jrxml
|   |-- *.jasper
|-- Base de datos versiones/
|   |-- Para xampp/
|   |-- Para nuebe creacion de tablas/
|-- lib/
|-- target/
```

## Que hace cada carpeta

- `Dao/`: acceso a datos, conexion JDBC y consultas para cada entidad.
- `Formularios/`: pantallas de la aplicacion y archivos `.form` generados por NetBeans.
- `Modelo/`: clases con la estructura de los datos del sistema.
- `Extras/`: utilidades y componentes extra de interfaz.
- `com/ecumarket/Main.java`: punto de arranque principal de la aplicacion.
- `com/mycompany/ecumarket/Ecumarket.java`: clase heredada o de compatibilidad historica.
- `src/main/reportes/` y `reportes/`: plantillas y archivos compilados de reportes; el proyecto conserva ambas rutas por su historia en NetBeans.
- `src/main/resources/Imagenes/`: imagenes usadas por la interfaz.
- `Base de datos versiones/`: scripts SQL historicos de referencia.
- `lib/`: librerias locales que Maven o NetBeans resolvieron de forma manual.
- `target/`: salida generada por compilacion. No se edita a mano.

## Base de datos local

La conexion actual apunta a una base local llamada `inventario2` en MySQL/XAMPP.

Archivo relacionado: [src/main/java/Dao/conexion.java](src/main/java/Dao/conexion.java)

## Requisitos para abrirlo en local

- JDK 23
- Maven
- XAMPP con MySQL activo
- NetBeans o un IDE compatible con formularios Swing

## Como ejecutarlo

1. Levanta MySQL desde XAMPP.
2. Crea la base `inventario2` si no existe.
3. Abre el proyecto en NetBeans o ejecuta `mvn clean package`.
4. Corre la clase principal configurada en `pom.xml`.

## Notas del proyecto

- Este repositorio esta ordenado para lectura publica y para seguir trabajando sobre una base local.
- Los formularios y la estructura reflejan el flujo original del sistema, sin esconder su etapa de aprendizaje.
- Si quieres adaptar la conexion a otro entorno, el punto a cambiar es `conexion.java`.

## Sobre el origen del proyecto

Ecumarkett empezo como un proyecto de practica y fue creciendo por etapas. La idea de dejar este repo publico es mostrar la estructura real de trabajo: formularios, modelos, DAOs, reportes y conexion local, todo en un mismo lugar y de forma entendible.

## Wiki del proyecto

La version resumida de la documentacion esta en [wiki/Home.md](wiki/Home.md).

## Licencia de uso

Este proyecto se publica bajo la licencia MIT. Traduccion rapida: lo puedes usar, copiar, modificar y compartir, siempre que conserves el aviso de copyright y la licencia.
