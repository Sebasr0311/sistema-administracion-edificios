# 🏗️ Arquitectura del Sistema — Sistema de Administración de Edificios

> **Patrón arquitectónico**: Arquitectura en Capas (Layered Architecture)
> **Paradigma**: Orientado a Objetos con principios SOLID

---

## 📐 Diagrama de Capas

```
┌─────────────────────────────────────────────────────────────────┐
│                  CAPA DE PRESENTACIÓN (JavaFX)                  │
│                                                                   │
│   login.fxml      dashboard.fxml      visitantes.fxml  ...       │
│   LoginController DashboardController VisitantesController ...   │
│   styles.css      images/             recursos gráficos          │
│                                                                   │
│   Paquetes: controller/ · resources/fxml/ · resources/css/       │
└──────────────────────────┬──────────────────────────────────────┘
                           │  llama a →
┌──────────────────────────▼──────────────────────────────────────┐
│                  CAPA DE LÓGICA DE NEGOCIO                       │
│                                                                   │
│   PersonaService    ApartamentoService    ContratoService         │
│   PagoService       VisitasQRService      EscaneoQRService        │
│   EstacionamientoService  AutenticacionService                    │
│                                                                   │
│   Paquetes: service/                                              │
└──────────────────────────┬──────────────────────────────────────┘
                           │  llama a →
┌──────────────────────────▼──────────────────────────────────────┐
│                  CAPA DE ACCESO A DATOS (DAO)                    │
│                                                                   │
│   PersonaDAO        ApartamentoDAO        ContratoDAO             │
│   PagoDAO           VisitanteRegistradoDAO CodigoQRVisitaDAO      │
│   EstacionamientoDAO UsuarioDAO                                   │
│   ConexionDB (Singleton)                                          │
│                                                                   │
│   Paquetes: dao/ · config/                                        │
└──────────────────────────┬──────────────────────────────────────┘
                           │  SQL vía JDBC →
┌──────────────────────────▼──────────────────────────────────────┐
│                  BASE DE DATOS (Oracle SQL Express 18c)          │
│                                                                   │
│   Tablas: APARTAMENTO, PERSONA, CONTRATO, PAGO                   │
│           VISITANTE_REGISTRADO, CODIGO_QR_VISITA                 │
│           HISTORIAL_VISITA, ESTACIONAMIENTO_VISITANTE            │
│           USUARIO, TIPO_VEHICULO, TUTOR_MENOR                    │
│   Vistas: VW_CONTRATOS_ACTIVOS, VW_VISITANTES_HOY, ...           │
│   Procedimientos: SP_EXPIRAR_CODIGOS_QR, SP_ALERTAS_PAGO, ...   │
│                                                                   │
│   Ubicación: Oracle XE en localhost:1521/XE                      │
└─────────────────────────────────────────────────────────────────┘
```

### 🔁 Regla Fundamental de Comunicación

> **Una capa solo puede comunicarse con la capa inmediatamente inferior.**

- ✅ Presentación → Lógica de Negocio
- ✅ Lógica de Negocio → Acceso a Datos
- ✅ Acceso a Datos → Base de Datos
- ❌ Presentación **NO** puede llamar directamente a DAO
- ❌ DAO **NO** contiene lógica de negocio

---

## 📦 Estructura de Paquetes Java

