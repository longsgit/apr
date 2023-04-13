package com.herbalife.examples;

public class JsonExample {
    public static void main(String[] args) {
        City houston = new City("Houston", "USA", 979072l);
        City chennai = new City("Chennai", "India", 9790792l);
        City kl = new City("KL", "Malaysia", 1979072l);
        System.out.println(getJson(houston));
        System.out.println(getJson(chennai));
        System.out.println(getJson(kl));
    }

    static String getJson(City city) {
        return """
                {
                    "city": "%s",
                    "country": "%s",
                    "population": %d
                }
                """.formatted(city.getName(), city.getCountry(), city.getPopulation()).stripLeading().stripTrailing();
    }
}


class City {
    private String name;
    private String country;
    private long population;

    public City(String name, String country, long population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
