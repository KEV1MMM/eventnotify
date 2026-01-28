// 1. El servicio viejo (Incompatible)
class LegacyLogger {
    logInFile(text) {
        console.log(`WRITING TO FILE >>> ${text}`);
    }
}

// 2. El Adaptador
class LoggerAdapter {
    constructor(legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    // Nuestra app espera el método 'log', no 'logInFile'
    log(message) {
        this.legacyLogger.logInFile(message);
    }
}

// 3. Uso
console.log("--- Adapter Pattern JS ---");
const oldLogger = new LegacyLogger();
const adaptedLogger = new LoggerAdapter(oldLogger);

adaptedLogger.log("Error de conexión detectado");