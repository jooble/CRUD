package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.DAOManager;
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
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getCurrencyDAO().insert(currency);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", currency), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", currency), e);
        }

    }

    @Override
    public void update(Currency currency) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getCurrencyDAO().update(currency);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update (%s)", currency), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update (%s)", currency), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getCurrencyDAO().deleteById(id);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t currency delete by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t currency delete by id (%s)", id), e);
        }
    }
}