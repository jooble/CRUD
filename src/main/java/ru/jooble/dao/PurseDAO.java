package ru.jooble.dao;

import org.springframework.data.repository.CrudRepository;
import ru.jooble.domain.Purse;

import java.util.List;

public interface PurseDAO extends CrudRepository<Purse, Long> {

    Purse findOne(Long id);

    List<Purse> findAll();

    Purse saveAndFlush(Purse purse);

    void delete(Purse purse);
}
