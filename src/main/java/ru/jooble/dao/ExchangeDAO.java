package ru.jooble.dao;


import ru.jooble.domain.Exchange;

import java.util.List;

public interface ExchangeDAO {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    Exchange getById(long id);

    void insert(Exchange exchange);

    List<Exchange> getAll();

    void update(Exchange exchange);

    void deleteById(long id);
}
