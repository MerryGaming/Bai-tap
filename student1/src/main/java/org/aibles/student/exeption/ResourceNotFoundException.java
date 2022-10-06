package org.aibles.student.exeption;

public class ResourceNotFoundException extends RuntimeException{
    private final String message;

    public ResourceNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
