package nz.co.bnz.lapworkshop.exception;

public class UnprivilegedDataAccessException extends Exception {

    public UnprivilegedDataAccessException() {
        super("You're not allowed to access this resource.");
    }
}
