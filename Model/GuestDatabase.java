package Model;

import Controller.Table;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestDatabase extends DatabaseModel {
    /**
     * Prints whatever data it comes up with or prints nothing if nothing is
     * found in the database
     */
    public static JTable search(String toSearch) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select m.title, m.rating, m.genre, m.releasedate, concat(a.fname, ' ', a.lname) as ACTOR_OR_ACTRESS from Movies m natural join Actors a natural join ActsIn where ? in (concat(a.fname, ' ', a.lname), a.fname, a.lname, m.title, m.genre, m.releasedate)");
            pStmt.setString(1, toSearch);
            System.out.println(pStmt);
            ResultSet rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 200);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            close(pStmt);
            close(conn);
        } // end finally try
        return table;
    }
    /**
     * Returns a random movie to the member or guest
     */
    public static JTable randomMovie() {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("select m.title, m.rating, m.genre, m.releasedate from Movies m order by RAND() limit 1");
            ResultSet rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 300);
            while (rs.next()) {
                // Retrieve by column name
                String movieTitle = rs.getString("TITLE");
                System.out.println("Your Randomly Selected Movie is: " + movieTitle);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            close(pStmt);
            close(conn);
        } // end finally try
        return table;
    }

    /**
     * User picks a random genre and this will get one random movie from that
     * genre
     */
    public static JTable randomGenre(String genre) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("select m.title, m.rating, m.genre, m.releasedate from Movies m where m.genre = ? order by RAND() limit 1");
            pStmt.setString(1, genre);
            ResultSet rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 300);

            while (rs.next()) {
                // Retrieve by column name
                String movieTitle = rs.getString("TITLE");
                System.out.println("Your Randomly Selected Movie is: " + movieTitle);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            close(pStmt);
            close(conn);
        } // end finally try
        return table;
    }
}
