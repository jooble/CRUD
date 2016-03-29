package ru.jooble.dao;


import org.springframework.stereotype.Repository;
import ru.jooble.domain.Exchange;

import javax.annotation.PostConstruct;

@Repository
public class ExchangeDAOImpl extends GenericDAOImpl<Exchange> implements ExchangeDAO {
    @PostConstruct
    public void init() {
        super.setType(Exchange.class);
    }
}

