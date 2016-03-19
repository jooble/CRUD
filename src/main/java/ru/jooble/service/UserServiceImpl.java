package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
        return daoManagerFactory.getDAOManager().getUserDAO().getById(id);
    }

    @Override
    public void insert(User user) {
        daoManagerFactory.getDAOManager().getUserDAO().insert(user);
    }


    @Override
    public List<User> getAll() {
        return daoManagerFactory.getDAOManager().getUserDAO().getAll();
    }


    @Override
    public void update(User user) {
        daoManagerFactory.getDAOManager().getUserDAO().update(user);
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


