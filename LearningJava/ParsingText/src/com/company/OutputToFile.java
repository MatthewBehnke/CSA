package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class OutputToFile {

    private static Scanner in;
    private static BufferedWriter out;
    private static final String file = "mymedia.csv";

    public static void writeString(String s) {
        if (out == null) {
            try {
                out = new BufferedWriter(new FileWriter(file));
            }
            catch (Exception e) {
                System.err.println("Cannot create file for output!");
                e.printStackTrace();
            }
        }

        try {
            out.write(s);
            // out.newLine();
            out.write(",");
        }
        catch (Exception e) {
            System.err.println("Cannot write file!");
            e.printStackTrace();
        }

    }

    public static void saveAndClose() {
        if (in != null) {
            try {
                in.close();
                in = null;
            }
            catch (Exception e) {
                System.err.println("Cannot close input file!");
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
                out = null;
            }
            catch (Exception e) {
                System.err.println("Cannot close output file!");
                e.printStackTrace();
            }
        }
    }
}
