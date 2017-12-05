package Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.mysql.jdbc.Statement;

public class DatabaseModel {

	public static java.sql.Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		final String DB_URL = "jdbc:mysql://localhost:3306/MoviesDatabase?useOldAliasMetadataBehavior=true&autoReconnect=true&useSSL=false";
		final String USER = "";
		final String PASS = "";

		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	/**
	 * Need to close connection after use so call this method when needed
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
}
