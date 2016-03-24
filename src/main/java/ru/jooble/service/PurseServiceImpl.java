package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.PurseDAO;
import ru.jooble.domain.Purse;

import java.util.List;

@Service
public class PurseServiceImpl implements PurseService {

    @Autowired
    private PurseDAO purseDAO;

    @Override
    public Purse getById(long id) {
        try {
            purseDAO.beginTransaction();
            Purse purse = purseDAO.getById(id);
            purseDAO.commitTransaction();
            return purse;
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t purse get by id (%s)", id), e);
        }
    }


    @Override
    public List<Purse> getAll() {
        try {
            try {
                purseDAO.beginTransaction();
                List<Purse> purses = purseDAO.getAll();
                purseDAO.commitTransaction();
                return purses;
            } catch (Exception e) {
                throw new ServiceException(String.format("Can`t get all purse"), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t get all purse"), e);
        }
    }

    @Override
    public void insert(Purse purse) {
        try {
            purseDAO.beginTransaction();
            try {
                purseDAO.insert(purse);
                purseDAO.commitTransaction();
            } catch (Exception e) {
                purseDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t insert (%s)", purse), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t insert (%s)", purse), e);
        }
    }

    @Override
    public void update(Purse purse) {
        try {
            purseDAO.beginTransaction();
            try {
                purseDAO.update(purse);
                purseDAO.commitTransaction();
            } catch (Exception e) {
                purseDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t update (%s)", purse), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t update (%s)", purse), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            purseDAO.beginTransaction();
            try {
                purseDAO.deleteById(id);
                purseDAO.commitTransaction();
            } catch (Exception e) {
                purseDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can`t delete purse by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can`t delete purse by id (%s)", id), e);
        }
    }
}
