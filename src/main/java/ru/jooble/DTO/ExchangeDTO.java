package ru.jooble.DTO;

import ru.jooble.domain.Exchange;

public class ExchangeDTO {
    private String id;
    private CurrencyDTO sourceCurrency;
    private CurrencyDTO targetCurrency;
    private String exchangeRate;


    public ExchangeDTO() {
    }

    public ExchangeDTO(Exchange exchange) {
        this.id = Long.toString(exchange.getId());
        this.sourceCurrency = new CurrencyDTO(exchange.getSourceCurrency());
        this.targetCurrency = new CurrencyDTO(exchange.getTargetCurrency());
        this.exchangeRate = Double.toString(exchange.getExchangeRate());
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CurrencyDTO getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(CurrencyDTO sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public CurrencyDTO getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(CurrencyDTO targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
