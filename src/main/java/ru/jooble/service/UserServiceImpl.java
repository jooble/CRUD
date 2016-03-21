package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.DAOManager;
import ru.jooble.dao.DAOManagerFactory;
import ru.jooble.domain.Purse;
import ru.jooble.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DAOManagerFactory daoManagerFactory;

    @Override
    public User getById(long id) {
        return daoManagerFactory.getDAOManager().getUserDAO().getById(id);
    }

    @Override
    public List<User> getAll() {
        return daoManagerFactory.getDAOManager().getUserDAO().getAll();
    }

    @Override
    public void insert(User user) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getUserDAO().insert(user);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", user), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", user), e);
        }
    }

    @Override
    public void update(User user) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getUserDAO().update(user);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update  (%s)", user), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update  (%s)", user), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<Purse> purses = daoManager.getPurseDAO().getAll();
                for (Purse purse : purses) {
                    if (purse.getOwnerId() == id) {
                        daoManager.getPurseDAO().deleteById(purse.getId());
                    }
                }
                daoManager.getUserDAO().deleteById(id);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can`t delete user by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t delete user by id (%s)", id), e);
        }
    }
}


