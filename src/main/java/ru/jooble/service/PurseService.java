package ru.jooble.service;

import ru.jooble.DTO.PurseDTO;

import java.util.List;

public interface PurseService {

    PurseDTO getById(long id);

    void insert(PurseDTO purseDTO);

    List<PurseDTO> getAll();

    void update(PurseDTO purseDTO);

    void deleteById(long id);
}




