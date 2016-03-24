package ru.jooble.dao;

import ru.jooble.domain.Purse;

import java.util.List;

public interface PurseDAO {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    Purse getById(long id);

    void insert(Purse purse);

    List<Purse> getAll();

    void update(Purse purse);

    void deleteById(long id);
}
