# 🌿 Estrategia de Ramas — Sistema de Administración de Edificios

> **Modelo**: Feature Branch Workflow con Gitflow simplificado
> **Herramienta**: Git + GitHub

---

## 🗺️ Diagrama Visual de Ramas

```
main ────────────────────────────────────────────────●─── (producción estable)
       ▲                                           ▲
       │ merge vía release/corte-2                 │ merge vía release/corte-3
       │                                           │
       ◄──── release/corte-2 ───────────────────── │
       ◄──────────────────────────── release/corte-3 ─┘

develop ─────●────●────●────●────●────●────●────●─── (integración continua)
             ▲    ▲    ▲    ▲    ▲    ▲    ▲    ▲
             │    │    │    │    │    │    │    │
             │    │    │    │    │    │    │    └── feature/reportes
             │    │    │    │    │    │    └─────── feature/integracion-modulos
             │    │    │    │    │    └──────────── feature/modulo-pagos
             │    │    │    │    └───────────────── feature/modulo-contratos
             │    │    │    └────────────────────── feature/modulo-auth
             │    │    └─────────────────────────── feature/modulo-escaneo-qr
             │    └──────────────────────────────── feature/modulo-visitas-qr
             └───────────────────────────────────── feature/modelo-base-datos
```

---

## 📋 Inventario de Ramas

### Ramas Permanentes

| Rama | Propósito | Acceso |
|------|-----------|--------|
| `main` | Código estable listo para entrega | Solo merge via `release/*` |
| `develop` | Integración de todas las features | Solo merge via PR aprobado |

### Ramas de Features

| Rama | Desarrollador | Módulo | Estado |
|------|--------------|--------|--------|
| `feature/estructura-proyecto` | @Sebasr0311 | Arquitectura y configuración base | ⏳ |
| `feature/modelo-base-datos` | Ambos | MER, Modelo Relacional, DDL, DML | ⏳ |
| `feature/modulo-personas` | @JoseReales-ui | CRUD personas, validaciones, tutores | ⏳ |
| `feature/modulo-apartamentos` | @JoseReales-ui | CRUD apartamentos, estados | ⏳ |
| `feature/modulo-contratos` | @JoseReales-ui | Contratos, residentes, menores | ⏳ |
| `feature/modulo-pagos` | @JoseReales-ui | Pagos, alertas de vencimiento | ⏳ |
| `feature/modulo-visitas-qr` | @Sebasr0311 | Sistema de visitas y generación QR | ⏳ |
| `feature/modulo-escaneo-qr` | @Sebasr0311 | Escaneo QR, pantalla del vigilante | ⏳ |
| `feature/modulo-estacionamiento` | @Sebasr0311 | Asignación de parqueadero | ⏳ |
| `feature/modulo-auth` | @Sebasr0311 | Login, roles, dashboard | ⏳ |
| `feature/integracion-modulos` | Ambos | Integración final de todos los módulos | ⏳ |
| `feature/reportes` | Ambos | Reportes e historial de visitas | ⏳ |

### Ramas de Release

| Rama | Propósito | Fecha estimada |
|------|-----------|----------------|
| `release/corte-2` | Avance funcional para Corte 2 | ~19 mayo 2026 |
| `release/corte-3` | Sistema completo para entrega final | ~26 mayo 2026 |

### Ramas Hotfix

| Rama | Propósito |
|------|-----------|
| `hotfix/descripcion-del-bug` | Correcciones urgentes sobre `main` |

---

## 👤 Asignación por Desarrollador

### @Sebasr0311 (Líder de Desarrollo)

| Rama | Descripción |
|------|-------------|
| `feature/estructura-proyecto` | Estructura inicial del proyecto Java + configuración JDBC |
| `feature/modulo-visitas-qr` | Registro de visitantes, generación de QR, validación, expiración |
| `feature/modulo-escaneo-qr` | Pantalla del vigilante, verificación de identidad, registro de entrada |
| `feature/modulo-estacionamiento` | Asignación automática de espacio según tipo de vehículo |
| `feature/modulo-auth` | Login, hash de contraseñas, roles, dashboard por rol |

**Responsabilidades adicionales:**
- Revisar y aprobar **todos** los Pull Requests de `feature/*` → `develop`
- Hacer merge de `develop` → `release/*` → `main`
- Mantener actualizados los diagramas de arquitectura

---

### @JoseReales-ui (Desarrollador 1)

| Rama | Descripción |
|------|-------------|
| `feature/modulo-personas` | CRUD de personas, validación de documentos, detección menores, tutores |
| `feature/modulo-apartamentos` | CRUD de apartamentos (todos en arriendo), estados, ocupación |
| `feature/modulo-contratos` | Contratos de arriendo, caso menor de edad con tutor, residentes |
| `feature/modulo-pagos` | Registro de pagos, alertas de vencimiento próximo |

---

### Colaboración de Ambos

| Rama | Descripción |
|------|-------------|
| `feature/modelo-base-datos` | Diseño completo del modelo de datos (MER, Relacional, DDL) |
| `feature/integracion-modulos` | Integración de todos los módulos |
| `feature/reportes` | Reportes generales e historial de visitas |

---

## 🔄 Flujo de Trabajo para una Feature

### Paso a Paso

**1. Crear la rama feature desde `develop`**
```bash
# Asegurarse de estar en develop actualizado
git checkout develop
git pull origin develop

# Crear la nueva rama feature
git checkout -b feature/modulo-pagos
```

**2. Desarrollar la funcionalidad**
```bash
# Trabajar en los archivos correspondientes...

# Ir haciendo commits frecuentes con mensajes descriptivos
git add .
git commit -m "feat(pagos): agregar DAO con consultas de pagos por apartamento"

git add .
git commit -m "feat(pagos): implementar Service con alertas de vencimiento"

git add .
git commit -m "feat(pagos): crear vista JavaFX para gestión de pagos"
```

