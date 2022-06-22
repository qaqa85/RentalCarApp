package com.CarRental.Exchanger;

import java.io.IOException;

public interface IExchangeConnector {
    void setRequestCurrency(String currencyCode);

    String getResponse();
}
