package ru.jooble.dao;

import org.springframework.data.repository.CrudRepository;
import ru.jooble.domain.Exchange;

import java.util.List;

public interface ExchangeDAO extends CrudRepository<Exchange, Long> {

    Exchange findOne(Long id);

    List<Exchange> findAll();

    Exchange saveAndFlush(Exchange exchange);

    void delete(Exchange exchange);
}