**3. Mantener la rama actualizada con `develop`**
```bash
# Si develop ha avanzado mientras trabajabas:
git fetch origin
git rebase origin/develop
# O con merge si prefieres:
# git merge origin/develop
```

**4. Subir la rama al repositorio**
```bash
git push origin feature/modulo-pagos
```

**5. Crear Pull Request en GitHub**

- Ir a GitHub → Pull Requests → New Pull Request
- **Base**: `develop`
- **Compare**: `feature/modulo-pagos`
- Título: `feat(pagos): módulo completo de gestión de pagos`
- Descripción: listar los cambios realizados y lo que falta por hacer
- Asignar a: **@Sebasr0311** para revisión

**6. Esperar revisión y aprobación**

- @Sebasr0311 revisa el código
- Si hay comentarios, el desarrollador hace los cambios y hace `git push`
- Una vez aprobado, @Sebasr0311 hace el merge a `develop`

---

## ✅ Proceso de Pull Request

### Plantilla de Descripción del PR

```markdown
## Descripción
Breve descripción de lo que hace este PR.

## Cambios realizados
- [ ] DAO implementado con operaciones CRUD
- [ ] Service con lógica de negocio
- [ ] Vista JavaFX conectada al Service
- [ ] Validaciones implementadas

## Cómo probar
1. Ejecutar la aplicación
2. Navegar a [módulo]
3. Verificar que [comportamiento esperado]

## Checklist
- [ ] El código sigue los principios SOLID
- [ ] No hay lógica de negocio en el Controller
- [ ] No hay SQL directamente en el Service
- [ ] Los commits siguen la convención de mensajes
```

### Criterios de Aprobación (para @Sebasr0311)

| Criterio | Descripción |
|----------|-------------|
| ✅ Arquitectura | Respeta la separación de capas |
| ✅ Principios SOLID | Cada clase tiene una responsabilidad |
| ✅ Nombrado | Variables y métodos en español, descriptivos |
| ✅ Sin SQL en Service | Solo los DAOs acceden a la BD |
| ✅ Sin lógica en Controller | Solo delega al Service |
| ✅ Manejo de excepciones | Errores controlados adecuadamente |
| ✅ Commits limpios | Mensajes siguen la convención |

---

## 🔀 Flujo de Release (Entregas por Corte)

```bash
# 1. Asegurarse de que develop está listo
git checkout develop
git pull origin develop

# 2. Crear rama de release
git checkout -b release/corte-2

# 3. Ajustes finales (versión, correcciones menores)
git commit -m "chore(release): preparar versión corte-2"

# 4. Merge a main
git checkout main
git merge --no-ff release/corte-2
git tag -a corte-2 -m "Entrega Corte 2 — Avance funcional"
git push origin main --tags

# 5. Merge de vuelta a develop (para incluir los ajustes finales)
git checkout develop
git merge --no-ff release/corte-2
git push origin develop

# 6. Eliminar la rama de release
git branch -d release/corte-2
git push origin --delete release/corte-2
```

---

## 🚨 Flujo de Hotfix

```bash
# 1. Crear rama hotfix desde main
git checkout main
git pull origin main
git checkout -b hotfix/correccion-validacion-qr

# 2. Corregir el bug
git commit -m "fix(visitas): corregir validación de QR expirado al escanear"

# 3. Merge a main
git checkout main
git merge --no-ff hotfix/correccion-validacion-qr
git tag -a v1.0.1 -m "Hotfix: corrección validación QR"
git push origin main --tags

# 4. Merge a develop también
git checkout develop
git merge --no-ff hotfix/correccion-validacion-qr
git push origin develop

# 5. Eliminar rama hotfix
git branch -d hotfix/correccion-validacion-qr
```

---

## 📏 Convenciones de Nombres de Ramas

| Tipo | Formato | Ejemplo |
|------|---------|---------|
| Feature | `feature/nombre-descriptivo` | `feature/modulo-visitas-qr` |
| Release | `release/nombre-corte` | `release/corte-2` |
| Hotfix | `hotfix/descripcion-bug` | `hotfix/correccion-login` |
| Experiment | `experiment/idea-a-probar` | `experiment/qr-websocket` |

### Reglas de Nomenclatura
- ✅ Usar **minúsculas** siempre
- ✅ Separar palabras con **guiones** (`-`)
- ✅ Nombres **descriptivos** en español
- ❌ No usar espacios, puntos, ni caracteres especiales
- ❌ No usar nombres genéricos como `feature/cambios`

---

## 🛡️ Protección de Ramas

### `main` — Protección Máxima

- ❌ No se permite push directo
- ✅ Solo acepta merges desde `release/*` o `hotfix/*`
- ✅ Requiere Pull Request con revisión aprobada
- ✅ Se debe mantener siempre funcional y estable

### `develop` — Protección Estándar

- ❌ No se permite push directo
- ✅ Solo acepta merges desde `feature/*`, `release/*` o `hotfix/*`
- ✅ Requiere Pull Request aprobado por @Sebasr0311
- ✅ Puede estar en desarrollo activo pero debe compilar

---

## 📊 Resumen Visual de Flujos

```
NUEVO TRABAJO:
  develop ──► feature/* ──[PR]──► develop

ENTREGA POR CORTE:
  develop ──► release/* ──► main (+ tag)
                       └──► develop (sync)

CORRECCIÓN URGENTE:
  main ──► hotfix/* ──► main (+ tag)
                   └──► develop (sync)
```

---

*Última actualización: Abril 2026*
