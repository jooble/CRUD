package ru.jooble.service;


import ru.jooble.DTO.ExchangeDTO;

import java.util.List;

public interface ExchangeService {

    ExchangeDTO getById(long id);

    void insert(ExchangeDTO exchangeDTO);

    List<ExchangeDTO> getAll();

    void update(ExchangeDTO exchangeDTO);

    void deleteById(long id);

}
