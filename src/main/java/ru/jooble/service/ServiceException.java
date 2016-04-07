package ru.jooble.service;


class ServiceException extends RuntimeException {

    ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
