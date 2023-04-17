package com.herbalife.springbootbasics;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "book-store")
public class BookStore {
    private String name;
    private int titles;
    private List<String> categories;
    private Map<String, Integer> locations;

    @Override
    public String toString() {
        return "BookStore{" +
                "name='" + name + '\'' +
                ", titles=" + titles +
                ", categories=" + categories +
                ", locations=" + locations +
                '}';
    }

    public Map<String, Integer> getLocations() {
        return locations;
    }

    public void setLocations(Map<String, Integer> locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

}
