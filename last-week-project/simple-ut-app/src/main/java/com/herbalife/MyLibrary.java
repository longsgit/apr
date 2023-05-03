package com.herbalife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyLibrary {
    private List<Integer> numbers;

    public MyLibrary() {
        numbers = new ArrayList<>();
    }

    public int getSize() {
        return numbers.size();
    }

    public void add(int num) {
        if(numbers.contains(num)) {
            throw new RuntimeException(num + " is already found");
        }
        numbers.add(num);
    }

    public void remove(int num) {
        isNumberPresent(num);
        numbers = numbers
                .stream()
                .filter(e -> e != num)
                .collect(Collectors.toList());
    }

    private void isNumberPresent(int num) {
        if(!numbers.contains(num)) {
            throw new RuntimeException(num + " is not found");
        }
    }

    private int dummy;

    private void increment() {
        dummy++;
    }
}
