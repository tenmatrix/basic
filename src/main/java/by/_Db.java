package by;

import java.net.URL;
import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * This program tests that the database and the JDBC driver are correctly
 * configured.
 * 
 * @version 1.01 2004-09-24
 * @author Cay Horstmann
 */
public class _Db {
	public static void main(String args[]) {
//		try {
//			Connection c1 = getConnection();
//			// Connection c2=getConnection();
//			// System.out.println(c1==c2);
//			// System.out.println(c1.isValid(0));
//			// System.out.println(c2.isValid(0));
//		} catch (SQLException ex) {
//			for (Throwable t : ex)
//				t.printStackTrace();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
		System.out.println(testConnection());
	}

	/**
	 * Runs a test by creating a table, adding a value, showing the table
	 * contents, and removing the table.
	 */
	public static void runTest() throws SQLException, IOException {
		Connection conn = getConnection();
		try {
			Statement stat = conn.createStatement();

			stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
			stat
					.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World!')");

			ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
			if (result.next())
				System.out.println(result.getString(1));
			result.close();
			stat.executeUpdate("DROP TABLE Greetings");
		} finally {
			conn.close();
		}
	}

	/**
	 * Gets a connection from the properties specified in the file
	 * database.properties
	 * 
	 * @return the database connection
	 */
	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();
		// FileInputStream in = new
		// FileInputStream(Thread.currentThread().getContextClassLoader().getResource("database.properties").getPath());
		URL propUrl = null;
		//propUrl = Db.class.getClassLoader().getResource("database.properties");
		propUrl = Thread.currentThread().getContextClassLoader().getResource("database.properties");
		if (propUrl == null) {
			propUrl = Thread.currentThread().getContextClassLoader().getResource(
					"by/database.properties");
		}
		FileInputStream in = new FileInputStream(propUrl.getPath());
		props.load(in);
		in.close();

		String drivers = props.getProperty("jdbc.driver");
		System.out.println("has driver?" + (drivers != null));
		if (drivers != null)
			System.setProperty("jdbc.driver", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		// 每一次调用得到一个新Connection实例
		return DriverManager.getConnection(url, username, password);
	}

	public static boolean testConnection() {
		boolean result=false;
		try {
			result=getConnection().isValid(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
