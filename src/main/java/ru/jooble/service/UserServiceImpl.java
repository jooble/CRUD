package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.PurseDAO;
import ru.jooble.dao.UserDAO;
import ru.jooble.domain.Purse;
import ru.jooble.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PurseDAO purseDAO;

    @Override
    public User getById(long id) {
        try {
            userDAO.beginTransaction();
            User user = userDAO.getById(id);
            userDAO.commitTransaction();
            return user;
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t user get by id (%s)", id), e);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            userDAO.beginTransaction();
            List<User> users = userDAO.getAll();
            userDAO.commitTransaction();
            return users;
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t purse get all"), e);
        }
    }


    @Override
    public void insert(User user) {
        try {
            userDAO.beginTransaction();
            try {
                userDAO.insert(user);
                userDAO.commitTransaction();
            } catch (Exception e) {
                userDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", user), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", user), e);
        }
    }

    @Override
    public void update(User user) {
        try {
            userDAO.beginTransaction();
            try {
                userDAO.update(user);
                userDAO.commitTransaction();
            } catch (Exception e) {
                userDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update  (%s)", user), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update  (%s)", user), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            userDAO.beginTransaction();
            try {
                List<Purse> purses = purseDAO.getAll();
                for (Purse purse : purses) {
                    if (purse.getOwner().getId() == id) {
                        purseDAO.deleteById(purse.getId());
                    }
                }
                userDAO.deleteById(id);
                userDAO.commitTransaction();
            } catch (Exception e) {
                userDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t delete user by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t delete user by id (%s)", id), e);
        }
    }
}


