package ru.jooble.dao;


import org.springframework.data.repository.CrudRepository;
import ru.jooble.domain.User;

import java.util.List;

public interface UserDAO extends CrudRepository<User, Long> {

    User findOne(Long id);

    List<User> findAll();

    User saveAndFlush(User user);

    void delete(User user);
}
