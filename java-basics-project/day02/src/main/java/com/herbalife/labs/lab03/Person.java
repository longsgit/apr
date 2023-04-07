package com.herbalife.labs.lab03;

import java.util.Arrays;

public class Person {
    private String name;
    private Person friend;
    private City[] citiesVisited;

    public Person(String name) {
        this.name = name;
    }

    public void addVisitedCity(City newCity) {
        if (citiesVisited == null) {
            citiesVisited = new City[]{newCity};
        } else {
            City[] newCitiesArr = new City[citiesVisited.length + 1];

            for (int i = 0; i < citiesVisited.length; i++) {
                newCitiesArr[i] = citiesVisited[i];
            }
            //length is 2; [0] & [1]
            //[2] error
            newCitiesArr[citiesVisited.length] = newCity;
            this.citiesVisited = newCitiesArr;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", citiesVisited=" + Arrays.toString(citiesVisited) +
                '}';
    }
}
