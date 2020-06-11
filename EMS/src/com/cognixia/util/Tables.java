package com.cognixia.util;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


public class Tables extends GetInfo {
	private DefaultTableModel getModel() {
		setLocalConnection();
		if(this.connection == null) return null;
		if(this.resultSet == null) return null;
		Vector<String> columnNames = new Vector<>();
		Vector<Vector<Object>> data = new Vector<>();
		int columnCount;
		try {
			columnCount = resultMetaData.getColumnCount();
			// put column names in columns
			for (int column = 1; column <= columnCount; column++) {
				columnNames.add(resultMetaData.getColumnName(column));
			}
			// get all the data for the columns
			while (this.resultSet.next()) {
				Vector<Object> vector = new Vector<>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
					vector.add(this.resultSet.getObject(columnIndex));
				}
				data.add(vector);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception when making the table");
			e.printStackTrace();
		}
		this.local.closeConnection(this.connection);
		return new DefaultTableModel(data, columnNames);
	}
	
	public DefaultTableModel getEmployeeModel() throws SQLException {
		this.prepStatement = this.connection.prepareStatement(this.query.selectAllEmployees());
		this.getResultSet(); 
		return getModel();
	}
	
	public DefaultTableModel getDepartmentModel() throws SQLException {
		this.prepStatement = this.connection.prepareStatement(this.query.selectAllDepartments());
		this.getResultSet(); 
		return getModel();
	}
	public DefaultTableModel getManagerModel() throws SQLException {
		this.prepStatement = this.connection.prepareStatement(this.query.selectAllManagers());
		this.getResultSet(); 
		return getModel();
	}
}
