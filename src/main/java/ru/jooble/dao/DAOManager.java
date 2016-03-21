package ru.jooble.dao;


import ru.jooble.domain.Exchange;

public interface DAOManager extends AutoCloseable {

    UserDAO getUserDAO();

    PurseDAO getPurseDAO();

    CurrencyDAO getCurrencyDAO();

    ExchangeDAO getExchangeDAO();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();
}
