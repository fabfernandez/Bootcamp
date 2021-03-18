package com.company;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many answers do you want? ");
        int answerCount = scanner.nextInt();

        System.out.println("Tell me the magic number, please. ");
        int magicNumber = scanner.nextInt();

        printTheFirstMultiplesOf(magicNumber, answerCount);

        scanner.close();
    }

    public static void printTheFirstMultiplesOf(int number, int answerCount) {
        int answersFound = 0;

        for (int integer = 0; answersFound < answerCount; integer++) {
            if (integer % number == 0) {
                System.out.println(integer);
                answersFound++;
            }
        }
    }
}
