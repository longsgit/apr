package com.herbalife.labs.lab05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab05 {
    private static List<String> linesInCitiesCsvFile = null;
    private static Map<String, List<City>> countryCitiesMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        linesInCitiesCsvFile = Files.readAllLines(Paths.get("./cities.csv"));
        populateCountryCitiesMap();
        //printAllTheCitiesGroupedByCountries();
        printCityNameWithLargestAndSmallestPopulation();
        printPopulationOf("China");
    }

    private static void printPopulationOf(String country) {
        long total = countryCitiesMap
                .get(country)
                .stream()
                .mapToLong(e -> e.getPopulation())
                .sum();
        System.out.println(String.format("Population of %s is %s", country, total));
    }

    private static void printPopulationOfOldStyle(String country) {
        List<City> cities = countryCitiesMap.get(country);
        long total = 0l;
        for (City city : cities) {
            total += city.getPopulation();
        }
        System.out.println(String.format("Population of %s is %s", country, total));
    }

    private static void printCityNameWithLargestAndSmallestPopulation() {
        List<City> allCities = new ArrayList<>();
        for (String country : countryCitiesMap.keySet()) {
            allCities.addAll(countryCitiesMap.get(country));
        }
        City smallestCity = allCities.get(0);
        City largestCity = allCities.get(0);

        for (int i = 0; i < allCities.size(); i++) {
            City currentCity = allCities.get(i);
            if (currentCity.getPopulation() > largestCity.getPopulation()) {
                largestCity = currentCity;
            }
            if (currentCity.getPopulation() < smallestCity.getPopulation()) {
                smallestCity = currentCity;
            }
        }
        System.out.println("Smallest city: " + smallestCity);
        System.out.println("Largest city: " + largestCity);
    }

    private static void populateCountryCitiesMap() {
        for (int i = 1; i < linesInCitiesCsvFile.size(); i++) {
            String line = linesInCitiesCsvFile.get(i);
            String[] items = line.split(",");
            String country = items[1];
            City city = new City(items[0], country, Long.parseLong(items[2]));
            if (countryCitiesMap.containsKey(country)) {
                List<City> cities = countryCitiesMap.get(country);
                cities.add(city);
            } else {
                List<City> cities = new ArrayList<>();
                cities.add(city);
                countryCitiesMap.put(country, cities);
            }
        }
    }

    private static void printAllTheCitiesGroupedByCountries() {
        countryCitiesMap.forEach((country, cities) -> {
            System.out.println(country);
            cities.forEach(city -> System.out.println(city));
        });
        //System.out.println(countryCitiesMap);
    }
}
