package ru.jooble.DTO;

import ru.jooble.domain.Currency;


public class CurrencyDTO {
    private String id;
    private String name;

    public CurrencyDTO() {

    }

    public CurrencyDTO(Currency currency) {
        this.id = Long.toString(currency.getId());
        this.name = currency.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
