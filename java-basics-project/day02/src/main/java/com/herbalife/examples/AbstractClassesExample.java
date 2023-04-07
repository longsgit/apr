package com.herbalife.examples;

//Name of the file and the name of the public class in the file should be same
public class AbstractClassesExample {
    public static void main(String[] args) {
        //Animal animal = new Animal();
        Animal snoopy = new Dog();
    }
}

abstract class Animal {
    public void move() {

    }

    public void eat() {

    }

    abstract void makeNoise();
}

class Dog extends Animal {

    public void makeNoise() {
        System.out.println("bow bow");
    }
}

//Package friendly
class Cat {
    String name;
    void sleep() {

    }
}