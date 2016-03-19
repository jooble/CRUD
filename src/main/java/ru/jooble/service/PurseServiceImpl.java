package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
        return daoManagerFactory.getDAOManager().getPurseDAO().getById(id);
    }

    @Override
    public void insert(Purse purse) {
        daoManagerFactory.getDAOManager().getPurseDAO().insert(purse);
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
        daoManagerFactory.getDAOManager().getPurseDAO().update(purse);
    }

    @Override
    public void deleteById(long id) {
        daoManagerFactory.getDAOManager().getPurseDAO().deleteById(id);
    }
}
