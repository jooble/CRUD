package ru.jooble.service;

/**
 * Created by ������� on 30.03.2016.
 */
public class CanNotDeleteCurrencyException extends ServiceException {

    public CanNotDeleteCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }
}
