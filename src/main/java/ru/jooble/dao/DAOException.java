package ru.jooble.dao;

/**
 * Исключение дао слоя
 * <p/>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class DAOException extends RuntimeException {


    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
