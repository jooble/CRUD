package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.dao.PurseDAO;
import ru.jooble.domain.Purse;

import java.util.List;

@Service
public class PurseServiceImpl implements PurseService {

    @Autowired
    private PurseDAO purseDAO;

    @Override
    @Transactional(readOnly = true)
    public Purse getById(long id) {
        return purseDAO.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Purse> getAll() {
        return purseDAO.getAll();
    }

    @Override
    @Transactional
    public void insert(Purse purse) {
        purseDAO.insert(purse);
    }

    @Override
    @Transactional
    public void update(Purse purse) {
        purseDAO.update(purse);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        purseDAO.deleteById(id);
    }
}
