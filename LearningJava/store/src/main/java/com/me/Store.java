package com.me;

import com.me.Database.Database;

import java.util.ArrayList;
import java.util.Scanner;

import static com.me.utils.Utils.fileExist;

public class Store {
    private String dbName;
    private boolean firstStart = false;
    private Database database;
    private boolean isInit;
    private String department = "home";
    private Shopper shopper;
    private ArrayList<Item> avalableItems;


    public Store(String dbName) {
        this.dbName = dbName;

        welcome();
        databaseInit();
        shopperInit();
        isInit = true;
        avalableItems = getAvailableItems();
    }

    public void run(String cliArg) {
        // check if the class was init
        if(!isInit){
            System.out.println("Please restart the program");
            System.exit(1);
        }

        // default department to choose where to go
        if (department.isEmpty() || department.equals("home")) {
            System.out.println("What would you like to do?");
            System.out.println("1: View Cart");
            System.out.println("2: View Available Items");
            System.out.println("3: View Available Balance");
            if(cliArg.contains("1") || cliArg.toLowerCase().contains("cart")) {
                department = "cart";
            } else if (cliArg.contains("2") || cliArg.toLowerCase().contains("items")) {
                department = "items";
            } else if (cliArg.contains("3") || cliArg.toLowerCase().contains("balance")) {
                department = "balance";
            } else {
                department = "home";
            }
            return;
        }

        //Choose what department to go into
        if (department.equals("cart")) {
            inCart(cliArg);
        } else if (department.equals("items")) {
            inItems(cliArg);
        } else if (department.equals("balance")) {
            inBalance();
        } else {
            department = "home";
            return;
        }
        return;
    }

    private void inCart(String cliArg) {
        System.out.println("type 'buy' to buy the items in your cart");
        printAvailableItems(shopper.getCart());
        if (cliArg.toLowerCase().contains("back")) {
            department = "home";
            return;
        }
        if (cliArg.toLowerCase().equals("buy")) {
            if (shopper.calculateCost() > shopper.getBalance()) {
                System.out.println("sorry you do not have enough money");
                department = "home";
                return;
            }
            System.out.println("You spent: " + shopper.calculateCost());
            System.exit(1);
            return;
        }

        department = "cart";
        return;

    }

    private void inItems(String cliArg) {
        printAvailableItems(getAvailableItems());
        System.out.println("Select What item you would like by the index");

        if (!cliArg.isEmpty()) {
            for (int i = 0; i < avalableItems.size(); i++) {
                if(cliArg.toLowerCase().equals(Integer.toString(i)))
                    shopper.buy(avalableItems, avalableItems.get(i));
            }
        }

        if (cliArg.contains("back")) {
            department = "home";
        } else {
            department = "items";
        }
        return;
    }

    private void inBalance() {
        System.out.println("Your Balance is ...");
        System.out.println(shopper.getBalance());
        department = "home";
        return;
    }

    private void printAvailableItems(ArrayList<Item> items){
        for(int i = 0; i < items.size(); i++) {
            System.out.print("Item Number " + i +"\n" +
                    "   ID:" + items.get(i).getId() + "\n" +
                    "   Name:"+ items.get(i).getName() +"\n" +
                    "   Price:"+items.get(i).getPrice()+"\n");
//                        System.out.println("Item Price: "+ availableItems.get(i).getPrice());
//                        System.out.println("Item Description" + availableItems.get(i).getDescription());
        }
    }

    private ArrayList<Item> getAvailableItems() {
        return database.selectAllFromWarehouses(dbName);
    }

    private void welcome() {
        System.out.println("Welcome to the programing store");
    }

    private void shopperInit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name");
        String name = scanner.nextLine().toLowerCase();
        System.out.println("How much do you have to spend");
        double balance = scanner.nextDouble();
        shopper = new Shopper(name,balance);
    }

    private void databaseInit() {
        // instantiating the class
        database = new Database();
        if (!fileExist(dbName)) {
            firstStart = true;
            // creating the database
            Database.createNewDatabase(dbName);
        }
        firstStart = false;

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
            database.warehouseInsert(dbName, "Binary", Math.round(Math.random() * 100.0) / 100.0, "There is 10 types of people in the world", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Assembly Language", Math.round(Math.random() * 100.0) / 100.0, "Why are assembly programmers always soaking wet? They work below C-level", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Fortran", Math.round(Math.random() * 100.0) / 100.0, "dinosaurs", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Comtran", Math.round(Math.random() * 100.0) / 100.0, "wait it was a language", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Lisp", Math.round(Math.random() * 100.0) / 100.0, "How many Lisp programmers does it take to change a lightbulb?", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Cobol", Math.round(Math.random() * 100.0) / 100.0, "only mainframes only", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Basic", Math.round(Math.random() * 100.0) / 100.0, "its in the name", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "C", Math.round(Math.random() * 100.0) / 100.0, "The C language combines all the power of assembly language with all the ease-of-use of assembly language.", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Sql", Math.round(Math.random() * 100.0) / 100.0, "A SQL query goes into a bar, walks up to two tables and asks, \"May I join you?", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "C++", Math.round(Math.random() * 100.0) / 100.0, "I have class", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Matlab", Math.round(Math.random() * 100.0) / 100.0, "A language that costs money", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Objective-C", Math.round(Math.random() * 100.0) / 100.0, "eww mac os ", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "LabVIEW", Math.round(Math.random() * 100.0) / 100.0, "You will need 10 monitors", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Haskell", Math.round(Math.random() * 100.0) / 100.0, ".....is it done yet?", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Python", Math.round(Math.random() * 100.0) / 100.0, "everyone favorite language", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Visual Basic", Math.round(Math.random() * 100.0) / 100.0, "it's visual so it must be better", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Lua", Math.round(Math.random() * 100.0) / 100.0, "its tape", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Java", Math.round(Math.random() * 100.0) / 100.0, "Java: write once, debug everywhere", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "JavaScript", Math.round(Math.random() * 100.0) / 100.0, "The worst language created", (int) Math.floor(Math.random() * 1000));
            database.warehouseInsert(dbName, "Go", Math.round(Math.random() * 100.0) / 100.0, "A programing language made by google in the early 2000s", (int) Math.floor(Math.random() * 1000));
        }
    }
}
