package Model;
import javax.swing.JTable;

/**
 * @author Trey
 * Employee Functions encompasses all the functions an employee
 * can do
 */
public class EmployeeFunctions {
	private String employeeEmail, employeePassword;

	/**
	 * Get employee email and password
	 * @param email
	 * @param password
	 */
	public EmployeeFunctions(String email, String password) {
		this.employeeEmail = email;
		this.employeePassword = password;
	}
	/**
	 * add movie
	 * @param movieID
	 * @param title
	 * @param rating
	 * @param genre
	 * @param releaseDate
	 */
	public void addMovie(String movieID, String title, String rating, String genre, String releaseDate) {
		Database.addMovie(movieID, title, rating, genre, releaseDate);
	}

	/**
	 * delete movie
	 * @param deleteMovieID
	 */
	public void deleteMovie(String deleteMovieID) {
		Database.deleteMovie(deleteMovieID);
	}

	/**
	 * add a mebmer
	 * @param email
	 * @param password
	 * @param fname
	 * @param lname
	 * @param phone
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 */
	public void addMember(String email, String password, String fname, String lname, String phone, String address, String city,
			String state, String zip) {
		Database.newUser(email, password, fname, lname, phone, address, city, state , zip);
	}
	
	/**
	 * delete a member
	 * @param memberID
	 */
	public void deleteMember(int memberID) {
		Database.deleteMember(memberID);
	}
	
	/**
	 * get employee information
	 * @return jtable with employee information
	 */
	public JTable getEmployeeInformation() {
		return Database.getEmployeeInformation(employeeEmail);
	}
	/**
	 * add and actor
	 * @param actorID
	 * @param fname
	 * @param lname
	 */
	public void addActor(String actorID, String fname, String lname){
		Database.addActor(actorID, fname, lname);
	}
	/**
	 * delete an actor
	 * @param actorID
	 */
	public void deleteActor(String actorID){
		Database.deleteActor(actorID);
	}

	/**
	 * update employee email 
	 * @param email - new email
	 */
	public void updateEmail(String email) {
		Database.updateEmployeeEmail(employeeEmail, email);
		employeeEmail = email;
	}

	/**
	 * update employee password 
	 * @param password - new password
	 */
	public void updatePassword(String password) {
		Database.updateEmployeePassword(employeeEmail, password);
		employeePassword = password;
	}
	public JTable getAllMembers() {
		return Database.getAllMembers();
	}
	public JTable getAllMovies() {
		return Database.getAllMovies();
	}
	public JTable getAllActors() {
		return Database.getAllActors();
	}


}
