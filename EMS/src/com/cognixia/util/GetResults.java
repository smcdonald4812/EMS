package com.cognixia.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cognixia.EMS.java.mySQL.Queries;

public class GetResults extends GetInfo {
	private String columnName = null;

	private String getData() {
		getResultSet();
		if (this.resultSet == null) return new String("");
		try {
			if(this.resultSet.next()) {
				return this.resultSet.getString(columnName);
			}
		} catch (SQLException e) {
			System.out.println("SQL exception in getData method in getResults");
			e.printStackTrace();
		}
		return new String("");
	}
	/**
	 * @param table
	 * @param columnData
	 * @param columnKnown
	 * @param tupleName
	 * @return String
	 */
	public String getData(String table, String columnData, String columnKnown, String tupleName) {
		this.query = new Queries();
		this.columnName = columnData;
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.getSpecificTuple());
			this.prepStatement.setString(1, columnData);
			this.prepStatement.setString(2, table);
			this.prepStatement.setString(3, columnKnown);
			this.prepStatement.setString(4, tupleName);
			getResultSet();
			if (this.resultSet == null)
				return new String("");
			return getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new String("");
	}
	/**
	 * @param columnData
	 * @param columnKnown
	 * @param tupleName
	 * @param columnKnown2
	 * @param tupleName2
	 * @return String
	 */
	public String getSpecificEmployeeByName(String tupleName,  String tupleName2) {
		this.query = new Queries();
		this.columnName = "employeeID";
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.getSpecificEmployeeByName());
			this.prepStatement.setString(1, tupleName);
			this.prepStatement.setString(2, tupleName2);
			//getResultSet();
			if (this.resultSet == null)
				return new String("");
			return getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new String("");
	}
	public String getSpecificDepartmentData(String columnData, String tupleName) {
		this.query = new Queries();
		this.columnName = columnData;
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectSpecificDepDepartment());
			this.prepStatement.setString(1, columnData);
			this.prepStatement.setString(2, tupleName);
			//getResultSet();
			if (this.resultSet == null)
				return new String("");
			return getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new String("");
	}
	/**
	 * @param departmentName
	 * @return String
	 * @throws SQLException
	 */
	public String allDepartmentEmployees(String departmentName) {
		this.query = new Queries();
		this.columnName = new String("departmentName");
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectAllDepartmentEmployees());
			this.prepStatement.setString(1, departmentName);
			//getResultSet();
			if (this.resultSet == null)
				return new String("");
			return getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new String("");
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @return String
	 * @throws SQLException
	 */
	public DefaultTableModel selectSpecificEmployee(String firstName, String lastName) {
		this.query = new Queries();
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectSpecificEmployee());
			this.prepStatement.setString(1, firstName);
			this.prepStatement.setString(2, lastName);
			getResultSet();
			if (this.resultSet == null)
				return null;
			return getRowData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel();
	}
	/**
	 * @param departmentID
	 * @return DefaultTableModel
	 */
	public DefaultTableModel selectSpecificDepartment(int departmentID) {
		this.query = new Queries();
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectSpecificEmpDepartment());
			this.prepStatement.setInt(1, departmentID);
			getResultSet();
			if (this.resultSet == null)
				return null;
			return getRowData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel();
	}
	/** 
	 * @return DefaultTableModel
	 */
	public DefaultTableModel selectAllEmployees() {
		this.query = new Queries();
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectAllEmployees());
			getResultSet();
			if (this.resultSet == null)
				return null;
			return getRowData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel();
	}
	/** 
	 * @return DefaultTableModel
	 */
	public DefaultTableModel selectAllManagers() {
		this.query = new Queries();
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.getAllManagers());
			getResultSet();
			if (this.resultSet == null)
				return null;
			return getRowData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel();
	}
	/** 
	 * @return DefaultTableModel
	 */
	public DefaultTableModel selectAllDepartments() {
		this.query = new Queries();
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectAllDepartments());
			getResultSet();
			if (this.resultSet == null)
				return null;
			return getRowData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel();
	}
	/**
	 * 
	 * @param departmentName
	 * @return String
	 * @throws SQLException
	 */
	public String selectSpecificDepartment(String departmentName) {
		this.query = new Queries();
		this.columnName = new String("departmentID");
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectSpecificDepartment());
			this.prepStatement.setString(1, departmentName);
			//getResultSet();
			if (this.resultSet == null)
				return new String("");
			return getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new String("");
	}
	/**
	 * 
	 * @param departmentName
	 * @return String
	 * @throws SQLException
	 */
	public String getSpecificDepartment(int departmentID) {
		this.query = new Queries();
		this.columnName = new String("departmentName");
		setLocalConnection();
		if (connection == null) new String("");
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectSpecificDepartmentById());
			this.prepStatement.setInt(1, departmentID);
			//getResultSet();
			if (this.resultSet == null)
				return new String("");
			return getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new String("");
	}
	public List<String> getSpecificEmployee(String firstName, String lastName) {
		this.query = new Queries();
		List<String> emp = new ArrayList<>();
		setLocalConnection();
		if (connection == null) return new ArrayList<String>();
		try {
			this.prepStatement = this.connection.prepareStatement(this.query.selectSpecificEmployee());
			this.prepStatement.setString(1, firstName);
			this.prepStatement.setString(2, lastName);
			getResultSet();
			if (this.resultSet == null) return null;
			if(this.resultSet.next()) {
				for (int i = 1; i <= this.resultMetaData.getColumnCount(); i++) {
					//String a = this.resultSet.getObject(i)+"";
					emp.add(this.resultSet.getObject(i)+"");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeLocalConnection();
		return emp;
	}
	private DefaultTableModel getRowData() {
		Vector<String> columnNames = new Vector<>();
		Vector<Vector<Object>> data = new Vector<>();
		int columnCount;
		try {
			columnCount = resultMetaData.getColumnCount();
			// put column names in columns
			for (int column = 1; column <= columnCount; column++) {
				columnNames.add(resultMetaData.getColumnName(column));
			}
			// get all the row data for the columns
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
		return new DefaultTableModel(data, columnNames);
	}
}
