package ru.jooble.dao;

import ru.jooble.domain.Currency;

import java.util.List;


public interface CurrencyDAO extends GenericDAO<Currency> {

    List<Currency> getByCriteria(String criteria);

}
