package Database;

import Model.Table;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CEODatabase extends EmployeeDatabase {


    /**
     * Adds a new employee to the database
     *
     * @param email
     *            - given employee email
     * @param password
     *            - given employee password
     * @param hireDate
     *            - given hire date of employee
     * @param fname
     *            - given employee first name
     * @param lname
     *            - given employee last name
     * @param jobLocation
     *            - given employee job location
     * @param position
     *            - given employee position
     * @param salary
     *            - given employee salary
     */
    public static void addEmployee(String email, String password, String hireDate, String fname, String lname,
                                   String jobLocation, String position, BigDecimal salary) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();

            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(hireDate);
            // because PreparedStatement#setDate(..) expects a java.sql.Date
            // argument
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pStmt = conn.prepareStatement(
                    "insert into EmployeesGroup(EMAIL, PASSWORD, HIRE_DATE, FNAME, LNAME, JOB_LOCATION, POSITION, SALARY) VALUES"
                            + "(?, ?, ?, ?, ? , ?, ?, ?)");
            pStmt.setString(1, email);
            pStmt.setString(2, password);
            pStmt.setDate(3, sqlDate);
            pStmt.setString(4, fname);
            pStmt.setString(5, lname);
            pStmt.setString(6, jobLocation);
            pStmt.setString(7, position);
            pStmt.setBigDecimal(8, salary);
            pStmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
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
     * Deletes given emloye
     *
     * @param employeeID
     *            - employee id to be deleted
     */
    public static void deleteEmployee(int employeeID) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("delete from EmployeesGroup where EMPLOYEE_ID = ?");
            pStmt.setInt(1, employeeID);
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
            System.out.println("Employee Deleted");
        } // end finally try
    }
    public static JTable getAllEmployees() {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        ResultSet rs = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select * from EmployeesGroup");
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
}
