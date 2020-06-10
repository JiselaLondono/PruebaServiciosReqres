package co.com.pruebarappi.servicios.exceptions;

public class AutenticacionError extends AssertionError {
    public AutenticacionError(String message) {
        super(message);
    }

    public AutenticacionError(String message, Throwable cause) {
        super(message, cause);
    }
}
