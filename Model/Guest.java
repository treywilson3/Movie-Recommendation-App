package Model;
import javax.swing.JTable;

/**
 * guest encompasses all functions that a guest can do
 * @author Trey
 *
 */
public class Guest {
	
	/**
	 * empty constructor
	 */
	public Guest(){
	}
	
	/**
	 * 
	 * @param searchData - what the member wants to search
	 * @return jtable with matched information the member search
	 */
	public JTable search(String searchData){
		return Database.search(searchData);
	}
	/**
	 * a complete random movie is returned
	 * @return jtable with complete random movie
	 */
	public JTable randomMovie() {
		return Database.randomMovie();
	}

	/**
	 * member gets to pick genre that will have that random genre
	 * chosen
	 * @param genre - member chosen genre
	 * @return jtable with randomly matched genre
	 */
	public JTable randomGenre(String genre) {
		return Database.randomGenre(genre);
	}
}
