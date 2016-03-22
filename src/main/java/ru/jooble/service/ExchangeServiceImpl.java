package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.DAOManager;
import ru.jooble.dao.DAOManagerFactory;
import ru.jooble.domain.Currency;
import ru.jooble.domain.Exchange;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private DAOManagerFactory daoManagerFactory;

    @Override
    public Exchange getById(long id) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            return daoManager.getExchangeDAO().getById(id);
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t exchange get by id (%s)", id), e);
        }
    }

    @Override
    public void insert(Exchange exchange) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getExchangeDAO().insert(exchange);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", exchange), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", exchange), e);
        }
    }

    @Override
    public List<Exchange> getAll() {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<Currency> currencies = daoManager.getCurrencyDAO().getAll();
                List<Exchange> exchanges = daoManager.getExchangeDAO().getAll();
                for (Exchange exchange : exchanges) {
                    for (Currency currency : currencies) {
                        if (exchange.getSourceCurrencyId() == currency.getId()) {
                            exchange.setSourceCurrencyShortName(currency.getName());
                        }
                        if (exchange.getTargetCurrencyId() == currency.getId()) {
                            exchange.setTargetCurrencyShortName(currency.getName());
                        }
                    }
                }
                daoManager.commitTransaction();
                return exchanges;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t get all exchange"), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t get all exchange"), e);
        }
    }


    @Override
    public void update(Exchange exchange) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getExchangeDAO().update(exchange);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update (%s)", exchange), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update (%s)", exchange), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getExchangeDAO().deleteById(id);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t delete by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t delete by id (%s)", id), e);

        }
    }
}
