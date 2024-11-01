package org.phm.exception;

public class FileIoException extends Throwable {
    private final String message;
    public FileIoException(String message) {
        super();
        this.message= message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
