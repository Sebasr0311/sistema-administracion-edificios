# 🏢 Sistema de Administración de Edificios

<div align="center">

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
- ⏱️ El propietario define la duración del código QR (mínimo 5 minutos, máximo 1 hora)
- 🔑 Se genera un código QR **único de un solo uso** — una vez escaneado, se invalida
- 📤 El QR se comparte fácilmente vía **WhatsApp** directamente desde la aplicación
- 📷 El visitante llega al edificio y presenta el QR desde su celular al vigilante
- 🖥️ El vigilante escanea el QR y ve en pantalla toda la información: quién genera la visita, datos del visitante y PDF del documento para verificación
- 🚗 El sistema asigna automáticamente un lugar de estacionamiento según el tipo de vehículo
- 👥 Soporte para grupos: se puede registrar a un visitante principal con acompañantes

---

## 👥 Equipo de Desarrollo

| Rol | Usuario GitHub | Enfoque |
|-----|---------------|---------|
| 🏆 **Líder de Desarrollo** | [@Sebasr0311](https://github.com/Sebasr0311) | Sistema de Visitas/QR + Arquitectura |
| 👨‍💻 **Desarrollador 1** | [@JoseReales-ui](https://github.com/JoseReales-ui) | Gestión del Edificio (Personas, Apartamentos, Contratos, Pagos) |

---

## 🛠️ Stack Tecnológico

| Tecnología | Versión | Uso |
|-----------|---------|-----|
| ☕ **Java** | 17+ (nativo) | Lenguaje principal |
| 🖼️ **JavaFX** | 17+ | Interfaz gráfica de usuario |
| 🗄️ **Oracle SQL Express** | 18c | Base de datos relacional |
| 🔗 **JDBC** | — | Conexión Java ↔ Oracle |
| 📊 **PlantUML** | — | Diagramas MER y Modelo Relacional |
| 💡 **IntelliJ IDEA** | — | IDE de desarrollo |
| 📱 **QR (ZXing)** | 3.x | Generación y lectura de códigos QR |

---

## 🏗️ Arquitectura del Sistema

El sistema sigue una **arquitectura en capas** estricta:

```
┌─────────────────────────────────────────────────────┐
│         CAPA DE PRESENTACIÓN (JavaFX)               │
│    Vistas FXML · Controllers · CSS · Recursos       │
├─────────────────────────────────────────────────────┤
│         CAPA DE LÓGICA DE NEGOCIO                   │
│    Services · Validaciones · Reglas de negocio      │
├─────────────────────────────────────────────────────┤
│         CAPA DE ACCESO A DATOS (DAO)                │
│    DAOs · Conexión JDBC · DTOs                      │
├─────────────────────────────────────────────────────┤
│         BASE DE DATOS (Oracle SQL Express 18c)      │
│    Tablas · Vistas · Procedimientos almacenados     │
└─────────────────────────────────────────────────────┘
```

> Cada capa solo puede comunicarse con la capa inmediatamente inferior.
> Para más detalles, ver [`docs/ARQUITECTURA.md`](docs/ARQUITECTURA.md).

---

## 📁 Estructura del Proyecto

```
sistema-administracion-edificios/
├── README.md                          ← Este archivo
├── .gitignore                         ← Exclusiones de Git
├── docs/
│   ├── PLAN_DE_TRABAJO.md             ← Plan completo con fases y fechas
│   ├── ARQUITECTURA.md                ← Documentación de la arquitectura
│   ├── ESTRATEGIA_RAMAS.md            ← Estrategia de ramas Git
│   ├── diagramas/
│   │   ├── mer.puml                   ← Diagrama Entidad-Relación (PlantUML)
│   │   └── modelo-relacional.puml    ← Modelo Relacional (PlantUML)
│   └── manuales/                      ← Manuales de usuario y técnico
├── database/
│   ├── ddl/                           ← Scripts de creación de tablas
│   ├── dml/                           ← Scripts de datos de prueba
│   └── scripts/                       ← Scripts auxiliares y procedimientos
├── src/
│   ├── main/
│   │   ├── java/com/edificio/admin/
│   │   │   ├── App.java               ← Punto de entrada JavaFX
│   │   │   ├── config/                ← Configuración (conexión BD, etc.)
│   │   │   ├── model/                 ← Entidades del dominio
│   │   │   ├── dao/                   ← Acceso a datos (DAOs)
│   │   │   ├── service/               ← Lógica de negocio
│   │   │   ├── controller/            ← Controladores JavaFX
│   │   │   ├── util/                  ← Utilidades y helpers
│   │   │   └── exception/             ← Excepciones personalizadas
│   │   └── resources/
│   │       ├── fxml/                  ← Vistas FXML
│   │       ├── css/                   ← Estilos
│   │       ├── images/                ← Imágenes y recursos gráficos
│   │       └── config/                ← Archivos de configuración
│   └── test/                          ← Pruebas unitarias
└── lib/                               ← Librerías externas (.jar)
```

---

## ⚙️ Configuración y Ejecución

### Requisitos Previos

- ✅ Java JDK 17 o superior
- ✅ IntelliJ IDEA (recomendado)
- ✅ Oracle SQL Express 18c instalado y en ejecución
- ✅ Git configurado

### 1. Clonar el Repositorio

```bash
git clone https://github.com/Sebasr0311/sistema-administracion-edificios.git
cd sistema-administracion-edificios
```

### 2. Configurar la Base de Datos

```bash
# Ejecutar los scripts en orden:
# 1. Crear tablas
sqlplus usuario/contraseña@localhost:1521/XE @database/ddl/crear_tablas.sql

# 2. Insertar datos de prueba
sqlplus usuario/contraseña@localhost:1521/XE @database/dml/datos_prueba.sql
```

### 3. Configurar la Conexión

Editar el archivo `src/main/resources/config/database.properties`:

```properties
db.url=jdbc:oracle:thin:@localhost:1521:XE
db.user=tu_usuario
db.password=tu_contraseña
```

### 4. Agregar Librerías

Colocar en la carpeta `lib/`:
- `ojdbc8.jar` — Driver JDBC de Oracle
- `javafx-sdk-17/` — SDK de JavaFX
- `core-3.x.x.jar` — ZXing (generación/lectura QR)

### 5. Ejecutar la Aplicación

```bash
# Desde IntelliJ IDEA:
# Run → Run 'App'

# O desde terminal (ajustar rutas según tu entorno):
java --module-path lib/javafx-sdk/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp "src/main/java:lib/*" \
     com.edificio.admin.App
```

---

## 🔀 Estrategia de Ramas

| Rama | Propósito |
|------|-----------|
| `main` | Código estable — solo merges desde `develop` vía release |
| `develop` | Integración — aquí se unen las features |
| `feature/*` | Desarrollo de funcionalidades individuales |
| `release/*` | Preparación de entregas por corte |
| `hotfix/*` | Correcciones urgentes |

> Para detalles completos, ver [`docs/ESTRATEGIA_RAMAS.md`](docs/ESTRATEGIA_RAMAS.md).

---

## 📦 Módulos del Sistema

### 👤 Gestión de Personas ([@JoseReales-ui](https://github.com/JoseReales-ui))
- CRUD completo de personas (residentes, propietarios, visitantes)
- Validación de documentos colombianos (cédula, tarjeta de identidad)
- Detección automática de menores de edad
- Gestión de relación tutor-menor

### 🏠 Gestión de Apartamentos ([@JoseReales-ui](https://github.com/JoseReales-ui))
- CRUD de apartamentos (todos en **arriendo**, no venta)
- Control de estados (disponible, ocupado, en mantenimiento)
- Registro de ocupantes por apartamento

### 📄 Gestión de Contratos ([@JoseReales-ui](https://github.com/JoseReales-ui))
- Creación y finalización de contratos de arriendo
- Caso especial: **menores de edad** → el contrato se firma con padres o tutores
- Registro de residentes del apartamento
- Tiempo de permanencia en el edificio

### 💰 Gestión de Pagos ([@JoseReales-ui](https://github.com/JoseReales-ui))
- Registro de pagos mensuales
- **Alertas automáticas** cuando se acerca la fecha de vencimiento
- Cálculo de próxima fecha de pago
- Historial de pagos por apartamento

### 🔐 Autenticación y Roles ([@Sebasr0311](https://github.com/Sebasr0311))
- Sistema de login seguro con hash de contraseñas
- Roles: **Administrador**, **Propietario**, **Vigilante**
- Dashboard personalizado según el rol del usuario

### 📲 Sistema de Visitas QR ⭐ ([@Sebasr0311](https://github.com/Sebasr0311))
- Registro de visitantes (nombre, documento, PDF del documento)
- Generación de código QR único de un solo uso
- Duración configurable: **5 minutos** a **1 hora**
- Soporte para grupos con acompañantes
- Compartir QR vía **WhatsApp** desde la aplicación
- Historial completo de visitas

### 📷 Escaneo QR ([@Sebasr0311](https://github.com/Sebasr0311))
- Pantalla del vigilante para escaneo en tiempo real
- Visualización de datos completos al escanear
- Verificación de identidad con PDF del documento
- Registro automático de hora de entrada

### 🚗 Estacionamiento ([@Sebasr0311](https://github.com/Sebasr0311))
- Asignación automática de espacio según tipo de vehículo
- Control de ocupación del parqueadero de visitantes

---

## 📅 Cronograma

| Fase | Período | Estado |
|------|---------|--------|
| F0: Configuración Inicial | 1-3 abr 2026 | 🔄 En progreso |
| F1: Diseño de Base de Datos | 4-13 abr 2026 | ⏳ Pendiente |
| F2: Capa de Acceso a Datos | 14-20 abr 2026 | ⏳ Pendiente |
| F3: Capa de Lógica de Negocio | 21-27 abr 2026 | ⏳ Pendiente |
| F4: Capa de Presentación JavaFX | 28 abr - 11 may 2026 | ⏳ Pendiente |
| F5: Integración y Pruebas | 12-18 may 2026 | ⏳ Pendiente |
| F6: Documentación y Entrega Final | 19-25 may 2026 | ⏳ Pendiente |

> Para el plan detallado con tareas y asignaciones, ver [`docs/PLAN_DE_TRABAJO.md`](docs/PLAN_DE_TRABAJO.md).

---

## 🔒 Casos Especiales de Negocio

1. **Solo arriendo**: Los apartamentos NO se venden bajo ninguna circunstancia
2. **Menores de edad**: Si el residente es menor, el contrato se firma con sus padres o tutor legal
3. **Visitantes recurrentes**: Una vez registrado un visitante, se puede generar un nuevo QR sin volver a registrarlo
4. **QR de un solo uso**: Cada código QR solo puede ser escaneado una vez; después queda inválido
5. **Grupos**: Al registrar una visita, se puede indicar si vienen acompañantes adicionales

---

## 📊 Diagramas

Los diagramas del proyecto se encuentran en `docs/diagramas/` en formato PlantUML:
- **MER** (`mer.puml`): Modelo Entidad-Relación completo
- **Modelo Relacional** (`modelo-relacional.puml`): Modelo relacional con claves primarias y foráneas

---

## 📜 Licencia

Este proyecto es de uso **académico** exclusivamente. Desarrollado para las materias **Base de Datos** y **Programación 3 (Buenas Prácticas)**.

© 2026 — [@Sebasr0311](https://github.com/Sebasr0311) & [@JoseReales-ui](https://github.com/JoseReales-ui)

---

<div align="center">
  <sub>Hecho con ❤️ en Valledupar, Cesar, Colombia 🇨🇴</sub>
</div>
