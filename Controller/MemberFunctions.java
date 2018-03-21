package Controller;

import Model.MemberDatabase;
import javax.swing.JTable;

public class MemberFunctions {
	private String memberEmail;
	private String memberPassword;

	public MemberFunctions(String memberEmail, String memberPassword) {
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
	}

	public void addToWatch(String movieToWatch) {
		MemberDatabase.addToWatch(getMemberEmail(), movieToWatch);
	}

	public void addWatched(String movieWatched, String dayWatched) {
		MemberDatabase.addWatchHistory(getMemberEmail(), movieWatched, dayWatched);
	}

	public void addFavoriteMovies(String movieFav) {
		MemberDatabase.addFavoriteMovie(getMemberEmail(), movieFav);
	}

	public JTable search(String searchData) {
		return MemberDatabase.search(searchData);
	}

	public JTable randomMovie() {
		return MemberDatabase.randomMovie();
	}

	public JTable toWatchList(){
		return MemberDatabase.toWatch(getMemberEmail());
	}

	public JTable watchHistoryList(){
		return MemberDatabase.watchHistory(getMemberEmail());
	}

	public JTable favoriteMoviesList(){
		return MemberDatabase.favoriteMovies(getMemberEmail());
	}

	public JTable getMemberInformation(){
		return MemberDatabase.getMemberInformation(getMemberEmail());
	}

	public void updatePhone(String memberPhoneNumber){
		MemberDatabase.updateMemberPhone(getMemberEmail(), memberPhoneNumber);
	}

	public void updateAddress(String memberAddress, String cityFinal, String stateFinal, String zipFinal){
		MemberDatabase.updateMemberAddress(getMemberEmail(), memberAddress, cityFinal, stateFinal, zipFinal);
	}

	public JTable randomGenre(String genre) {
		return MemberDatabase.randomGenre(genre);
	}

	public void deleteAccount(String memberEmail) {
		MemberDatabase.deleteAccount(memberEmail);
	}

	public JTable recommendations() {
		return MemberDatabase.recommendations(getMemberEmail());
	}

	public void updateEmail(String email) {
		MemberDatabase.updateMemberEmail(getMemberEmail(), email);
		setMemberEmail(email);
	}

	public void updatePassword(String password) {
		MemberDatabase.updateMemberPassword(getMemberEmail(), password);
		setMemberPassword(password);
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
}
