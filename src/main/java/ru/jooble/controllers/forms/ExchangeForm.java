package ru.jooble.controllers.forms;


import ru.jooble.domain.Exchange;

public class ExchangeForm {
    private String id;
    private String sourceCurrencyId;
    private String targetCurrencyId;
    private String exchangeRate;


    public ExchangeForm() {

    }


    public ExchangeForm(Exchange exchange) {
        this.id = Long.toString(exchange.getId());
        this.sourceCurrencyId = Long.toString(exchange.getSourceCurrencyId());
        this.targetCurrencyId = Long.toString(exchange.getTargetCurrencyId());
        this.exchangeRate = Double.toString(exchange.getExchangeRate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRatee) {
        this.exchangeRate = exchangeRatee;
    }

    public String getSourceCurrencyId() {
        return sourceCurrencyId;
    }

    public void setSourceCurrencyId(String sourceCurrencyId) {
        this.sourceCurrencyId = sourceCurrencyId;
    }

    public String getTargetCurrencyId() {
        return targetCurrencyId;
    }

    public void setTargetCurrencyId(String targetCurrencyId) {
        this.targetCurrencyId = targetCurrencyId;
    }

    @Override
    public String toString() {
        return "ExchangeForm{" +
                "id='" + id + '\'' +
                ", exchangeRoute='" + exchangeRate + '\'' +
                '}';
    }
}