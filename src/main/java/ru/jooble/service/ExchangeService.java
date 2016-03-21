package ru.jooble.service;


import ru.jooble.domain.Exchange;

import java.util.List;

public interface ExchangeService {

    Exchange getById(long id);

    void insert(Exchange exchange);

    List<Exchange> getAll();

    void update(Exchange exchange);

    void deleteById(long id);

}
