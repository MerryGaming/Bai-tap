package org.aibles.demo_worker.exeption;

public class BadRequestException extends RuntimeException{
    private final String message;

    public BadRequestException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
