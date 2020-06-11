package com.cognixia.EMS.java.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cognixia.util.GUIInputChecker;
import com.cognixia.util.GetResults;
import com.cognixia.util.Modifications;

public class EMSGUI {

	private GUIInputChecker patterns;
	private Modifications modify;
	private GetResults getInfo;
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu editEmpMenu, editDepMenu, editManMenu;
	private JMenuItem modifyEmpItem, fireEmpItem, editDepItem, editManItem;
	private CardLayout cardLayout;
	private JTable employeesTable, departmentsTable, managersTable;
	private JPanel cardPanel, seeEmployeesPanel, seeDepartmentsPanel, seeManagersPanel, newEmployeePanel,
			newDepartmentPanel, newManagerPanel, editEmployee, editManager, editDepartment, fireEmployee, selectEditEmployee;

	private Label newEmpFormLabel, newEmpFirstLabel,
			editManagerOldLastLabel, editManagerOldFirstLabel, editManagerOldLabel,
			editManagerLabel, editDepartmentNameLabel, editDepartmentLabel, fireEmployeeLastLabel,
			fireEmployeeFirstLabel, fireEmployeeWarningLabel, fireEmployeeLabel, editEmployeeDateStartLabel,
			editEmployeeDateLabel, editEmployeeDepartmentLabel, editEmployeePhoneLabel, editEmployeeEmailLabel,
			editEmployeeAddressLabel, editEmployeeLastLabel, editEmployeeFirstLabel, editEmployeePayLabel,
			editEmployeeLabel, newManagerDepartmentLabel, newManagerLastLabel, newManagerFirstLabel,
			newManagerNameLabel, newManagerLabel, newDepartmentStartLabel, 
			newDepartmentNameLabel, newDepartmentLabel, newEmpPayLabel,
			newEmpDepartmentLabel, newEmpPhoneLable, newEmpEmailLabel, newEmpAddressLabel, newEmpLastLabel,
			selectEditEmployeeLabel, selectEditEmployeeFirstLabel, selectEditEmployeeLastLabel;

	private TextField newEmpFirstText, newEmpLastText, newEmpAddressText, 
			editManagerOldLastText, editManagerOldFirstText,
			editDepartmentNameText, fireEmployeeLastText, fireEmployeeFirstText,
			editEmployeeDepartmentText, editEmployeePhoneText, editEmployeeEmailText, editEmployeeAddressText,
			editEmployeePayText, newManagerDepartmentText, newManagerLastText, newManagerFirstText,
			newDepartmentStartText, newDepartmentManagerLastText, newDepartmentManagerFirstText, newDepartmentNameText,
			newEmpStartText, newEmpPayText, newEmpManagerLastText, newEmpManagerFirstText, newEmpDepartmentText,
			newEmpPhoneText, newEmpEmailText, selectEditEmployeeFirstText, selectEditEmployeeLastText;

	private JButton newEmployeeSubmit, newEmployeeReset, newDepartmentSubmit, newDepartmentReset, newManagerSubmit,
			newManagerReset, editEmployeeSubmit, editEmployeeReset, fireEmployeeSubmit, fireEmployeeReset,
			editManagerSubmit, editManagerReset, editDepartmentSubmit, editDepartmentReset, seeEmpButton, seeDepButton, seeManButton, newEmpButton, newDepButton,
			newManButton, selectEditEmployeeSubmit, selectEditEmployeeReset;

	private JScrollPane employeePane, departmentPane, managerPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EMSGUI window = new EMSGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EMSGUI() {
		this.patterns = new GUIInputChecker();
		this.getInfo = new GetResults();
		this.modify = new Modifications();
		initialize();
		buttons();
		onStart();
	}

	private void onStart() {
		this.employeesTable = new JTable(this.getEmployeeModel());
		this.departmentsTable = new JTable(this.getDepartmentModel());
		this.managersTable = new JTable(this.getManagerModel());

		this.employeePane = new JScrollPane();
		this.departmentPane = new JScrollPane();
		this.managerPane = new JScrollPane();

		this.seeEmployeesPanel.add(employeePane);
		this.seeDepartmentsPanel.add(departmentPane);
		this.seeManagersPanel.add(managerPane);

		this.departmentPane.add(this.departmentsTable);
		this.employeePane.add(this.employeesTable);
		this.managerPane.add(this.managersTable);

		this.cardLayout.show(cardPanel, "1");
	}

	public JFrame getFrame() {
		return this.frame;
	}

	private DefaultTableModel getEmployeeModel() {
		return this.getInfo.selectAllEmployees();
	}

	private DefaultTableModel getDepartmentModel() {
		return this.getInfo.selectAllDepartments();
	}

