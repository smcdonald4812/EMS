package com.cognixia.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.cognixia.EMS.java.mySQL.LocalConnectionHandler;
import com.cognixia.EMS.java.mySQL.MySQLObjectsGet;
import com.cognixia.EMS.java.mySQL.Queries;

public abstract class GetInfo extends MySQLObjectsGet {
	protected ResultSet resultSet = null;
	protected ResultSetMetaData resultMetaData = null;
	protected LocalConnectionHandler local = null;
	protected Connection connection = null;
	protected Queries query = null;
	protected PreparedStatement prepStatement = null;

	@Override
	protected void setLocalConnection() {
		this.local = new LocalConnectionHandler();
		this.connection = local.getConnection();
	}
	
	@Override
	protected void closeLocalConnection() {
		this.local.closeConnection(connection);
	}
	
	@Override
	protected ResultSet getResultSet() {
		try {
			this.resultSet = this.prepStatement.executeQuery();
			this.resultMetaData = this.resultSet.getMetaData();
		} catch (SQLException e) {
			System.out.println("getResultSet threw SQLException");
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	protected ResultSetMetaData getMetaData() {
		return this.resultMetaData;
	}

}
