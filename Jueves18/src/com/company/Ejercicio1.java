package com.company;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pair numbers do you want? ");

        int answerCount = scanner.nextInt();

        Ejercicio2.printTheFirstMultiplesOf(2, answerCount);

        scanner.close();
    }
}
