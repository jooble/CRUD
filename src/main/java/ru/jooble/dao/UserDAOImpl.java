package ru.jooble.dao;


import org.springframework.stereotype.Repository;
import ru.jooble.domain.User;

import javax.annotation.PostConstruct;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

    @PostConstruct
    public void init() {
        super.setType(User.class);
    }

}
