package com.cognixia.EMS.java.mySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface MySQLConnections {
	public Connection getConnection();
	public void closeConnection(Connection connection);
	public ResultSet setup(PreparedStatement preparedStatement);
}