package ma.tamount.backend.exceptions;

public class CustomStripeException extends RuntimeException {
    public CustomStripeException(String message) {
        super(message);
    }
}
