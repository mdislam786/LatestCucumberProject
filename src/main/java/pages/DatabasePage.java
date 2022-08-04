package pages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabasePage {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String columnValue;
	public String getDataFromDb(String columnName) throws SQLException, ClassNotFoundException {	
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
			if (resultSet != null) {
				resultSet.close();
			}
			if (connection != null) {
				connection.close();
			}			
		return columnValue;
	}
}
