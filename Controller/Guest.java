package Controller;

import Model.GuestDatabase;
import javax.swing.JTable;


public class Guest {

	public Guest(){
	}

	public JTable search(String searchData){
		return GuestDatabase.search(searchData);
	}

	public JTable randomMovie() {
		return GuestDatabase.randomMovie();
	}

	public JTable randomGenre(String genre) {
		return GuestDatabase.randomGenre(genre);
	}
}
