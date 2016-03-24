package ru.jooble.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jooble.domain.Currency;

import java.util.List;

@Component
public class CurrencyDAOImpl implements CurrencyDAO {
    @Autowired
    public SessionFactory sessionFactory;


    @Override
    public void beginTransaction() {
        sessionFactory.getCurrentSession().beginTransaction();
    }

    @Override
    public void commitTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        sessionFactory.getCurrentSession().getTransaction().rollback();
    }


    @Override
    public Currency getById(long id) {
        return (Currency) sessionFactory.getCurrentSession().get(Currency.class, id);
    }

    @Override
    public List<Currency> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Currency.class).list();
    }

    @Override
    public void insert(Currency currency) {
        sessionFactory.getCurrentSession().save(currency);
    }

    @Override
    public void update(Currency currency) {
        sessionFactory.getCurrentSession().update(currency);
    }

    @Override
    public void deleteById(long id) {
        Currency currency = (Currency) sessionFactory.getCurrentSession().get(Currency.class, id);
        sessionFactory.getCurrentSession().delete(currency);
    }

}