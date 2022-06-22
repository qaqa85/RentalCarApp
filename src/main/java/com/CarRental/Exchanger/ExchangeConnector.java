package com.CarRental.Exchanger;

import com.CarRental.Exceptions.ApiStatusCodeException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class ExchangeConnector implements IExchangeConnector {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private HttpRequest request;

    @Override
    public void setRequestCurrency(String currencyCode) {
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://open.er-api.com/v6/latest/" + currencyCode.toUpperCase()))
                .build();
    }

    @Override
    public String getResponse() {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200)
                throw new ApiStatusCodeException();

            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
