package ru.jooble.controllers.forms;


import ru.jooble.DTO.ExchangeDTO;

public class ExchangeForm {
    private String id;
    private String sourceCurrencyId;
    private String targetCurrencyId;
    private String exchangeRate;


    public ExchangeForm() {

    }

    public ExchangeForm(ExchangeDTO exchangeDTO) {
        this.id = exchangeDTO.getId();
        this.sourceCurrencyId = exchangeDTO.getSourceCurrency().getId();
        this.targetCurrencyId = exchangeDTO.getTargetCurrency().getId();
        this.exchangeRate = exchangeDTO.getExchangeRate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetCurrencyId() {
        return targetCurrencyId;
    }

    public void setTargetCurrencyId(String targetCurrencyId) {
        this.targetCurrencyId = targetCurrencyId;
    }

    public String getSourceCurrencyId() {
        return sourceCurrencyId;
    }

    public void setSourceCurrencyId(String sourceCurrencyId) {
        this.sourceCurrencyId = sourceCurrencyId;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "ExchangeForm{" +
                "id='" + id + '\'' +
                ", sourceCurrencyId='" + sourceCurrencyId + '\'' +
                ", targetCurrencyId='" + targetCurrencyId + '\'' +
                ", exchangeRate='" + exchangeRate + '\'' +
                '}';
    }
}