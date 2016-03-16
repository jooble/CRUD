package ru.jooble.controllers.forms;


import ru.jooble.domain.Purse;


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
        this.currencyId = Long.toString(purse.getCurrencyId());
        this.ownerId = Long.toString(purse.getOwnerId());
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
