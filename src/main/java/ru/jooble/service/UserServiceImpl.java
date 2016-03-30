package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.dao.UserDAO;
import ru.jooble.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(User user) {
        userDAO.insert(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }
}


