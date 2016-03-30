package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.DTO.CurrencyDTO;
import ru.jooble.dao.CurrencyDAO;
import ru.jooble.dao.PurseDAO;
import ru.jooble.domain.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Autowired
    private PurseDAO purseDAO;


    @Override
    @Transactional(readOnly = true)
    public Currency getById(long id) {
        return currencyDAO.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Currency> getAll() {
        return currencyDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(CurrencyDTO currencyDTO) {
        currencyDAO.insert(currencyDTOInTheCurrency(currencyDTO));
    }

    @Override
    @Transactional
    public void update(CurrencyDTO currencyDTO) {
        currencyDAO.update(currencyDTOInTheCurrency(currencyDTO));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        try {
            currencyDAO.deleteById(id);
        } catch (Exception e) {
            throw new CanNotDeleteCurrencyException(String.format("Can`t delete currency. Id - (%)", id), e);
        }
    }

    private Currency currencyDTOInTheCurrency(CurrencyDTO currencyDTO) {
        Currency currency = new Currency();
        if (currencyDTO.getId() == null) {
            currency.setName(currencyDTO.getName());
        } else {
            currency.setId(Long.parseLong(currencyDTO.getId()));
            currency.setName(currencyDTO.getName());
        }

        return currency;
    }
}