	private DefaultTableModel getManagerModel() {
		return this.getInfo.selectAllManagers();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame("Employee Management System");
		this.menuBar = new JMenuBar();
		this.cardLayout = new CardLayout();

		this.cardPanel = new JPanel();
		this.seeEmployeesPanel = new JPanel();
		this.seeDepartmentsPanel = new JPanel();
		this.seeManagersPanel = new JPanel();
		this.newEmployeePanel = new JPanel();
		this.newDepartmentPanel = new JPanel();
		this.newManagerPanel = new JPanel();
		this.editEmployee = new JPanel();
		this.editManager = new JPanel();
		this.editDepartment = new JPanel();
		this.fireEmployee = new JPanel();
		this.selectEditEmployee = new JPanel();

		this.cardPanel.setLayout(this.cardLayout);

		this.editEmpMenu = new JMenu("Edit Employee");
		this.editDepMenu = new JMenu("Edit Departments");
		this.editManMenu = new JMenu("Edit Managers");

		this.modifyEmpItem = new JMenuItem("Modify employee");
		this.fireEmpItem = new JMenuItem("Fire Employee");
		this.editDepItem = new JMenuItem("Edit Department");
		this.editManItem = new JMenuItem("Edit Manager");

		this.newEmpFirstText = new TextField();
		this.newEmpLastText = new TextField();
		this.newEmpAddressText = new TextField();
		this.editManagerOldLastText = new TextField();
		this.editManagerOldFirstText = new TextField();
		this.editDepartmentNameText = new TextField();
		this.fireEmployeeLastText = new TextField();
		this.fireEmployeeFirstText = new TextField();
		this.selectEditEmployeeLastText = new TextField();
		this.selectEditEmployeeFirstText = new TextField();
		this.editEmployeeDepartmentText = new TextField();
		this.editEmployeePhoneText = new TextField();
		this.editEmployeeEmailText = new TextField();
		this.editEmployeeAddressText = new TextField();
		this.editEmployeePayText = new TextField();
		this.newManagerDepartmentText = new TextField();
		this.newManagerLastText = new TextField();
		this.newManagerFirstText = new TextField();
		this.newDepartmentStartText = new TextField();
		this.newDepartmentNameText = new TextField();
		this.newEmpStartText = new TextField();
		this.newEmpPayText = new TextField();
		this.newEmpManagerLastText = new TextField();
		this.newEmpManagerFirstText = new TextField();
		this.newEmpDepartmentText = new TextField();
		this.newEmpPhoneText = new TextField();
		this.newEmpEmailText = new TextField();

		this.editManagerOldLastLabel = new Label("Last Name");
		this.editManagerOldFirstLabel = new Label("First Name");
		this.editManagerOldLabel = new Label("Old Manager");
		this.editManagerLabel = new Label("Edit Manager");
		this.editDepartmentNameLabel = new Label("Department Name");
		this.editDepartmentLabel = new Label("Edit Department");
		this.fireEmployeeLastLabel = new Label("Last Name");
		this.fireEmployeeFirstLabel = new Label("First Name");
		this.selectEditEmployeeLastLabel = new Label("Last Name");
		this.selectEditEmployeeFirstLabel = new Label("First Name");
		this.selectEditEmployeeLabel = new Label("Edit Employee");
		this.fireEmployeeWarningLabel = new Label("Warning!!! Once submitted this employee will be fired!");
		this.fireEmployeeLabel = new Label("Fire Employee");
		this.editEmployeeDateStartLabel = new Label("none");
		this.editEmployeeDateLabel = new Label("Date Started");
		this.editEmployeeDepartmentLabel = new Label("Department Name");
		this.editEmployeePhoneLabel = new Label("Phone Number");
		this.editEmployeeEmailLabel = new Label("Email");
		this.editEmployeeAddressLabel = new Label("Address");
		this.editEmployeeLastLabel = new Label("tempLast");
		this.editEmployeeFirstLabel = new Label("tempName");
		this.editEmployeePayLabel = new Label("Pay Rate");
		this.editEmployeeLabel = new Label("Edit Employee");
		this.newManagerDepartmentLabel = new Label("Department Name");
		this.newManagerLastLabel = new Label("Last Name");
		this.newManagerFirstLabel = new Label("First Name");
		this.newManagerNameLabel = new Label("Employee");
		this.newManagerLabel = new Label("New Manager");
		this.newDepartmentStartLabel = new Label("Date Created");
		this.newDepartmentNameLabel = new Label("Department Name");
		this.newDepartmentLabel = new Label("New Department");
		this.newEmpPayLabel = new Label("Pay Rate");
		this.newEmpDepartmentLabel = new Label("Department");
		this.newEmpPhoneLable = new Label("Phone");
		this.newEmpEmailLabel = new Label("Email");
		this.newEmpAddressLabel = new Label("Address");
		this.newEmpLastLabel = new Label("Last Name");
		this.newEmpFormLabel = new Label("New Employee Form");
		this.newEmpFirstLabel = new Label("First Name");

		this.cardPanel.add(seeEmployeesPanel, "1");
		this.cardPanel.add(seeDepartmentsPanel, "2");
		this.cardPanel.add(seeManagersPanel, "3");
		this.cardPanel.add(newEmployeePanel, "4");
		this.cardPanel.add(newDepartmentPanel, "5");
		this.cardPanel.add(newManagerPanel, "6");
		this.cardPanel.add(editEmployee, "11");
		this.cardPanel.add(fireEmployee, "8");
		this.cardPanel.add(editDepartment, "9");
		this.cardPanel.add(editManager, "10");
		this.cardPanel.add(selectEditEmployee, "7");
		this.newEmployeePanel.setLayout(null);
		this.newDepartmentPanel.setLayout(null);
		this.newManagerPanel.setLayout(null);
		this.editEmployee.setLayout(null);
		this.editManager.setLayout(null);
		this.editDepartment.setLayout(null);
		this.fireEmployee.setLayout(null);
		this.selectEditEmployee.setLayout(null);

		this.newEmployeeSubmit = new JButton("Submit");
		this.newEmployeeReset = new JButton("Reset");
		this.newDepartmentSubmit = new JButton("Submit");
		this.newDepartmentReset = new JButton("Reset");
		this.newManagerSubmit = new JButton("Submit");
		this.newManagerReset = new JButton("Reset");
		this.editEmployeeSubmit = new JButton("Submit");
		this.editEmployeeReset = new JButton("Reset");
		this.fireEmployeeSubmit = new JButton("Submit");
		this.fireEmployeeReset = new JButton("Reset");
		this.selectEditEmployeeSubmit = new JButton("Submit");
		this.selectEditEmployeeReset = new JButton("Reset");
		this.editManagerSubmit = new JButton("Submit");
		this.editManagerReset = new JButton("Reset");
		this.editDepartmentSubmit = new JButton("Submit");
		this.editDepartmentReset = new JButton("Reset");
		this.seeEmpButton = new JButton("See Employees");
		this.seeDepButton = new JButton("See Departments");
		this.seeManButton = new JButton("See Managers");
		this.newEmpButton = new JButton("New Employee");
		this.newDepButton = new JButton("New Department");
		this.newManButton = new JButton("New Manager");

		this.frame.setForeground(Color.BLACK);
		this.frame.setBounds(100, 100, 950, 570);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.menuBar.setOpaque(true);
		this.menuBar.setBackground(new JButton().getBackground());

		this.frame.setJMenuBar(this.menuBar);
		this.frame.getContentPane().setLayout(new CardLayout(0, 0));
		this.frame.getContentPane().add(this.cardPanel, "name_71059939251700");

		this.newEmpFormLabel.setBounds(10, 10, 173, 34);
		this.newEmployeePanel.add(newEmpFormLabel);
		this.newEmpFirstLabel.setBounds(10, 75, 113, 22);
		this.newEmployeePanel.add(newEmpFirstLabel);
		this.newEmpFirstText.setBounds(129, 75, 173, 22);
		this.newEmployeePanel.add(newEmpFirstText);
		this.newEmpLastLabel.setBounds(10, 103, 113, 22);
		this.newEmployeePanel.add(newEmpLastLabel);
		this.newEmpLastText.setBounds(129, 103, 173, 22);
		this.newEmployeePanel.add(newEmpLastText);
		this.newEmpAddressLabel.setBounds(10, 131, 113, 22);
		this.newEmployeePanel.add(newEmpAddressLabel);
		this.newEmpAddressText.setBounds(129, 131, 173, 22);
		this.newEmployeePanel.add(newEmpAddressText);
		this.newEmpEmailLabel.setBounds(10, 162, 113, 22);
		this.newEmployeePanel.add(newEmpEmailLabel);
		this.newEmpEmailText.setBounds(129, 162, 173, 22);
		this.newEmployeePanel.add(newEmpEmailText);
		this.newEmpPhoneLable.setBounds(10, 189, 113, 22);
		this.newEmployeePanel.add(newEmpPhoneLable);
		this.newEmpPhoneText.setBounds(129, 190, 173, 22);
		this.newEmployeePanel.add(newEmpPhoneText);
		this.newEmpDepartmentLabel.setBounds(10, 217, 113, 22);
		this.newEmployeePanel.add(newEmpDepartmentLabel);
		this.newEmpDepartmentText.setBounds(129, 218, 173, 22);
		this.newEmployeePanel.add(newEmpDepartmentText);
		this.newEmpPayLabel.setBounds(379, 75, 113, 22);
		this.newEmployeePanel.add(newEmpPayLabel);
		this.newEmpPayText.setBounds(498, 75, 173, 22);
		this.newEmployeePanel.add(newEmpPayText);
		this.newEmployeeSubmit.setBounds(498, 359, 89, 23);
		this.newEmployeePanel.add(newEmployeeSubmit);
		this.newEmployeeReset.setBounds(597, 358, 89, 23);
		this.newEmployeePanel.add(newEmployeeReset);

		this.newDepartmentLabel.setBounds(10, 10, 188, 22);
		this.newDepartmentPanel.add(newDepartmentLabel);
		this.newDepartmentNameLabel.setBounds(10, 69, 125, 22);
		this.newDepartmentPanel.add(newDepartmentNameLabel);
		this.newDepartmentNameText.setBounds(141, 69, 125, 22);
		this.newDepartmentPanel.add(newDepartmentNameText);
		this.newDepartmentStartLabel.setBounds(334, 69, 125, 22);
		this.newDepartmentPanel.add(newDepartmentStartLabel);
		this.newDepartmentStartText.setBounds(465, 69, 125, 22);
		this.newDepartmentPanel.add(newDepartmentStartText);

		this.newDepartmentSubmit.setBounds(465, 194, 89, 23);
		this.newDepartmentPanel.add(newDepartmentSubmit);
		this.newDepartmentReset.setBounds(564, 194, 89, 23);
		this.newDepartmentPanel.add(newDepartmentReset);

		this.newManagerLabel.setBounds(10, 10, 167, 22);
		this.newManagerPanel.add(newManagerLabel);
		this.newManagerNameLabel.setBounds(10, 84, 167, 22);
		this.newManagerPanel.add(newManagerNameLabel);
		this.newManagerFirstLabel.setBounds(10, 126, 113, 22);
		this.newManagerPanel.add(newManagerFirstLabel);
		this.newManagerFirstText.setBounds(129, 126, 123, 22);
		this.newManagerPanel.add(newManagerFirstText);
		this.newManagerLastLabel.setBounds(10, 154, 113, 22);
		this.newManagerPanel.add(newManagerLastLabel);
		this.newManagerLastText.setBounds(129, 154, 123, 22);
		this.newManagerPanel.add(newManagerLastText);
		this.newManagerDepartmentLabel.setBounds(10, 225, 113, 22);
		this.newManagerPanel.add(newManagerDepartmentLabel);
		this.newManagerDepartmentText.setBounds(129, 225, 123, 22);
		this.newManagerPanel.add(newManagerDepartmentText);

		this.newManagerSubmit.setBounds(351, 224, 89, 23);
		this.newManagerPanel.add(newManagerSubmit);
		this.newManagerReset.setBounds(450, 224, 89, 23);
		this.newManagerPanel.add(newManagerReset);

		this.editEmployeeLabel.setBounds(10, 10, 158, 22);
		this.editEmployee.add(editEmployeeLabel);
		this.editEmployeePayLabel.setBounds(10, 79, 110, 22);
		this.editEmployee.add(editEmployeePayLabel);
		this.editEmployeeFirstLabel.setBounds(10, 51, 110, 22);
		this.editEmployee.add(editEmployeeFirstLabel);
		this.editEmployeeLastLabel.setBounds(126, 51, 110, 22);
		this.editEmployee.add(editEmployeeLastLabel);
		this.editEmployeePayText.setBounds(10, 107, 226, 22);
		this.editEmployee.add(editEmployeePayText);
		this.editEmployeeAddressLabel.setBounds(10, 135, 110, 22);
		this.editEmployee.add(editEmployeeAddressLabel);
		this.editEmployeeAddressText.setBounds(10, 163, 226, 22);
		this.editEmployee.add(editEmployeeAddressText);
		this.editEmployeeEmailLabel.setBounds(10, 191, 110, 22);
		this.editEmployee.add(editEmployeeEmailLabel);
		this.editEmployeeEmailText.setBounds(10, 219, 226, 22);
		this.editEmployee.add(editEmployeeEmailText);
		this.editEmployeePhoneLabel.setBounds(10, 247, 110, 22);
		this.editEmployee.add(editEmployeePhoneLabel);
		this.editEmployeePhoneText.setBounds(10, 275, 226, 22);
		this.editEmployee.add(editEmployeePhoneText);
		this.editEmployeeDepartmentLabel.setBounds(10, 303, 110, 22);
		this.editEmployee.add(editEmployeeDepartmentLabel);
		this.editEmployeeDepartmentText.setBounds(10, 331, 226, 22);
		this.editEmployee.add(editEmployeeDepartmentText);
		this.editEmployeeDateLabel.setBounds(307, 135, 110, 22);
		this.editEmployee.add(editEmployeeDateLabel);
		this.editEmployeeDateStartLabel.setBounds(307, 163, 110, 22);
		this.editEmployee.add(editEmployeeDateStartLabel);

		this.editEmployeeSubmit.setBounds(307, 330, 89, 23);
		this.editEmployee.add(editEmployeeSubmit);
		this.editEmployeeReset.setBounds(406, 331, 89, 23);
		this.editEmployee.add(editEmployeeReset);

		fireEmployeeLabel.setBounds(10, 11, 118, 14);
		fireEmployee.add(fireEmployeeLabel);
		fireEmployeeWarningLabel.setBounds(292, 11, 229, 14);
		fireEmployee.add(fireEmployeeWarningLabel);
		fireEmployeeFirstLabel.setBounds(199, 76, 109, 14);
		fireEmployee.add(fireEmployeeFirstLabel);
		fireEmployeeLastLabel.setBounds(406, 76, 115, 14);
		fireEmployee.add(fireEmployeeLastLabel);
		fireEmployeeFirstText.setBounds(198, 96, 109, 22);
		fireEmployee.add(fireEmployeeFirstText);
		fireEmployeeLastText.setBounds(406, 96, 115, 22);
		fireEmployee.add(fireEmployeeLastText);

		fireEmployeeSubmit.setBounds(199, 210, 89, 23);
		fireEmployee.add(fireEmployeeSubmit);
		fireEmployeeReset.setBounds(432, 210, 89, 23);
		fireEmployee.add(fireEmployeeReset);
		
		selectEditEmployeeLabel.setBounds(10, 11, 118, 14);
		selectEditEmployee.add(selectEditEmployeeLabel);
		selectEditEmployeeFirstLabel.setBounds(199, 76, 109, 14);
		selectEditEmployee.add(selectEditEmployeeFirstLabel);
		selectEditEmployeeLastLabel.setBounds(406, 76, 115, 14);
		selectEditEmployee.add(selectEditEmployeeLastLabel);
		selectEditEmployeeFirstText.setBounds(198, 96, 109, 22);
		selectEditEmployee.add(selectEditEmployeeFirstText);
		selectEditEmployeeLastText.setBounds(406, 96, 115, 22);
		selectEditEmployee.add(selectEditEmployeeLastText);

		selectEditEmployeeSubmit.setBounds(199, 210, 89, 23);
		selectEditEmployee.add(selectEditEmployeeSubmit);
		selectEditEmployeeReset.setBounds(432, 210, 89, 23);
		selectEditEmployee.add(selectEditEmployeeReset);

		editDepartmentLabel.setBounds(10, 10, 146, 22);
		editDepartment.add(editDepartmentLabel);
		editDepartmentNameLabel.setBounds(10, 66, 146, 22);
		editDepartment.add(editDepartmentNameLabel);
		editDepartmentNameText.setBounds(10, 94, 146, 22);
		editDepartment.add(editDepartmentNameText);

		editManagerLabel.setBounds(10, 10, 152, 22);
		editManager.add(editManagerLabel);
		editManagerOldLabel.setBounds(10, 75, 152, 22);
		editManager.add(editManagerOldLabel);
		editManagerOldFirstLabel.setBounds(10, 103, 152, 22);
		editManager.add(editManagerOldFirstLabel);
		editManagerOldFirstText.setBounds(10, 131, 152, 22);
		editManager.add(editManagerOldFirstText);
		editManagerOldLastLabel.setBounds(10, 159, 152, 22);
		editManager.add(editManagerOldLastLabel);
		editManagerOldLastText.setBounds(10, 187, 152, 22);
		editManager.add(editManagerOldLastText);

		editManagerSubmit.setBounds(10, 282, 89, 23);
		editManager.add(editManagerSubmit);
		editManagerReset.setBounds(109, 282, 89, 23);
		editManager.add(editManagerReset);
		
		editDepartmentSubmit.setBounds(10, 282, 89, 23);
		editDepartment.add(editDepartmentSubmit);
		editDepartmentReset.setBounds(109, 282, 89, 23);
		editDepartment.add(editDepartmentReset);

		menuBar.add(seeEmpButton);
		menuBar.add(seeDepButton);
		menuBar.add(seeManButton);
		menuBar.add(newEmpButton);

		menuBar.add(newDepButton);
		menuBar.add(newManButton);

		editEmpMenu.setOpaque(true);
		editEmpMenu.setBackground(new JButton().getBackground());
		editEmpMenu.setForeground(Color.BLACK);
		menuBar.add(editEmpMenu);

		editEmpMenu.add(modifyEmpItem);
		editEmpMenu.add(fireEmpItem);

		editDepMenu.setOpaque(true);
		editDepMenu.setBackground(new JButton().getBackground());
		editDepMenu.setForeground(Color.BLACK);

		menuBar.add(editDepMenu);
		editDepMenu.add(editDepItem);

		editManMenu.setOpaque(true);
		editManMenu.setBackground(new JButton().getBackground());
		editManMenu.setForeground(Color.BLACK);

		menuBar.add(editManMenu);
		editManMenu.add(editManItem);
	}

