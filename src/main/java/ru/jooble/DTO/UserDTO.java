package ru.jooble.DTO;

import ru.jooble.domain.User;

import java.util.List;

public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private List<PurseDTO> purseDTOs;

    public UserDTO() {

    }

    public UserDTO(User user) {
        this.id = Long.toString(user.getId());
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PurseDTO> getPurseDTOs() {
        return purseDTOs;
    }

    public void setPurseDTOs(List<PurseDTO> purseDTOs) {
        this.purseDTOs = purseDTOs;
    }
}
