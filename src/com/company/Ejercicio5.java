package com.company;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers? (N) ");
        int showQuantity = scanner.nextInt();

        System.out.println("How many digits? (M) ");
        int digitQuantity = scanner.nextInt();

        System.out.println("What is the digit? (D) ");
        int digit = scanner.nextInt();

        if (digit > 9 || digit < 0) {
            System.out.println("The digit must be a number between 0 and 9. Please try again: ");
            digit = scanner.nextInt();
        }

        int count = 0;
        for (Integer naturalNumber = 0; count < showQuantity; naturalNumber++) {
            if (countDigits(naturalNumber, digit) == digitQuantity) {
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