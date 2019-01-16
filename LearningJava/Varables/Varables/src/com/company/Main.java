package com.company;

public class Main {

    public static void main(String[] args) {
        int a = 555555;
        double b = 6.666666;

	    System.out.println(justAMethod(b));
	    System.out.println(wow(a));
    }

    public static double justAMethod(double anInput) {
        return anInput * anInput;
    }

    public static int wow(int wowAnInput) {
        return wowAnInput + 5;
    }



}
