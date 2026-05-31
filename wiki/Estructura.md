# Estructura

```text
Ecumarkett/
|-- pom.xml
|-- README.md
|-- LICENSE
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
|-- wiki/
```

## Carpetas clave

- `Dao/`: consultas y acceso a datos.
- `Formularios/`: pantallas de la aplicacion.
- `Modelo/`: clases con la estructura de los datos.
- `Extras/`: utilidades y componentes de interfaz.
- `src/main/reportes/`: plantillas y reportes compilados.
- `src/main/resources/Imagenes/`: imagenes usadas por la interfaz.
- `wiki/`: documentacion resumida del proyecto.

## Idea general

El proyecto esta organizado para que el flujo sea facil de seguir: vista, logica de acceso a datos, modelos y reportes.