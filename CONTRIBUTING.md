# Contributing (Reglas del Equipo)

## A) Estructura obligatoria por patrón
Cada patrón debe tener exactamente estos 5 puntos (rúbrica):
1) **Nombre** (identificación oficial)
2) **Categoría** (Creacional / Estructural / Comportamiento)
3) **Propósito** (1 oración: qué hace y por qué es útil)
4) **Código de referencia** funcional en mínimo **2 lenguajes**
5) **Estructura UML** (diagrama de clases)

### Estructura de carpetas por patrón
patterns/<categoria>/<patron>/
  README.md
  uml/
    diagram.puml
    diagram.png   (si puedes generar imagen)
  code/
    java/
      Demo.java (o Main.java)
    javascript/
      demo.js

## B) Reglas de código (para que sea “funcional”)
- Debe existir un archivo Demo/Main que se pueda ejecutar y muestre salida en consola.
- Java: incluir `Demo.java` con `public static void main`.
- JavaScript: incluir `demo.js` ejecutable con `node demo.js`.

## C) Commits (colaboración trazable)
Cada patrón debe tener mínimo estos commits (por persona):
1) `Add <Pattern> documentation`
2) `Add <Pattern> UML`
3) `Implement <Pattern> in Java`
4) `Implement <Pattern> in JavaScript`

## D) Flujo de trabajo (obligatorio)
- Cada integrante trabaja en su rama: `feature/<pattern>-<name>`
- Abrir Pull Request (PR)
- Otro integrante revisa y aprueba
- Merge a main
