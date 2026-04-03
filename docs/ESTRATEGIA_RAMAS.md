# 🌿 Estrategia de Ramas

## Diagrama de Ramas

```
main                    ← Código estable, solo merge desde develop vía release
│
├── develop             ← Rama de integración, aquí se unen las features
│   │
│   ├── feature/modelo-base-datos            ← MER + Modelo Relacional + DDL (Ambos)
│   │
│   ├── feature/modulo-personas              ← CRUD personas (@JoseReales-ui)
│   ├── feature/modulo-apartamentos          ← CRUD apartamentos (@JoseReales-ui)
│   ├── feature/modulo-contratos             ← Contratos y residentes (@JoseReales-ui)
│   ├── feature/modulo-pagos                 ← Sistema de pagos y alertas (@JoseReales-ui)
│   │
│   ├── feature/modulo-visitas-qr            ← Sistema de visitas QR (@Sebasr0311)
│   ├── feature/modulo-escaneo-qr            ← Escaneo QR celular + PC (@Sebasr0311)
│   ├── feature/modulo-estacionamiento       ← Asignación estacionamiento (@Sebasr0311)
│   ├── feature/modulo-auth                  ← Login y roles (@Sebasr0311)
│   │
│   ├── feature/integracion-modulos          ← Integración final (Ambos)
│   └── feature/reportes                     ← Reportes e historial (Ambos)
│
├── release/corte-2     ← Preparación entrega corte 2
├── release/corte-3     ← Preparación entrega final
└── hotfix/*            ← Correcciones urgentes
```

---

## Asignación de Ramas por Desarrollador

| Desarrollador | Ramas Asignadas |
|--------------|----------------|
| @Sebasr0311 | `feature/modulo-visitas-qr`, `feature/modulo-escaneo-qr`, `feature/modulo-estacionamiento`, `feature/modulo-auth` |
| @JoseReales-ui | `feature/modulo-personas`, `feature/modulo-apartamentos`, `feature/modulo-contratos`, `feature/modulo-pagos` |
| Ambos | `feature/modelo-base-datos`, `feature/integracion-modulos`, `feature/reportes` |

---

## Flujo de Trabajo — Desarrollo de una Funcionalidad

**Paso 1:** Crear la rama `feature/` desde `develop`
```bash
git checkout develop
git pull origin develop
git checkout -b feature/nombre-del-modulo
```

**Paso 2:** Desarrollar en la rama `feature/`
```bash
# Hacer cambios en el código...
git add .
git commit -m "feat(modulo): descripción en español"
```

**Paso 3:** Mantener la rama actualizada con `develop`
```bash
git fetch origin develop
git merge origin/develop
```

**Paso 4:** Crear Pull Request hacia `develop`
- Ir a GitHub y abrir un Pull Request desde `feature/nombre-del-modulo` → `develop`
- Añadir descripción de los cambios en español
- Solicitar revisión al líder (@Sebasr0311)

**Paso 5:** El líder revisa y aprueba el Pull Request

**Paso 6:** Merge a `develop` (lo hace el líder tras aprobación)

---

## Flujo de Entrega de Cortes Académicos

**Paso 1:** Crear rama de release desde `develop`
```bash
git checkout develop
git checkout -b release/corte-2
```

**Paso 2:** Pruebas finales en la rama `release/`

**Paso 3:** Merge de `release/corte-X` → `main`
```bash
git checkout main
git merge release/corte-2
git tag -a v2.0 -m "Entrega corte 2"
git push origin main --tags
```

**Paso 4:** También hacer merge de vuelta a `develop` (para incluir correcciones)
```bash
git checkout develop
git merge release/corte-2
```

---

## Reglas del Equipo

- ❌ **NUNCA** hacer push directo a `main` ni a `develop`
- ✅ Siempre usar Pull Request con descripción en español
- ✅ El líder (@Sebasr0311) aprueba todos los Pull Requests
- ✅ Mantener las ramas `feature/` actualizadas con `develop`
- ✅ Los mensajes de commit siguen la convención en español (ver `docs/PLAN_DE_TRABAJO.md`)
- ✅ Eliminar las ramas `feature/` después del merge a `develop`

---

## Nomenclatura de Ramas

| Prefijo | Uso | Ejemplo |
|---------|-----|---------|
| `feature/` | Nueva funcionalidad | `feature/modulo-visitas-qr` |
| `release/` | Preparación de entrega por corte | `release/corte-2` |
| `hotfix/` | Corrección urgente en producción | `hotfix/corregir-login` |
