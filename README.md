# Informe del Proyecto: 🪲 BugLog
## Parcial 1 - Aplicaciones Móviles (ACN4BV)

**Repositorio:** AnthonyNadsat/parcial-1-am-acn4bv-galarza-salazar  
**Equipo:** Galarza & Salazar  
**Descripción:** Primer parcial de Aplicaciones Móviles en Escuela Da Vinci

---

## 📋 Descripción

BugLog es una aplicación móvil desarrollada en Android que permite a los usuarios reportar y gestionar bugs encontrados en videojuegos de manera organizada y eficiente. Cuenta con un formulario interactivo de registro y un historial visual para consultar los reportes realizados.

---

## ✨ Características

- 📝 **Formulario de Reporte:** Interfaz intuitiva para registrar bugs con validación de datos
- 📚 **Historial de Bugs:** Visualización de reportes en formato de tarjetas (cards)
- 🔄 **Navegación Fluida:** Sistema de navegación bidireccional entre vistas
- 🎨 **Diseño Moderno:** Interfaz de usuario renovada y pulida
- 🔍 **Filtrado:** Botón flotante para filtrar bugs en el historial
- ⬅️ **Navegación Intuitiva:** Botón de retorno para volver a la vista principal

---

### 💿 Pasos de instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/AnthonyNadsat/parcial-1-am-acn4bv-galarza-salazar.git
```

2. **Abrir en Android Studio**
```bash
cd parcial-1-am-acn4bv-galarza-salazar
```
Luego abre el proyecto desde Android Studio

3. **Sincronizar Gradle**
- Android Studio sincronizará automáticamente las dependencias

4. **Ejecutar la aplicación**
- Conecta un dispositivo Android o inicia un emulador
- Presiona el botón "Run" en Android Studio

---

## 📱 Capturas de Pantalla

### Pantalla Principal - Formulario de Reporte
<img width="525" height="1128" alt="formulario" src="https://github.com/user-attachments/assets/8cfac1d8-65a8-457a-8679-40257e965061" />

### Pantalla Secundaria - Historial de Bugs
<img width="532" height="1154" alt="historial" src="https://github.com/user-attachments/assets/184119f2-7300-4f09-8c83-c635c17f9741" />


---

## 📊 Resumen

Este proyecto corresponde al desarrollo colaborativo de una aplicación Android llamada **BugLog**, diseñada para el reporte y seguimiento de bugs/glitches encontrados en videojuegos. 
---

## 💻 Tecnologías y Estadísticas

### Lenguajes de Programación
- **Java**

### Información del Repositorio
- **Visibilidad:** Público
- **Rama principal:** master
- **Colaboradores:* AnthonyNadsat, Lukarda

---

## 📅 Línea de Tiempo del Proyecto

### **Fase 1: Configuración Inicial** 

#### Commit 1: Estructura Base
- **Autor:** AnthonyNadsat
- **Hash:** `c4fac99`
- **Mensaje:** `chore(base-setup): Estructura inicial del proyecto Android`
- **Descripción:** Configuración base del proyecto Android
---

### **Fase 2: Desarrollo del Formulario**

#### Commit 2: Pantalla de Reporte
- **Autor:** AnthonyNadsat
- **Hash:** `413560b`
- **Mensaje:** `feat(form): pantalla de reporte con formulario`
- **Descripción:** Implementación de la pantalla principal con formulario interactivo para reportar bugs, incluyendo campos de entrada y validaciones.

#### Commit 3: Sistema de Historial
- **Autor:** Lukarda
- **Hash:** `088f367`
- **Mensaje:** `feat(list): lista de bugs con tarjetas agregadas a modo de historial`
- **Descripción:** Creación del sistema de visualización de bugs registrados mediante 'cards' en una segunda pantalla.

---

### **Fase 3: Rediseño de Interfaz**

#### Commit 4: Rediseño Completo
- **Autor:** AnthonyNadsat
- **Hash:** `0b007cc`
- **Mensaje:** `feat(ui): rediseño completo de BugLog (formulario e historial)`
- **Descripción:** Renovación de la interfaz de usuario con mejoras visuales tanto del formulario como del historial de bugs.

---

### **Fase 4: Mejoras de Navegación**

#### Commit 5: Botón de Retorno
- **Autor:** Lukarda
- **Hash:** `ac73b68`
- **Mensaje:** `feat(list): boton volver para regresar a la vista principal`
- **Descripción:** Implementación de un botón para retornar desde el historial a la pantalla principal.

#### Commit 6: Recuperación de Archivos
- **Autor:** Lukarda
- **Hash:** `ee7245b`
- **Mensaje:** `fix(list): recupera archivos de pantalla de historial`
- **Descripción:** Corrección y recuperación de archivos relacionados con la pantalla de historial.

---

### **Fase 5: Refinamiento Final**

#### Commit 7: Botón Flotante y Ajustes Finales
- **Autor:** Lukarda
- **Hash:** `6ff6925`
- **Mensaje:** `feat(list-ui): boton flotante de filtro y ajustes visuales en historial de bugs`
- **Descripción:** Implementación de botón flotante para funcionalidad de filtrado y refinamiento en la experiencia de usuario del historial.


---

## 🎯 Funcionalidades Implementadas

### ✅ Módulo de Registro
- Formulario completo de reporte de bugs
- Validación de datos de entrada
- Interfaz de usuario moderna

### ✅ Módulo de Historial
- Visualización de bugs en formato de tarjetas
- Sistema de navegación fluida entre pantallas
- Botón flotante para filtrado

### ✅ Sistema de Navegación
- Navegación bidireccional entre vistas
- Botón de retorno a vista principal

---

## 🔧 Aspectos Técnicos

### Tecnologías Utilizadas
- **Plataforma:** Android
- **Lenguaje Principal:** Java
- **IDE:** Android Studio 
- **Build System:** Gradle
- **Patrón de diseño:** Activities

### Archivos Principales
- `ListaBugsActivity.java` - Actividad principal para listar y gestionar bugs
- Archivos de layout XML para formularios y listas
- Recursos drawable para elementos visuales
- Configuraciones Gradle para dependencias

---

## 📈 Estadísticas del Desarrollo

| Métrica | Valor |
|---------|-------|
| Total de Commits | 8 |
| Features Implementadas | 6 |
| Fixes | 1 |
| Refactorizaciones | 1 |
| Colaboradores | 2 |

---

## 🔄 Flujo de Trabajo

El equipo utilizó un flujo de trabajo colaborativo basado en Git:

1. **Desarrollo paralelo** - Ambos desarrolladores trabajaron en diferentes módulos simultáneamente
2. **Integración continua** - Merge regular de cambios a la rama master
3. **Conventional Commits** - Uso de prefijos semánticos (feat, fix, chore)

### Patrones de Commit Utilizados
- `feat(módulo):` - Nuevas funcionalidades
- `fix(módulo):` - Corrección de bugs
- `chore(módulo):` - Tareas de mantenimiento

---

## 🎨 Evolución del Diseño

### Iteración 1 
- Diseño funcional básico
- Formulario simple
- Lista básica de bugs

### Iteración 2
- Rediseño completo de interfaz
- Mejoras visuales significativas

### Iteración 3 
- Mejoras de navegación
- Botón de retorno implementado

### Iteración 4 
- Botón flotante para filtros
- Refinamientos visuales finales

---

## 🏆 Logros del Proyecto

- ✅ Aplicación funcional y completa
- ✅ Interfaz moderna
- ✅ Navegación intuitiva
- ✅ Colaboración efectiva entre los colaboradores
- ✅ Uso de conventional commits

---

## 📝 Conclusiones

El proyecto **BugLog** fue desarrollado con la presencia de los siguientes puntos:

- **Colaboración efectiva:** Trabajo coordinado entre Lukarda y AnthonyNadsat con integración fluida de cambios
- **Iteración continua:** Múltiples refinamientos del diseño hasta alcanzar un resultado pulido
- **Buenas prácticas:** Uso de conventional commits, estructura organizada del proyecto
- **Enfoque en UX:** Atención especial a la experiencia del usuario con mejoras visuales constantes
- **Resolución de problemas:** Capacidad de recuperar archivos y resolver conflictos

El resultado es una **aplicación Android funcional y moderna** para el registro y seguimiento de bugs, con una interfaz intuitiva que incluye formulario de reporte, historial con tarjetas, navegación fluida y sistema de filtrado mediante botón flotante.

---

## 🔗 Enlaces Relevantes

- **Repositorio:** https://github.com/AnthonyNadsat/parcial-1-am-acn4bv-galarza-salazar
- **Commit más reciente:** https://github.com/AnthonyNadsat/parcial-1-am-acn4bv-galarza-salazar/commit/6ff69252fe57adf39405fe9992a7ddc50606d3aa

---

