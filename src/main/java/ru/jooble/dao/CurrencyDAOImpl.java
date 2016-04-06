package ru.jooble.dao;


import org.springframework.stereotype.Repository;
import ru.jooble.domain.Currency;
import ru.jooble.domain.Currency_;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class CurrencyDAOImpl extends GenericDAOImpl<Currency> implements CurrencyDAO {

    @PostConstruct
    public void init() {
        super.setType(Currency.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Currency> getByCriteria(String st) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery = criteriaBuilder.createQuery(Currency.class);
        Root<Currency> currencyRoot = criteriaQuery.from(Currency.class);
        criteriaQuery.where(criteriaBuilder.like(currencyRoot.get(Currency_.name), "*" + st + "*"));
        List<Currency> currencies = entityManager.createQuery(criteriaQuery).getResultList();
        return currencies;
    }
}