package com.company;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me a number, I'll tell you if it's a primer number: ");

        int n = scanner.nextInt();

        boolean result = isPrime(n);

        System.out.println(result ? n + " is prime" : n + " is not prime");

        scanner.close();
    }

    public static boolean isPrime(int n) {
        boolean flag = n != 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
