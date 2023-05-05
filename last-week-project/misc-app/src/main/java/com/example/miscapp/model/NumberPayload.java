package com.example.miscapp.model;

public class NumberPayload {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "NumberPayload{" +
                "number=" + number +
                '}';
    }
}
