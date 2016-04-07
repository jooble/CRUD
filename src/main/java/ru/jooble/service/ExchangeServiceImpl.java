package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.DTO.ConverterDTOToDomain;
import ru.jooble.DTO.ExchangeDTO;
import ru.jooble.dao.ExchangeDAO;
import ru.jooble.domain.Exchange;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeDAO exchangeDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;

    @Override
    @Transactional(readOnly = true)
    public ExchangeDTO getById(long id) {
        return new ExchangeDTO(exchangeDAO.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExchangeDTO> getAll() {
        List<Exchange> exchanges = exchangeDAO.findAll();
        List<ExchangeDTO> exchangeDTOs = new ArrayList<>();
        for (Exchange exchange : exchanges) {
            exchangeDTOs.add(new ExchangeDTO(exchange));
        }
        return exchangeDTOs;
    }

    @Override
    @Transactional
    public void insert(ExchangeDTO exchangeDTO) {
        exchangeDAO.saveAndFlush(converterDTOToDomain.convertExchangeDTOToTheExchange(exchangeDTO));
    }

    @Override
    @Transactional
    public void update(ExchangeDTO exchangeDTO) {
        exchangeDAO.saveAndFlush(converterDTOToDomain.convertExchangeDTOToTheExchange(exchangeDTO));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Exchange exchange = exchangeDAO.findOne(id);
        exchangeDAO.delete(exchange);
    }
}
