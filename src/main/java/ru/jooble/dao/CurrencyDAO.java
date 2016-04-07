package ru.jooble.dao;

import org.springframework.data.repository.CrudRepository;
import ru.jooble.domain.Currency;

import java.util.List;


public interface CurrencyDAO extends CrudRepository<Currency, Long> {

    Currency findOne(Long id);

    List<Currency> findAll();

    Currency saveAndFlush(Currency currency);

    void delete(Currency currency);

    List<Currency> findByNameIgnoreCaseLike(String criteria);
}
