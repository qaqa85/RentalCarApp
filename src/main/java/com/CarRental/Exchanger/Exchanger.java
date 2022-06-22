package com.CarRental.Exchanger;

import java.util.Currency;

public class Exchanger {
    private final IExchangeConnector exchangeConnector = new ExchangeConnector();

    public Exchanger() {
    }

    /**
     * Exchanges currency from PLN to target currency
     * @param toCurrency currency code (ISO 4217) passed as String
     * @return value of ration between two currencies
     */
    public String exchangeCurrencies(String toCurrency) {
        String FROM_CURRENCY = "PLN";
        exchangeConnector.setRequestCurrency(FROM_CURRENCY);
        ResponseParser responseParser = new ResponseParser(exchangeConnector);
        return responseParser.getSingleCurrency(toCurrency);
    }
}
