package com.me;

import com.me.Database.Database;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.me.utils.Utils.fileExist;

public class Main extends JFrame {

    private static String dbName = "store.db";
    private static boolean firstStart = false;


    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Caught shutdown signal")));

//        EventQueue.invokeLater(() -> {
//            Display ex = new Display();
//            ex.setVisible(true);
//        });

        // instantiating the class
        Database storeDatabase = new Database();

        if (!fileExist(dbName)) {
            firstStart = true;
            // creating the database
            Database.createNewDatabase(dbName);
        }

        // Create Table warehouse
        String warehousesSql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "price double NOT NULL, \n"
                + "	description text NOT NULL,\n"
                + "quantity int NOT NULL \n"
                + ");";

        Database.createNewTable(dbName, warehousesSql);

        if(firstStart) {

            // insert data into database table
            storeDatabase.warehouseInsert(dbName, "Binary", Math.round(Math.random() * 100.0) / 100.0, "There is 10 types of people in the world", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Assembly Language", Math.round(Math.random() * 100.0) / 100.0, "Why are assembly programmers always soaking wet? They work below C-level", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Fortran", Math.round(Math.random() * 100.0) / 100.0, "dinosaurs", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Comtran", Math.round(Math.random() * 100.0) / 100.0, "wait it was a language", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Lisp", Math.round(Math.random() * 100.0) / 100.0, "How many Lisp programmers does it take to change a lightbulb?", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Cobol", Math.round(Math.random() * 100.0) / 100.0, "only mainframes only", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Basic", Math.round(Math.random() * 100.0) / 100.0, "its in the name", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "C", Math.round(Math.random() * 100.0) / 100.0, "The C language combines all the power of assembly language with all the ease-of-use of assembly language.", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Sql", Math.round(Math.random() * 100.0) / 100.0, "A SQL query goes into a bar, walks up to two tables and asks, \"May I join you?", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "C++", Math.round(Math.random() * 100.0) / 100.0, "I have class", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Matlab", Math.round(Math.random() * 100.0) / 100.0, "A language that costs money", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Objective-C", Math.round(Math.random() * 100.0) / 100.0, "eww mac os ", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "LabVIEW", Math.round(Math.random() * 100.0) / 100.0, "You will need 10 monitors", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Haskell", Math.round(Math.random() * 100.0) / 100.0, ".....is it done yet?", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Python", Math.round(Math.random() * 100.0) / 100.0, "everyone favorite language", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Visual Basic", Math.round(Math.random() * 100.0) / 100.0, "it's visual so it must be better", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Lua", Math.round(Math.random() * 100.0) / 100.0, "its tape", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Java", Math.round(Math.random() * 100.0) / 100.0, "Java: write once, debug everywhere", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "JavaScript", Math.round(Math.random() * 100.0) / 100.0, "The worst language created", (int) Math.floor(Math.random() * 1000));
            storeDatabase.warehouseInsert(dbName, "Go", Math.round(Math.random() * 100.0) / 100.0, "A programing language made by google in the early 2000s", (int) Math.floor(Math.random() * 1000));
        }

        ArrayList<Item> availableItems = new ArrayList<>();
        for (int i = 0; i < storeDatabase.selectAllFromWarehouses(dbName).size(); i++) {
            Item item = new Item();
            item.setName(storeDatabase.selectAllFromWarehouses(dbName).get(i).getName());
            item.setPrice(storeDatabase.selectAllFromWarehouses(dbName).get(i).getPrice());
            item.setDescription(storeDatabase.selectAllFromWarehouses(dbName).get(i).getDescription());
            item.setQuantity(storeDatabase.selectAllFromWarehouses(dbName).get(i).getQuantity());
            availableItems.add(item);
        }

        Scanner scanner = new Scanner(System.in);
        Shopper shopper = new Shopper(getName(), 100);
//        System.out.println("Welcome " + shopper.getName());

//        do {
//            System.out.print("Available Choices\n 0: Check Balance\n 1: View Available Items\n 2: View Cart\n");
//            String choice = scanner.nextLine();
//            choice = choice.toLowerCase();
//            if (choice.contains("0") || choice.contains("balance")) {
//                System.out.println("Here is your balance\n" + shopper.getBalance());
//            } else if(choice.contains("1") || choice.contains("items") || choice.contains("available")) {
//                System.out.println("View items");
//                String chooseItems = scanner.nextLine().toLowerCase();
//                do{
//                    printAvailableItems(availableItems);
//                } while(scanner.hasNext()  && !chooseItems.contains("back"));
//
//            } else if(choice.contains("2") || choice.contains("cart")) {
//                System.out.println("View Cart");
//            }
//        } while(true);
//
    }

    public static String getName(Scanner scanner) {
        System.out.printf("Hello\nWhat is your name?\n\n");
        scanner.nextLine().toLowerCase();
        return name;
    }

    public static void printAvailableItems(ArrayList<Item> items){
        for(int i = 0; i < items.size(); i++) {
            System.out.print("Item\n" +
                    "   Name:"+ items.get(i).getName() +"\n" +
                    "   Price:"+items.get(i).getPrice()+"\n");
//                        System.out.println("Item Price: "+ availableItems.get(i).getPrice());
//                        System.out.println("Item Description" + availableItems.get(i).getDescription());
        }
    }

    public static void reset() {
        Database database = new Database();
        database.dropWarehouses(dbName);
        System.exit(0);
    }

}
