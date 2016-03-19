package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.jooble.dao.DAOManagerFactory;
import ru.jooble.domain.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private DAOManagerFactory daoManagerFactory;


    @Override
    public Currency getById(long id) {
        return daoManagerFactory.getDAOManager().getCurrencyDAO().getById(id);
    }


    @Override
    public List<Currency> getAll() {
        return daoManagerFactory.getDAOManager().getCurrencyDAO().getAll();
    }

    @Override
    public void insert(Currency currency) {
        daoManagerFactory.getDAOManager().getCurrencyDAO().insert(currency);
    }

    @Override
    public void update(Currency currency) {
        daoManagerFactory.getDAOManager().getCurrencyDAO().update(currency);
    }

    @Override
    public void deleteById(long id) {
        daoManagerFactory.getDAOManager().getCurrencyDAO().deleteById(id);
    }
}