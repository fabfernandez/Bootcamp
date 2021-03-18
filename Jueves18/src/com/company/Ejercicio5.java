package com.company;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many answers do you need? (N)");
        int answerCount = scanner.nextInt();

        System.out.println("What is the digit we are looking for? (D) ");
        int digit = scanner.nextInt();

        if (digit > 9 || digit < 0) {
            System.out.println("The digit must be a number between 0 and 9. Please try again: ");
            digit = scanner.nextInt();
        }

        System.out.println("How many repetitions of that digit? (M) ");
        int digitCount = scanner.nextInt();

        int count = 0;
        for (Integer naturalNumber = 0; count < answerCount; naturalNumber++) {
            if (countDigits(naturalNumber, digit) == digitCount) {
                System.out.println(naturalNumber);
                count++;
            }
        }

        scanner.close();
    }

    public static int countDigits(int input, int digit) {

        int count = 0;

        for (int i = input; i > 0; i = i / 10) {
            if (i % 10 == digit) {
                count++;
            }
        }

        return count;
    }
}