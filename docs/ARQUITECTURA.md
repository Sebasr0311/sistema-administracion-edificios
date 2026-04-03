# 🏗️ Arquitectura del Sistema

## Diagrama de Capas

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

> **Regla de comunicación:** solo la capa superior puede llamar a la capa inmediatamente inferior. La capa de presentación no accede directamente a los DAOs ni a la base de datos.

---

## Estructura de Paquetes Java

| Paquete | Responsabilidad |
|---------|----------------|
| `com.edificio.admin` | Clase principal `App.java` — punto de entrada JavaFX |
| `com.edificio.admin.modelo` | Entidades del dominio (clases POJO) |
| `com.edificio.admin.dao` | Acceso a datos — operaciones CRUD con Oracle |
| `com.edificio.admin.servicio` | Lógica de negocio y validaciones |
| `com.edificio.admin.controlador` | Controladores JavaFX para las vistas FXML |
| `com.edificio.admin.configuracion` | Configuración de conexión a la base de datos |
| `com.edificio.admin.utilidad` | Clases utilitarias: generación de QR, validaciones, WhatsApp |
| `com.edificio.admin.excepcion` | Excepciones personalizadas del sistema |

---

## Entidades del Dominio (`com.edificio.admin.modelo`)

- `Edificio` — Datos del edificio administrado
- `Apartamento` — Apartamentos del edificio (solo arriendo)
- `Persona` — Personas registradas (propietarios, residentes, visitantes)
- `TutorMenor` — Relación entre menores de edad y sus tutores/padres
- `Contrato` — Contratos de arriendo
- `Residente` — Personas que residen en un apartamento
- `Pago` — Pagos de arriendo registrados
- `VisitanteRegistrado` — Visitantes registrados por un propietario
- `TipoVehiculo` — Catálogo de tipos de vehículo
- `EstacionamientoVisitante` — Asignación de estacionamiento al visitante
- `CodigoQRVisita` — Códigos QR generados (UUID único, un solo uso)
- `AcompananteVisita` — Acompañantes de un visitante principal
- `HistorialVisita` — Registro histórico de visitas escaneadas
- `Usuario` — Cuentas de acceso al sistema (roles: administrador, propietario, vigilante)

---

## Principios SOLID Aplicados

### S — Responsabilidad Única (Single Responsibility)
Cada clase tiene una única razón para cambiar.
*Ejemplo:* `PersonaDAO` solo accede a datos de personas. `PersonaServicio` solo aplica la lógica de negocio sobre personas.

### O — Abierto/Cerrado (Open/Closed)
Las clases están abiertas para extensión pero cerradas para modificación.
*Ejemplo:* La interfaz `IBaseDAO` define las operaciones CRUD; cada DAO la implementa sin modificar las demás.

### L — Sustitución de Liskov (Liskov Substitution)
Las subclases pueden sustituir a sus clases padre sin alterar el comportamiento.
*Ejemplo:* Cualquier implementación de `IVisitaQRServicio` puede ser usada sin cambiar el controlador.

### I — Segregación de Interfaces (Interface Segregation)
Las interfaces son específicas y no obligan a implementar métodos innecesarios.
*Ejemplo:* `ILecturaDAO` y `IEscrituraDAO` están separadas para DAOs que solo necesitan lectura.

### D — Inversión de Dependencias (Dependency Inversion)
Los módulos de alto nivel no dependen de módulos de bajo nivel; ambos dependen de abstracciones.
*Ejemplo:* `VisitaQRServicio` depende de la interfaz `ICodigoQRVisitaDAO`, no de la implementación concreta.

---

## Patrones de Diseño Utilizados

### Singleton — Conexión a la Base de Datos
`ConexionBD` en `com.edificio.admin.configuracion` garantiza una única instancia de conexión JDBC a Oracle durante toda la ejecución.

### DAO (Data Access Object)
Cada entidad tiene su propia clase DAO que encapsula todas las operaciones de base de datos. Separa la lógica de acceso a datos de la lógica de negocio.

### MVC con JavaFX
- **Modelo:** clases en `com.edificio.admin.modelo`
- **Vista:** archivos FXML en `recursos/vistas/`
- **Controlador:** clases en `com.edificio.admin.controlador`

### DTO (Data Transfer Object)
Se usan objetos DTO para transferir datos entre capas sin exponer directamente las entidades del dominio, especialmente hacia la capa de presentación.
