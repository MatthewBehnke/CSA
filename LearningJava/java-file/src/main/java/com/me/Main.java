package com.me;

import java.io.File;
import java.sql.*;

public class Main {
    private static String dbName = "store.db";
    private static Connection databaseConn = null;

    public static void main(String[] args) throws Exception {
        // catch program terminating early and close the database
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Caught shutdown signal");

            if (!closeDatabase(databaseConn)) {
                System.out.println("Database was not closed");
            } else {
                System.out.println("Database closed");
            }
        }));

        if (!fileExist(dbName)) {
            // create a database b/c the database does not exist
            createNewDatabase(dbName);
        }
        databaseConn = connectToDatabase(dbName);

        Statement stmt = databaseConn.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS items (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + ");";

        stmt.execute(sql);

        stmt.executeUpdate("INSERT INTO items VALUES (0, 'tape')");


//        // select from the database
//
//        String query = "SELECT id, name from items";
//        ResultSet rs = null;
//
//        try {
//            rs = st.executeQuery(query);
//            while(rs.next()) {
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                int price = rs.getInt(3);
//                String description = rs.getString(4);
//                System.out.println("id:"+ id+ ", name: "+ name + ", price: " + price + ", description: " + description);
//            }
//
//         st.executeUpdate("DELETE from items");
//        } finally {
//            st.close();
//            closeDatabase(databaseConn);
//        }
    }


    public static boolean fileExist( String fileName){
        File file = new File(fileName);
        return file.exists();

    }


    private static boolean closeDatabase(Connection conn) {
        try {
            conn.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private static Connection connectToDatabase(String filename) {
        String url = "jdbc:sqlite:"+filename;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static void createNewDatabase(String filename) {
        String url = "jdbc:sqlite:"+filename;

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connected to Database");
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new Database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}