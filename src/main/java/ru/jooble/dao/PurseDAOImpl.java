package ru.jooble.dao;


import org.springframework.stereotype.Repository;
import ru.jooble.domain.Purse;

import javax.annotation.PostConstruct;

@Repository
public class PurseDAOImpl extends GenericDAOImpl<Purse> implements PurseDAO {

    @PostConstruct
    public void init() {
        super.setType(Purse.class);
    }
}

