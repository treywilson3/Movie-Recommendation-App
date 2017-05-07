package Model;
import javax.swing.JTable;

/** @author Trey
 * memberFunctions encompasses all functions that a member can do
 */
public class MemberFunctions {
	private String memberEmail;
	private String memberPassword;

	/**
	 * Get member email and password
	 * @param email
	 * @param password
	 */
	public MemberFunctions(String memberEmail, String memberPassword) {
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
	}
	/**
	 * member can movie to their to watch list
	 * @param movieToWatch
	 */
	public void addToWatch(String movieToWatch) {
		Database.addToWatch(memberEmail, movieToWatch);

	}
	/**
	 * member can add movie to watched
	 * @param movieWatched
	 * @param dayWatched
	 */
	public void addWatched(String movieWatched, String dayWatched) {
		Database.addWatchHistory(memberEmail, movieWatched, dayWatched);
	}
	/**
	 * member can add movie to favorite movies
	 * @param movieFav
	 */
	public void addFavoriteMovies(String movieFav) {
		Database.addFavoriteMovie(memberEmail, movieFav);
	}
	
	/**
	 * member can search for any movie attributes in database
	 * @param searchData - member entered data
	 * @return jtable with matched data
	 */
	public JTable search(String searchData) {
		return Database.search(searchData);
	}
	/**
	 * member gets presented with random movie
	 * @return jtable with random movie information
	 */
	public JTable randomMovie() {
		return Database.randomMovie();
	}
	/**
	 * member can see their to watch list
	 * @return jtable with to watch list
	 */
	public JTable toWatchList(){
		return Database.toWatch(memberEmail);
	}
	/**
	 * member can see their watch history list
	 * @return jtable with watched list
	 */
	public JTable watchHistoryList(){
		return Database.watchHistory(memberEmail);
	}
	/**
	 * member can see their favorite movie list
	 * @return jtable with favorite movie list
	 */
	public JTable favoriteMoviesList(){
		return Database.favoriteMovies(memberEmail);
	}
	/**
	 * member can see all their account information
	 * @return jtable with all member information
	 */
	public JTable getMemberInformation(){
		return Database.getMemberInformation(memberEmail);
	}
	/**
	 * allows member to update their phone number 
	 * @param memberPhoneNumber - new phone number
	 */
	public void updatePhone(String memberPhoneNumber){
		Database.updateMemberPhone(memberEmail, memberPhoneNumber);
	}
	/**
	 * allows member to update their address
	 * @param memberAddress - new address
	 * @param cityFinal - new city
	 * @param stateFinal - new state
	 * @param zipFinal - new zip
	 */
	public void updateAddress(String memberAddress, String cityFinal, String stateFinal, String zipFinal){
		Database.updateMemberAddress(memberEmail, memberAddress, cityFinal, stateFinal, zipFinal);
	}
	
	/**
	 * member gets to genre to have randomly movie chosen
	 * @param genre - member chosen genre
	 * @return
	 */
	public JTable randomGenre(String genre) {
		return Database.randomGenre(genre);
	}
	/**
	 * member can delete their account
	 * @param memberEmail - member email to be deleted
	 */
	public void deleteAccount(String memberEmail) {
		Database.deleteAccount(memberEmail);	
	}
	/**
	 * member can see their recommendations list
	 * @return jtable with recommendations
	 */
	public JTable recommendations() {
		return Database.recommendations(memberEmail);
	}
	/**
	 * member can update their email
	 * @param email - new email
	 */
	public void updateEmail(String email) {
		Database.updateMemberEmail(memberEmail, email);
		memberEmail = email;
		
	}
	/**
	 * member can update their password 
	 * @param password - new password
	 */
	public void updatePassword(String password) {
		Database.updateMemberPassword(memberEmail, password);
		memberPassword = password;
	}

}
