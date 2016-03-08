package ru.jooble.service;

import ru.jooble.domain.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> getAll();

    void insert(Currency currency);
}