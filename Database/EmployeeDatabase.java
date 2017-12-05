package Database;

import Model.Table;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeDatabase extends DatabaseModel {

    /**
     * Adds a movie to the database
     *
     * @param movieID
     *            - given movieID
     * @param title
     *            - given title
     * @param rating
     *            - given rating
     * @param genre
     *            - given genre
     * @param releaseDate
     *            - given releaseDate
     */
    public static void addMovie(String movieID, String title, String rating, String genre, String releaseDate) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();

            pStmt = conn.prepareStatement(
                    "insert into Movies(MOVIE_ID, TITLE, RATING, GENRE, RELEASEDATE) VALUES" + "(?, ?, ?, ? , ?)");
            pStmt.setString(1, movieID);
            pStmt.setString(2, title);
            pStmt.setString(3, rating);
            pStmt.setString(4, genre);
            pStmt.setString(5, releaseDate);
            pStmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate Entry");
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
            System.out.println("Movie Added");
        } // end finally try
    }

    /**
     * Deletes a movie from the database
     *
     * @param movieID
     *            - movie id to be deleted
     */
    public static void deleteMovie(String movieID) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("delete from Movies where MOVIE_ID = ?");
            pStmt.setString(1, movieID);
            pStmt.executeUpdate();
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
            System.out.println("Movie Deleted");
        } // end finally try
    }

    /**
     * Prints out the employees information
     *
     * @param employeeEmail
     *            - employee email address
     */
    public static JTable getEmployeeInformation(String employeeEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        ResultSet rs = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select * from EmployeesGroup where EMPLOYEE_ID in (select EMPLOYEE_ID from EmployeesGroup where EMAIL = ?)");
            pStmt.setString(1, employeeEmail);
            rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 120);
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

    public static JTable getAllMembers() {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        ResultSet rs = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select * from Members");
            rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 120);
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

    public static JTable getAllMovies() {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        ResultSet rs = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select * from Movies");
            rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 120);
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
    public static JTable getAllActors() {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        ResultSet rs = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select * from Actors");
            rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 120);
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
     * Will create a new member and update the database
     *
     * @param memberEmail
     *            - given member email
     * @param password
     *            - given member password
     * @param fname
     *            - given member first name
     * @param lname
     *            - given member last name
     * @param phone
     *            - given member phone
     * @param address
     *            - given member address
     * @param city
     *            - given member city
     * @param state
     *            - given member state
     * @param zip
     *            - given member zipcode
     */
    public static void newUser(String memberEmail, String password, String fname, String lname, String phone,
                               String address, String city, String state, String zip) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();

            pStmt = conn.prepareStatement(
                    "insert into Members(EMAIL, PASSWORD, FNAME, LNAME, PHONE, ADDRESS, CITY, STATE, ZIP) values"
                            + "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pStmt.setString(1, memberEmail);
            pStmt.setString(2, password);
            pStmt.setString(3, fname);
            pStmt.setString(4, lname);
            pStmt.setString(5, phone);
            pStmt.setString(6, address);
            pStmt.setString(7, city);
            pStmt.setString(8, state);
            pStmt.setString(9, zip);
            pStmt.executeUpdate();
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
            System.out.println("Member Added");
        } // end finally try

    }

    /**
     * Will delete a member from the database
     *
     * @param memberID
     *            - member id to be deleted
     */
    public static void deleteMember(int memberID) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            pStmt = conn.prepareStatement("delete from Members where MEMBER_ID = ?");
            pStmt.setInt(1, memberID);
            pStmt.executeUpdate();
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
            System.out.println("Member Deleted");
        } // end finally try

    }
    /**
     * Add an actor to the database
     *
     * @param actorID
     *            - given actor id
     * @param fname
     *            - given actor first name
     * @param lname
     *            - given actor last name
     */
    public static void addActor(String actorID, String fname, String lname) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("insert into Actors(ACTOR_ID, FNAME, LNAME) VALUES" + "(?, ?, ?)");
            pStmt.setString(1, actorID);
            pStmt.setString(2, fname);
            pStmt.setString(3, lname);
            pStmt.executeUpdate();
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
            System.out.println("Employee Added");
        } // end finally try

    }

    /**
     * Deletes an actor
     *
     * @param actorID
     *            - actor id to be deleted
     */
    public static void deleteActor(String actorID) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("delete from Actors where ACTOR_ID = ?");
            pStmt.setString(1, actorID);
            pStmt.executeUpdate();
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
            System.out.println("Movie Deleted");
        } // end finally try
    }
    /**
     * Will update employee email address
     * @param employeeEmail - old employee email
     * @param newEmployeeEmail - new employee email
     */
    public static void updateEmployeeEmail(String email, String newEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            int id = 0;

            pStmt = conn.prepareStatement("select EMPLOYEE_ID from EmployeesGroup where EMAIL = ?");
            pStmt.setString(1, email);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                id = rs2.getInt("EMPLOYEE_ID");
            }
            pStmt = conn.prepareStatement("update Employees set EMAIL = ? where EMPLOYEE_ID = ?");
            pStmt.setString(1, newEmail);
            pStmt.setInt(2, id);
            pStmt.executeUpdate();
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
    }
    /**
     * Will update employee password
     * @param employeeEmail - employee email
     * @param newEmployeePassword - new employee passowrd
     */
    public static void updateEmployeePassword(String email, String password) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            int id = 0;

            pStmt = conn.prepareStatement("select EMPLOYEE_ID from EmployeesGroup where EMAIL = ?");
            pStmt.setString(1, email);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                id = rs2.getInt("EMPLOYEE_ID");
            }
            pStmt = conn.prepareStatement("update EmployeesGroup set PASSWORD = ? where EMPLOYEE_ID = ?");
            pStmt.setString(1, password);
            pStmt.setInt(2, id);
            pStmt.executeUpdate();
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
    }
}
