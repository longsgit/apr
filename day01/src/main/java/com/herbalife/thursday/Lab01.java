package com.herbalife.thursday;

import java.util.Scanner;

public class Lab01 {
    private static final String AIM_HIGHER = "Aim higher";
    private static final String AIM_LOWER = "Aim lower";
    private static final String YOU_HAVE_GOT_IT = "You've got it!!!";

    public static void main(String[] args) {
        int target = (int) (Math.random() * 100);
        System.out.println("Welcome to the Guessing Game. Enter a number between 1 and 100");
        play(target);
    }

    private static void play(int target) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        String message = null;
        int guess;
        boolean gameOver = false;
        while (!gameOver) {
            attempts++;
            guess = scanner.nextInt();
            if (guess == target) {
                message = YOU_HAVE_GOT_IT;
                gameOver = true;
            } else {
                message = guess > target ? AIM_LOWER : AIM_HIGHER;
            }
            System.out.println(message);
        }
        System.out.println(String.format("Attempts: %s", attempts));
    }
}
