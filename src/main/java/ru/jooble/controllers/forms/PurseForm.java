package ru.jooble.controllers.forms;


import ru.jooble.domain.Currency;
import ru.jooble.domain.Purse;
import ru.jooble.domain.User;


public class PurseForm {
    private String id;
    private String name;
    private String amount;
    private String currencyId;
    private String ownerId;

    public PurseForm() {

    }

    public PurseForm(Purse purse) {
        this.id = Long.toString(purse.getId());
        this.name = purse.getName();
        this.amount = purse.getAmount().toString();
        this.currencyId = Long.toString(purse.getCurrency().getId());
        this.ownerId = Long.toString(purse.getOwner().getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "PurseForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
