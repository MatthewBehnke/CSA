package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello we will find out your first and last Sic-Fi Name");
        System.out.println(" ");
        System.out.println("What is your first name?");
        String firstName = scanner.nextLine().toLowerCase();
        System.out.println(" ");
        System.out.println("What is your last name");
        String lastName = scanner.nextLine().toLowerCase();
        String sciFiFirstName = firstName.substring(0,3) + lastName.substring(0,2);
        System.out.println("Your Sci-Fi First Name is " + sciFiFirstName);
        System.out.println(" ");
        System.out.println("What City where you born in?");
        String birthPlace = scanner.nextLine().toLowerCase();
        System.out.println(" ");
        System.out.println("What elementary school did you go to");
        String school = scanner.nextLine().toLowerCase();

        String sciFiLastName = birthPlace.substring(0,2) + school.substring(0,3);

        System.out.println("Your Sci-fi Last name is " + sciFiLastName);

        System.out.println("What is the name of a relative");
        String relative = scanner.nextLine();
        int randomPlace = (int)(Math.random() * relative.length()-1 + 1);
        String firstPart =  relative.substring(randomPlace, relative.length());

        System.out.println("What is the name of a diffrent relative");
        String secondRelative = scanner.nextLine();
        int bRandomPlace = (int)(Math.random() * secondRelative.length()-1 + 1);
        String secondPart =  secondRelative.substring(bRandomPlace, secondRelative.length());
        String orgin = firstPart + secondPart;
        System.out.println("Your Sci-Fi place of origin is " + orgin);

        System.out.println("Hello " + firstName + lastName + " Of " + orgin);

    }
}
