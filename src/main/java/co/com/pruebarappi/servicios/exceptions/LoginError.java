package co.com.pruebarappi.servicios.exceptions;

public class LoginError extends AssertionError {
    public LoginError(String message) {
        super(message);
    }

    public LoginError(String message, Throwable cause) {
        super(message, cause);
    }
}
