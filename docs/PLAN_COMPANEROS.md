# Plan de Trabajo — Compañeros de Equipo

## Sistema de Administración de Edificio Residencial (SAED)

> Basado en el proyecto de referencia: `C:\Users\JUAN\IdeaProjects\prueba_proyeccto`

---

## Configuración Inicial (ambos)

Antes de empezar, configurar git local:

```powershell
git config --local user.name  "Tu Nombre"
git config --local user.email "tu-correo@ejemplo.com"
```

---

================================================================================
## JOSE REALES (JoseReales-ui) — Módulos Administrativos
================================================================================

### Rama: feature/modulo-residentes

```powershell
git checkout develop
git pull origin develop
git checkout -b feature/modulo-residentes
```

#### COMMIT 4.1 — Modelo Residente
**Fecha:** 2026-03-18 09:30
**Archivo:** `src/main/java/com/edificio/admin/model/Residente.java`
```
package com.edificio.admin.model;
public class Residente extends Persona {
    private int idResidente;
    private int idPersona;
    private int idApartamento;
    private String fechaIngreso;
    private String relacion;
    // getters y setters
}
```
```powershell
git add src/main/java/com/edificio/admin/model/Residente.java
$env:GIT_COMMITTER_DATE = "2026-03-18T09:30:00-05:00"
git commit --date="2026-03-18T09:30:00-05:00" -m "Crea modelo Residente con atributos y getters/setters"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-residentes
```

#### COMMIT 4.2 — DAO de Residente
**Fecha:** 2026-03-19 10:00
**Archivo:** `src/main/java/com/edificio/admin/dao/ResidenteDAO.java`
```
CRUD completo + findByDocumento() + findAllConUsuario()
```
```powershell
git add src/main/java/com/edificio/admin/dao/ResidenteDAO.java
$env:GIT_COMMITTER_DATE = "2026-03-19T10:00:00-05:00"
git commit --date="2026-03-19T10:00:00-05:00" -m "Implementa ResidenteDAO con CRUD y busqueda por documento"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-residentes
```

#### COMMIT 4.3 — Servicio y handler REST de Residente
**Fecha:** 2026-03-20 11:00
**Archivos:**
- `src/main/java/com/edificio/admin/service/ResidenteService.java`
- `src/main/java/com/edificio/admin/rest/handler/ResidenteHandler.java`
```powershell
git add src/main/java/com/edificio/admin/service/ResidenteService.java
git add src/main/java/com/edificio/admin/rest/handler/ResidenteHandler.java
$env:GIT_COMMITTER_DATE = "2026-03-20T11:00:00-05:00"
git commit --date="2026-03-20T11:00:00-05:00" -m "Agrega servicio y endpoints REST para gestion de residentes"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-residentes
```

#### COMMIT 4.4 — Modelo Apartamento
**Fecha:** 2026-03-21 09:00
**Archivo:** `src/main/java/com/edificio/admin/model/Apartamento.java`
```powershell
git add src/main/java/com/edificio/admin/model/Apartamento.java
$env:GIT_COMMITTER_DATE = "2026-03-21T09:00:00-05:00"
git commit --date="2026-03-21T09:00:00-05:00" -m "Crea modelo Apartamento con tipo, estado y valor administracion"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-residentes
```

#### COMMIT 4.5 — DAO, Servicio y Handler de Apartamento
**Fecha:** 2026-03-22 14:00
**Archivos:**
- `src/main/java/com/edificio/admin/dao/ApartamentoDAO.java`
- `src/main/java/com/edificio/admin/service/ApartamentoService.java`
- `src/main/java/com/edificio/admin/rest/handler/ApartamentoHandler.java`
```powershell
git add src/main/java/com/edificio/admin/dao/ApartamentoDAO.java
git add src/main/java/com/edificio/admin/service/ApartamentoService.java
git add src/main/java/com/edificio/admin/rest/handler/ApartamentoHandler.java
$env:GIT_COMMITTER_DATE = "2026-03-22T14:00:00-05:00"
git commit --date="2026-03-22T14:00:00-05:00" -m "Implementa CRUD completo para apartamentos"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-residentes
```

#### COMMIT 4.6 — Modelos Usuario y Tutor
**Fecha:** 2026-03-23 09:30
**Archivos:**
- `src/main/java/com/edificio/admin/model/Usuario.java`
- `src/main/java/com/edificio/admin/model/Tutor.java`
```powershell
git add src/main/java/com/edificio/admin/model/Usuario.java
git add src/main/java/com/edificio/admin/model/Tutor.java
$env:GIT_COMMITTER_DATE = "2026-03-23T09:30:00-05:00"
git commit --date="2026-03-23T09:30:00-05:00" -m "Agrega modelos Usuario con rol y Tutor para residentes menores"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-residentes
```

