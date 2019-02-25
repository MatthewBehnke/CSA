package com.me;

import com.me.Database.Database;
import com.me.Displays.Display;

import javax.swing.*;

import java.awt.*;

import static com.me.utils.Utils.fileExist;

public class Main extends JFrame {

    private static String dbName = "store.db";


    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Caught shutdown signal")));

        EventQueue.invokeLater(() -> {
            Display ex = new Display();
            ex.setVisible(true);
        });

        // instantiating the class
        Database storeDatabase = new Database();

        if (!fileExist(dbName)) {
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

//        if(!fileExist(dbName)) {

        // insert data into database table
            storeDatabase.warehouseInsert(dbName, "Binary",Math.round(Math.random() * 100.0)/100.0,"There is 10 types of people in the world", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Assembly Language",Math.round(Math.random() * 100.0)/100.0,"Why are assembly programmers always soaking wet? They work below C-level", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Fortran",Math.round(Math.random() * 100.0)/100.0,"dinosaurs", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Comtran",Math.round(Math.random() * 100.0)/100.0,"wait it was a language", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Lisp",Math.round(Math.random() * 100.0)/100.0,"How many Lisp programmers does it take to change a lightbulb?", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Cobol",Math.round(Math.random() * 100.0)/100.0,"only mainframes only", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Basic",Math.round(Math.random() * 100.0)/100.0,"its in the name", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "C",Math.round(Math.random() * 100.0)/100.0,"The C language combines all the power of assembly language with all the ease-of-use of assembly language.", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Sql",Math.round(Math.random() * 100.0)/100.0,"A SQL query goes into a bar, walks up to two tables and asks, \"May I join you?", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "C++",Math.round(Math.random() * 100.0)/100.0,"I have class", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Matlab",Math.round(Math.random() * 100.0)/100.0,"A language that costs money", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Objective-C",Math.round(Math.random() * 100.0)/100.0,"eww mac os ", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "LabVIEW",Math.round(Math.random() * 100.0)/100.0,"You will need 10 monitors", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Haskell",Math.round(Math.random() * 100.0)/100.0,".....is it done yet?", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Python",Math.round(Math.random() * 100.0)/100.0,"everyone favorite language", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Visual Basic",Math.round(Math.random() * 100.0)/100.0,"it's visual so it must be better", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Lua",Math.round(Math.random() * 100.0)/100.0,"its tape", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Java",Math.round(Math.random() * 100.0)/100.0,"Java: write once, debug everywhere", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "JavaScript",Math.round(Math.random() * 100.0)/100.0,"The worst language created", (int)Math.floor(Math.random()* 1000));
            storeDatabase.warehouseInsert(dbName, "Go",Math.round(Math.random() * 100.0)/100.0,"A programing language made by google in the early 2000s", (int)Math.floor(Math.random()* 1000));
//        }

        // read all from database table
        for (int i = 0; i < storeDatabase.selectAllFromWarehouses(dbName).size(); i++)
            System.out.println(storeDatabase.selectAllFromWarehouses(dbName).get(i).getName());

//        // update a database element
//        storeDatabase.updateWarehouses(dbName, 10, "leg", 13,"its a leg", 500);
//
//        // remove a database element
//        storeDatabase.deleteWarehouses(dbName, 13);

    }

    public static void reset() {
        Database database = new Database();
        database.dropWarehouses(dbName);
        System.exit(0);
    }

}
