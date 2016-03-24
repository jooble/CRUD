package ru.jooble.dao;


import ru.jooble.domain.User;
import java.util.List;

public interface UserDAO {

    User getById(long id);

    List<User> getAll();

    void insert(User user);

    void update(User user);

    void deleteById(long id);
}
