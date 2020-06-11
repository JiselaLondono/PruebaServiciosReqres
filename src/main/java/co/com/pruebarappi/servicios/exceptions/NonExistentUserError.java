package co.com.pruebarappi.servicios.exceptions;

public class NonExistentUserError extends AssertionError {

    public NonExistentUserError(String message) {
        super(message);
    }

    public NonExistentUserError(String message, Throwable cause) {
        super(message, cause);
    }
}
