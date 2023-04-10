package com.herbalife.examples;

import java.util.ArrayList;
import java.util.List;

public class GenericsInJava {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        //List<Integer> numbers = new ArrayList();
        //List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(100);
        //numbers.add("string");
        for (int i = 0; i < numbers.size(); i++) {
            int item = numbers.get(i);
            item++;
        }

        List lst = new ArrayList();
        lst.add(10);
        lst.add("string");
        lst.add(true);
        for (int i = 0; i < lst.size(); i++) {
            Object item = lst.get(i);

            //RTTI
            if (item instanceof Integer) { //item is Integer in c#; typeof in javascript
                int value = (int) item;
                System.out.println(value + 1);
            } else if (item instanceof String) {
                //do something
            } else if (item instanceof Boolean) {
                //do something
            }
        }
    }
}
