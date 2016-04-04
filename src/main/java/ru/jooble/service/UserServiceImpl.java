package ru.jooble.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.DTO.ConverterDTOToDomain;
import ru.jooble.DTO.UserDTO;
import ru.jooble.dao.UserDAO;
import ru.jooble.domain.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;


    @Override
    @Transactional(readOnly = true)
    public UserDTO getById(long id) {
        return new UserDTO(userDAO.getById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAll() {
        List<User> users = userDAO.getAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(new UserDTO(user));
        }
        return userDTOs;
    }

    @Override
    @Transactional
    public void insert(UserDTO userDTO) {
        userDAO.insert(converterDTOToDomain.convertUserDTOToTheUser(userDTO));
    }

    @Override
    @Transactional
    public void update(UserDTO userDTO) {
        userDAO.update(converterDTOToDomain.convertUserDTOToTheUser(userDTO));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

}


