package com.herbalife.examples;

public class ClassFilesExample {
    public static void main(String[] args) {
        Worker coderSam = new Coder();
        coderSam.doSomething();

        Worker ram = new Coder();
        ram.doSomething();

        //Anonymous inner class
        Worker playerJoe = new Worker() {
            public void doSomething() {
                System.out.println("Playing cricket");
            }
        };
        playerJoe.doSomething();

        Worker salesAnnie = new Worker() {
            public void doSomething() {
                System.out.println("Selling mutual funds");
            }
        };
        salesAnnie.doSomething();

        Worker marketeer = new Worker() {
            @Override
            public void doSomething() {
                System.out.println("Running ads");
            }
        };

    }
}

interface Worker {
    void doSomething();
}
class Coder implements Worker {
    @Override
    public void doSomething() {
        System.out.println("Writing code");
    }
}

class Parent {
    class Child {
        class GrandChild {}
    }
}
class TV {
    class Remote {}
}
