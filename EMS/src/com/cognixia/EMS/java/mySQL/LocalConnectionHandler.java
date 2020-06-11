package com.cognixia.EMS.java.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalConnectionHandler implements MySQLConnections{
	String databaseURL = new String("jdbc:mysql://localhost:3306"), 
			userName = new String("root"), 
			password = new String("root");
	Connection connection;
	
	@Override
	public Connection getConnection() {
		try {
			this.connection = DriverManager.getConnection(
					this.databaseURL, this.userName, this.password);
		} catch (SQLException e) {
			System.out.println("not connecting in getConnection method of ConnectionHandler");
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void closeConnection(Connection connection) {
		try {
			this.connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(!this.connection.isClosed()) {
				try {
					this.connection.close();
					System.out.println("trying to close connection");
				} catch(SQLException e) {
					System.out.println("Error while Connection was closing" + e);
				}
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		
	}

	@Override
	public ResultSet setup(PreparedStatement preparedStatement) {
		ResultSet resultSet = null;
		try {
			this.connection = DriverManager.getConnection(
					this.databaseURL, this.userName, this.password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet == null) {
				resultSet = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}
