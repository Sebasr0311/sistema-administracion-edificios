# 📋 Plan de Trabajo — Sistema de Administración de Edificios

## Información del Equipo

| Rol | Integrante | GitHub | Enfoque |
|-----|-----------|--------|---------|
| 🏆 Líder de Desarrollo | Sebastián | [@Sebasr0311](https://github.com/Sebasr0311) | Sistema de Visitas QR, Arquitectura, Autenticación |
| 👨‍💻 Desarrollador 1 | José | [@JoseReales-ui](https://github.com/JoseReales-ui) | Gestión del Edificio (Personas, Apartamentos, Contratos, Pagos) |

---

## Cronograma de Cortes Académicos

| Corte | Estado | Entregable |
|-------|--------|------------|
| Corte 1 | ✅ Entregado | Propuesta del proyecto |
| Corte 2 | 🔄 En progreso | Avance funcional (BD + módulos básicos) |
| Corte 3 | ⏳ Pendiente | Sistema completo y funcional |

---

## Diagrama de Gantt

| Fase | Sem 1 (1-6 abr) | Sem 2 (7-13 abr) | Sem 3 (14-20 abr) | Sem 4 (21-27 abr) | Sem 5 (28 abr-4 may) | Sem 6 (5-11 may) | Sem 7 (12-18 may) | Sem 8 (19-25 may) |
|------|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| F0: Configuración | ██ | | | | | | | |
| F1: Base de Datos | ██ | ██ | | | | | | |
| F2: Capa DAO | | | ██ | | | | | |
| F3: Capa Servicio | | | | ██ | | | | |
| F4: Capa Vista (JavaFX) | | | | | ██ | ██ | | |
| F5: Integración y Pruebas | | | | | | | ██ | |
| F6: Documentación y Entrega | | | | | | | | ██ |

---

## FASE 0: Configuración Inicial (1–3 abril 2026)

- [x] Crear repositorio en GitHub ← @Sebasr0311
- [x] Estructura del proyecto y plan de trabajo ← @Sebasr0311
- [ ] Configurar ramas (main, develop) ← @Sebasr0311
- [ ] Agregar colaborador @JoseReales-ui ← @Sebasr0311
- [ ] Clonar repositorio y configurar IntelliJ ← @JoseReales-ui

---

## FASE 1: Diseño de Base de Datos (4–13 abril 2026)

**Rama:** `feature/modelo-base-datos`

- [ ] Modelo Entidad-Relación (MER) en PlantUML ← Ambos
- [ ] Modelo Relacional en PlantUML ← Ambos
- [ ] Diccionario de datos ← Ambos
- [ ] Script DDL para Oracle SQL Express 18c ← Ambos
- [ ] Script de datos de prueba (INSERT) ← Ambos
- [ ] Revisión y ajustes del modelo ← Ambos

---

## FASE 2: Capa de Acceso a Datos — DAO (14–20 abril 2026)

- [ ] Configurar conexión JDBC a Oracle (Singleton) ← @Sebasr0311
- [ ] PersonaDAO ← @JoseReales-ui (rama: `feature/modulo-personas`)
- [ ] ApartamentoDAO ← @JoseReales-ui (rama: `feature/modulo-apartamentos`)
- [ ] ContratoDAO + ResidenteDAO ← @JoseReales-ui (rama: `feature/modulo-contratos`)
- [ ] PagoDAO ← @JoseReales-ui (rama: `feature/modulo-pagos`)
- [ ] VisitanteRegistradoDAO ← @Sebasr0311 (rama: `feature/modulo-visitas-qr`)
- [ ] CodigoQRVisitaDAO ← @Sebasr0311 (rama: `feature/modulo-visitas-qr`)
- [ ] EstacionamientoDAO ← @Sebasr0311 (rama: `feature/modulo-estacionamiento`)
- [ ] UsuarioDAO ← @Sebasr0311 (rama: `feature/modulo-auth`)

---

## FASE 3: Capa de Lógica de Negocio — Servicios (21–27 abril 2026)

- [ ] PersonaServicio (validaciones documentos colombianos, edad, tutor) ← @JoseReales-ui
- [ ] ApartamentoServicio (estados, disponibilidad) ← @JoseReales-ui
- [ ] ContratoServicio (caso menor de edad con tutor, residentes) ← @JoseReales-ui
- [ ] PagoServicio (alertas de vencimiento, cálculo próxima fecha) ← @JoseReales-ui
- [ ] VisitaQRServicio (generación UUID, validación duración 5–60 min, un solo uso, expiración) ← @Sebasr0311
- [ ] EscaneoQRServicio (decodificación, verificación, respuesta al vigilante) ← @Sebasr0311
- [ ] EstacionamientoServicio (asignación automática según tipo de vehículo) ← @Sebasr0311
- [ ] AutenticacionServicio (login, hashing de contraseñas, roles) ← @Sebasr0311

---

## FASE 4: Capa de Presentación — JavaFX (28 abril – 11 mayo 2026)

- [ ] Pantalla de Inicio de Sesión ← @Sebasr0311 (rama: `feature/modulo-auth`)
- [ ] Panel Principal (según rol) ← @Sebasr0311
- [ ] Vista Gestión de Personas (CRUD) ← @JoseReales-ui (rama: `feature/modulo-personas`)
- [ ] Vista Gestión de Apartamentos ← @JoseReales-ui (rama: `feature/modulo-apartamentos`)
- [ ] Vista Gestión de Contratos + Residentes ← @JoseReales-ui (rama: `feature/modulo-contratos`)
- [ ] Vista Gestión de Pagos + Alertas ← @JoseReales-ui (rama: `feature/modulo-pagos`)
- [ ] Vista Registro de Visitantes ← @Sebasr0311 (rama: `feature/modulo-visitas-qr`)
- [ ] Vista Generación de QR + Compartir WhatsApp ← @Sebasr0311 (rama: `feature/modulo-visitas-qr`)
- [ ] Vista Escaneo QR (pantalla del vigilante) ← @Sebasr0311 (rama: `feature/modulo-escaneo-qr`)
- [ ] Vista Estacionamiento ← @Sebasr0311 (rama: `feature/modulo-estacionamiento`)
- [ ] Vista Reportes e Historial ← Ambos (rama: `feature/reportes`)

---

## FASE 5: Integración y Pruebas (12–18 mayo 2026)

**Rama:** `feature/integracion-modulos`

- [ ] Integrar todos los módulos en develop ← Ambos
- [ ] Pruebas funcionales completas ← Ambos
- [ ] Pruebas de QR con celular real ← @Sebasr0311
- [ ] Corrección de errores ← Ambos
- [ ] Optimización de consultas Oracle ← Ambos
- [ ] Crear release/corte-2 ← @Sebasr0311

---

## FASE 6: Documentación y Entrega Final (19–25 mayo 2026)

- [ ] Manual de usuario ← @JoseReales-ui
- [ ] Manual técnico ← @Sebasr0311
- [ ] Documentación de la base de datos ← Ambos
- [ ] Preparar presentación ← Ambos
- [ ] Release final → main (release/corte-3) ← @Sebasr0311

---

## Distribución de Responsabilidades

### @Sebasr0311 — Líder de Desarrollo

**Ramas:** `feature/modulo-visitas-qr`, `feature/modulo-escaneo-qr`, `feature/modulo-estacionamiento`, `feature/modulo-auth`

- Configuración del proyecto y arquitectura
- Conexión JDBC a Oracle (ConexionBD Singleton)
- Sistema de Visitas QR (registro, generación, validación, expiración)
- Escaneo QR desde celular y pantalla del vigilante
- Módulo de Estacionamiento (asignación automática)
- Módulo de Autenticación (login, roles: administrador, propietario, vigilante)
- Panel principal según rol
- Revisión y aprobación de Pull Requests
- Manual técnico

### @JoseReales-ui — Desarrollador 1

**Ramas:** `feature/modulo-personas`, `feature/modulo-apartamentos`, `feature/modulo-contratos`, `feature/modulo-pagos`

- Módulo de Personas (CRUD, validación documentos colombianos, detección menores, tutores)
- Módulo de Apartamentos (CRUD, estados, solo arriendo)
- Módulo de Contratos (crear/finalizar, caso menor con tutor, residentes)
- Módulo de Pagos (registro, alertas de vencimiento próximo)
- Vistas JavaFX de sus módulos
- Manual de usuario

---

## Convenciones de Commits (en español)

| Tipo | Uso |
|------|-----|
| `feat` | Nueva funcionalidad |
| `fix` | Corrección de error |
| `docs` | Documentación |
| `refactor` | Refactorización de código |
| `estilo` | Cambios de formato o estilo |
| `prueba` | Pruebas |
| `mant` | Mantenimiento |

**Formato:** `tipo(módulo): descripción en español`

**Ejemplos:**
- `feat(visitas): agregar generación de código QR con duración configurable`
- `fix(contratos): corregir validación de fecha de inicio`
- `docs(arquitectura): documentar capa de acceso a datos`
- `feat(personas): implementar validación de documentos colombianos`
- `feat(auth): agregar inicio de sesión con verificación de roles`
