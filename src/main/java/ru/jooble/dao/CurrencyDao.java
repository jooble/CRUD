package ru.jooble.dao;

import ru.jooble.domain.Currency;

import java.util.List;


public interface CurrencyDao {

    List<Currency> getAll();

    void insert(Currency currency);
}
