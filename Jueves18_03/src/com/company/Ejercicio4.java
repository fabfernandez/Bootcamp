package com.company;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many prime numbers do you want? I'll start from the first in order.");
        int answerCount = scanner.nextInt();

        int answersFound = 0;

        for(int i = 0; answersFound < answerCount;i++){
            if(Ejercicio3.isPrime(i)){
                System.out.println(i);
                answersFound++;
            }
        }

        scanner.close();
    }
}
