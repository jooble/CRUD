package ru.jooble.service;

import ru.jooble.DTO.CurrencyDTO;
import ru.jooble.domain.Currency;

import java.util.List;

public interface CurrencyService {

    Currency getById(long id);

    List<Currency> getAll();

    void insert(CurrencyDTO currencyDTO);

    void update(CurrencyDTO currencyDTO);

    void deleteById(long id);

}