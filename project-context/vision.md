# Visión del Proyecto Base: EventNotify

EventNotify es un sistema basado en eventos para una aplicación genérica. Cuando ocurre una acción
importante (por ejemplo: registro de usuario, pago confirmado, restablecimiento de contraseña),
se publica un evento y múltiples componentes pueden reaccionar automáticamente.

El sistema envía notificaciones por diferentes canales (Email, SMS, Push) y permite extender
comportamientos sin modificar el núcleo (por ejemplo: logging, reintentos, prioridad).

Este repositorio documenta los patrones de diseño GoF aplicados a este contexto para apoyar la toma
de decisiones en el diseño de arquitecturas de software complejas.
