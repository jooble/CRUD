package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jooble.dao.CurrencyDao;
import ru.jooble.dao.PurseDao;
import ru.jooble.domain.Currency;
import ru.jooble.domain.Purse;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurseServiceImpl implements PurseService {

    @Autowired
    private PurseDao purseDao;

    @Autowired
    private CurrencyDao currencyDao;

    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    public void setPurseDao(PurseDao purseDao) {
        this.purseDao = purseDao;
    }

    @Override
    public Purse getById(long id) {
        return purseDao.getById(id);
    }

    @Override
    public void insert(Purse purse) {
        purseDao.insert(purse);
    }

    @Override
    public List<Purse> getAll() {
        List<Purse> purse = new ArrayList<>();
        purse.addAll(purseDao.getAll());
        for (int i = 0; i <= purse.size() - 1; i++) {
            purse.get(i).setCurrencyShortName(currencyDao.getById(purse.get(i).getIdcurrency()).getName());
        }
        return purse;
    }

    @Override
    public void update(Purse purse) {
        purseDao.update(purse);
    }

    @Override
    public void deleteById(long id) {
        purseDao.deleteById(id);
    }


}
