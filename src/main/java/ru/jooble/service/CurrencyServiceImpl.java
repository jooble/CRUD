package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.CurrencyDao;
import ru.jooble.domain.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public List<Currency> getAll() {
        return currencyDao.getAll();
    }

    @Override
    public void insert(Currency currency) {
        currencyDao.insert(currency);
    }

    @Override
    public Currency getById(long id) {
        return currencyDao.getById(id);
    }

    @Override
    public void update(Currency currency) {
        currencyDao.update(currency);
    }

    @Override
    public void deleteById(long id) {
        currencyDao.deleteById(id);
    }

}
