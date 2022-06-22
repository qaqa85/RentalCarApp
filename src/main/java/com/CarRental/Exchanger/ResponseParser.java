package com.CarRental.Exchanger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class ResponseParser {
    IExchangeConnector exchangeConnector;

    ResponseParser(IExchangeConnector exchangeConnector) {
        this.exchangeConnector = exchangeConnector;
    }

    /**
     * Fetches exchanged ratio between two currencies
     * @param fetchCurrency Currency ISO code that will be fetched from response
     * @return ratio between two currencies as String
     */
    String getSingleCurrency(String fetchCurrency) {
        String response = exchangeConnector.getResponse();
        if (response == null)
            return null;

        JsonElement jsonElement = JsonParser.parseString(response);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        if(jsonObject.get("result").getAsString().equals("error"))
            return null;

        jsonObject = jsonObject.get("rates").getAsJsonObject();

        return jsonObject.get(fetchCurrency).getAsString();
    }
}
