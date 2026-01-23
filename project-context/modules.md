# Módulos del Sistema (Contexto)

- **EventBus**: Publica eventos y notifica a suscriptores.
- **Events**: Tipos de evento (UserRegistered, OrderPaid, PasswordReset).
- **Subscribers/Handlers**: Componentes que reaccionan a eventos.
- **NotificationService**: Coordina el envío de notificaciones.
- **Channels**: EmailChannel, SMSChannel, PushChannel.
- **Templates**: Construcción del mensaje según el evento.
- **Cross-cutting**: logging, reintentos, prioridad, rate-limiting (extensiones).
