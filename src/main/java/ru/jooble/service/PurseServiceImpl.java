package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.DTO.ConverterDTOToDomain;
import ru.jooble.DTO.PurseDTO;
import ru.jooble.dao.PurseDAO;
import ru.jooble.domain.Purse;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurseServiceImpl implements PurseService {

    @Autowired
    private PurseDAO purseDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;


    @Override
    @Transactional(readOnly = true)
    public PurseDTO getById(long id) {
        return new PurseDTO(purseDAO.getById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurseDTO> getAll() {
        List<Purse> purses = purseDAO.getAll();
        List<PurseDTO> purseDTOs = new ArrayList<>();
        for (Purse purse : purses) {
            purseDTOs.add(new PurseDTO(purse));
        }
        return purseDTOs;
    }

    @Override
    @Transactional
    public void insert(PurseDTO purseDTO) {
        purseDAO.insert(converterDTOToDomain.convertPurseDTOToThePurse(purseDTO));
    }

    @Override
    @Transactional
    public void update(PurseDTO purseDTO) {
        purseDAO.update(converterDTOToDomain.convertPurseDTOToThePurse(purseDTO));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        purseDAO.deleteById(id);
    }
}
