package com.herbalife.thursday;

public class Lab02 {

    public static final int NUM_10001 = 10001;

    public static void main(String[] args) {
        calculateSumOfOddNumbersBetween1To10001();

        int[] exclusionList = {10, 19, 21, 39, 309, 431, 643, 942, 1209, 7981, 8888, 9910};
        calculateIntegerAverageOfNumbersBetween1To10001(exclusionList);

        computeTotal();
    }

    private static void computeTotal() {
        String input = "+5 -1 +9 +5 -67 +5 -3 +2 -4 +6 +8 -13 +2 -4 +6 +18 -3 +2 -4 +6 +88 +15 -1 +9 +5 -67 +45 -3 +2 -4 +36 +8 -13 +2 -4 +6 +18 -3 +2 -74 +11 +109";
        int total = 0;
        for (String item : input.split(" ")) {
            int num = Integer.parseInt(item);
            total += num;
        }
        System.out.println(String.format("Total: %s", total));

    }

    private static void calculateIntegerAverageOfNumbersBetween1To10001(int[] exclusionList) {
        int sum = 0;
        for (int i = 1; i < NUM_10001; i++) {
            sum += i;
        }
        for (int i = 0; i < exclusionList.length; i++) {
            sum -= exclusionList[i];
        }
        int average = sum / (10000 - exclusionList.length);
        System.out.println(String.format("Average: %s", average));
    }

    private static void calculateSumOfOddNumbersBetween1To10001() {
        int sum = 0;
        for (int i = 1; i < NUM_10001; i++) {
            sum += i % 2 == 1 ? i : 0;
        }
        System.out.println(String.format("Sum: %s", sum));
    }

}
