# Chain of Responsibility

## Nombre
Chain of Responsibility

## Categoría
Comportamiento (Behavioral)

## Propósito
Encadenar múltiples manejadores para que una solicitud sea procesada por uno o varios de ellos sin acoplar directamente el emisor con el receptor final.

## Código de Referencia

### Implementación en Java
**Archivo:** `code/java/Demo.java`

Este ejemplo implementa una cadena de validación y envío de notificaciones, donde cada manejador decide si procesa la solicitud o la pasa al siguiente.

**Compilar:**
```bash
cd patterns/behavioral/chain-of-responsibility/code/java
javac Demo.java
```
**Ejecutar:**
```bash
java Demo
```

### Implementación en JavaScript 
Archivo: code/javascript/demo.js
**Ejecutar:**
```bash
cd patterns/behavioral/chain-of-responsibility/code/javascript
node demo.js
```

### Estructura UML
Diagrama de clases en PlantUML:
uml/chain-of-responsibility.puml
