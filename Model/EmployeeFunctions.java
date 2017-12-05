package Model;

import Database.EmployeeDatabase;
import javax.swing.JTable;


public class EmployeeFunctions {
	private String employeeEmail;
	private String employeePassword;


	public EmployeeFunctions(String email, String password) {
		this.employeeEmail = email;
		this.employeePassword = password;
	}

	public void addMovie(String movieID, String title, String rating, String genre, String releaseDate) {
		EmployeeDatabase.addMovie(movieID, title, rating, genre, releaseDate);
	}

	public void deleteMovie(String deleteMovieID) {
		EmployeeDatabase.deleteMovie(deleteMovieID);
	}

	public void addMember(String email, String password, String fname, String lname, String phone, String address, String city,
			String state, String zip) {
		EmployeeDatabase.newUser(email, password, fname, lname, phone, address, city, state , zip);
	}

	public void deleteMember(int memberID) {
		EmployeeDatabase.deleteMember(memberID);
	}

	public JTable getEmployeeInformation() {
		return EmployeeDatabase.getEmployeeInformation(getEmployeeEmail());
	}

	public void addActor(String actorID, String fname, String lname){
		EmployeeDatabase.addActor(actorID, fname, lname);
	}

	public void deleteActor(String actorID){
		EmployeeDatabase.deleteActor(actorID);
	}

	public void updateEmail(String email) {
		EmployeeDatabase.updateEmployeeEmail(getEmployeeEmail(), email);
		setEmployeeEmail(email);
	}

	public void updatePassword(String password) {
		EmployeeDatabase.updateEmployeePassword(getEmployeeEmail(), password);
		setEmployeePassword(password);
	}
	public JTable getAllMembers() {
		return EmployeeDatabase.getAllMembers();
	}
	public JTable getAllMovies() {
		return EmployeeDatabase.getAllMovies();
	}
	public JTable getAllActors() {
		return EmployeeDatabase.getAllActors();
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public String getEmployeePassword(){
		return employeePassword;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
}
