# 📋 Plan de Trabajo — Sistema de Administración de Edificios

> **Proyecto Académico** | Base de Datos & Programación 3 (Buenas Prácticas)
> **Período**: Abril — Mayo 2026 | **Entrega Final**: Mayo 2026

---

## 👥 Distribución de Responsabilidades

### 🏆 @Sebasr0311 — Líder de Desarrollo
**Enfoque: Sistema de Visitas/QR + Arquitectura General**

| Módulo | Rama | Descripción |
|--------|------|-------------|
| Arquitectura | `feature/estructura-proyecto` | Configuración inicial del proyecto, JDBC Singleton |
| Visitas QR | `feature/modulo-visitas-qr` | Registro visitantes, generación QR, validación, expiración |
| Escaneo QR | `feature/modulo-escaneo-qr` | Pantalla vigilante, verificación de identidad |
| Estacionamiento | `feature/modulo-estacionamiento` | Asignación automática por tipo de vehículo |
| Autenticación | `feature/modulo-auth` | Login, roles (admin, propietario, vigilante) |

**Responsabilidades adicionales:**
- Definición y mantenimiento de la arquitectura del proyecto
- Revisión y aprobación de todos los Pull Requests
- Configuración del repositorio y protección de ramas
- Dashboard principal (vistas según rol)

---

### 👨‍💻 @JoseReales-ui — Desarrollador 1
**Enfoque: Gestión del Edificio**

| Módulo | Rama | Descripción |
|--------|------|-------------|
| Personas | `feature/modulo-personas` | CRUD personas, validación docs, menores, tutores |
| Apartamentos | `feature/modulo-apartamentos` | CRUD apartamentos, estados, ocupación |
| Contratos | `feature/modulo-contratos` | Contratos arriendo, caso menor de edad, residentes |
| Pagos | `feature/modulo-pagos` | Registro pagos, alertas vencimiento próximo |

**Responsabilidades adicionales:**
- Vistas JavaFX de sus módulos
- Manual de usuario

---

## 🌿 Estrategia de Ramas (Branching Strategy)

```
main                    ← Código estable, solo merge desde develop vía release
│
├── develop             ← Rama de integración
│   │
│   ├── feature/estructura-proyecto          ← @Sebasr0311
│   ├── feature/modelo-base-datos            ← Ambos
│   │
│   ├── feature/modulo-personas              ← @JoseReales-ui
│   ├── feature/modulo-apartamentos          ← @JoseReales-ui
│   ├── feature/modulo-contratos             ← @JoseReales-ui
│   ├── feature/modulo-pagos                 ← @JoseReales-ui
│   │
│   ├── feature/modulo-visitas-qr            ← @Sebasr0311
│   ├── feature/modulo-escaneo-qr            ← @Sebasr0311
│   ├── feature/modulo-estacionamiento       ← @Sebasr0311
│   ├── feature/modulo-auth                  ← @Sebasr0311
│   │
│   ├── feature/integracion-modulos          ← Ambos
│   └── feature/reportes                     ← Ambos
│
├── hotfix/*            ← Correcciones urgentes
└── release/*           ← Preparación de entregas por corte
    ├── release/corte-2
    └── release/corte-3
```

### 📏 Reglas de Trabajo

- ✅ Cada desarrollador trabaja **SOLO** en sus ramas `feature/*`
- ✅ Para integrar: crear **Pull Request** de `feature/*` → `develop`
- ✅ El líder **@Sebasr0311** revisa y aprueba los PRs
- ✅ Para entregar un corte: `develop` → `release/corte-X` → `main`
- ❌ **NUNCA** hacer push directo a `main` ni a `develop`
- ❌ **NUNCA** hacer merge sin Pull Request revisado

---

## 📅 Fases y Tareas

---

### 🔧 FASE 0: Configuración Inicial
**Período**: 1 — 3 de abril de 2026 | **Responsables**: Ambos

