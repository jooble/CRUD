package ru.jooble.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Currency.class)
public class Currency_ {

    public static volatile SingularAttribute<Currency, Long> id;
    public static volatile SingularAttribute<Currency, String> name;
}