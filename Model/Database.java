package Model;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Statement;

/**
 * @author Trey class Database has all static methods that can be called All of
 *         the functions will staticly call Database's methods. Result set is
 *         used in any method that returns data. Result set is just the data
 *         that the queries get returned to them. So you can print that data
 *         onto the console using the result set. Prepared Statements and
 *         Statements are also used in nearly every method, which communicates
 *         with the database.
 */
public class Database {
	/**
	 * Create a connection to mysql database
	 * 
	 * @return connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static java.sql.Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		final String DB_URL = "jdbc:mysql://localhost:3306/MoviesDatabase?useOldAliasMetadataBehavior=true&autoReconnect=true&useSSL=false";
		final String USER = "";
		final String PASS = "";

		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	/**
	 * Need to close connection after use so call this method when needed
	 * 
	 * @param conn
	 *            - connection to database
	 */
	public static void close(java.sql.Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Need to close statements after use so call this method
	 * 
	 * @param st
	 *            - query statement
	 */
	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Need to close prepared statements after use so call this method
	 * 
	 * @param pst
	 *            - the prepared statement
	 */
	public static void close(PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To print information, you need the result set. That result set needs to
	 * be closed after use so call this method
	 * 
	 * @param rs
	 *            - the result set
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * When using transactions, you need to rollback if the transaction was not
	 * successful. Call this class if needed
	 * 
	 * @param conn
	 *            - the connection to the database
	 */
	public static void rollback(java.sql.Connection conn) {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints all member information when called
	 * 
	 * @param memberEmail
	 *            - the members email address
	 */
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

	/**
	 * Prints whatever data it comes up with or prints nothing if nothing is
	 * found in the database
	 * 
	 * @param searchData
	 *            - whatever the member wants to search in Movies
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
	 * Prints the members to watch list
	 * 
	 * @param memberEmail
	 *            - the members email address
	 */
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

	/**
	 * Prints the members watch history list
	 * 
	 * @param memberEmail
	 *            - the members email address
	 */
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

	/**
	 * Prints out recommendations for member
	 * @param memberEmail - given member email
	 */
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

	/**
	 * Prints the users favorite movies list
	 * 
	 * @param memberEmail
	 *            - the members email address
	 */
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

	/**
	 * Updates the members phone number
	 * 
	 * @param memberEmail
	 *            - the members email address
	 * @param phoneNumber
	 *            - the new phone number the member wants
	 */
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

	/**
	 * Updates the members address. If any part fails, then all info is rolled
	 * back. Transaction
	 * 
	 * @param memberEmail
	 *            - the members email address
	 * @param address
	 *            - new address
	 * @param city
	 *            - new city
	 * @param state
	 *            - new state
	 * @param zip
	 *            - new zipcode
	 */
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
	 * Will verify if employee is CEo
	 * 
	 * @param ceoEmail
	 *            - email of potential ceo
	 * @param ceoPassword
	 *            - password of potention ceo
	 * @return if CEO or not
	 */
	public static boolean ceo(String ceoEmail, String ceoPassword) {
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

	/**
	 * Adds a movie to the member's to watch list
	 * 
	 * @param memberEmail
	 *            - the members email address
	 * @param movieToWatch
	 *            - the members chosen movie to add
	 */
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

	/**
	 * Adds a movie to the members favorite movie list
	 * 
	 * @param memberEmail
	 *            - the members email address
	 * @param movieFav
	 *            - members chosen favorite movie
	 */
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

	/**
	 * Adds to members watch history list
	 * 
	 * @param memberEmail
	 *            - the members email address
	 * @param watched
	 *            - members watched movie to be added
	 * @param dayWatched
	 *            - what day the member said they watched it
	 */
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
	 * Will verify a member
	 * 
	 * @param memberEmail
	 *            - possible member email
	 * @param memberPassword
	 *            - possible member password
	 * @return if member or not (boolean)
	 */
	public static boolean verifiedMember(String memberEmail, String memberPassword) {
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
	 * Will verify an employee
	 * 
	 * @param employeeEmail
	 *            - possible employee email
	 * @param employeePassword
	 *            - possible employee password
	 * @return boolean - if employee or not
	 */
	public static boolean verifiedEmployee(String employeeEmail, String employeePassword) {
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
	 * User picks a random genre and this will get one random movie from that
	 * genre
	 * 
	 * @param genre
	 *            user chosen genre
	 * @return
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

	/**
	 * Will update member email
	 * @param memberEmail - old member email
	 * @param newMemberEmail - new member email
	 */
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
	/**
	 * Will update member password
	 * @param memberEmail - member email
	 * @param newMemberPassword - new password
	 */
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
