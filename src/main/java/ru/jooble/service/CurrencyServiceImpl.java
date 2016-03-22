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
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
          return  daoManager.getCurrencyDAO().getById(id);
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t currency get by id (%s)", id), e);
        }
    }

    @Override
    public List<Currency> getAll() {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            return  daoManager.getCurrencyDAO().getAll();
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t currency get all"), e);
        }
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