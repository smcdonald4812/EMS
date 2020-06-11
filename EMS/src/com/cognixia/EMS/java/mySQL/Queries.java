package com.cognixia.EMS.java.mySQL;

/**
 * 
 * @author steven
 * all statements for get, insert, and update are in this class
 *
 */
public class Queries {
	private final String empTable, depTable, manageTable;
	
	public Queries() {
		this.empTable = new String("employeemanagementsystem.employees");
		this.depTable = new String("employeemanagementsystem.departments");
		this.manageTable = new String("employeemanagementsystem.managers");
	}
	/**
	 * @return String
	 */
	public String selectAllEmployees() {
		return "SELECT * FROM " + this.empTable;
	}
	/**
	 * @return String
	 */
	public String selectAllDepartments() {
		return "SELECT * FROM " + this.depTable;
	}
	/**
	 * @return String
	 */
	public String selectAllManagers() {
		return "SELECT * FROM " + this.empTable + " WHERE isManager = 1";
	}
	/**
	 * @return
	 */
	public String setNewManagerTable() {
		return "INSERT INTO "+this.manageTable+" (departmentID, employeeID) values (?, ?)";
	}
	/**
	 * @return
	 */
	public String setAsManager() {
		return "UPDATE "+this.empTable+" SET isManager = ? WHERE firstName = ? AND lastName = ?";
	}
	/**
	 * @return
	 */
	public String setNewDepartment() {
		return "INSERT INTO "+this.depTable+" (departmentName) values (?)";
	}
	/**
	 * @return
	 */
	public String getAllManagers() {
		return "SELECT * FROM employeemanagementsystem.managersView";
	}
	/**
	 * @return
	 */
	public String selectAllDepartmentEmployees() {
		return "SELECT * FROM " + empTable + " WHERE departmentId like '%?%'";
	}
	/**
	 * @return String
	 */
	public String terminateEmployee() {
		return "UPDATE " + this.empTable + " SET endDate = ?, departmentID = -1, isManager = 0, payRate = 'XXXX' WHERE firstName = "
				+ "? AND lastName = ?";
	}
	/**
	 * @return String
	 */
	public String selectSpecificEmployee() {	
		return "Select * FROM " + this.empTable + " WHERE firstName = ? AND lastName = ?";
	}
	/**
	 * @return String
	 */
	public String selectSpecificDepartment() {	
		return "Select * FROM " + this.depTable + " WHERE departmentName = ?";
	}
	/**
	 * @return String
	 */
	public String selectSpecificDepartmentById() {	
		return "Select * FROM " + this.depTable + " WHERE departmentID = ?";
	}
	/**
	 * @return String
	 */
	public String insertNewEmployee() {
		return "INSERT INTO " + this.empTable + " (firstName, lastName, address, email, "
				+ "phoneNumber, departmentID, payRate, startDate, isManager) VALUES (?, "
						+ "?, ?, ?, ?, ?, ?, ?, ?)";
	}
	/**
	 * @return String
	 */
	public String editEmployee() {
		return "Update " + this.empTable + " SET address=?, email=?, "
				+ "phoneNumber=?, departmentID=?, payRate=? WHERE employeeID=?";
	}
	/**
	 * @return String
	 */
	public String editDepartment() {
		return "Update " + this.empTable + " SET departmentName=? WHERE departmentID=?";
	}
	/**
	 * @return String
	 */
	public String updateManager() {
		return "Update " + this.empTable + " SET isManager=0 WHERE firstName=? AND lastName=?";
	}
	/**
	 * @param table
	 * @return String
	 */
	public String updateSpecificTuple() {
		return "UPDATE " + this.empTable + " SET ? = ? WHERE ? = ?";
	}
	/**
	 * @param table
	 * @return String
	 */
	public String getSpecificTuple() {
		return "SELECT ? FROM ? WHERE ? = ?";
	}
	/**
	 * @param table
	 * @return String
	 */
	public String getSpecificEmployeeByName() {
		return "SELECT employeeID FROM " + this.empTable + " WHERE firstName = ? AND lastName = ?";
	}
	/**
	 * @return String
	 */
	public String selectSpecificEmpDepartment() {
		return "Select * FROM " + this.empTable + " WHERE departmentID = ?";
	}
	/**
	 * @return String
	 */
	public String selectSpecificDepDepartment() {
		return "Select ? FROM " + this.depTable + " WHERE departmentName = ?";
	}
}
