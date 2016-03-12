package ru.jooble.domain;


public class Purse {
    private long id;
    private String name;
    private int currencyId;
    private String currencyShortName;
    private int ownerId;
    private int amount;

    public Purse(long id, String name, int currencyId, int ownerId, int amount) {
        this.id = id;
        this.name = name;
        this.currencyId = currencyId;
        this.ownerId = ownerId;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyShortName() {
        return currencyShortName;
    }

    public void setCurrencyShortName(String currencyShortName) {
        this.currencyShortName = currencyShortName;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Purse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currencyId=" + currencyId +
                ", currencyShortName='" + currencyShortName + '\'' +
                ", ownerId=" + ownerId +
                ", amount=" + amount +
                '}';
    }
}
