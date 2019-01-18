package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Create a new Scanner
        Scanner userInputScanner = new Scanner(System.in);

        Quiz myQuiz = new Quiz(userInputScanner);

        myQuiz.firstQuestion();
        myQuiz.secondQuestion();
        myQuiz.thirdQuestion();
        myQuiz.fourthQuestion();
        myQuiz.endOfQuiz();

    }
}

class Quiz {

    private Scanner inputScanner;
    private int wizard;
    private int muggle;

    public Quiz(Scanner InputScanner) {
        inputScanner = InputScanner;
    }

    private boolean isYes(String input) {
        String[] yesArray = {"yes", "ok", "okey-dokey", "by all means",
                             "affirmative", "aye aye", "roger", "10-4",
                             "un-hun", "righto", "very well", "yep",
                             "yeppers", "right on", "ja", "surely",
                             "amen", "fo' shizze", "totally", "sure",
                             "yes sir", "okay", "right", "absolutely",
                             "si", "oui"};

        return Arrays.stream(yesArray).anyMatch(input.toLowerCase()::equals);
    }

    private boolean isNo(String input) {
        String[] noArray = {"no", "uh-uh", "nix", "nixie",
                "nixy", "nixey", "nope", "nay",
                "no way", "no way, José", "negative", "veto",
                "out of the question", "no sir", "for foul nor fair", "not on your life",
                "not on your nelly", "not on ypur tinytype", "not for all the tea in China", "not in a million years",
                "under no circumstances", "not likely", "not for joe", "thumbs down",
                "not a cat in hell chance", "fat chance", "catch me!", "no fear", "go fish"};

        return Arrays.stream(noArray).anyMatch(input.toLowerCase()::equals);
    }

    private boolean isWizard() {
        if (wizard >= muggle) {
            return true;
        }
        return false;
    }

    private String ReadAndSanitise(Scanner scanner) {
        return scanner.nextLine().toLowerCase();
    }

    private String askQuestion(String question, boolean isTrue) {
        System.out.println(question);
        String userResponse = ReadAndSanitise(inputScanner);

        if (isTrue && isYes())

    }


    public void firstQuestion() {
        System.out.println("Next Question...");
        System.out.println("Have you ever wanted to be a wizard");
        String userResponse = ReadAndSanitise(inputScanner);
        if (isYes(userResponse)) { wizard++; }
        else { muggle++; }
    }

    public void secondQuestion() {
        System.out.println("Next Question...");
        System.out.println("Do you have a wand");
        String userResponse = ReadAndSanitise(inputScanner);
        if (isYes(userResponse)) { wizard++; }
        else { muggle++; }
    }

    public void thirdQuestion() {
        System.out.println("Next Question...");
        System.out.println("Do you know what quidditch is");
        String userResponse = ReadAndSanitise(inputScanner);
        if (isYes(userResponse)) { wizard++; }
        else { muggle++; }
    }

    public void fourthQuestion() {
        System.out.println("Next Question...");
        System.out.println("Do you like foot ball");
        String userResponse = ReadAndSanitise(inputScanner);
        if (isYes(userResponse)) { muggle++; }
        else { wizard++; }
    }

    public void endOfQuiz(){
        System.out.println("Congrats you made it to the end of the quiz");
        if (isWizard()) {
            System.out.println("You are a wizard Harry");
        } else {
            System.out.println("But sorry dude you are still a Muggle");
        }
    }
}