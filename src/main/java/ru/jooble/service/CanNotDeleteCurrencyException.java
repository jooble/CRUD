package ru.jooble.service;


public class CanNotDeleteCurrencyException extends ServiceException {

    CanNotDeleteCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }
}
