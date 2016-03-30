package ru.jooble.service;


public class CanNotDeleteCurrencyException extends ServiceException {

    public CanNotDeleteCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }
}
