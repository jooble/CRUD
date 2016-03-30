package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.dao.ExchangeDAO;
import ru.jooble.domain.Exchange;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeDAO exchangeDAO;

    @Override
    @Transactional(readOnly = true)
    public Exchange getById(long id) {
        return exchangeDAO.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Exchange> getAll() {
        return exchangeDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(Exchange exchange) {
        exchangeDAO.insert(exchange);
    }

    @Override
    @Transactional
    public void update(Exchange exchange) {
        exchangeDAO.update(exchange);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        exchangeDAO.deleteById(id);
    }
}
