package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoopingMediaLib {

    public static void main(String[] args) throws IOException {
        File f = new File("mymedia.csv");
        Scanner scan = new Scanner(f);
        while (scan.hasNext()) {
            System.out.println(scan.nextLine());
        }
    }
}
