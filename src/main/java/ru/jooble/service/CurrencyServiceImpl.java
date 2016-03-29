package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.dao.CurrencyDAO;
import ru.jooble.domain.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Override
    @Transactional
    public Currency getById(long id) {
        return currencyDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Currency> getAll() {
        return currencyDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(Currency currency) {
        currencyDAO.insert(currency);
    }

    @Override
    @Transactional
    public void update(Currency currency) {
        currencyDAO.update(currency);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        try {
            currencyDAO.deleteById(id);
        } catch (Exception e) {
            throw new canNotDelete(String.format("Can`t delete currency. Id - (%)", id), e);
        }
    }

    class canNotDelete extends RuntimeException {
        public canNotDelete(String message, Throwable cause) {
            super(message, cause);
        }
    }
}