```
com.edificio.admin/
│
├── App.java                          ← Punto de entrada (extiende Application de JavaFX)
│
├── config/
│   ├── ConexionDB.java               ← Singleton para conexión JDBC a Oracle
│   └── AppConfig.java                ← Constantes de configuración
│
├── model/                            ← Entidades del dominio (POJOs)
│   ├── Edificio.java
│   ├── Apartamento.java
│   ├── Persona.java
│   ├── TutorMenor.java
│   ├── Contrato.java
│   ├── Residente.java
│   ├── Pago.java
│   ├── VisitanteRegistrado.java
│   ├── CodigoQRVisita.java
│   ├── AcompananteVisita.java
│   ├── HistorialVisita.java
│   ├── TipoVehiculo.java
│   ├── EstacionamientoVisitante.java
│   └── Usuario.java
│
├── dao/                              ← Acceso a datos (implementan IBaseDAO)
│   ├── IBaseDAO.java                 ← Interfaz genérica con operaciones CRUD
│   ├── ApartamentoDAO.java
│   ├── PersonaDAO.java
│   ├── TutorMenorDAO.java
│   ├── ContratoDAO.java
│   ├── ResidenteDAO.java
│   ├── PagoDAO.java
│   ├── VisitanteRegistradoDAO.java
│   ├── CodigoQRVisitaDAO.java
│   ├── AcompananteVisitaDAO.java
│   ├── HistorialVisitaDAO.java
│   ├── TipoVehiculoDAO.java
│   ├── EstacionamientoVisitanteDAO.java
│   └── UsuarioDAO.java
│
├── service/                          ← Lógica de negocio
│   ├── PersonaService.java
│   ├── ApartamentoService.java
│   ├── ContratoService.java
│   ├── PagoService.java
│   ├── VisitasQRService.java
│   ├── EscaneoQRService.java
│   ├── EstacionamientoService.java
│   └── AutenticacionService.java
│
├── controller/                       ← Controladores JavaFX (MVC)
│   ├── LoginController.java
│   ├── DashboardController.java
│   ├── PersonaController.java
│   ├── ApartamentoController.java
│   ├── ContratoController.java
│   ├── PagoController.java
│   ├── VisitantesController.java
│   ├── GenerarQRController.java
│   ├── EscaneoQRController.java
│   ├── EstacionamientoController.java
│   └── ReportesController.java
│
├── util/                             ← Utilidades y helpers
│   ├── ValidadorDocumentos.java      ← Validación de cédulas y TI colombianas
│   ├── GeneradorQR.java              ← Generación de imágenes QR (ZXing)
│   ├── ExportadorQR.java             ← Exportar QR para WhatsApp
│   ├── HashUtil.java                 ← Hash de contraseñas
│   ├── FechaUtil.java                ← Utilidades de manejo de fechas
│   └── AlertaUtil.java               ← Helper para diálogos JavaFX
│
└── exception/                        ← Excepciones personalizadas
    ├── ConexionException.java
    ├── ValidacionException.java
    ├── QRExpiradoException.java
    ├── QRUsadoException.java
    └── AutenticacionException.java
```

---

## 🔧 Descripción Detallada de Cada Capa

### 1️⃣ Capa de Presentación (JavaFX)

**Responsabilidad**: Mostrar la interfaz gráfica y capturar interacciones del usuario.

**Componentes:**
- **Vistas FXML** (`src/main/resources/fxml/`): Archivos XML que definen la estructura visual de cada pantalla
- **Controllers** (`controller/`): Reciben eventos de la UI y delegan la lógica al Service correspondiente
- **CSS** (`src/main/resources/css/`): Estilos visuales de la aplicación
- **Imágenes** (`src/main/resources/images/`): Íconos, logos y recursos gráficos

**Reglas:**
- Los controllers **NO** contienen lógica de negocio
- Los controllers **NO** acceden directamente a DAOs
- Solo llaman a Services y actualizan la UI con los resultados

---

### 2️⃣ Capa de Lógica de Negocio (Services)

**Responsabilidad**: Implementar las reglas del negocio y coordinar las operaciones.

**Ejemplos de lógica:**
- `PersonaService`: Validar que la cédula tiene el formato correcto, detectar si es menor de edad
- `ContratoService`: Verificar que si el residente es menor, el contrato vaya a nombre del tutor
- `PagoService`: Calcular si la fecha de pago se acerca (alertas) y la próxima fecha
- `VisitasQRService`: Generar UUID único, validar duración (5-60 min), marcar QR como usado
- `AutenticacionService`: Verificar credenciales con hash, asignar permisos según rol

**Reglas:**
- Un Service puede llamar a múltiples DAOs si es necesario
- Un Service **NO** accede a la BD directamente — solo a través de DAOs
- Las validaciones de negocio van aquí, **no** en el DAO ni en el Controller

