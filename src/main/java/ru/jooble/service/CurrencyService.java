package ru.jooble.service;

import ru.jooble.domain.Currency;

import java.util.List;

public interface CurrencyService {

    Currency getById(long id);

    List<Currency> getAll();

    void insert(Currency currency);

    void update(Currency currency);

    void deleteById(long id);

}