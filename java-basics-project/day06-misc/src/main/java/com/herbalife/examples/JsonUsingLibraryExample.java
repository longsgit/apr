package com.herbalife.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JsonUsingLibraryExample {
    public static void main(String[] args) throws JsonProcessingException {
        City houston = new City("Houston", "USA", 979072l);

        //Using Gson
        Gson gson = new Gson();
        String json = gson.toJson(houston);
        System.out.println(json);

        //Using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String cityJson = objectMapper.writeValueAsString(houston);
        System.out.println(cityJson);

        String jsonValue = """
                {"name":"Houston","country":"USA","population":979072}
                """;
        City city = gson.fromJson(jsonValue, City.class);
        System.out.println("%s, %s, %s".formatted(city.getName(), city.getCountry(), city.getPopulation()));

        City cityObj = objectMapper.readValue(jsonValue, City.class);
        System.out.println("%s, %s, %s".formatted(cityObj.getName(), cityObj.getCountry(), cityObj.getPopulation()));
    }
}