| Tarea | Responsable | Estado |
|-------|-------------|--------|
| Crear repositorio en GitHub | @Sebasr0311 | ✅ Completado |
| Estructura del proyecto y plan de trabajo | @Sebasr0311 | 🔄 En progreso |
| Configurar ramas (main, develop) | @Sebasr0311 | ⬜ Pendiente |
| Agregar colaborador @JoseReales-ui | @Sebasr0311 | ⬜ Pendiente |
| Clonar repositorio y configurar IntelliJ | @JoseReales-ui | ⬜ Pendiente |

**Checklist detallado:**
- [x] Crear repositorio en GitHub ← @Sebasr0311
- [ ] Crear estructura de carpetas del proyecto ← @Sebasr0311
- [ ] Crear archivos de documentación base (README, PLAN_DE_TRABAJO, etc.) ← @Sebasr0311
- [ ] Configurar rama `develop` ← @Sebasr0311
- [ ] Configurar protección de ramas `main` y `develop` ← @Sebasr0311
- [ ] Agregar colaborador @JoseReales-ui al repositorio ← @Sebasr0311
- [ ] Clonar repositorio en local ← @JoseReales-ui
- [ ] Configurar proyecto en IntelliJ IDEA ← @JoseReales-ui
- [ ] Agregar librerías necesarias (ojdbc, JavaFX, ZXing) ← @JoseReales-ui

---

### 🗄️ FASE 1: Diseño de Base de Datos
**Período**: 4 — 13 de abril de 2026 | **Responsables**: Ambos | **Rama**: `feature/modelo-base-datos`

**Checklist detallado:**
- [ ] Modelo Entidad-Relación (MER) en PlantUML ← Ambos
- [ ] Modelo Relacional en PlantUML ← Ambos
- [ ] Diccionario de datos (descripción de todas las tablas y columnas) ← Ambos
- [ ] Script DDL para Oracle SQL Express 18c (crear tablas, constraints, índices) ← Ambos
- [ ] Script de datos de prueba (INSERT con datos realistas) ← Ambos
- [ ] Revisión y ajustes del modelo ← Ambos
- [ ] PR: `feature/modelo-base-datos` → `develop` ← @Sebasr0311 aprueba

**Entidades principales:**
- `EDIFICIO`, `APARTAMENTO`, `PERSONA`, `TUTOR_MENOR`
- `CONTRATO`, `RESIDENTE`, `PAGO`
- `VISITANTE_REGISTRADO`, `CODIGO_QR_VISITA`, `ACOMPANANTE_VISITA`, `HISTORIAL_VISITA`
- `TIPO_VEHICULO`, `ESTACIONAMIENTO_VISITANTE`
- `USUARIO`

---

### 🔌 FASE 2: Capa de Acceso a Datos (DAOs)
**Período**: 14 — 20 de abril de 2026 | **Responsables**: Ambos

**Checklist detallado:**

*@Sebasr0311:*
- [ ] Configurar conexión JDBC a Oracle (patrón Singleton) ← rama: `feature/estructura-proyecto`
- [ ] `DAO VisitanteRegistrado` ← rama: `feature/modulo-visitas-qr`
- [ ] `DAO CodigoQRVisita` ← rama: `feature/modulo-visitas-qr`
- [ ] `DAO AcompananteVisita` ← rama: `feature/modulo-visitas-qr`
- [ ] `DAO HistorialVisita` ← rama: `feature/modulo-visitas-qr`
- [ ] `DAO Estacionamiento` ← rama: `feature/modulo-estacionamiento`
- [ ] `DAO TipoVehiculo` ← rama: `feature/modulo-estacionamiento`
- [ ] `DAO Usuario` ← rama: `feature/modulo-auth`

*@JoseReales-ui:*
- [ ] `DAO Persona` ← rama: `feature/modulo-personas`
- [ ] `DAO TutorMenor` ← rama: `feature/modulo-personas`
- [ ] `DAO Apartamento` ← rama: `feature/modulo-apartamentos`
- [ ] `DAO Contrato` ← rama: `feature/modulo-contratos`
- [ ] `DAO Residente` ← rama: `feature/modulo-contratos`
- [ ] `DAO Pago` ← rama: `feature/modulo-pagos`

