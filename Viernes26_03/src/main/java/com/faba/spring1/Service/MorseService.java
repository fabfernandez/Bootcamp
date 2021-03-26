package com.faba.spring1.Service;

public class MorseService {
    // Morse code by indexing
    private static String[] code
            = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};

    private static String[] splitIntoWords(String morseMessage) {
        return morseMessage.split("   ");
    }

    public static String translate(String morseMessage) {
        String result = "";
        String[] wordsMorse = splitIntoWords(morseMessage);
        for (String word : wordsMorse) {
            result += translateWordMorse(word) + " ";
        }
        return result.substring(0, result.length() - 1);
    }

    private static String translateWordMorse(String morseCode) {
        String result = "";
        String[] array = morseCode.split(" ");

        System.out.print("Morse code " + morseCode
                + " to English is ");
        // Morse code to English
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (array[i].compareTo(code[j]) == 0) {
                    result += (char) (j + 'a');
                    break;
                }
            }
        }
        return result;

    }
}
