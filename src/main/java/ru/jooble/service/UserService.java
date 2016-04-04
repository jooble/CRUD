package ru.jooble.service;

import ru.jooble.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getById(long id);

    void insert(UserDTO userDTO);

    List<UserDTO> getAll();

    void update(UserDTO userDTO);

    void deleteById(long id);
}

