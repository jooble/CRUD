package ru.jooble.dao;


public interface DAOManager extends AutoCloseable {

    UserDAO getUserDAO();

    PurseDAO getPurseDAO();

    CurrencyDAO getCurrencyDAO();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();
}
