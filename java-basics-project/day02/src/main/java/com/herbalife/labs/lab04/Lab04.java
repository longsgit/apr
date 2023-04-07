package com.herbalife.labs.lab04;

public class Lab04 {
    public static void main(String[] args) {
        Person sam = new Person("Sam");

        Country usa = new Country("USA", "DC", 9840087897L);
        City nj = new City("New Jersey", usa);

        Country india = new Country("India", "ND", 767868687600L);
        City pune = new City("Pune", india);

        sam.addVisitedCity(nj);
        sam.addVisitedCity(pune);

        System.out.println(sam);
    }
}
