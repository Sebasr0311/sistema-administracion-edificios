<div align="center">

# 🏢 Sistema de Administración de Edificios

![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![JavaFX](https://img.shields.io/badge/JavaFX-17%2B-blue)
![Oracle](https://img.shields.io/badge/Oracle-SQL%20Express%2018c-red)
![Licencia](https://img.shields.io/badge/Licencia-Académica-green)

**Sistema integral de administración de edificios de apartamentos en arriendo con control de visitas mediante códigos QR**

*Proyecto Académico — Materias: Base de Datos & Programación 3 (Buenas Prácticas)*
*Universidad — Valledupar, Cesar, Colombia*

</div>

---

## 📋 Descripción del Proyecto

El **Sistema de Administración de Edificios** es una aplicación de escritorio desarrollada en Java con JavaFX que permite automatizar y centralizar los procesos administrativos de un edificio de apartamentos de **arriendo** ubicado en Valledupar, Cesar, Colombia.

### 🎯 Objetivo Principal

Digitalizar y automatizar los procesos del edificio, eliminando trámites manuales y mejorando la seguridad y experiencia tanto de residentes como del personal administrativo.

### 🌟 Diferenciador: Sistema de Visitas con Código QR

El módulo más innovador del proyecto es el **sistema de control de visitas basado en códigos QR**, que elimina la necesidad de que el vigilante llame al propietario cada vez que llega una visita:

- 📲 El propietario registra al visitante desde la aplicación (nombre, documento, PDF del documento, tipo de vehículo)
- ⏱️ El propietario define la duración del código QR (mínimo 5 minutos, máximo 60 minutos)
- 🔑 Se genera un código QR **único de un solo uso** — una vez escaneado, se invalida
- 📤 El QR se comparte fácilmente vía **WhatsApp** directamente desde la aplicación
- 📷 El visitante llega al edificio y presenta el QR desde su celular al vigilante
- 🖥️ El vigilante escanea el QR y ve en pantalla toda la información: quién generó la visita, datos del visitante, PDF del documento para verificación, vehículo y acompañantes
- 🚗 El sistema asigna automáticamente un lugar de estacionamiento según el tipo de vehículo
- 👥 Soporte para grupos: se puede registrar un visitante principal con acompañantes

---

## 👥 Equipo de Desarrollo

| Rol | Usuario GitHub | Enfoque |
|-----|---------------|---------|
| 🏆 **Líder de Desarrollo** | [@Sebasr0311](https://github.com/Sebasr0311) | Sistema de Visitas/QR + Arquitectura + Autenticación |
| 👨‍💻 **Desarrollador 1** | [@JoseReales-ui](https://github.com/JoseReales-ui) | Gestión del Edificio (Personas, Apartamentos, Contratos, Pagos) |

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Uso |
|-----------|---------|-----|
| ☕ **Java** | 17+ (nativo) | Lenguaje principal |
| 🖼️ **JavaFX** | 17+ | Interfaz gráfica de usuario |
| 🗄️ **Oracle SQL Express** | 18c | Base de datos relacional |
| 🔗 **JDBC** | — | Conexión Java ↔ Oracle |
| 📊 **PlantUML** | — | Diagramas MER y Modelo Relacional |
| 💡 **IntelliJ IDEA** | — | IDE de desarrollo |
| 📱 **ZXing** | 3.x | Generación y lectura de códigos QR |

---

## 🏗️ Arquitectura del Sistema

El sistema sigue una **arquitectura en capas** estricta:

```
┌─────────────────────────────────────────┐
│   CAPA DE PRESENTACIÓN (JavaFX)         │
│   com.edificio.admin.controlador        │
│   recursos/vistas/ (FXML)               │
│   recursos/estilos/ (CSS)               │
├─────────────────────────────────────────┤
│   CAPA DE LÓGICA DE NEGOCIO             │
│   com.edificio.admin.servicio           │
├─────────────────────────────────────────┤
│   CAPA DE ACCESO A DATOS (DAO)          │
│   com.edificio.admin.dao                │
│   com.edificio.admin.configuracion      │
├─────────────────────────────────────────┤
│   BASE DE DATOS                         │
│   Oracle SQL Express 18c                │
└─────────────────────────────────────────┘
```

> Cada capa solo puede comunicarse con la capa inmediatamente inferior.
> Para más detalles, ver [`docs/ARQUITECTURA.md`](docs/ARQUITECTURA.md).

---

## 📦 Módulos del Sistema

| # | Módulo | Responsable | Estado |
|---|--------|-------------|--------|
| 1 | 👤 **Gestión de Personas** | @JoseReales-ui | ⏳ Pendiente |
| 2 | 🏠 **Gestión de Apartamentos** | @JoseReales-ui | ⏳ Pendiente |
| 3 | 📄 **Gestión de Contratos** | @JoseReales-ui | ⏳ Pendiente |
| 4 | 💰 **Gestión de Pagos** | @JoseReales-ui | ⏳ Pendiente |
| 5 | 🔑 **Sistema de Visitas QR** ⭐ | @Sebasr0311 | ⏳ Pendiente |
| 6 | 🚗 **Estacionamiento** | @Sebasr0311 | ⏳ Pendiente |
| 7 | 🔐 **Autenticación** | @Sebasr0311 | ⏳ Pendiente |
| 8 | 📊 **Reportes e Historial** | Ambos | ⏳ Pendiente |

### Reglas de Negocio Clave

- 🏠 Solo **arriendo**, no se venden apartamentos
- 👶 Menores de edad: el contrato se firma con los **padres o tutores**
- 🔑 Los códigos QR son de **un solo uso** — al escanear se invalidan automáticamente
- ⏱️ Duración del QR: configurable entre **5 y 60 minutos**
- 📤 Los QR se comparten por **WhatsApp** desde la aplicación
- 🖥️ Al escanear el QR, el vigilante ve: quién generó, apartamento, datos del visitante, PDF del documento, vehículo y acompañantes

---

## 📁 Estructura del Proyecto

```
sistema-administracion-edificios/
├── README.md
├── .gitignore
├── docs/
│   ├── PLAN_DE_TRABAJO.md
│   ├── ARQUITECTURA.md
│   ├── ESTRATEGIA_RAMAS.md
│   ├── diagramas/
│   │   ├── mer.puml
│   │   └── modelo-relacional.puml
│   └── manuales/
│       └── .gitkeep
├── base-datos/
│   ├── ddl/
│   │   └── .gitkeep
│   ├── dml/
│   │   └── .gitkeep
│   └── scripts/
│       └── .gitkeep
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── edificio/
│   │   │           └── admin/
│   │   │               ├── App.java
│   │   │               ├── configuracion/
│   │   │               ├── modelo/
│   │   │               ├── dao/
│   │   │               ├── servicio/
│   │   │               ├── controlador/
│   │   │               ├── utilidad/
│   │   │               └── excepcion/
│   │   └── recursos/
│   │       ├── vistas/
│   │       ├── estilos/
│   │       ├── imagenes/
│   │       └── configuracion/
│   └── pruebas/
│       └── java/
│           └── com/
│               └── edificio/
│                   └── admin/
└── librerias/
```

---

## 🔀 Estrategia de Ramas

| Rama | Propósito |
|------|-----------|
| `main` | Código estable — solo merges desde `develop` vía release |
| `develop` | Integración — aquí se unen las features |
| `feature/*` | Desarrollo de funcionalidades individuales |
| `release/*` | Preparación de entregas por corte académico |
| `hotfix/*` | Correcciones urgentes en producción |

> Para detalles completos, ver [`docs/ESTRATEGIA_RAMAS.md`](docs/ESTRATEGIA_RAMAS.md).

---

## ⚙️ Configuración y Ejecución

### Requisitos Previos

- ✅ Java JDK 17 o superior
- ✅ IntelliJ IDEA
- ✅ Oracle SQL Express 18c instalado y en ejecución
- ✅ Git configurado

### Pasos de Configuración

**1. Clonar el repositorio**

```bash
git clone https://github.com/Sebasr0311/sistema-administracion-edificios.git
cd sistema-administracion-edificios
```

**2. Abrir en IntelliJ IDEA**

Abrir la carpeta raíz del proyecto en IntelliJ IDEA.

**3. Configurar Oracle SQL Express 18c**

Asegurarse de que el servicio de Oracle esté en ejecución.

**4. Agregar driver JDBC de Oracle**

Colocar el archivo `ojdbc8.jar` en la carpeta `librerias/` y agregarlo al classpath del proyecto en IntelliJ.

**5. Ejecutar scripts DDL**

```sql
-- Ejecutar en Oracle SQL Developer o SQL*Plus:
@base-datos/ddl/crear_tablas.sql
@base-datos/dml/datos_prueba.sql
```

**6. Ejecutar la aplicación**

Ejecutar la clase `com.edificio.admin.App` desde IntelliJ IDEA.

---

## 📅 Estado del Proyecto

| Corte | Estado | Entregable |
|-------|--------|------------|
| Corte 1 | ✅ Entregado | Propuesta del proyecto |
| Corte 2 | 🔄 En progreso | Avance funcional (BD + módulos básicos) |
| Corte 3 | ⏳ Pendiente | Sistema completo y funcional |

---

## 📝 Licencia

Proyecto académico — Todos los derechos reservados © 2026 @Sebasr0311 & @JoseReales-ui