*Ambos:*
- [ ] Crear interfaces genéricas (`IBaseDAO<T>`) con operaciones CRUD
- [ ] Crear clases DTO para transferencia de datos entre capas
- [ ] PRs de cada `feature/*` → `develop` ← @Sebasr0311 aprueba

---

### ⚙️ FASE 3: Capa de Lógica de Negocio (Services)
**Período**: 21 — 27 de abril de 2026 | **Responsables**: Ambos

**Checklist detallado:**

*@JoseReales-ui:*
- [ ] `Service Persona` (validaciones de documentos colombianos, detección edad, asignación tutor) ← rama: `feature/modulo-personas`
- [ ] `Service Apartamento` (estados disponibilidad, ocupación) ← rama: `feature/modulo-apartamentos`
- [ ] `Service Contrato` (caso menor de edad con tutor, residentes, tiempo en edificio) ← rama: `feature/modulo-contratos`
- [ ] `Service Pago` (alertas de vencimiento próximo, cálculo próxima fecha de pago) ← rama: `feature/modulo-pagos`

*@Sebasr0311:*
- [ ] `Service VisitasQR` (generación UUID único, validación duración 5-60 min, un solo uso, expiración automática) ← rama: `feature/modulo-visitas-qr`
- [ ] `Service EscaneoQR` (decodificación QR, verificación validez, respuesta al vigilante) ← rama: `feature/modulo-escaneo-qr`
- [ ] `Service Estacionamiento` (asignación automática de espacio según tipo de vehículo) ← rama: `feature/modulo-estacionamiento`
- [ ] `Service Autenticacion` (login, hashing de contraseñas con BCrypt/SHA-256, control de roles) ← rama: `feature/modulo-auth`

*Ambos:*
- [ ] PRs de cada `feature/*` → `develop` ← @Sebasr0311 aprueba

---

### 🖼️ FASE 4: Capa de Presentación — JavaFX
**Período**: 28 de abril — 11 de mayo de 2026 | **Responsables**: Ambos

**Checklist detallado:**

*@Sebasr0311:*
- [ ] Pantalla de Login (login.fxml + LoginController) ← rama: `feature/modulo-auth`
- [ ] Dashboard principal (según rol: admin, propietario, vigilante) ← rama: `feature/modulo-auth`
- [ ] Vista Registro de Visitantes ← rama: `feature/modulo-visitas-qr`
- [ ] Vista Generación de QR + previsualización + botón compartir vía WhatsApp ← rama: `feature/modulo-visitas-qr`
- [ ] Vista Escaneo QR del vigilante (datos completos: generador, visitante, PDF) ← rama: `feature/modulo-escaneo-qr`
- [ ] Vista Gestión de Estacionamiento (asignación automática) ← rama: `feature/modulo-estacionamiento`

*@JoseReales-ui:*
- [ ] Vista Gestión de Personas (CRUD completo con validaciones) ← rama: `feature/modulo-personas`
- [ ] Vista Gestión de Apartamentos (lista, estados, detalles) ← rama: `feature/modulo-apartamentos`
- [ ] Vista Gestión de Contratos + Residentes ← rama: `feature/modulo-contratos`
- [ ] Vista Gestión de Pagos + alertas de vencimiento ← rama: `feature/modulo-pagos`

*Ambos:*
- [ ] Vista Reportes e Historial de visitas ← rama: `feature/reportes`
- [ ] Aplicar estilos CSS consistentes a todas las vistas
- [ ] PRs de cada `feature/*` → `develop` ← @Sebasr0311 aprueba

---

### 🧪 FASE 5: Integración y Pruebas
**Período**: 12 — 18 de mayo de 2026 | **Responsables**: Ambos | **Rama**: `feature/integracion-modulos`

**Checklist detallado:**
- [ ] Integrar todos los módulos en `develop` ← Ambos
- [ ] Pruebas funcionales completas (flujo end-to-end) ← Ambos
- [ ] Pruebas del sistema QR con celular real ← @Sebasr0311
- [ ] Pruebas de alertas de vencimiento de pagos ← @JoseReales-ui
- [ ] Pruebas de caso especial: menor de edad con tutor ← @JoseReales-ui
- [ ] Corrección de bugs encontrados ← Ambos
- [ ] Optimización de consultas Oracle (índices, explain plan) ← Ambos
- [ ] Crear `release/corte-2` con avance funcional ← @Sebasr0311
- [ ] Merge `release/corte-2` → `main` ← @Sebasr0311

