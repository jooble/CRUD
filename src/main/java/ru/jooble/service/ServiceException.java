package ru.jooble.service;


public class ServiceException extends RuntimeException {

    ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
