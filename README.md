# 🧠 Proyecto de Automatización con Serenity BDD y Selenium WebDriver

---

## 📑 Tabla de contenido

- [Introducción](#-introducción)
- [Tecnologías utilizadas](#-tecnologías-utilizadas)
- [Ejecución](#-ejecución)
- [Sobre los datos del proyecto](#-sobre-los-datos-del-proyecto)

---

## 🧩 Introducción

Proyecto de automatización de pruebas web creado para fortalecer mis conocimientos en **Serenity BDD**, **Selenium** y **Gradle**.

Implementa el patrón **ScreenPlay** y ejecuta pruebas funcionales para la pagina de **Airbnb**, generando reportes detallados con Serenity.

---

## ⚙️ Tecnologías utilizadas

El proyecto está desarrollado en **Java**, utilizando **Gradle** como sistema de construcción y administración de dependencias.  
Implementa el framework **Serenity BDD** junto con **Selenium WebDriver**, bajo el patrón **ScreenPlay** para mantener una estructura escalable y reutilizable.

| Tecnología | Versión | Descripción |
|-------------|---------|--------------|
| **Java** | 11+ | Lenguaje base para el desarrollo del framework |
| **Gradle** | 8.14 | Sistema de construcción y gestión de dependencias |
| **Serenity BDD** | 4.2.22 | Framework principal de automatización de pruebas (incluye módulos para JUnit, Cucumber y Screenplay) |
| **Selenium WebDriver** | Incluido en Serenity | Control del navegador para pruebas automatizadas |
| **JUnit Jupiter (JUnit 5)** | 5.8.1 | Framework de pruebas unitarias e integración |
| **Apache POI** | 3.17 | Lectura y manipulación de archivos Excel (para datos de prueba) |
| **WebDriverManager** | 5.9.2 | Descarga y configuración automática de drivers del navegador |
| **SLF4J Simple** | 1.7.7 | Implementación ligera para logs del proyecto |

---

## 🚀 Ejecución

En esta sección se describen los pasos necesarios para clonar, configurar y ejecutar el proyecto localmente, así como la forma de ejecutar las pruebas en Airbnb.

### 🧰 Requisitos previos

- **Java 11** o superior instalado y con `JAVA_HOME` configurado.
- **Gradle 8.14** (no es necesario instalarlo manualmente: el proyecto incluye el *Gradle Wrapper*).
- **Navegador Chrome** (recomendado) u otro navegador compatible.
- **Conexión a Internet** para descargar dependencias y (opcional) para ejecutar en Airbnb.
- Opcional: **IntelliJ IDEA** o **Eclipse** para abrir el proyecto desde un IDE.

### ⚙️ Estructura de comandos (desde la raíz del proyecto)

> **Nota:** en sistemas Unix/macOS y en Git Bash usa `./gradlew`; en PowerShell (Windows) usa `.\gradlew.bat`.

1. Clonar el repositorio
```bash
git clone https://github.com/aymonsalver/airbnb-serenity-screenplay-automation.git
cd airbnb-serenity-screenplay-automation
```

2. Dar permisos de ejecución al Gradle Wrapper (solo en Unix/macOS)
```bash
chmod +x gradlew 
```

3. Limpiar y compilar el proyecto
```bash
# Unix / macOS / Git Bash
./gradlew clean build
```
```bash
# Windows PowerShell
.\gradlew.bat clean build
```

4. Ejecutar las pruebas localmente en Chrome
```bash
# Ejecuta la suite de tests configurada
./gradlew test
```
```bash
# O desde Windows PowerShell
.\gradlew.bat test
```

---

## 🔐 Sobre los datos del proyecto

El archivo **Excel** incluido dentro del proyecto (`src/test/resources/data/AlojamientoSeleccionado.xlsx`) contiene **atos públicos obtenidos desde la plataforma Airbnb, utilizados exclusivamente con fines didácticos y académicos.**  

La información fue extraída como parte de un ejercicio de automatización de pruebas y no tiene como propósito exponer datos sensibles, realizar uso comercial, ni vulnerar las políticas de la plataforma. Este proyecto tiene únicamente fines educativos para demostrar la automatización de extracción y manejo de datos en pruebas funcionales.

⚠️ **Importante:**
- No se incluyen datos personales, confidenciales ni sensibles.
- El propósito del archivo es ilustrar cómo parametrizar pruebas mediante datos externos (por ejemplo, usuarios o formularios de prueba).
- Cualquier persona que clone este repositorio puede reemplazar el contenido del archivo con sus propios datos de ejemplo, manteniendo la misma estructura de columnas.
- Se recomienda no utilizar datos reales o sensibles en entornos de prueba automatizados.
- El autor no se hace responsable del uso indebido de los datos o de la inclusión de información sensible por parte de los usuarios que utilicen este proyecto.