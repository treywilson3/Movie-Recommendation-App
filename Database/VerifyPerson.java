package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyPerson extends DatabaseModel {

    /**
     * Will verify a member
     *
     * @param memberEmail
     *            - possible member email
     * @param memberPassword
     *            - possible member password
     * @return if member or not (boolean)
     */
    public static boolean verifyMember(String memberEmail, String memberPassword) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        String password;
        boolean member = false;
        try {
            conn = createConnection();

            pStmt = conn.prepareStatement("select PASSWORD from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                // Retrieve by column name
                password = rs.getString("PASSWORD");
                if (password.equals(memberPassword)) {
                    member = true;
                }
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
        return member;
    }


    /**
     * Will verify an employee
     *
     * @param employeeEmail
     *            - possible employee email
     * @param employeePassword
     *            - possible employee password
     * @return boolean - if employee or not
     */
    public static boolean verifyEmloyee(String employeeEmail, String employeePassword) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        String password;
        boolean employee = false;
        try {
            conn = createConnection();

            pStmt = conn.prepareStatement("select PASSWORD from EmployeesGroup where EMAIL = ?");
            pStmt.setString(1, employeeEmail);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                // Retrieve by column name
                password = rs.getString("PASSWORD");
                if (password.equals(employeePassword)) {
                    employee = true;
                }
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
        return employee;
    }

    /**
     * Will verify if employee is CEo
     *
     * @param ceoEmail
     *            - email of potential ceo
     * @param ceoPassword
     *            - password of potention ceo
     * @return if CEO or not
     */
    public static boolean verifyCEO(String ceoEmail, String ceoPassword) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        String position;
        boolean ceo = false;
        try {
            conn = createConnection();

            pStmt = conn.prepareStatement("select POSITION from EmployeesGroup where EMAIL = ? and PASSWORD = ?");
            pStmt.setString(1, ceoEmail);
            pStmt.setString(2, ceoPassword);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                // Retrieve by column name
                position = rs.getString("POSITION");
                // System.out.println("POSITION : " + position);
                if (position.equals("CEO")) {
                    ceo = true;
                }
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
        return ceo;
    }
}
