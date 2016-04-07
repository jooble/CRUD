package ru.jooble.DTO;

import ru.jooble.domain.Purse;

public class PurseDTO {
    private String id;
    private String name;
    private CurrencyDTO currencyDTO;
    private UserDTO ownerDTO;
    private String amount;

    public PurseDTO() {

    }

    public PurseDTO(Purse purse) {
        this.id = Long.toString(purse.getId());
        this.name = purse.getName();
        this.currencyDTO = new CurrencyDTO(purse.getCurrency());
        this.ownerDTO = new UserDTO(purse.getOwner());
        this.amount = purse.getAmount().toString();
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

    public CurrencyDTO getCurrencyDTO() {
        return currencyDTO;
    }

    public void setCurrencyDTO(CurrencyDTO currencyDTO) {
        this.currencyDTO = currencyDTO;
    }

    public UserDTO getOwnerDTO() {
        return ownerDTO;
    }

    public void setOwnerDTO(UserDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
