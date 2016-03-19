package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.DAOManager;
import ru.jooble.dao.DAOManagerFactory;
import ru.jooble.domain.Purse;

import java.util.List;

@Service
public class PurseServiceImpl implements PurseService {

   @Autowired
    private DAOManagerFactory daoManagerFactory;

    @Override
    public Purse getById(long id) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                Purse purse = daoManager.getPurseDAO().getById(id);
                daoManager.commitTransaction();
                return purse;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t get purse by id (%)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t get purse by id (%)", id), e);
        }
    }

    @Override
    public void insert(Purse purse) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getPurseDAO().insert(purse);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", purse), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", purse), e);
        }
    }

    @Override
    public List<Purse> getAll() {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<Purse> purses = daoManager.getPurseDAO().getAll();
                for (Purse purse : purses) {
                    purse.setCurrencyShortName(daoManager.getCurrencyDAO().getById(purse.getCurrencyId()).getName());
                }
                daoManager.commitTransaction();
                return purses;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Catn`t get all purse"), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Catn`t get all purse"), e);
        }
    }

    @Override
    public void update(Purse purse) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getPurseDAO().update(purse);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update (%s)", purse), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update (%s)", purse), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getPurseDAO().deleteById(id);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t delete purse by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t delete purse by id (%s)", id), e);
        }
    }
}