	private void buttons() {
		newEmployeeSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isName(newEmpFirstText.getText())) {
					JOptionPane.showMessageDialog(newEmployeePanel, "First name is incorrect!");
					return;
				}
				if (!patterns.isName(newEmpLastText.getText())) {
					JOptionPane.showMessageDialog(newEmployeePanel, "Last name is incorrect!");
					return;
				}
				if (!patterns.isName(newEmpDepartmentText.getText())) {
					JOptionPane.showMessageDialog(newEmployeePanel, "Department name is incorrect!");
					return;
				}
				if (!patterns.isAddress(newEmpAddressText.getText())) {
					JOptionPane.showMessageDialog(newEmployeePanel, "Address is incorrect!");
					return;
				}
				if (!patterns.isEmail(newEmpEmailText.getText())) {
					JOptionPane.showMessageDialog(newEmployeePanel, "Email is incorrect!");
					return;
				}
				if (!patterns.isPay(newEmpPayText.getText())) {
					JOptionPane.showMessageDialog(newEmployeePanel, "Pay rate is incorrect!");
					return;
				}
				if (!patterns.isPhone(newEmpPhoneText.getText())) {
					JOptionPane.showMessageDialog(newEmployeePanel, "Phone number is incorrect!");
					return;
				}
				String a = getInfo.selectSpecificDepartment(newEmpDepartmentText.getText());
				modify.insertNewEmployee(newEmpFirstText.getText(), newEmpLastText.getText(),
						newEmpAddressText.getText(), newEmpEmailText.getText(), newEmpPhoneText.getText(),
						(int)Integer.valueOf(a), newEmpPayText.getText(), new java.sql.Date(Instant.now().toEpochMilli()), 0);
				if (employeesTable != null) {
					seeEmployeesPanel.remove(employeesTable);
				}
				newEmpStartText.setText("");
				newEmpPayText.setText("");
				newEmpManagerLastText.setText("");
				newEmpManagerFirstText.setText("");
				newEmpDepartmentText.setText("");
				newEmpPhoneText.setText("");
				newEmpEmailText.setText("");
				newEmpFirstText.setText("");
				newEmpLastText.setText("");
				newEmpAddressText.setText("");
				seeEmployeesPanel.remove(employeesTable);
				employeesTable = new JTable(getEmployeeModel());
				seeEmployeesPanel.add(employeesTable);
				cardLayout.show(cardPanel, "1");
			}
		});
		newEmployeeReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEmpStartText.setText("");
				newEmpPayText.setText("");
				newEmpManagerLastText.setText("");
				newEmpManagerFirstText.setText("");
				newEmpDepartmentText.setText("");
				newEmpPhoneText.setText("");
				newEmpEmailText.setText("");
				newEmpFirstText.setText("");
				newEmpLastText.setText("");
				newEmpAddressText.setText("");
			}
		});
		newDepartmentSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isName(newDepartmentNameText.getText())) {
					JOptionPane.showMessageDialog(newDepartmentPanel, "Department name is incorrect!");
					return;
				}
				if(modify.insertDepartmentTable(newDepartmentNameText.getText())<1) {
					JOptionPane.showMessageDialog(newDepartmentPanel, "Could not add department!");
					return;
				}
				newDepartmentStartText.setText("");
				newDepartmentManagerLastText.setText("");
				newDepartmentManagerFirstText.setText("");
				newDepartmentNameText.setText("");
				seeDepartmentsPanel.remove(departmentsTable);
				departmentsTable = new JTable(getDepartmentModel());
				seeDepartmentsPanel.add(departmentsTable);
				cardLayout.show(cardPanel, "2");
			}
		});
		newDepartmentReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newDepartmentStartText.setText("");
				newDepartmentManagerLastText.setText("");
				newDepartmentManagerFirstText.setText("");
				newDepartmentNameText.setText("");
			}
		});
		newManagerSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isName(newManagerDepartmentText.getText())) {
					JOptionPane.showMessageDialog(newManagerPanel, "Department name is incorrect!");
					return;
				}
				if (!patterns.isName(newManagerFirstText.getText())) {
					JOptionPane.showMessageDialog(newManagerPanel, "Manager first name is incorrect!");
					return;
				}
				if (!patterns.isName(newManagerLastText.getText())) {
					JOptionPane.showMessageDialog(newManagerPanel, "Manager last name is incorrect!");
					return;
				}
				modify.makeManager(1, newManagerFirstText.getText(), newManagerLastText.getText());
				String empID = getInfo.getSpecificEmployeeByName(newManagerFirstText.getText(), newManagerLastText.getText());
				String depID = getInfo.selectSpecificDepartment(newManagerDepartmentText.getText());
				if(empID.isBlank() | depID.isBlank()) {
					JOptionPane.showMessageDialog(newManagerPanel, "Could not find department or manager!");
					return;
				} else {
					modify.insertManagerTable(empID, depID);
					modify.makeManager(1, newManagerFirstText.getText(), newManagerLastText.getText());
				}
				newManagerDepartmentText.setText("");
				newManagerLastText.setText("");
				newManagerFirstText.setText("");
				seeManagersPanel.remove(managersTable);
				managersTable = new JTable(getManagerModel());
				seeManagersPanel.add(managersTable);
				cardLayout.show(cardPanel, "3");
			}
		});
		newManagerReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newManagerDepartmentText.setText("");
				newManagerLastText.setText("");
				newManagerFirstText.setText("");
			}
		});
		fireEmployeeSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isName(fireEmployeeLastText.getText())) {
					JOptionPane.showMessageDialog(fireEmployee, "Last name is incorrect!");
					return;
				}
				if (!patterns.isName(fireEmployeeFirstText.getText())) {
					JOptionPane.showMessageDialog(fireEmployee, "First name is incorrect!");
					return;
				}
				modify.terminateEmployee(new java.sql.Date(Instant.now().toEpochMilli()), fireEmployeeFirstText.getText(), fireEmployeeLastText.getText());
				fireEmployeeLastText.setText("");
				fireEmployeeFirstText.setText("");
				seeEmployeesPanel.remove(employeesTable);
				employeesTable = new JTable(getEmployeeModel());
				seeEmployeesPanel.add(employeesTable);
				cardLayout.show(cardPanel, "1");
			}
		});
		fireEmployeeReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEmployeeLastText.setText("");
				fireEmployeeFirstText.setText("");
			}
		});
		selectEditEmployeeSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isName(selectEditEmployeeLastText.getText())) {
					JOptionPane.showMessageDialog(selectEditEmployee, "Last name is incorrect!");
					return;
				}
				if (!patterns.isName(selectEditEmployeeFirstText.getText())) {
					JOptionPane.showMessageDialog(selectEditEmployee, "First name is incorrect!");
					return;
				}
				List<String> emp = getInfo.getSpecificEmployee(selectEditEmployeeFirstText.getText(), selectEditEmployeeLastText.getText());
				String dep = getInfo.getSpecificDepartment(Integer.valueOf(emp.get(6)));
				editEmployeeDateStartLabel.setText(emp.get(8));
				editEmployeeLastLabel.setText(emp.get(2));
				editEmployeeFirstLabel.setText(emp.get(1));
				editEmployeePayText.setText(emp.get(7));
				editEmployeeDepartmentText.setText(dep);
				editEmployeePhoneText.setText(emp.get(5));
				editEmployeeEmailText.setText(emp.get(4));
				editEmployeeAddressText.setText(emp.get(3));
				cardLayout.show(cardPanel, "11");
			}
		});
		selectEditEmployeeReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> emp = getInfo.getSpecificEmployee(selectEditEmployeeLastText.getText(), selectEditEmployeeFirstText.getText());
				String dep = getInfo.getSpecificDepartment(Integer.valueOf(emp.get(6)));
				editEmployeeDateStartLabel.setText(emp.get(8));
				editEmployeeLastLabel.setText(emp.get(2));
				editEmployeeFirstLabel.setText(emp.get(1));
				editEmployeePayText.setText(emp.get(7));
				editEmployeeDepartmentText.setText(dep);
				editEmployeePhoneText.setText(emp.get(5));
				editEmployeeEmailText.setText(emp.get(4));
				editEmployeeAddressText.setText(emp.get(3));
			}
		});
		editEmployeeSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isPay(editEmployeePayText.getText())) {
					JOptionPane.showMessageDialog(editEmployee, "Pay Rate is incorrect!");
					return;
				}
				if (!patterns.isAddress(editEmployeeAddressText.getText())) {
					JOptionPane.showMessageDialog(editEmployee, "Address is incorrect!");
					return;
				}
				if (!patterns.isEmail(editEmployeeEmailText.getText())) {
					JOptionPane.showMessageDialog(editEmployee, "Email is incorrect!");
					return;
				}
				if (!patterns.isPhone(editEmployeePhoneText.getText())) {
					JOptionPane.showMessageDialog(editEmployee, "Phone Number is incorrect!");
					return;
				}
				if (!patterns.isName(editEmployeeDepartmentText.getText())) {
					JOptionPane.showMessageDialog(editEmployee, "Department is incorrect!");
					return;
				}
				List<String> emp = getInfo.getSpecificEmployee(selectEditEmployeeFirstText.getText(), selectEditEmployeeLastText.getText());
				if(emp.size()<1) {
					JOptionPane.showMessageDialog(selectEditEmployee, "Issue editing employee!");
					return;
				}
				String dep = getInfo.selectSpecificDepartment(editEmployeeDepartmentText.getText());
				if(dep.isBlank()) {
					JOptionPane.showMessageDialog(editEmployee, "Department doesn't exist!");
					return;
				}
				emp.set(7, editEmployeePayText.getText());
				emp.set(6, dep);
				emp.set(5, editEmployeePhoneText.getText());
				emp.set(4, editEmployeeEmailText.getText());
				emp.set(3, editEmployeeAddressText.getText());
				modify.editEmployee(emp);
				editEmployeeDateStartLabel.setText("");
				editEmployeeLastLabel.setText("");
				editEmployeeFirstLabel.setText("");
				editEmployeePayText.setText("");
				editEmployeeDepartmentText.setText("");
				editEmployeePhoneText.setText("");
				editEmployeeEmailText.setText("");
				editEmployeeAddressText.setText("");
				seeEmployeesPanel.remove(employeesTable);
				employeesTable = new JTable(getEmployeeModel());
				seeEmployeesPanel.add(employeesTable);
				cardLayout.show(cardPanel, "1");
			}
		});
		editEmployeeReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> emp = getInfo.getSpecificEmployee(selectEditEmployeeLastText.getText(), selectEditEmployeeFirstText.getText());
				String dep = getInfo.getSpecificDepartment(Integer.valueOf(emp.get(6)));
				editEmployeeDateStartLabel.setText(emp.get(8));
				editEmployeeLastLabel.setText(emp.get(2));
				editEmployeeFirstLabel.setText(emp.get(1));
				editEmployeePayText.setText(emp.get(7));
				editEmployeeDepartmentText.setText(dep);
				editEmployeePhoneText.setText(emp.get(5));
				editEmployeeEmailText.setText(emp.get(4));
				editEmployeeAddressText.setText(emp.get(3));
			}
		});
		editManagerSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isName(editManagerOldFirstText.getText())) {
					JOptionPane.showMessageDialog(editManager, "First name is incorrect!");
					return;
				}
				if (!patterns.isName(editManagerOldLastText.getText())) {
					JOptionPane.showMessageDialog(editManager, "Last name is incorrect!");
					return;
				}
				modify.updateManager(editManagerOldFirstText.getText(), editManagerOldLastText.getText());
				editManagerOldFirstText.setText("");
				editManagerOldLastText.setText("");
				seeEmployeesPanel.remove(employeesTable);
				employeesTable = new JTable(getEmployeeModel());
				seeEmployeesPanel.add(employeesTable);
				cardLayout.show(cardPanel, "1");
			}
		});
		editManagerReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editManagerOldFirstText.setText("");
				editManagerOldLastText.setText("");
			}
		});
		editDepartmentSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!patterns.isName(editDepartmentNameText.getText())) {
					JOptionPane.showMessageDialog(editDepartment, "Department is incorrect!");
					return;
				}
				String a = getInfo.selectSpecificDepartment(editDepartmentNameText.getText());
				if(a.isBlank()) {
					JOptionPane.showMessageDialog(editDepartment, "Department is incorrect!");
					return;
				}
				modify.updateDepartment(editDepartmentNameText.getText(), Integer.valueOf(a));
				editDepartmentNameText.setText("");
				seeDepartmentsPanel.remove(departmentsTable);
				departmentsTable = new JTable(getDepartmentModel());
				seeDepartmentsPanel.add(departmentsTable);
				cardLayout.show(cardPanel, "2");
			}
		});
		editDepartmentReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editDepartmentNameText.setText("");
			}
		});
		seeEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (employeesTable != null) {
					seeEmployeesPanel.remove(employeesTable);
				}
				employeesTable = new JTable(getEmployeeModel());
				seeEmployeesPanel.add(employeesTable);
				cardLayout.show(cardPanel, "1");
			}
		});
		seeDepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeDepartmentsPanel.remove(departmentsTable);
				departmentsTable = new JTable(getDepartmentModel());
				seeDepartmentsPanel.add(departmentsTable);
				cardLayout.show(cardPanel, "2");
			}
		});
		seeManButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeManagersPanel.remove(managersTable);
				managersTable = new JTable(getManagerModel());
				seeManagersPanel.add(managersTable);
				cardLayout.show(cardPanel, "3");
			}
		});
		newEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "4");
			}
		});
		newDepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "5");
			}
		});
		newManButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "6");
			}
		});
		modifyEmpItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "7");
			}
		});
		fireEmpItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "8");
			}
		});
		editDepItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "9");
			}
		});
		editManItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "10");
			}
		});
	}
}