#### COMMIT 4.7 — DAOs, Servicio y Handlers de Usuario, TipoDocumento y Tutor
**Fecha:** 2026-03-24 11:00
**Archivos:**
- `src/main/java/com/edificio/admin/dao/UsuarioDAO.java`
- `src/main/java/com/edificio/admin/dao/TipoDocumentoDAO.java`
- `src/main/java/com/edificio/admin/dao/TutorDAO.java`
- `src/main/java/com/edificio/admin/service/UsuarioService.java`
- `src/main/java/com/edificio/admin/rest/handler/UsuarioHandler.java`
- `src/main/java/com/edificio/admin/rest/handler/TipoDocumentoHandler.java`
- `src/main/java/com/edificio/admin/rest/handler/TutorHandler.java`
```powershell
git add src/main/java/com/edificio/admin/dao/UsuarioDAO.java
git add src/main/java/com/edificio/admin/dao/TipoDocumentoDAO.java
git add src/main/java/com/edificio/admin/dao/TutorDAO.java
git add src/main/java/com/edificio/admin/service/UsuarioService.java
git add src/main/java/com/edificio/admin/rest/handler/UsuarioHandler.java
git add src/main/java/com/edificio/admin/rest/handler/TipoDocumentoHandler.java
git add src/main/java/com/edificio/admin/rest/handler/TutorHandler.java
$env:GIT_COMMITTER_DATE = "2026-03-24T11:00:00-05:00"
git commit --date="2026-03-24T11:00:00-05:00" -m "Implementa CRUD para usuarios, tipos de documento y tutores"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-residentes
```

#### MERGE feature/modulo-residentes -> develop
```powershell
git checkout develop
git pull origin develop
git merge --no-ff feature/modulo-residentes -m "Merge feature/modulo-residentes: residentes, apartamentos y usuarios"
git push origin develop
```

---

### Rama: feature/modulo-contratos

```powershell
git checkout develop
git pull origin develop
git checkout -b feature/modulo-contratos
git push -u origin feature/modulo-contratos
```

