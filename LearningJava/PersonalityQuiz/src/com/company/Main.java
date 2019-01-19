package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Quiz wizardQuiz = new Quiz();

        wizardQuiz.askAQuestion("Have you ever wanted to be a wizard", true);
        wizardQuiz.askAQuestion("Do you have a wand", true);

        wizardQuiz.askAQuestion("Do you know what quidditch is", true);
        wizardQuiz.askAQuestion("Do you like foot ball", false);

        wizardQuiz.endOfQuiz("You are a wizard Harry", "But sorry dude you are still a Muggle");

    }
}

class Quiz {

    private Scanner inputScanner;
    private int typeZero;
    private int typeOne;

    public Quiz() {
        inputScanner = new Scanner(System.in);
    }

    public void askAQuestion(String question, boolean isZeroCorrect) {
        System.out.println(question);
        String userResponse = ReadAndSanitise(inputScanner);

        if (isYes(userResponse)) {
            addCount(isZeroCorrect, true);
        } else if (isNo(userResponse)) {
            addCount(isZeroCorrect, false);
        } else {
            System.out.println("Sorry I do not understand");
            askAQuestion(question, isZeroCorrect);
        }
    }

    public void endOfQuiz(String zeroMessage, String oneMessage){
        System.out.println("Congrats you made it to the end of the quiz");
        if (isTypeZero()) {
            System.out.println(zeroMessage);
        } else {
            System.out.println(oneMessage);
        }
    }

    private void addCount(boolean isZeroCorrect, boolean response) {
        if (isZeroCorrect && response) {
            typeZero = typeZero + 1;
        } else if (isZeroCorrect) {
            typeOne = typeOne + 1;
        } else if (response) {
            typeZero =  typeZero + 1;
        } else {
            typeOne = typeOne + 1;
        }
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

    private boolean isTypeZero() {
        if (typeZero >= typeOne) {
            return true;
        }
        return false;
    }

    private String ReadAndSanitise(Scanner scanner) {
        return scanner.nextLine().toLowerCase();
    }

}