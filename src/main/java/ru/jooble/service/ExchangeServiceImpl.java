package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.ExchangeDAO;
import ru.jooble.domain.Exchange;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeDAO exchangeDAO;

    @Override
    public Exchange getById(long id) {
        try {
            exchangeDAO.beginTransaction();
            Exchange exchange = exchangeDAO.getById(id);
            exchangeDAO.commitTransaction();
            return exchange;
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t exchange get by id (%s)", id), e);
        }
    }

    @Override
    public void insert(Exchange exchange) {
        try {
            exchangeDAO.beginTransaction();
            try {
                exchangeDAO.insert(exchange);
                exchangeDAO.commitTransaction();
            } catch (Exception e) {
                exchangeDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", exchange), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", exchange), e);
        }
    }

    @Override
    public List<Exchange> getAll() {
        try {
            exchangeDAO.beginTransaction();
            try {
                List<Exchange> exchanges = exchangeDAO.getAll();
                exchangeDAO.commitTransaction();
                return exchanges;
            } catch (Exception e) {
                exchangeDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t get all exchange"), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t get all exchange"), e);
        }
    }


    @Override
    public void update(Exchange exchange) {
        try {
            exchangeDAO.beginTransaction();
            try {
                exchangeDAO.update(exchange);
                exchangeDAO.commitTransaction();
            } catch (Exception e) {
                exchangeDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update (%s)", exchange), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update (%s)", exchange), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            exchangeDAO.beginTransaction();
            try {
                exchangeDAO.deleteById(id);
                exchangeDAO.commitTransaction();
            } catch (Exception e) {
                exchangeDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t delete by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t delete by id (%s)", id), e);

        }
    }
}
