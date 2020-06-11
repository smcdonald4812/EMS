package com.cognixia.util;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import com.cognixia.EMS.java.mySQL.LocalConnectionHandler;
import com.cognixia.EMS.java.mySQL.MySQLObjectsSet;
import com.cognixia.EMS.java.mySQL.Queries;

public class Modifications extends MySQLObjectsSet {
	private LocalConnectionHandler local = null;
	private Connection connection = null;
	private PreparedStatement prepStatement = null;
	private Queries query;
	private int changed = 0;

	private int change() {
		setLocalConnection();
		if (connection == null)
			return 0;
		send();
		if (this.changed == 0)
			return 0;
		this.local.closeConnection(this.connection);
		return changed;
	}

	@Override
	protected void setLocalConnection() {
		this.local = new LocalConnectionHandler();
		this.connection = local.getConnection();
	}

	@Override
	protected void send() {
		try {
			this.prepStatement.execute();
		} catch (SQLException e) {
			System.out.println("get result set in Inserts threw SQLException");
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return int
	 * @throws SQLException
	 */
	public int terminateEmployee(Date endDate, String firstName, String lastName) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.terminateEmployee());
			this.prepStatement.setDate(1, endDate);
			this.prepStatement.setString(2, firstName);
			this.prepStatement.setString(3, lastName);
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param phoneNumber
	 * @param departmentName
	 * @param payRate
	 * @param startDate
	 * @param isManager
	 * @return int
	 * @throws SQLException
	 */
	public int insertNewEmployee(String firstName, String lastName, String address, String email, String phoneNumber,
			int departmentID, String payRate, Date startDate, int isManager) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.insertNewEmployee());
			this.prepStatement.setString(1, firstName);
			this.prepStatement.setString(2, lastName);
			this.prepStatement.setString(3, address);
			this.prepStatement.setString(4, email);
			this.prepStatement.setString(5, phoneNumber);
			this.prepStatement.setInt(6, departmentID);
			this.prepStatement.setString(7, payRate);
			this.prepStatement.setDate(8, startDate);
			this.prepStatement.setInt(9, isManager);
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 
	 * @param emp
	 * @return
	 */
	public int editEmployee(List<String> emp) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.editEmployee());
			this.prepStatement.setString(1, emp.get(3));
			this.prepStatement.setString(2, emp.get(4));
			this.prepStatement.setString(3, emp.get(5));
			this.prepStatement.setInt(4, Integer.valueOf(emp.get(6)));
			this.prepStatement.setString(5, emp.get(7));
			this.prepStatement.setInt(6, Integer.valueOf(emp.get(0)));
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 
	 * @param table
	 * @param columnsName
	 * @param tuple
	 * @param tuple2
	 * @return int
	 * @throws SQLException
	 */
	public int updateSpecificStringTuple(String columnsName, String tuple, String columnsName2, String tuple2) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.updateSpecificTuple());
			this.prepStatement.setString(1, columnsName);
			this.prepStatement.setString(2, tuple);
			this.prepStatement.setString(3, columnsName2);
			this.prepStatement.setString(4, tuple2);
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * @param isManager
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public int makeManager(int isManager, String firstName, String lastName) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.setAsManager());
			this.prepStatement.setInt(1, isManager);
			this.prepStatement.setString(2, firstName);
			this.prepStatement.setString(3, lastName);
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * @param empID
	 * @param depID
	 * @return
	 */
	public int insertManagerTable(String empID, String depID) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.setNewManagerTable());
			this.prepStatement.setInt(1, Integer.valueOf(depID));
			this.prepStatement.setInt(2, Integer.valueOf(empID));
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * @param departmentName
	 * @return
	 */
	public int insertDepartmentTable(String departmentName) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.setNewDepartment());
			this.prepStatement.setString(1, departmentName);
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * @param departmentName
	 * @return
	 */
	public int updateDepartment(String departmentName, int departmentID) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.editDepartment());
			this.prepStatement.setString(1, departmentName);
			this.prepStatement.setInt(2, departmentID);
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public int updateManager(String firstName, String lastName) {
		this.query = new Queries();
		try {
			setLocalConnection();
			if (connection == null) new String("");
			this.prepStatement = this.connection.prepareStatement(this.query.updateManager());
			this.prepStatement.setString(1, firstName);
			this.prepStatement.setString(2, lastName);
			return change();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
