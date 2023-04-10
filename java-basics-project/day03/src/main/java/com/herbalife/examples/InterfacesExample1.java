package com.herbalife.examples;

public class InterfacesExample1 {
    public static void main(String[] args) {
        Terrestrial terrestrial = new Frog();
        Aquatic aquatic = new AquaticImpl();

        //Terrestrial t = new Terrestrial();
    }
}

//interface ITerrestrial
interface Terrestrial {
    void walk();
}

//interface IAquatic
interface Aquatic {
    void swim();
}

class Frog implements Terrestrial, Aquatic {
    @Override
    public void walk() {

    }

    @Override
    public void swim() {

    }
}

//class Aquatic : IAquatic {...}
class AquaticImpl implements Aquatic {
    @Override
    public void swim() {

    }
}

class TerrestrialImpl implements Terrestrial {
    @Override
    public void walk() {

    }
}
