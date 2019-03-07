package com.me;

import java.util.Scanner;

public class StoreRunner {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Caught shutdown signal")));

        Store store = new Store("store.db");
        Scanner scanner = new Scanner(System.in);
        String statement = scanner.nextLine();

        while (!statement.toLowerCase().contains("exit")) {
            store.run(statement);
            statement = scanner.nextLine();
        }
    }
}
