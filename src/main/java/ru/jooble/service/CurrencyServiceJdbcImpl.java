package ru.jooble.service;


import ru.jooble.dao.ConnectionFactory;
import ru.jooble.dao.CurrencyDaoJdbcImpl;
import ru.jooble.domain.Currency;

import java.util.List;

public class CurrencyServiceJdbcImpl implements CurrencyService {


    @Override
    public List<Currency> getAll() {
        return new CurrencyDaoJdbcImpl(ConnectionFactory.getInstance()).getAll();
    }

    @Override
    public void insert(Currency currency) {
        new CurrencyDaoJdbcImpl(ConnectionFactory.getInstance()).insert(currency);
    }

    @Override
    public Currency getById(long id) {
        return new CurrencyDaoJdbcImpl(ConnectionFactory.getInstance()).getById(id);
    }

    @Override
    public void update(Currency currency) {
        new CurrencyDaoJdbcImpl(ConnectionFactory.getInstance()).update(currency);
    }

    @Override
    public void deleteById(long id) {
        new CurrencyDaoJdbcImpl(ConnectionFactory.getInstance()).deleteById(id);
    }

}
