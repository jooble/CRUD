package ru.jooble.service;

import ru.jooble.dao.ConnectionFactory;
import ru.jooble.dao.PurseDaoJdbcImpl;
import ru.jooble.domain.Purse;

import java.util.List;


public class PurseServiceJdbcImpl implements PurseService {

    @Override
    public Purse getById(long id) {
        return new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).getById(id);
    }

    @Override
    public void insert(Purse purse) {
        new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).insert(purse);
    }

    @Override
    public List<Purse> getAll() {
        return new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).getAll();
    }

    @Override
    public void update(Purse purse) {
        new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).update(purse);
    }

    @Override
    public void deleteById(long id) {
        new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).deleteById(id);
    }
}
