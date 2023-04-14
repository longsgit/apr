package com.herbalife.labs.lab12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab11 {
    private static List<String> linesInCitiesCsvFile = null;
    private static Map<String, List<City>> countryCitiesMap = new HashMap<>();
    private static BiFunction<Integer, String, String> csvProcessFunction = (index, line) -> line.split(",")[index];

    public static void main(String[] args) throws Exception {
        linesInCitiesCsvFile = Files.readAllLines(Paths.get("./cities.csv"));
//        store(line -> csvProcessFunction.apply(0, line), "./cities.txt");
//        store(line -> csvProcessFunction.apply(1, line), "./countries.txt");
        printCountOfCitiesGroupedByCountry();
//        printNamesOfAllCities();
//        generatePlacesJson();
        generatePlacesJsonUsingJackson();
    }

    private static void generatePlacesJsonUsingJackson() throws JsonProcessingException {
        Set<City> cities = countryCitiesMap
                .values() //List<List<City>>
                .stream()
                .flatMap(Collection::stream)//List<City>
                .collect(Collectors.toSet());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cities);
        System.out.println();
        System.out.println(json);
    }

    private static String getCityInJsonFormat2(String lineInCsv) {
        return """
                {
                    "city": "%s",
                    "country": "%s",
                    "population": %d
                }
                """.formatted(csvProcessFunction.apply(0, lineInCsv), csvProcessFunction.apply(1, lineInCsv), csvProcessFunction.apply(2, lineInCsv)).stripLeading().stripTrailing();
    }

    private static String getCityInJsonFormat(String lineInCsv) {
        StringBuilder jsonBuilder = new StringBuilder("");
        jsonBuilder.append("{");
        jsonBuilder.append("\"city\"");
        jsonBuilder.append(":");
        jsonBuilder.append("\"");
        jsonBuilder.append(csvProcessFunction.apply(0, lineInCsv));
        jsonBuilder.append("\"");
        jsonBuilder.append(", ");
        jsonBuilder.append("\"country\"");
        jsonBuilder.append(":");
        jsonBuilder.append("\"");
        jsonBuilder.append(csvProcessFunction.apply(0, lineInCsv));
        jsonBuilder.append("\"");
        jsonBuilder.append(", ");
        jsonBuilder.append("\"population\"");
        jsonBuilder.append(":");
        jsonBuilder.append(csvProcessFunction.apply(0, lineInCsv));
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    private static void generatePlacesJson() throws IOException {
        String jsonFormattedPlaces = linesInCitiesCsvFile
                .stream()
                .skip(1)
                .map(Lab11::getCityInJsonFormat)
                .collect(Collectors.joining(",", "[", "]"));
        Files.write(Paths.get("./places.json"), jsonFormattedPlaces.getBytes());
    }

    private static String fetchCountryFromCsv(String line) {
        return csvProcessFunction.apply(1, line);
    }

    private static City createCityFromCsv(String line) {
        return new City(csvProcessFunction.apply(0, line), csvProcessFunction.apply(1, line), Long.parseLong(csvProcessFunction.apply(2, line)));
    }

    private static void printCountOfCitiesGroupedByCountry() {
        countryCitiesMap = linesInCitiesCsvFile
                .stream()
                .skip(1)
                .collect(Collectors.groupingBy(Lab11::fetchCountryFromCsv,
                        Collectors.mapping(Lab11::createCityFromCsv, Collectors.toList())));

        countryCitiesMap
                .forEach((country, cities) -> System.out.println(country + ": " + cities.size()));
    }

    private static void printNamesOfAllCities() {
        countryCitiesMap
                .values() //List<List<City>>
                .stream()
                .flatMap(Collection::stream)//List<City>
                .forEach(System.out::println);

//        countryCitiesMap
//                .values()
//                .forEach(cities -> cities.forEach(System.out::println));
    }

    private static void store(Function<String, String> processFunction, String fileName) throws IOException {
        Set<String> citySet = linesInCitiesCsvFile
                .stream()
                .skip(1)
                .map(processFunction)
                //.distinct()
                .collect(Collectors.toSet());
        Files.write(Paths.get(fileName), citySet);
    }
}
