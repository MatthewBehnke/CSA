package com.me.Database;

import com.me.Item;

import java.sql.*;
import java.util.ArrayList;

/*
 *  A class to interact with a database primarily getters and setters
 */
public class Database {

    /*
     * Create a new database
     *
     *  @param fileName
     */
    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new Database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Create a table in a database
     *
     * @param fileName
     * @param sql
     */
    public static void createNewTable(String fileName, String sql) {
        // SQLite connection string
        String url = "jdbc:sqlite:"+ fileName;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Insert a row into the database
     *
     * @param fileName
     * @param name
     * @param price
     * @param description
     * @param quantity
     */
    public void warehouseInsert(String fileName, String name, double price, String description, int quantity) {
        String sql = "INSERT INTO warehouses(name, price, description, quantity) VALUES(?,?,?,?)";

        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, description);
            pstmt.setInt(4,quantity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Gets all rows from warehouses table
     *
     * @param fileName
     */
    public ArrayList<Item> selectAllFromWarehouses(String fileName) {
        String sql = "SELECT name, price, description, quantity FROM warehouses";

        ArrayList<Item> items = new ArrayList<>();

        try (Connection conn = this.connect(fileName);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Item item = new Item();

//                item.setId(rs.get("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setDescription(rs.getString("description"));
                item.setQuantity(rs.getInt("quantity"));
                items.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;

    }

    /*
     * Updates a row in warehouses table
     *
     * @param filename
     * @param id
     * @param name
     * @param price
     * @param description
     * @param quantity
     */
    public void updateWarehouses(String fileName, int id, String name, double price, String description, int quantity) {
        String sql = "UPDATE warehouses SET name = ? , "
                + "price = ?, "
                + "description = ?,"
                + "quantity = ?"
                + "WHERE id = ?";

        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, description);
            pstmt.setInt(4,quantity);
            pstmt.setInt(5, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /*
     * Deletes a row from warehouses table
     *
     * @param fileName
     * @param id
     */

    public void deleteWarehouses(String fileName, int id) {
        String sql = "DELETE FROM warehouses WHERE id = ?";

        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropWarehouses(String fileName) {
        String sql = "DROP TABLE IF EXISTS 'warehouses'";
        try (Connection conn = this.connect(fileName);
              Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect(String fileName) {
        // SQLite connection string
        String url = "jdbc:sqlite:"+fileName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}