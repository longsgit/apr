package com.herbalife.examples;

import java.util.*;

public class CollectionsInJava {
    public static void main(String[] args) {
        //All the collection classes are present in java.util package
        //Similar to System.Collection namespace
        //List(Allows duplications; preserves order)
        //Set(Does not allow duplications; does not preserve order)
        //Map(Key, Value) dictionary collection

        Map romanNumbers = new TreeMap();
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        romanNumbers.put(true, 1);
        romanNumbers.put(false, 0);

        Map<Integer, String> romanNumerals = new HashMap<>();
        romanNumerals.put(1, "I");
        romanNumerals.put(2, "II");
        romanNumerals.put(3, "III");
        System.out.println(romanNumerals.get(1));
        System.out.println(romanNumerals.get(2));
        Set<Integer> keys = romanNumerals.keySet();
        for (int key : keys) {
            System.out.println(romanNumerals.get(key));
        }


        Set set = new HashSet();
        set.add(10);
        set.add(100);
        set.add(10);
        for (Object item : set) {
            System.out.println(item);
        }
        System.out.println();
        Set<Integer> numbersSet = new TreeSet<>();
        numbersSet.add(1000);
        numbersSet.add(3000);


        List lst = new ArrayList();
        lst.add(10);
        lst.add("Some string");
        lst.add(true);
        for (Object item : lst) {
            System.out.println(item);
        }

        List lst2 = new LinkedList();
        lst2.add(100);
        lst2.add(true);
        lst2.add(3.14);
        for (Object item : lst2) {
            System.out.println(item);
        }

        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("JS");
        languages.add("Golang");
        for (String item : languages) {
            System.out.println(item);
        }
        for (int i = 0; i < languages.size(); i++) {
            System.out.println(languages.get(i));
        }
    }
}
