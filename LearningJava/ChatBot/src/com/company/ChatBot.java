package com.company;
import java.util.Scanner;

public class ChatBot
{

    public static void main(String[] args) {
        Chatter chat = new Chatter();

        Scanner inputScanner = new Scanner(System.in);

        System.out.println(chat.beginningMessage());

        String message = "";
        while (!message.toLowerCase().contains("bye")) {
            message = inputScanner.nextLine();
            chat.responder(message);
        }
        System.out.println(chat.endingMessage());
    }
}
class Chatter {

    boolean isMad = false;

    String beginningMessage() {
        return "Hello, you may ask me anything but I most likely will not understand";
    }

    String endingMessage() {
        return "Thanks, it was nice talking to you";
    }

    void responder(String inputMessage) {
        if (isUpperCase(inputMessage)) {
            System.out.println("Why are you so mad but we will go with it");
            isMad = true;
        }
        isMad = false;

        if (inputMessage.toLowerCase().contains("sports")) {
            System.out.println("So you want to talk about sports");

        }

    }

    boolean isUpperCase(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            if (!Character.isUpperCase(s.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

}
