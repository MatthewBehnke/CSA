package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        File f = new File("output.txt");
        FileWriter fr;
        fr = new FileWriter(f);
        String message = "";
        while(!message.toLowerCase().contains("bye")) {
            System.out.println("he");
        }
        fr.write("Line one\n");
        fr.close();
    }
}
