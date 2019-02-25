package com.me;

import javax.swing.*;

import java.awt.*;

import static com.me.Utils.fileExist;

public class Main extends JFrame {

    private static String dbName = "store.db";


    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Caught shutdown signal")));

        EventQueue.invokeLater(() -> {
            Display ex = new Display();
            ex.setVisible(true);
        });

        // instantiating the class
//        Database storeDatabase = new Database();
//
//        if (!fileExist(dbName)) {
//            // creating the database
//            Database.createNewDatabase(dbName);
//
//            // Create Table warehouse
//            String warehousesSql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
//                + "	id integer PRIMARY KEY,\n"
//                + "	name text NOT NULL,\n"
//                + "price double NOT NULL, \n"
//                + "	description text NOT NULL,\n"
//                + "quantity int NOT NULL \n"
//                + ");";
//
//            Database.createNewTable(dbName, warehousesSql);
//        }
//
//        // insert data into database table
//        storeDatabase.warehouseInsert(dbName, "tape",10.5,"its tape", 100);
//
//        // read all from database table
//        for (int i = 0; i < storeDatabase.selectAllFromWarehouses(dbName).size(); i++)
//            System.out.println(storeDatabase.selectAllFromWarehouses(dbName).get(i).getName());
//
//        // update a database element
//        storeDatabase.updateWarehouses(dbName, 10, "leg", 13,"its a leg", 500);
//
//        // remove a database element
//        storeDatabase.deleteWarehouses(dbName, 13);

    }

}
