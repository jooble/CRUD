package ru.jooble.dao;


import org.springframework.stereotype.Repository;
import ru.jooble.domain.Currency;

import javax.annotation.PostConstruct;

@Repository
public class CurrencyDAOImpl extends GenericDAOImpl<Currency> implements CurrencyDAO {

    @PostConstruct
    public void init() {
        super.setType(Currency.class);
    }
}
