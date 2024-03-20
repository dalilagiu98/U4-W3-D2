package org.example.exceptions;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException(long id) {
        super("The element with id " + id + " not found!");
    }
}
