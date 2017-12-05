package Model;

import Database.CEODatabase;
import java.math.BigDecimal;
import javax.swing.JTable;

public class CEOFunctions extends EmployeeFunctions{

	public CEOFunctions(String ceoEmail, String ceoPassword) {
		super(ceoEmail, ceoPassword);
	}

	public void addEmployee(String email, String password, String hireDate, String fname, String lname,
			String jobLocation, String position, BigDecimal salary){
		CEODatabase.addEmployee(email, password, hireDate, fname, lname, jobLocation, position, salary);
	}

	public void deleteEmployee(int employeeID){
		CEODatabase.deleteEmployee(employeeID);
	}

	public JTable getAllEmployees() {
		return CEODatabase.getAllEmployees();
	}
}
