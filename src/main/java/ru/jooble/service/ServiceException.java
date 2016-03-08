package ru.jooble.service;


public class ServiceException extends RuntimeException {


    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
