package ru.jooble.service;

import ru.jooble.DTO.CurrencyDTO;

import java.util.List;

public interface CurrencyService {

    CurrencyDTO getById(long id);

    List<CurrencyDTO> getAll();

    void insert(CurrencyDTO currencyDTO);

    void update(CurrencyDTO currencyDTO);

    void deleteById(long id);

    List<CurrencyDTO> getByCriteria(String criteria);
}