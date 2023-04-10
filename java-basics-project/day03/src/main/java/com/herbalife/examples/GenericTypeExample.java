package com.herbalife.examples;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeExample {
    public static void main(String[] args) {
        MyCollection<String> books = new MyCollection<>();
        books.add("Grit");
        books.add("RoR 6");
        MyCollection<Integer> numbers = new MyCollection<>();
        numbers.add(10);
        numbers.add(20);

//        DvdCollection<Integer> dvdCollection = new DvdCollection<>();
//        dvdCollection.add(1);
//        dvdCollection.add(2);
//
//        DvdCollection<String> dvdCollection2 = new DvdCollection<>();
//        dvdCollection2.add("A");
//        dvdCollection2.add("B");

        DvdCollection<Movie> movies = new DvdCollection<>();
        DvdCollection<Soccer> soccerDvdCollection = new DvdCollection<>();

        DvdCollection dvdCollection1 = new DvdCollection();
        dvdCollection1.add(new Movie());
        dvdCollection1.add(new Soccer());
    }
}

class EntertainmentEntity {
}

class Movie extends EntertainmentEntity {
}

class Soccer extends EntertainmentEntity {
}

class DvdCollection<T extends EntertainmentEntity> {
    private List<T> dvdList = new ArrayList<>();

    public void add(T item) {
        dvdList.add(item);
    }

    public void remove(T item) {
        dvdList.remove(item);
    }
}

class MyCollection<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }
}
