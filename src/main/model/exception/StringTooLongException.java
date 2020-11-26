package model.exception;

// an exception which is thrown when the uniqueID given is not a string
public class StringTooLongException extends Exception {
    public StringTooLongException() {

    }

    public StringTooLongException(String msg) {
        super(msg);
    }
}