---

### 📚 FASE 6: Documentación y Entrega Final
**Período**: 19 — 25 de mayo de 2026 | **Responsables**: Ambos

**Checklist detallado:**
- [ ] Manual de usuario (cómo usar la aplicación) ← @JoseReales-ui
- [ ] Manual técnico (arquitectura, instalación, configuración) ← @Sebasr0311
- [ ] Documentación completa de la base de datos (diccionario de datos final) ← Ambos
- [ ] Preparar presentación del proyecto ← Ambos
- [ ] Revisión final del código (code review) ← Ambos
- [ ] Crear `release/corte-3` ← @Sebasr0311
- [ ] Merge `release/corte-3` → `main` (entrega final) ← @Sebasr0311

---

## 📊 Diagrama de Gantt

| Fase | Sem 1 (1-6 abr) | Sem 2 (7-13 abr) | Sem 3 (14-20 abr) | Sem 4 (21-27 abr) | Sem 5 (28 abr-4 may) | Sem 6 (5-11 may) | Sem 7 (12-18 may) | Sem 8 (19-25 may) |
|------|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| F0: Configuración | ██ | | | | | | | |
| F1: Base de Datos | ██ | ██ | | | | | | |
| F2: Capa DAO | | | ██ | | | | | |
| F3: Capa Service | | | | ██ | | | | |
| F4: Capa Vista (JavaFX) | | | | | ██ | ██ | | |
| F5: Integración y Pruebas | | | | | | | ██ | |
| F6: Docs y Entrega Final | | | | | | | | ██ |

---

## 📝 Convenciones de Commits

Seguimos el estándar **Conventional Commits**:

| Prefijo | Uso |
|---------|-----|
| `feat` | Nueva funcionalidad |
| `fix` | Corrección de bug |
| `docs` | Documentación |
| `refactor` | Refactorización de código sin cambiar comportamiento |
| `style` | Cambios de estilo/formato (sin cambios de lógica) |
| `test` | Agregar o modificar pruebas |
| `chore` | Tareas de mantenimiento (dependencias, configuración) |

### Formato

```
tipo(módulo): descripción breve en español

[cuerpo opcional]

[pie opcional]
```

### Ejemplos

```bash
feat(visitas): agregar generación de código QR con duración configurable
fix(pagos): corregir cálculo de fecha de próximo pago en febrero
docs(arquitectura): actualizar diagrama de capas con paquetes Java
refactor(persona): extraer validación de cédula a clase utilitaria
style(login): ajustar espaciado y colores en pantalla de autenticación
test(contrato): agregar prueba para caso de menor de edad con tutor
chore(deps): agregar librería ZXing 3.5.2 para generación de QR
```

---

## 🏁 Hitos del Proyecto

| Hito | Fecha | Descripción |
|------|-------|-------------|
| 📌 **Corte 1** | ✅ Ya entregado | Propuesta del proyecto |
| 📌 **Corte 2** | ~19 mayo 2026 | Avance funcional (fases 0-4 completadas) |
| 📌 **Corte 3** | ~26 mayo 2026 | Sistema completo y documentado |

---

## ⚠️ Reglas del Proyecto

1. **Idioma**: Todo el código (comentarios, variables, métodos) en **español** cuando sea posible
2. **Calidad**: Aplicar principios SOLID en toda la capa de negocio
3. **Patrones**: Singleton (conexión BD), DAO, MVC (JavaFX), DTO
4. **Seguridad**: Nunca almacenar contraseñas en texto plano
5. **Base de datos**: Todos los apartamentos son de **arriendo** — no se venden
6. **Caso especial**: Si un residente es menor de edad, el contrato va a nombre del tutor legal

---

*Última actualización: Abril 2026*
