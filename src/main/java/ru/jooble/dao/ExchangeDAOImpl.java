package ru.jooble.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.jooble.domain.Exchange;

import java.util.List;

@Repository
public class ExchangeDAOImpl implements ExchangeDAO {


    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public Exchange getById(long id) {
        return (Exchange) sessionFactory.getCurrentSession().get(Exchange.class, id);
    }

    @Override
    public List<Exchange> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Exchange.class).list();
    }

    @Override
    public void insert(Exchange exchange) {
        sessionFactory.getCurrentSession().save(exchange);
    }

    @Override
    public void update(Exchange exchange) {
        sessionFactory.getCurrentSession().update(exchange);
    }

    @Override
    public void deleteById(long id) {
        Exchange exchange = (Exchange) sessionFactory.getCurrentSession().get(Exchange.class, id);
        sessionFactory.getCurrentSession().delete(exchange);
    }

}

