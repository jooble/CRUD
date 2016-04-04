package ru.jooble.controllers.forms;


import ru.jooble.DTO.CurrencyDTO;

public class CurrencyForm {
    private String id;
    private String shortName;

    public CurrencyForm() {

    }

    public CurrencyForm(CurrencyDTO currencyDTO) {
        this.id = currencyDTO.getId();
        this.shortName = currencyDTO.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "CurrencyForm{" +
                "id='" + id + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
