package ru.jooble.dao;

/**
 * Исключение дао слоя
 * <p/>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class DaoException extends RuntimeException {


    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
