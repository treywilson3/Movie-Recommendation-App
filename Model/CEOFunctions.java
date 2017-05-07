package Model;
import java.math.BigDecimal;
import javax.swing.JTable;

/**
 * @author Trey
 * This class encompasses all the functions the ceo can do
 * and will then call the appropraite database method
 */
public class CEOFunctions {
	private String ceoEmail;
	private String ceoPassword;
	
	/**
	 * Get the ceo's email and password
	 * @param email - ceo email
	 * @param password - ceo password
	 */
	public CEOFunctions(String email, String password) {
		ceoEmail = email;
		ceoPassword = password;
	}
	/**
	 * Create movie 
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
	 * add a member
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
		return Database.getEmployeeInformation(ceoEmail);
	}
	/** add an
	 * add an employee
	 * @param eemail
	 * @param epassword
	 * @param hireDate
	 * @param fname
	 * @param lname
	 * @param jobLocation
	 * @param position
	 * @param salary
	 */
	public void addEmployee(String eemail, String epassword, String hireDate, String fname, String lname,
			String jobLocation, String position, BigDecimal salary){
		Database.addEmployee(eemail, epassword, hireDate, fname, lname, jobLocation, position, salary);
	}
	/**
	 * delete an employee
	 * @param employeeID
	 */
	public void deleteEmployee(int employeeID){
		Database.deleteEmployee(employeeID);
	}
	/**
	 * add an actor
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
	 * update email
	 * @param email - new email
	 */
	public void updateEmail(String email) {
		Database.updateEmployeeEmail(ceoEmail, email);
		ceoEmail = email;		
	}
	/**
	 * update password 
	 * @param password - new password
	 */
	public void updatePassword(String password) {
		Database.updateEmployeePassword(ceoEmail, password);
		ceoPassword = password;
	}
	public JTable getAllEmployees() {
		return Database.getAllEmployees();	
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