#### COMMIT 6.1 — Modelos de contrato
**Fecha:** 2026-03-25 09:00
**Archivos:**
- `src/main/java/com/edificio/admin/model/Contrato.java`
- `src/main/java/com/edificio/admin/model/ContratoResidente.java`
```powershell
git add src/main/java/com/edificio/admin/model/Contrato.java
git add src/main/java/com/edificio/admin/model/ContratoResidente.java
$env:GIT_COMMITTER_DATE = "2026-03-25T09:00:00-05:00"
git commit --date="2026-03-25T09:00:00-05:00" -m "Crea modelos Contrato y ContratoResidente"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### COMMIT 6.2 — DAOs de contratos
**Fecha:** 2026-03-26 10:00
**Archivos:**
- `src/main/java/com/edificio/admin/dao/ContratoDAO.java`
- `src/main/java/com/edificio/admin/dao/ContratoResidenteDAO.java`
```powershell
git add src/main/java/com/edificio/admin/dao/ContratoDAO.java
git add src/main/java/com/edificio/admin/dao/ContratoResidenteDAO.java
$env:GIT_COMMITTER_DATE = "2026-03-26T10:00:00-05:00"
git commit --date="2026-03-26T10:00:00-05:00" -m "Implementa ContratoDAO con expiracion automatica y CRUD"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### COMMIT 6.3 — Servicio, validador y handler de contratos
**Fecha:** 2026-03-27 11:00
**Archivos:**
- `src/main/java/com/edificio/admin/service/ContratoService.java`
- `src/main/java/com/edificio/admin/service/ContratoValidatorService.java`
- `src/main/java/com/edificio/admin/service/ContratoSuggestionService.java`
- `src/main/java/com/edificio/admin/rest/handler/ContratoHandler.java`
- `src/main/java/com/edificio/admin/rest/dto/ContratoDetalleDTO.java`
```powershell
git add src/main/java/com/edificio/admin/service/ContratoService.java
git add src/main/java/com/edificio/admin/service/ContratoValidatorService.java
git add src/main/java/com/edificio/admin/service/ContratoSuggestionService.java
git add src/main/java/com/edificio/admin/rest/handler/ContratoHandler.java
git add src/main/java/com/edificio/admin/rest/dto/ContratoDetalleDTO.java
$env:GIT_COMMITTER_DATE = "2026-03-27T11:00:00-05:00"
git commit --date="2026-03-27T11:00:00-05:00" -m "Agrega servicio, validador y endpoint REST para contratos"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### COMMIT 6.4 — Generación de PDF para contratos
**Fecha:** 2026-03-28 09:00
**Archivos:**
- `src/main/java/com/edificio/admin/service/ContratoPdfService.java`
- `src/main/java/com/edificio/admin/service/TemplateRenderService.java`
- `src/main/java/com/edificio/admin/service/VariableResolverService.java`
- `src/main/java/com/edificio/admin/service/PdfGeneratorService.java`
```powershell
git add src/main/java/com/edificio/admin/service/ContratoPdfService.java
git add src/main/java/com/edificio/admin/service/TemplateRenderService.java
git add src/main/java/com/edificio/admin/service/VariableResolverService.java
git add src/main/java/com/edificio/admin/service/PdfGeneratorService.java
$env:GIT_COMMITTER_DATE = "2026-03-28T09:00:00-05:00"
git commit --date="2026-03-28T09:00:00-05:00" -m "Implementa generacion de PDF para contratos con plantillas HTML"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### COMMIT 6.5 — Plantillas HTML de contratos
**Fecha:** 2026-03-28 14:00
**Archivos:**
- `src/main/resources/templates/contratos/contrato_inicial.html`
- `src/main/resources/templates/contratos/contrato_permanencia.html`
- `src/main/resources/templates/contratos/contrato_renovacion.html`
- `Plantillas_Contratos/contrato_inicial.html`
- `Plantillas_Contratos/contrato_permanencia.html`
- `Plantillas_Contratos/contrato_renovacion.html`
```powershell
git add src/main/resources/templates/contratos/contrato_inicial.html
git add src/main/resources/templates/contratos/contrato_permanencia.html
git add src/main/resources/templates/contratos/contrato_renovacion.html
git add Plantillas_Contratos/contrato_inicial.html
git add Plantillas_Contratos/contrato_permanencia.html
git add Plantillas_Contratos/contrato_renovacion.html
$env:GIT_COMMITTER_DATE = "2026-03-28T14:00:00-05:00"
git commit --date="2026-03-28T14:00:00-05:00" -m "Agrega plantillas HTML para contratos: inicial, permanencia y renovacion"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### COMMIT 6.6 — Modelos Pago y CuotaArriendo
**Fecha:** 2026-03-30 09:30
**Archivos:**
- `src/main/java/com/edificio/admin/model/Pago.java`
- `src/main/java/com/edificio/admin/model/CuotaArriendo.java`
```powershell
git add src/main/java/com/edificio/admin/model/Pago.java
git add src/main/java/com/edificio/admin/model/CuotaArriendo.java
$env:GIT_COMMITTER_DATE = "2026-03-30T09:30:00-05:00"
git commit --date="2026-03-30T09:30:00-05:00" -m "Crea modelos Pago y CuotaArriendo para el modulo financiero"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### COMMIT 6.7 — DAOs, Servicio y Handlers de pagos y cuotas
**Fecha:** 2026-03-31 11:00
**Archivos:**
- `src/main/java/com/edificio/admin/dao/PagoDAO.java`
- `src/main/java/com/edificio/admin/dao/CuotaArriendoDAO.java`
- `src/main/java/com/edificio/admin/service/PagoService.java`
- `src/main/java/com/edificio/admin/rest/handler/PagoHandler.java`
- `src/main/java/com/edificio/admin/rest/handler/CuotaHandler.java`
```powershell
git add src/main/java/com/edificio/admin/dao/PagoDAO.java
git add src/main/java/com/edificio/admin/dao/CuotaArriendoDAO.java
git add src/main/java/com/edificio/admin/service/PagoService.java
git add src/main/java/com/edificio/admin/rest/handler/PagoHandler.java
git add src/main/java/com/edificio/admin/rest/handler/CuotaHandler.java
$env:GIT_COMMITTER_DATE = "2026-03-31T11:00:00-05:00"
git commit --date="2026-03-31T11:00:00-05:00" -m "Implementa CRUD de pagos y cuotas con calculo de mora"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### COMMIT 6.8 — Módulo de alertas de pago
**Fecha:** 2026-04-01 10:00
**Archivos:**
- `src/main/java/com/edificio/admin/model/AlertaPago.java`
- `src/main/java/com/edificio/admin/dao/AlertaPagoDAO.java`
- `src/main/java/com/edificio/admin/service/AlertaService.java`
- `src/main/java/com/edificio/admin/rest/handler/AlertaHandler.java`
```powershell
git add src/main/java/com/edificio/admin/model/AlertaPago.java
git add src/main/java/com/edificio/admin/dao/AlertaPagoDAO.java
git add src/main/java/com/edificio/admin/service/AlertaService.java
git add src/main/java/com/edificio/admin/rest/handler/AlertaHandler.java
$env:GIT_COMMITTER_DATE = "2026-04-01T10:00:00-05:00"
git commit --date="2026-04-01T10:00:00-05:00" -m "Agrega modulo de alertas de pago: vencimiento y mora"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-contratos
```

#### MERGE feature/modulo-contratos -> develop
```powershell
git checkout develop
git pull origin develop
git merge --no-ff feature/modulo-contratos -m "Merge feature/modulo-contratos: contratos, pagos, cuotas y alertas"
git push origin develop
```

---

### Rama: feature/modulo-gestion

```powershell
git checkout develop
git pull origin develop
git checkout -b feature/modulo-gestion
git push -u origin feature/modulo-gestion
```

#### COMMIT 7.1 — Módulo de multas
**Fecha:** 2026-03-30 14:00
**Archivos:**
- `src/main/java/com/edificio/admin/model/Multa.java`
- `src/main/java/com/edificio/admin/dao/MultaDAO.java`
- `src/main/java/com/edificio/admin/rest/handler/MultaHandler.java`
```powershell
git add src/main/java/com/edificio/admin/model/Multa.java
git add src/main/java/com/edificio/admin/dao/MultaDAO.java
git add src/main/java/com/edificio/admin/rest/handler/MultaHandler.java
$env:GIT_COMMITTER_DATE = "2026-03-30T14:00:00-05:00"
git commit --date="2026-03-30T14:00:00-05:00" -m "Agrega modulo de multas con CRUD y endpoints REST"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-gestion
```

#### COMMIT 7.2 — Módulo de quejas y sugerencias
**Fecha:** 2026-04-01 09:00
**Archivos:**
- `src/main/java/com/edificio/admin/model/QuejaSugerencia.java`
- `src/main/java/com/edificio/admin/dao/QuejaSugerenciaDAO.java`
- `src/main/java/com/edificio/admin/rest/handler/QuejaSugerenciaHandler.java`
```powershell
git add src/main/java/com/edificio/admin/model/QuejaSugerencia.java
git add src/main/java/com/edificio/admin/dao/QuejaSugerenciaDAO.java
git add src/main/java/com/edificio/admin/rest/handler/QuejaSugerenciaHandler.java
$env:GIT_COMMITTER_DATE = "2026-04-01T09:00:00-05:00"
git commit --date="2026-04-01T09:00:00-05:00" -m "Implementa modulo de quejas y sugerencias de residentes"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-gestion
```

#### COMMIT 7.3 — Servicios de notificación y configuración del edificio
**Fecha:** 2026-04-02 11:00
**Archivos:**
- `src/main/java/com/edificio/admin/service/NotificacionService.java`
- `src/main/java/com/edificio/admin/service/EdificioConfigService.java`
```powershell
git add src/main/java/com/edificio/admin/service/NotificacionService.java
git add src/main/java/com/edificio/admin/service/EdificioConfigService.java
$env:GIT_COMMITTER_DATE = "2026-04-02T11:00:00-05:00"
git commit --date="2026-04-02T11:00:00-05:00" -m "Agrega servicio de notificaciones y configuracion del edificio"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-gestion
```

#### COMMIT 7.4 — Módulo de buzón (backend)
**Fecha:** 2026-04-03 10:00
**Archivos:**
- `src/main/java/com/edificio/admin/model/Buzon.java`
- `src/main/java/com/edificio/admin/dao/BuzonDAO.java`
- `src/main/java/com/edificio/admin/rest/handler/BuzonHandler.java`
```powershell
git add src/main/java/com/edificio/admin/model/Buzon.java
git add src/main/java/com/edificio/admin/dao/BuzonDAO.java
git add src/main/java/com/edificio/admin/rest/handler/BuzonHandler.java
$env:GIT_COMMITTER_DATE = "2026-04-03T10:00:00-05:00"
git commit --date="2026-04-03T10:00:00-05:00" -m "Implementa modulo de buzon con mensajes, paquetes y avisos"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/modulo-gestion
```

#### MERGE feature/modulo-gestion -> develop
```powershell
git checkout develop
git pull origin develop
git merge --no-ff feature/modulo-gestion -m "Merge feature/modulo-gestion: multas, quejas, buzon y notificaciones"
git push origin develop
```

---

### Rama: feature/frontend-admin

```powershell
git checkout develop
git pull origin develop
git checkout -b feature/frontend-admin
git push -u origin feature/frontend-admin
```

#### COMMIT 10.1 — Página de gestión de residentes
**Fecha:** 2026-04-06 09:00
**Archivo:** `frontend/js/pages/residentes.js`
```powershell
git add frontend/js/pages/residentes.js
$env:GIT_COMMITTER_DATE = "2026-04-06T09:00:00-05:00"
git commit --date="2026-04-06T09:00:00-05:00" -m "Crea pagina de gestion de residentes con CRUD y filtros"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-admin
```

#### COMMIT 10.2 — Página de gestión de apartamentos
**Fecha:** 2026-04-07 09:30
**Archivo:** `frontend/js/pages/apartamentos.js`
```powershell
git add frontend/js/pages/apartamentos.js
$env:GIT_COMMITTER_DATE = "2026-04-07T09:30:00-05:00"
git commit --date="2026-04-07T09:30:00-05:00" -m "Implementa pagina de gestion de apartamentos"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-admin
```

#### COMMIT 10.3 — Página de contratos
**Fecha:** 2026-04-08 10:00
**Archivo:** `frontend/js/pages/contratos.js`
```powershell
git add frontend/js/pages/contratos.js
$env:GIT_COMMITTER_DATE = "2026-04-08T10:00:00-05:00"
git commit --date="2026-04-08T10:00:00-05:00" -m "Agrega modulo de contratos con renovacion y descarga de PDF"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-admin
```

#### COMMIT 10.4 — Página de pagos y cuotas
**Fecha:** 2026-04-09 09:00
**Archivo:** `frontend/js/pages/pagos.js`
```powershell
git add frontend/js/pages/pagos.js
$env:GIT_COMMITTER_DATE = "2026-04-09T09:00:00-05:00"
git commit --date="2026-04-09T09:00:00-05:00" -m "Crea pagina de pagos y cuotas con estado de deuda"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-admin
```

#### COMMIT 10.5 — Página de usuarios del sistema
**Fecha:** 2026-04-10 10:00
**Archivo:** `frontend/js/pages/usuarios.js`
```powershell
git add frontend/js/pages/usuarios.js
$env:GIT_COMMITTER_DATE = "2026-04-10T10:00:00-05:00"
git commit --date="2026-04-10T10:00:00-05:00" -m "Implementa gestion de usuarios con roles y permisos"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-admin
```

#### COMMIT 10.6 — Páginas de avisos y gestión de quejas
**Fecha:** 2026-04-11 11:00
**Archivos:**
- `frontend/js/pages/avisos.js`
- `frontend/js/pages/quejas-admin.js`
```powershell
git add frontend/js/pages/avisos.js
git add frontend/js/pages/quejas-admin.js
$env:GIT_COMMITTER_DATE = "2026-04-11T11:00:00-05:00"
git commit --date="2026-04-11T11:00:00-05:00" -m "Agrega paginas de avisos masivos y gestion de quejas admin"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-admin
```

#### MERGE feature/frontend-admin -> develop
```powershell
git checkout develop
git pull origin develop
git merge --no-ff feature/frontend-admin -m "Merge feature/frontend-admin: todas las paginas administrativas"
git push origin develop
```

---

### COMMIT 12.2 — Vistas FXML y controladores administrativos (directo a develop)
**Fecha:** 2026-04-14 10:00
**Archivos:**
- `src/main/resources/com/edificio/admin/view/vistas/Login.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/Dashboard.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/Apartamentos.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/Contratos.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/Pagos.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/AlertasPago.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/Residentes.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/Usuarios.fxml`
- `src/main/resources/com/edificio/admin/view/vistas/Parqueaderos.fxml`
- `src/main/java/com/edificio/admin/view/controladores/LoginController.java`
- `src/main/java/com/edificio/admin/view/controladores/DashboardController.java`
- `src/main/java/com/edificio/admin/view/controladores/ApartamentoController.java`
- `src/main/java/com/edificio/admin/view/controladores/ContratoController.java`
- `src/main/java/com/edificio/admin/view/controladores/PagoController.java`
- `src/main/java/com/edificio/admin/view/controladores/AlertasPagoController.java`
- `src/main/java/com/edificio/admin/view/controladores/ResidenteController.java`
- `src/main/java/com/edificio/admin/view/controladores/UsuarioController.java`
```powershell
git checkout develop
git pull origin develop
git add src/main/resources/com/edificio/admin/view/vistas/Login.fxml
git add src/main/resources/com/edificio/admin/view/vistas/Dashboard.fxml
git add src/main/resources/com/edificio/admin/view/vistas/Apartamentos.fxml
git add src/main/resources/com/edificio/admin/view/vistas/Contratos.fxml
git add src/main/resources/com/edificio/admin/view/vistas/Pagos.fxml
git add src/main/resources/com/edificio/admin/view/vistas/AlertasPago.fxml
git add src/main/resources/com/edificio/admin/view/vistas/Residentes.fxml
git add src/main/resources/com/edificio/admin/view/vistas/Usuarios.fxml
git add src/main/resources/com/edificio/admin/view/vistas/Parqueaderos.fxml
git add src/main/java/com/edificio/admin/view/controladores/LoginController.java
git add src/main/java/com/edificio/admin/view/controladores/DashboardController.java
git add src/main/java/com/edificio/admin/view/controladores/ApartamentoController.java
git add src/main/java/com/edificio/admin/view/controladores/ContratoController.java
git add src/main/java/com/edificio/admin/view/controladores/PagoController.java
git add src/main/java/com/edificio/admin/view/controladores/AlertasPagoController.java
git add src/main/java/com/edificio/admin/view/controladores/ResidenteController.java
git add src/main/java/com/edificio/admin/view/controladores/UsuarioController.java
$env:GIT_COMMITTER_DATE = "2026-04-14T10:00:00-05:00"
git commit --date="2026-04-14T10:00:00-05:00" -m "Agrega vistas FXML y controladores para modulos administrativos"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin develop
```

### COMMIT 13.2 — Datos de prueba v2 (directo a develop)
**Fecha:** 2026-04-21 10:00
**Archivo:** `database/datos_prueba_v2.sql`
```powershell
git checkout develop
git pull origin develop
git add database/datos_prueba_v2.sql
$env:GIT_COMMITTER_DATE = "2026-04-21T10:00:00-05:00"
git commit --date="2026-04-21T10:00:00-05:00" -m "Actualiza datos de prueba con escenarios de mora y multas"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin develop
```

### COMMIT 14.2 — Resumen técnico del proyecto (directo a develop)
**Fecha:** 2026-04-29 10:00
**Archivo:** `RESUMEN_PROYECTO.txt`
```powershell
git checkout develop
git pull origin develop
git add RESUMEN_PROYECTO.txt
$env:GIT_COMMITTER_DATE = "2026-04-29T10:00:00-05:00"
git commit --date="2026-04-29T10:00:00-05:00" -m "Agrega resumen tecnico del proyecto SAED"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin develop
```

---

================================================================================
## IVAN CAMILO HERNANDEZ (icamilohernandez) — Frontend Base y Portal Residente
================================================================================

### Rama: feature/frontend-base

```powershell
git checkout develop
git pull origin develop
git checkout -b feature/frontend-base
git push -u origin feature/frontend-base
```

#### COMMIT 8.1 — Estructura HTML base del SPA
**Fecha:** 2026-03-25 09:00
**Archivo:** `frontend/index.html`
```powershell
git add frontend/index.html
$env:GIT_COMMITTER_DATE = "2026-03-25T09:00:00-05:00"
git commit --date="2026-03-25T09:00:00-05:00" -m "Crea estructura HTML base del SPA con secciones por rol"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.2 — Hoja de estilos global
**Fecha:** 2026-03-26 10:00
**Archivo:** `frontend/css/style.css`
```powershell
git add frontend/css/style.css
$env:GIT_COMMITTER_DATE = "2026-03-26T10:00:00-05:00"
git commit --date="2026-03-26T10:00:00-05:00" -m "Agrega CSS global con layout sidebar, cards, modales y formularios"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.3 — Imágenes y recursos visuales
**Fecha:** 2026-03-26 14:30
**Archivo:** `frontend/imagenes/` (todos los PNG)
```powershell
git add frontend/imagenes/
$env:GIT_COMMITTER_DATE = "2026-03-26T14:30:00-05:00"
git commit --date="2026-03-26T14:30:00-05:00" -m "Agrega imagenes del proyecto: logo, galeria login y fondos"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.4 — Módulo de autenticación frontend
**Fecha:** 2026-03-27 09:00
**Archivo:** `frontend/js/auth.js`
```
auth.js: Manejo de JWT en sessionStorage, login(), logout(), getToken(), isAuthenticated()
```
```powershell
git add frontend/js/auth.js
$env:GIT_COMMITTER_DATE = "2026-03-27T09:00:00-05:00"
git commit --date="2026-03-27T09:00:00-05:00" -m "Implementa autenticacion frontend con JWT y sessionStorage"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.5 — Cliente HTTP centralizado (api.js)
**Fecha:** 2026-03-27 14:00
**Archivo:** `frontend/js/api.js`
```
api.js: API.get(), API.post(), API.put(), API.delete() con token interceptor
```
```powershell
git add frontend/js/api.js
$env:GIT_COMMITTER_DATE = "2026-03-27T14:00:00-05:00"
git commit --date="2026-03-27T14:00:00-05:00" -m "Crea cliente HTTP centralizado para consumo de la API REST"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.6 — Router del SPA
**Fecha:** 2026-03-28 09:30
**Archivo:** `frontend/js/router.js`
```
router.js: Sistema de navegación por hash (#/ruta), guardias de ruta por rol
```
```powershell
git add frontend/js/router.js
$env:GIT_COMMITTER_DATE = "2026-03-28T09:30:00-05:00"
git commit --date="2026-03-28T09:30:00-05:00" -m "Implementa router SPA con navegacion por hash y guardias de ruta"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.7 — Funciones utilitarias del frontend
**Fecha:** 2026-03-28 15:00
**Archivo:** `frontend/js/utils.js`
```
utils.js: formatearFecha(), formatearMoneda(), validarEmail(), mostrarAlerta(), etc.
```
```powershell
git add frontend/js/utils.js
$env:GIT_COMMITTER_DATE = "2026-03-28T15:00:00-05:00"
git commit --date="2026-03-28T15:00:00-05:00" -m "Agrega utilidades frontend: formateo de fechas, moneda y validaciones"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.8 — Página de login
**Fecha:** 2026-03-29 10:00
**Archivo:** `frontend/js/pages/login.js`
```
login.js: formulario login con galería de imágenes, toggle password, recordarme
```
```powershell
git add frontend/js/pages/login.js
$env:GIT_COMMITTER_DATE = "2026-03-29T10:00:00-05:00"
git commit --date="2026-03-29T10:00:00-05:00" -m "Crea pagina de login con galeria, toggle password y recordarme"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### COMMIT 8.9 — Controlador principal de páginas
**Fecha:** 2026-03-30 09:00
**Archivo:** `frontend/js/pages/app.js`
```
app.js: Carga la página según el rol (admin, portero, residente), sidebar dinámico
```
```powershell
git add frontend/js/pages/app.js
$env:GIT_COMMITTER_DATE = "2026-03-30T09:00:00-05:00"
git commit --date="2026-03-30T09:00:00-05:00" -m "Agrega controlador principal del SPA con navegacion por rol"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-base
```

#### MERGE feature/frontend-base -> develop
```powershell
git checkout develop
git pull origin develop
git merge --no-ff feature/frontend-base -m "Merge feature/frontend-base: HTML, CSS global, router y autenticacion"
git push origin develop
```

---

### Rama: feature/frontend-residente

```powershell
git checkout develop
git pull origin develop
git checkout -b feature/frontend-residente
git push -u origin feature/frontend-residente
```

#### COMMIT 9.1 — Dashboard del residente
**Fecha:** 2026-04-01 09:00
**Archivo:** `frontend/js/pages/residente-dashboard.js`
```
Dashboard con KPI cards: multas pendientes, cuotas vencidas, paquetes, mensajes no leídos
```
```powershell
git add frontend/js/pages/residente-dashboard.js
$env:GIT_COMMITTER_DATE = "2026-04-01T09:00:00-05:00"
git commit --date="2026-04-01T09:00:00-05:00" -m "Crea dashboard del residente con KPI cards y modales de detalle"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-residente
```

#### COMMIT 9.2 — Módulo de paquetes para el residente
**Fecha:** 2026-04-02 10:00
**Archivo:** `frontend/js/pages/paquetes.js`
```
Lista de paquetes recibidos con filtros por estado (recibido, entregado, reclamado)
```
```powershell
git add frontend/js/pages/paquetes.js
$env:GIT_COMMITTER_DATE = "2026-04-02T10:00:00-05:00"
git commit --date="2026-04-02T10:00:00-05:00" -m "Implementa vista de paquetes del residente con filtros de estado"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-residente
```

#### COMMIT 9.3 — Módulo de paquetes para el administrador
**Fecha:** 2026-04-03 11:00
**Archivo:** `frontend/js/pages/paquetes-admin.js`
```
Historial completo con filtros de fecha y búsqueda por texto
```
```powershell
git add frontend/js/pages/paquetes-admin.js
$env:GIT_COMMITTER_DATE = "2026-04-03T11:00:00-05:00"
git commit --date="2026-04-03T11:00:00-05:00" -m "Agrega pagina admin de paquetes con filtros de fecha y texto"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-residente
```

#### COMMIT 9.4 — Página de quejas del residente
**Fecha:** 2026-04-04 09:30
**Archivo:** `frontend/js/pages/quejas-residente.js`
```
Formulario de queja + lista de quejas enviadas con estado
```
```powershell
git add frontend/js/pages/quejas-residente.js
$env:GIT_COMMITTER_DATE = "2026-04-04T09:30:00-05:00"
git commit --date="2026-04-04T09:30:00-05:00" -m "Crea interfaz de quejas y sugerencias para el residente"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-residente
```

#### COMMIT 9.5 — Página de alertas de pago
**Fecha:** 2026-04-05 10:00
**Archivo:** `frontend/js/pages/alertas.js`
```
Alertas de cuotas pendientes y vencidas, vista para residente y administrador
```
```powershell
git add frontend/js/pages/alertas.js
$env:GIT_COMMITTER_DATE = "2026-04-05T10:00:00-05:00"
git commit --date="2026-04-05T10:00:00-05:00" -m "Agrega vista de alertas de pago para residente y administrador"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin feature/frontend-residente
```

#### MERGE feature/frontend-residente -> develop
```powershell
git checkout develop
git pull origin develop
git merge --no-ff feature/frontend-residente -m "Merge feature/frontend-residente: dashboard, paquetes, alertas y quejas"
git push origin develop
```

---

### COMMIT 12.3 — Vista FXML del residente y estilos JavaFX (directo a develop)
**Fecha:** 2026-04-14 14:00
**Archivos:**
- `src/main/resources/com/edificio/admin/view/vistas/ResidenteDashboard.fxml`
- `src/main/resources/com/edificio/admin/view/estilos/estilos.css`
- `src/main/java/com/edificio/admin/view/controladores/ResidenteDashboardController.java`
- `src/main/java/com/edificio/admin/view/controladores/ControladorVista.java`
```powershell
git checkout develop
git pull origin develop
git add src/main/resources/com/edificio/admin/view/vistas/ResidenteDashboard.fxml
git add src/main/resources/com/edificio/admin/view/estilos/estilos.css
git add src/main/java/com/edificio/admin/view/controladores/ResidenteDashboardController.java
git add src/main/java/com/edificio/admin/view/controladores/ControladorVista.java
$env:GIT_COMMITTER_DATE = "2026-04-14T14:00:00-05:00"
git commit --date="2026-04-14T14:00:00-05:00" -m "Agrega vista FXML del residente y controlador base de vistas"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin develop
```

### COMMIT 13.3 — Ajustes de UI y responsividad (directo a develop)
**Fecha:** 2026-04-22 11:00
**Archivo:** `frontend/css/style.css`
Antes del commit, abre `frontend/css/style.css` y agrega al inicio:
```css
/* v2 - ajustes de responsividad y mejoras visuales */
```
```powershell
git checkout develop
git pull origin develop
git add frontend/css/style.css
$env:GIT_COMMITTER_DATE = "2026-04-22T11:00:00-05:00"
git commit --date="2026-04-22T11:00:00-05:00" -m "Ajusta estilos globales: responsividad, colores y espaciado"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin develop
```

### COMMIT 13.5 — Corrección: indicador de mensajes no leídos (directo a develop)
**Fecha:** 2026-04-24 10:30
**Archivo:** `frontend/js/pages/residente-dashboard.js`
```powershell
git checkout develop
git pull origin develop
git add frontend/js/pages/residente-dashboard.js
$env:GIT_COMMITTER_DATE = "2026-04-24T10:30:00-05:00"
git commit --date="2026-04-24T10:30:00-05:00" -m "Corrige badge de mensajes no leidos en buzon del residente"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin develop
```

### COMMIT 14.1 — Documentación completa de la base de datos (directo a develop)
**Fecha:** 2026-04-28 09:00
**Archivo:** `DOCUMENTACION_BASE_DATOS.txt`
```powershell
git checkout develop
git pull origin develop
git add DOCUMENTACION_BASE_DATOS.txt
$env:GIT_COMMITTER_DATE = "2026-04-28T09:00:00-05:00"
git commit --date="2026-04-28T09:00:00-05:00" -m "Agrega documentacion completa de la BD: tablas, triggers y paquetes"
Remove-Item Env:GIT_COMMITTER_DATE
git push origin develop
```

---

## NOTAS IMPORTANTES

### Para ver el código fuente de referencia
Los archivos completos están en:
```
C:\Users\JUAN\IdeaProjects\prueba_proyeccto\
```

### Reglas de oro
1. **NUNCA** uses `git add .` — agrega archivos específicos
2. Antes de cada commit usa `git status` para verificar
3. Cada persona debe configurar su `git config --local user.name` y `user.email` ANTES de hacer commits
4. Para verificar fechas: `git log --format="%h %ad %an %s" --date=short`
5. Si el push falla con "rejected", haz `git pull origin develop` primero
