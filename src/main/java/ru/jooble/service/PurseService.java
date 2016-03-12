package ru.jooble.service;

import ru.jooble.domain.Purse;

import java.util.List;

public interface PurseService {

    Purse getById(long id);

    void insert(Purse purse);

    List<Purse> getAll();

    void update(Purse purse);

    void deleteById(long id);
}




