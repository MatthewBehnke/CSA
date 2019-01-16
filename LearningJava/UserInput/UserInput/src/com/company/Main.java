package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        welcome();

        Scanner myScanner = new Scanner(System.in);

        System.out.println("you said: " + getInput(myScanner));

    }

    private static void welcome() {
        System.out.println("Welcome to ...");
    }

    private static String getInput(Scanner scannerInput) {
        return scannerInput.nextLine();
    }

}
