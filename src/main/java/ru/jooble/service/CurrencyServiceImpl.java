package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.CurrencyDAO;
import ru.jooble.domain.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Override
    public Currency getById(long id) {
        try {
            currencyDAO.beginTransaction();
            Currency currency = currencyDAO.getById(id);
            currencyDAO.commitTransaction();
            return currency;
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t currency get by id (%s)", id), e);
        }
    }

    @Override
    public List<Currency> getAll() {
        try {
            currencyDAO.beginTransaction();
            List<Currency> currencies = currencyDAO.getAll();
            currencyDAO.commitTransaction();
            return currencies;
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t currency get all"), e);
        }
    }

    @Override
    public void insert(Currency currency) {
        try {
            currencyDAO.beginTransaction();
            try {
                currencyDAO.insert(currency);
                currencyDAO.commitTransaction();
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", currency), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", currency), e);
        }

    }

    @Override
    public void update(Currency currency) {
        try {
            currencyDAO.beginTransaction();
            try {
                currencyDAO.update(currency);
                currencyDAO.commitTransaction();
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update (%s)", currency), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update (%s)", currency), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            currencyDAO.beginTransaction();
            try {
                currencyDAO.deleteById(id);
                currencyDAO.commitTransaction();
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t currency delete by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t currency delete by id (%s)", id), e);
        }
    }
}