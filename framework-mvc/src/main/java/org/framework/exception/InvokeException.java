package org.framework.exception;

public class InvokeException extends Exception {

    public InvokeException(Throwable cause) {
        super(cause);
    }

    public InvokeException(String message) {
        super(message);
    }
}