---

### 3️⃣ Capa de Acceso a Datos (DAO)

**Responsabilidad**: Gestionar la persistencia de datos — operaciones CRUD con la base de datos.

**Patrón utilizado**: Data Access Object (DAO)

**Interfaz base:**
```java
public interface IBaseDAO<T> {
    void insertar(T entidad) throws ConexionException;
    T buscarPorId(int id) throws ConexionException;
    List<T> listarTodos() throws ConexionException;
    void actualizar(T entidad) throws ConexionException;
    void eliminar(int id) throws ConexionException;
}
```

**Conexión a BD** (`ConexionDB.java` — Singleton):
```java
public class ConexionDB {
    private static ConexionDB instancia;
    private Connection conexion;

    private ConexionDB() {
        // Cargar driver Oracle y establecer conexión desde properties
    }

    public static synchronized ConexionDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
```

---

### 4️⃣ Base de Datos (Oracle SQL Express 18c)

**Responsabilidad**: Almacenar todos los datos del sistema de forma persistente.

**Ubicación**: `localhost:1521/XE`

**Objetos de base de datos:**
- **Tablas**: Entidades del sistema con sus relaciones
- **Vistas** (`VW_*`): Consultas frecuentes predefinidas
- **Procedimientos almacenados** (`SP_*`): Lógica compleja como expiración de QR
- **Secuencias** (`SEQ_*`): Generación de IDs autoincrementales
- **Índices**: Para optimizar consultas frecuentes

---

## 🎯 Principios SOLID Aplicados

| Principio | Aplicación en el Proyecto |
|-----------|--------------------------|
| **S** — Single Responsibility | Cada clase tiene una única responsabilidad. `PersonaDAO` solo maneja BD, `PersonaService` solo valida lógica |
| **O** — Open/Closed | Las interfaces como `IBaseDAO<T>` permiten extender sin modificar |
| **L** — Liskov Substitution | Las implementaciones de `IBaseDAO` son intercambiables |
| **I** — Interface Segregation | Interfaces específicas por módulo (no una interfaz gigante) |
| **D** — Dependency Inversion | Los Services dependen de interfaces, no de implementaciones concretas |

---

## 🎨 Patrones de Diseño

### Singleton — Conexión a Base de Datos
```
Garantiza una única instancia de la conexión JDBC a lo largo de toda
la aplicación, evitando múltiples conexiones simultáneas y optimizando
el uso de recursos.
```

### DAO (Data Access Object)
```
Separa la lógica de acceso a datos de la lógica de negocio.
Cada entidad tiene su propio DAO con las operaciones CRUD necesarias.
```

### MVC con JavaFX
```
Model:      Clases en model/ (POJOs que representan entidades del dominio)
View:       Archivos FXML + CSS en resources/
Controller: Clases en controller/ que conectan Vista con Services
```

### DTO (Data Transfer Object)
```
Objetos simples para transferir datos entre capas sin exponer
la estructura interna de las entidades del dominio.
```

---

## 🔒 Flujo de Ejemplo: Generación de Código QR

```
1. [PRESENTACIÓN]  VisitantesController.onGenerarQR()
       │
       ▼
2. [SERVICIO]      VisitasQRService.generarCodigoQR(visitanteId, duracionMin)
       │  - Valida que la duración esté entre 5 y 60 minutos
       │  - Genera UUID único
       │  - Calcula timestamp de expiración
       │
       ▼
3. [DAO]           CodigoQRVisitaDAO.insertar(codigoQR)
       │  - Ejecuta INSERT en tabla CODIGO_QR_VISITA
       │
       ▼
4. [BASE DE DATOS] Tabla CODIGO_QR_VISITA ← registro guardado
       │
       ▼
5. [SERVICIO]      Retorna el objeto CodigoQRVisita con la imagen QR generada
       │
       ▼
6. [PRESENTACIÓN]  Muestra el QR en pantalla + botón "Compartir por WhatsApp"
```

---

*Última actualización: Abril 2026*
