package Database;

import Model.Table;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MemberDatabase extends DatabaseModel {

    public static JTable getMemberInformation(String memberEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        ResultSet rs = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("select * from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 150);
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

    public static JTable toWatch(String memberEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select  m.title, m.rating, m.genre, m.releasedate from Movies m natural join ToWatch where MEMBER_ID in (select MEMBER_ID from Members where EMAIL = ?)");
            pStmt.setString(1, memberEmail);
            ResultSet rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 300);
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

    public static JTable watchHistory(String memberEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select m.title, m.rating, m.genre, m.releasedate from Movies m natural join WatchHistory where MEMBER_ID in (select MEMBER_ID from Members where EMAIL = ?)");
            pStmt.setString(1, memberEmail);
            ResultSet rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 300);
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

    public static JTable recommendations(String memberEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select m.title, m.rating, m.genre, m.releasedate from Movies m natural join Recommendations where MEMBER_ID in (select MEMBER_ID from Members where EMAIL = ?)");
            pStmt.setString(1, memberEmail);
            ResultSet rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 300);
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

    public static JTable favoriteMovies(String memberEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        JTable table = null;
        try {
            conn = createConnection();
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement(
                    "select m.title, m.rating, m.genre, m.releasedate from Movies m natural join FavoriteMovies where MEMBER_ID in (select MEMBER_ID from Members where EMAIL = ?)");
            pStmt.setString(1, memberEmail);
            ResultSet rs = pStmt.executeQuery();
            table = new JTable(Table.buildTableModel(rs));
            Table.columnSize(table, 300);
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

    public static void updateMemberPhone(String memberEmail, String phoneNumber) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            int memberID = 0;

            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                memberID = rs2.getInt("MEMBER_ID");
            }
            pStmt = conn.prepareStatement("update Members set PHONE = ? where MEMBER_ID = ?");
            pStmt.setString(1, phoneNumber);
            pStmt.setInt(2, memberID);
            pStmt.executeUpdate();
            getMemberInformation(memberEmail);
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

    public static void updateMemberAddress(String memberEmail, String address, String cityFinal, String stateFinal,
                                           String zipFinal) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            conn.setAutoCommit(false);
            int memberID = 0;

            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                memberID = rs2.getInt("MEMBER_ID");
            }
            pStmt = conn.prepareStatement("update Members set ADDRESS = ? where MEMBER_ID = ?");
            pStmt.setString(1, address);
            pStmt.setInt(2, memberID);
            pStmt.executeUpdate();
            pStmt = conn.prepareStatement("update Members set CITY = ? where MEMBER_ID = ?");
            pStmt.setString(1, cityFinal);
            pStmt.setInt(2, memberID);
            pStmt.executeUpdate();
            pStmt = conn.prepareStatement("update Members set STATE = ? where MEMBER_ID = ?");
            pStmt.setString(1, stateFinal);
            pStmt.setInt(2, memberID);
            pStmt.executeUpdate();
            pStmt = conn.prepareStatement("update Members set ZIP = ? where MEMBER_ID = ?");
            pStmt.setString(1, zipFinal);
            pStmt.setInt(2, memberID);
            pStmt.executeUpdate();
            conn.commit();
            System.out.println("Here is your new information: ");
            getMemberInformation(memberEmail);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            rollback(conn);
            System.out.println("There was an issue updating your address.");
            System.out.println("Please try again.");
        } finally {
            // finally block used to close resources
            close(pStmt);
            close(conn);
        } // end finally try

    }

    public static void addToWatch(String memberEmail, String movieToWatch) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        java.sql.PreparedStatement pStmt2 = null;
        String id = null;
        try {
            conn = createConnection();
            pStmt = conn.prepareStatement("select MOVIE_ID from Movies where TITLE = ?");
            pStmt.setString(1, movieToWatch);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                id = rs.getString("MOVIE_ID");
            }
            int memberID = 0;
            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                memberID = rs2.getInt("MEMBER_ID");
            }
            pStmt = conn.prepareStatement("insert into ToWatch(MOVIE_ID, MEMBER_ID) VALUES" + "(?, ?)");
            pStmt.setString(1, id);
            pStmt.setInt(2, memberID);
            pStmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            close(pStmt2);
            close(pStmt);
            close(conn);
            System.out.println("To Watch Movie Added");
        } // end finally try

    }

    public static void addFavoriteMovie(String memberEmail, String movieFav) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        java.sql.PreparedStatement pStmt2 = null;
        String id = null;
        try {
            String recommendation = null;
            conn = createConnection();
            pStmt = conn.prepareStatement("select MOVIE_ID from Movies where TITLE = ?");
            pStmt.setString(1, movieFav);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                id = rs.getString("MOVIE_ID");
            }
            int memberID = 0;
            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                memberID = rs2.getInt("MEMBER_ID");
            }
            pStmt = conn.prepareStatement("insert into FavoriteMovies(MOVIE_ID, MEMBER_ID) VALUES" + "(?, ?)");
            pStmt.setString(1, id);
            pStmt.setInt(2, memberID);
            pStmt.executeUpdate();
            pStmt = conn.prepareStatement(
                    "select MOVIE_ID from (select Movies.MOVIE_ID from Movies natural join Actors as a natural join ActsIn where concat(a.fname, ' ', a.lname)  = (select concat(a.fname, ' ', a.lname) from Movies natural join FavoriteMovies natural join Actors as a natural join ActsIn where MEMBER_ID = ? and Movies.MOVIE_ID = ? limit 1) order by rand() limit 1)a");
            pStmt.setInt(1, memberID);
            pStmt.setString(2, id);
            ResultSet rs3 = pStmt.executeQuery();
            while (rs3.next()) {
                recommendation = rs3.getString("MOVIE_ID");
            }
            if (!(recommendation.equals(id))) {
                pStmt = conn.prepareStatement("insert into Recommendations(MOVIE_ID, MEMBER_ID) VALUES" + "(?, ?)");
                pStmt.setString(1, recommendation);
                pStmt.setInt(2, memberID);
                pStmt.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            close(pStmt2);
            close(pStmt);
            close(conn);
            System.out.println("Favorite Movie Added");
        } // end finally try
    }

    public static void addWatchHistory(String memberEmail, String watched, String dayWatched) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        java.sql.PreparedStatement pStmt2 = null;
        String id = null;
        String recommendation = null;
        try {
            conn = createConnection();
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dayWatched);
            // because PreparedStatement#setDate(..) expects a java.sql.Date
            // argument
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pStmt = conn.prepareStatement("select MOVIE_ID from Movies where TITLE = ?");
            pStmt.setString(1, watched);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                id = rs.getString("MOVIE_ID");
            }
            int memberID = 0;
            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                memberID = rs2.getInt("MEMBER_ID");
            }
            pStmt2 = conn.prepareStatement("insert into WatchHistory(MOVIE_ID, MEMBER_ID, DATE) VALUES" + "(?, ?, ?)");
            pStmt2.setString(1, id);
            pStmt2.setInt(2, memberID);
            pStmt2.setDate(3, sqlDate);
            pStmt2.executeUpdate();
            pStmt = conn.prepareStatement(
                    "select MOVIE_ID from (select Movies.MOVIE_ID from Movies natural join Actors as a natural join ActsIn where concat(a.fname, ' ', a.lname)  = (select concat(a.fname, ' ', a.lname) from Movies natural join WatchHistory natural join Actors as a natural join ActsIn where MEMBER_ID = ? and Movies.MOVIE_ID = ? limit 1) order by rand() limit 1)a");
            pStmt.setInt(1, memberID);
            pStmt.setString(2, id);
            ResultSet rs3 = pStmt.executeQuery();
            while (rs3.next()) {
                recommendation = rs3.getString("MOVIE_ID");
            }
            if (!(recommendation.equals(id))) {
                pStmt = conn.prepareStatement("insert into Recommendations(MOVIE_ID, MEMBER_ID) VALUES" + "(?, ?)");
                pStmt.setString(1, recommendation);
                pStmt.setInt(2, memberID);
                pStmt.executeUpdate();
            }
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
            close(pStmt2);
            close(pStmt);
            close(conn);
            System.out.println("Favorite Movie Added");
        } // end finally try
    }

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
    public static void updateMemberEmail(String memberEmail, String newEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            int memberID = 0;

            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                memberID = rs2.getInt("MEMBER_ID");
            }
            pStmt = conn.prepareStatement("update Members set EMAIL = ? where MEMBER_ID = ?");
            pStmt.setString(1, newEmail);
            pStmt.setInt(2, memberID);
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
    public static void updateMemberPassword(String email, String password) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            int memberID = 0;

            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, email);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {
                memberID = rs2.getInt("MEMBER_ID");
            }
            pStmt = conn.prepareStatement("update Members set PASSWORD = ? where MEMBER_ID = ?");
            pStmt.setString(1, password);
            pStmt.setInt(2, memberID);
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

    public static void deleteAccount(String memberEmail) {
        java.sql.Connection conn = null;
        java.sql.PreparedStatement pStmt = null;
        try {
            conn = createConnection();
            int id = 0;
            System.out.println("Creating statement...");
            pStmt = conn.prepareStatement("select MEMBER_ID from Members where EMAIL = ?");
            pStmt.setString(1, memberEmail);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("MEMBER_ID");
            }
            pStmt = conn.prepareStatement("delete from Members where MEMBER_ID = ?");
            pStmt.setInt(1, id);
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
}
