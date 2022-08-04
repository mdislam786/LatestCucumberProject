package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage2 {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String columnValue;

	public String getDataFromDb(String columnName) {
		try {
			// set the properties of mySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl = "jdbc:mysql://localhost:3306/december2021";
			String sqlUsername = "root";
			String sqlPassword = "admin";
			String sqlQuery = "Select * from users;";

			// create a connection to the local database
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);

			// Empower the connection reference variable to execute queries
			statement = connection.createStatement();

			// Deliver the query
			resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				return columnValue = resultSet.getString(columnName);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}		
		return columnValue;
	}

}
