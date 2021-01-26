package be.pxl.ja.streamingservice.exception;

public class DuplicateEmailException extends Exception {
    public DuplicateEmailException(String email) {
        super(email + " allready exists");

    }
}
