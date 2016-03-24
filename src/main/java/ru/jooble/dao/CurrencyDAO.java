package ru.jooble.dao;

import ru.jooble.domain.Currency;

import java.util.List;


public interface CurrencyDAO {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    Currency getById(long id);

    List<Currency> getAll();

    void insert(Currency currency);

    void update(Currency currency);

    void deleteById(long id);

}
