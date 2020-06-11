package com.cognixia.EMS.java.mySQL;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public abstract class MySQLObjectsGet {
	protected abstract void setLocalConnection();
	protected abstract void closeLocalConnection();
	protected abstract ResultSet getResultSet();
	protected abstract ResultSetMetaData getMetaData();
}
