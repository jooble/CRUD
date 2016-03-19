package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.DAOManager;
import ru.jooble.dao.DAOManagerFactory;
import ru.jooble.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DAOManagerFactory daoManagerFactory;

    @Override
    public User getById(long id) {
        try {
            try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
                daoManager.beginTransaction();
                try {
                    User user = daoManager.getUserDAO().getById(id);
                    daoManager.commitTransaction();
                    return user;
                } catch (Exception e) {
                    daoManager.rollbackTransaction();
                    throw new ServiceException(String.format("Can`t get user by id (%s)", id), e);
                }
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t get user by id (%s)", id), e);
        }
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
    public List<User> getAll() {
        try {
            try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
                daoManager.beginTransaction();
                try {
                    List<User> users = daoManager.getUserDAO().getAll();
                    daoManager.commitTransaction();
                    return users;
                } catch (Exception e) {
                    daoManager.rollbackTransaction();
                    throw new ServiceException(String.format("Can't get all users"), e);
                }
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't get all users"), e);
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
                daoManager.getPurseDAO().deleteById(id);
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


