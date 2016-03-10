package ru.jooble.domain;


public class Purse {
    private long id;
    private String name;
    private int idcurrency;
    private String currencyShortName;
    private int amount;


    public Purse(long id, String name, int idcurrency, int amount) {
        this.id = id;
        this.name = name;
        this.idcurrency = idcurrency;
        this.amount = amount;

    }

    public Purse(long id, int amount, String name, int idcurrency, String currencyShortName) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.idcurrency = idcurrency;
        this.currencyShortName = currencyShortName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdcurrency() {
        return idcurrency;
    }

    public void setIdcurrency(int idcurrency) {
        this.idcurrency = idcurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyShortName() {
        return currencyShortName;
    }

    public void setCurrencyShortName(String currencyShortName) {
        this.currencyShortName = currencyShortName;
    }

    @Override
    public String toString() {
        return "Purse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idcurrency=" + idcurrency +
                ", currencyShortName='" + currencyShortName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
