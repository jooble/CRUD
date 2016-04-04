package ru.jooble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.DTO.ConverterDTOToDomain;
import ru.jooble.DTO.CurrencyDTO;
import ru.jooble.dao.CurrencyDAO;
import ru.jooble.domain.Currency;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;

    @Override
    @Transactional(readOnly = true)
    public CurrencyDTO getById(long id) {
        return new CurrencyDTO(currencyDAO.getById(id));
    }


    @Override
    @Transactional(readOnly = true)
    public List<CurrencyDTO> getAll() {
        List<Currency> currencies = currencyDAO.getAll();
        List<CurrencyDTO> currencyDTOs = new ArrayList<>();
        for (Currency currency : currencies) {
            currencyDTOs.add(new CurrencyDTO(currency));
        }
        return currencyDTOs;
    }

    @Override
    @Transactional
    public void insert(CurrencyDTO currencyDTO) {
        currencyDAO.insert(converterDTOToDomain.convertCurrencyDTOToTheCurrency(currencyDTO));
    }

    @Override
    @Transactional
    public void update(CurrencyDTO currencyDTO) {
        currencyDAO.update(converterDTOToDomain.convertCurrencyDTOToTheCurrency(currencyDTO));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        try {
            currencyDAO.deleteById(id);
        } catch (CanNotDeleteCurrencyException e) {
            throw new CanNotDeleteCurrencyException(String.format("Can`t delete currency. Id - (%)", id), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyDTO> getByCriteria(String criteria) {
        List<Currency> currencies = currencyDAO.getByCriteria(criteria);
        List<CurrencyDTO> currencyDTOs = new ArrayList<>();
        for (Currency currency : currencies) {
            currencyDTOs.add(new CurrencyDTO(currency));
        }
        return currencyDTOs;
    }
}
