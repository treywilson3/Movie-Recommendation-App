package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Model.MemberFunctions;

/**
 * @author Trey
 * MemberPanel is the panel that the member uses
 * To update, change, search
 */
public class MemberPanel extends JPanel {
	// Member Information and memberFunction class
	private MemberFunctions memberFunctions;
	private String memberEmail;
	private String memberPassword;
	
	// Table shown when member searches
	private JTable searchTable;

	// Main Screen options
	private JButton random;
	private JButton storedData;
	private JButton settings;
	private JButton search;
	private TextField searchBar;
	private String searchBarPrompt;

	// Buttons for member to press when addding to list
	private JButton toWatch;
	private JButton watchHistory;
	private JButton favoriteMovies;

	// Buttons for members movie lists
	private JButton toWatchList;
	private JButton watchHistoryList;
	private JButton favoriteMoviesList;
	private JButton recommendations;
	private JButton memberInformation;

	// Settings Choices
	private JButton updatePhone;
	private JButton updateAddress;
	private JButton updateEmail;
	private JButton updatePassword;
	private JButton deleteAccount;

	// Add to lists buttons
	private JButton submitToWatch;
	private JButton submitWatchHistory;
	private JButton submitFavorite;

	
	// Updating phone number
	private TextField phoneText;
	private String phoneTextPrompt;
	private JButton submitPhone;

	// Updating address
	private TextField addressText;
	private String addressTextPrompt;
	private TextField addCityText;
	private String addCityTextPrompt;
	private TextField addStateText;
	private String addStateTextPrompt;
	private TextField addZipText;
	private String addZipTextPrompt;
	private JButton submitAddress;

	// Updating email
	private TextField emailText;
	private String emailTextPrompt;
	private JButton submitEmail;

	// Updating password
	private TextField passwordText;
	private String passwordTextPrompt;
	private JButton submitPassword;

	// Button to go home and a optional label
	private JButton homeButton;
	private JLabel restartLabel;

	private GridBagConstraints c;

	// random button/genre
	private DefaultComboBoxModel<String> genreChoiceModel;
	private JComboBox<String> genreChoiceBox;
	private JButton randomButton;
	private JButton go;
	
	private ActionListener myInnerClass;
	private FocusListener myFocusListener;
	
	/**
	 * Set the layout, get the memberEmail and password
	 * Call memberFunctions (the model) and then call
	 * the main member page
	 * @param memberEmail
	 * @param memberPassword
	 */
	public MemberPanel(String memberEmail, String memberPassword) {
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		
		myInnerClass = new MyActionListener();
		myFocusListener = new MyFocusListener();
		
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		memberFunctions = new MemberFunctions(this.memberEmail, this.memberPassword);
		memberPage();

	}
	/**
	 * homeButton will be called whenever the member chooses
	 * a method that needs to have access to back to the home
	 * screen. 
	 * @param text - Could use text to make a jlabel that would
	 * tell user what they did (ex: You successfully updated your
	 * phone number).
	 */
	public void homeButton(String text) {
		resetScreen();
		restartLabel = new JLabel();
		restartLabel.setText(text);
		homeButton = new JButton("Home");

		c.fill = GridBagConstraints.CENTER;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(restartLabel, c);
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 7;
		c.gridy = 1;
		add(homeButton, c);
		
		homeButton.addActionListener(myInnerClass);
	}
	/**
	 * memberPage is the homescreen and is called from constructor
	 * also homebutton will bring member back to this page
	 */
	public void memberPage() {
		resetScreen();
		
		random = new JButton("Random");
		storedData = new JButton("Stored Data");
		settings = new JButton("Settings");
		search = new JButton("Search");
		searchBar = new TextField(40);
		searchBarPrompt = "Search any Title, Actor, Genre";
		searchBar.setText(searchBarPrompt);
		searchBar.setForeground(Color.GRAY);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(random, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		add(storedData, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 3;
		c.gridy = 0;
		add(settings, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(20, 20, 20, 20); // side padding
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 2;
		add(searchBar, c);
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(20, 20, 20, 20); // side padding
		c.gridx = 3;
		c.gridy = 3;
		add(search, c);
		
		random.addActionListener(myInnerClass);
		storedData.addActionListener(myInnerClass);
		settings.addActionListener(myInnerClass);
		search.addActionListener(myInnerClass);
		searchBar.addFocusListener(myFocusListener);

	}
	
	/**
	 * toWatch will allow the user to enter their movie title
	 * for them to add to their toWatch
	 */
	public JButton toWatch() {	
		submitToWatch = new JButton("To Watch");
		submitToWatch.addActionListener(myInnerClass);
		return submitToWatch;
	}
	/**
	 * watchHistory allows the member to enter their title
	 * to add to their watched list. They need to enter
	 * the date watched as well
	 */
	public JButton watchHistory() {
		submitWatchHistory = new JButton("Watched");
		submitWatchHistory.addActionListener(myInnerClass);
		return submitWatchHistory;

	}
	/**
	 * favoriteMovies allows member to enter title of 
	 * movie that the member wants to favorite
	 */
	public JButton favoriteMovies() {
		submitFavorite = new JButton("Favorite Movie");		
		submitFavorite.addActionListener(myInnerClass);
		return submitFavorite;
	}
	public void addButtons(){
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.ipadx = 20;
		//c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 7;
		c.gridy = 2;
		add(toWatch(), c);
		
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.ipadx = 20;
		//c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 7;
		c.gridy = 3;
		add(watchHistory(), c);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.ipadx = 20;
		//c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 7;
		c.gridy = 4;
		add(favoriteMovies(), c);
	}
	/**
	 * random() allows the user to either get a completley
	 * random movie or allow the user to pick a genre to
	 * be randomized
	 */
	public void random() {	
		resetScreen();
		
		randomButton = new JButton("Random");
		go = new JButton("Go");
		genreChoiceBox = new JComboBox<String>();
		genreChoiceModel = new DefaultComboBoxModel<String>();
		
		// Set all genres
		genreChoiceModel.addElement("Thrillers");
		genreChoiceModel.addElement("Comedy");
		genreChoiceModel.addElement("Romantic Comedies");
		genreChoiceModel.addElement("Documentaries");
		genreChoiceModel.addElement("Horror");
		genreChoiceModel.addElement("Fantasy");
		genreChoiceModel.addElement("Family");
		genreChoiceModel.addElement("Drama");
		genreChoiceModel.addElement("Action");
		genreChoiceModel.addElement("Parodies");
		genreChoiceBox.setModel(genreChoiceModel);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(randomButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(genreChoiceBox, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 0;
		add(go, c);
		
		randomButton.addActionListener(myInnerClass);
		go.addActionListener(myInnerClass);
	}
	/**
	 * storedData shows member choices to see of their
	 * stored data. 
	 */
	public void storedData() {	
		resetScreen();
		
		toWatchList = new JButton("To Watch List");
		watchHistoryList = new JButton("Watch History List");
		favoriteMoviesList = new JButton("Favorite Movies List");
		recommendations = new JButton("Recommendations");
		memberInformation = new JButton("Member Information");
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(toWatchList, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 0;
		add(watchHistoryList, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 3;
		c.gridy = 0;
		add(favoriteMoviesList, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 4;
		c.gridy = 0;
		add(recommendations, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 5;
		c.gridy = 0;
		add(memberInformation, c);
		
		toWatchList.addActionListener(myInnerClass);
		watchHistoryList.addActionListener(myInnerClass);
		favoriteMoviesList.addActionListener(myInnerClass);
		recommendations.addActionListener(myInnerClass);
		memberInformation.addActionListener(myInnerClass);
	}
	
	/**
	 * settings shows the member their choices of updating 
	 * or deleting aspects of their account
	 */
	public void settings() {
		resetScreen();
		
		updatePhone = new JButton("Update Phone");
		updateAddress = new JButton("Update Address");
		updateEmail = new JButton("Update Email");
		updatePassword = new JButton("Update Password");
		deleteAccount = new JButton("Delete Account");
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(updatePhone, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(updateAddress, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 0;
		add(updateEmail, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 3;
		c.gridy = 0;
		add(updatePassword, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 4;
		c.gridy = 0;
		add(deleteAccount, c);
		
		updatePhone.addActionListener(myInnerClass);
		updateAddress.addActionListener(myInnerClass);
		updateEmail.addActionListener(myInnerClass);
		updatePassword.addActionListener(myInnerClass);
		deleteAccount.addActionListener(myInnerClass);
	}
	
	/**
	 * updatePhone allows the member to update their phone
	 */
	public void updatePhone() {	
		resetScreen();
		
		phoneText = new TextField(40);
		phoneText.setForeground(Color.GRAY);
		phoneTextPrompt = "Enter New Phone Number";
		phoneText.setText(phoneTextPrompt);
		submitPhone = new JButton("Submit");

		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(phoneText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(submitPhone, c);
		
		submitPhone.addActionListener(myInnerClass);
		phoneText.addFocusListener(myFocusListener);
	}
	/**
	 * update address allows the user to update all
	 * aspects of their address
	 */
	public void updateAddress() {	
		resetScreen();
		
		addressText = new TextField(40);
		addressText.setForeground(Color.GRAY);
		addressTextPrompt = "Enter New Address";
		addressText.setText(addressTextPrompt);
		addCityText = new TextField(20);
		addCityText.setForeground(Color.GRAY);
		addCityTextPrompt = "Enter Your City";
		addCityText.setText(addCityTextPrompt);
		addStateText = new TextField(10);
		addStateText.setForeground(Color.GRAY);
		addStateTextPrompt = "Enter Your State (2)";
		addStateText.setText(addStateTextPrompt);
		addZipText = new TextField(10);
		addZipText.setForeground(Color.GRAY);
		addZipTextPrompt = "Enter Your Zipcode (5)";
		addZipText.setText(addZipTextPrompt);	
		submitAddress = new JButton("Submit");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addressText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 1;
		add(addCityText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 2;
		add(addStateText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 3;
		add(addZipText, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 4;
		add(submitAddress, c);
		
		submitAddress.addActionListener(myInnerClass);
		addressText.addFocusListener(myFocusListener);
		addCityText.addFocusListener(myFocusListener);
		addStateText.addFocusListener(myFocusListener);
		addZipText.addFocusListener(myFocusListener);
	}
	/**
	 * updateEmail allows the member to update their email
	 */
	public void updateEmail() {
		resetScreen();
		
		emailText = new TextField(40);
		emailText.setForeground(Color.GRAY);
		emailTextPrompt = "Enter New Email";
		emailText.setText(emailTextPrompt);
		submitEmail = new JButton("Submit");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(emailText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(submitEmail, c);
		
		submitEmail.addActionListener(myInnerClass);
		emailText.addFocusListener(myFocusListener);
	}
	/**
	 * updatePassword will allow the member to update their password
	 */
	public void updatePassword() {
		resetScreen();
		
		passwordText = new TextField(40);
		passwordText.setForeground(Color.GRAY);
		passwordText.setText("Enter New Password");
		submitPassword = new JButton("Submit");
	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(passwordText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(submitPassword, c);
		
		submitPassword.addActionListener(myInnerClass);
		passwordText.addFocusListener(myFocusListener);
	}
	/**
	 * deleteAccount will allow user to delete their account
	 */
	public void deleteAccount() {
		int action = JOptionPane.showConfirmDialog(this, "Do you really want to delete your account?",
				"Confirm Account Deletion", JOptionPane.OK_CANCEL_OPTION);
		if (action == JOptionPane.OK_OPTION) {
			memberFunctions.deleteAccount(memberEmail);
			System.exit(0);
		} else {
			homeButton("");
		}

	}
	/**
	 * resetScreen is needed to update screen
	 */
	public void resetScreen(){
		removeAll();
		repaint();
		revalidate();
	}
	public JTable getSearchTable(){
		return searchTable;
	}
	public void confirmMessage(String prompt){
		JOptionPane.showMessageDialog(this, prompt);
	}

	/**
	 * @author Trey
	 * If submit button is pressed, then the correct DatabaseModel
	 * method will be called to enter the database information
	 * If not submit button, then the correct method will be called
	 */
	public class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == random) {
				homeButton("");
				random();
			} else if (e.getSource() == storedData) {
				homeButton("");
				storedData();
			} else if (e.getSource() == settings) {
				homeButton("");
				settings();
			} else if (e.getSource() == randomButton) {
				homeButton("");
				c.fill = GridBagConstraints.NONE;
				addButtons();
				JTable table = memberFunctions.randomMovie();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == go) {
				String genre = (String) genreChoiceBox.getSelectedItem();
				homeButton("");
				addButtons();
				JTable table = memberFunctions.randomGenre(genre);
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == toWatch) {
				homeButton("");
				toWatch();
			} else if (e.getSource() == submitToWatch) {
				if (getSearchTable().getSelectedRow() != -1){
					String toWatchFinal = searchTable.getValueAt(getSearchTable().getSelectedRow(), 0).toString();
					memberFunctions.addToWatch(toWatchFinal);	
					confirmMessage(toWatchFinal + " has been added to your 'To Watch List'");
				}
				
			} else if (e.getSource() == watchHistory) {
				homeButton("");
				watchHistory();
			} else if (e.getSource() == submitWatchHistory) {
				if (getSearchTable().getSelectedRow() != -1){
					String watchedFinal = searchTable.getValueAt(getSearchTable().getSelectedRow(), 0).toString();
					memberFunctions.addWatched(watchedFinal, "1995-07-01");		
					confirmMessage(watchedFinal + " has been added to your 'Watched List'");
				}
			} else if (e.getSource() == favoriteMovies) {
				homeButton("");
				favoriteMovies();
			} else if (e.getSource() == submitFavorite) {
				if (getSearchTable().getSelectedRow() != -1){
					String favoriteFinal = searchTable.getValueAt(getSearchTable().getSelectedRow(), 0).toString();
					memberFunctions.addFavoriteMovies(favoriteFinal);
					confirmMessage(favoriteFinal + " has been added to your 'Favorites List'");
				}
				
			} else if (e.getSource() == toWatchList) {
				homeButton("");
				JTable table = memberFunctions.toWatchList();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == watchHistoryList) {
				homeButton("");
				JTable table = memberFunctions.watchHistoryList();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == recommendations) {
				homeButton("");
				JTable table = memberFunctions.recommendations();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == favoriteMoviesList) {
				homeButton("");
				JTable table = memberFunctions.favoriteMoviesList();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == memberInformation) {
				homeButton("");
				JTable table = memberFunctions.getMemberInformation();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == updatePhone) {
				homeButton("");
				updatePhone();
			} else if (e.getSource() == submitPhone) {
				String phoneFinal = (String) phoneText.getText();
				memberFunctions.updatePhone(phoneFinal);
				homeButton("");
			} else if (e.getSource() == updateAddress) {
				homeButton("");
				updateAddress();
			} else if (e.getSource() == submitAddress) {
				String addressFinal = (String) addressText.getText();
				String cityFinal = (String) addCityText.getText();
				String stateFinal = (String) addStateText.getText();
				String zipFinal = (String) addZipText.getText();
				memberFunctions.updateAddress(addressFinal, cityFinal, stateFinal, zipFinal);
				homeButton("");
			} else if (e.getSource() == updateEmail) {
				updateEmail();
			} else if (e.getSource() == submitEmail) {
				String email = (String) emailText.getText();
				memberFunctions.updateEmail(email);
				memberEmail = email;
				homeButton("");
			} else if (e.getSource() == updatePassword) {
				updatePassword();
			} else if (e.getSource() == submitPassword) {
				String password = (String) passwordText.getText();
				memberFunctions.updatePassword(password);
				memberPassword = password;
				homeButton("");
			} else if (e.getSource() == deleteAccount) {
				deleteAccount();
			} else if (e.getSource() == homeButton) {
				memberPage();
			} else if (e.getSource() == search) {
				String searchData = (String) searchBar.getText();
				homeButton("");
				addButtons();
				searchTable = memberFunctions.search(searchData);
				JScrollPane pane = new JScrollPane(searchTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				searchTable.setAutoResizeMode(searchTable.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
				
			}
		}
	}

	/**
	 * @author Trey If the textbox is clicked, then set the text to empty so the
	 *         user doesn't have to clear it. Also, set the text color to black
	 *         (it was gray for the prompt) that way it is more aesthetically
	 *         pleasing. If the textbox was clicked in but the user did not type
	 *         anything, then set the color back to gray and present the prompt.
	 */
	public class MyFocusListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			if (e.getSource() == searchBar) {
				searchBar.setForeground(Color.BLACK);
				if (searchBar.getText().equals(searchBarPrompt)) {
					searchBar.setText("");
				}
			}else if (e.getSource() == phoneText) {
				phoneText.setForeground(Color.BLACK);
				if (phoneText.getText().equals(phoneTextPrompt)) {
					phoneText.setText("");
				}
			} else if (e.getSource() == addressText) {
				addressText.setForeground(Color.BLACK);
				if (addressText.getText().equals(addressTextPrompt)) {
					addressText.setText("");
				}
			} else if (e.getSource() == addCityText) {
				addCityText.setForeground(Color.BLACK);
				if (addCityText.getText().equals(addCityTextPrompt)) {
					addCityText.setText("");
				}
			} else if (e.getSource() == addStateText) {
				addStateText.setForeground(Color.BLACK);
				if (addStateText.getText().equals(addStateTextPrompt)) {
					addStateText.setText("");
				}
			} else if (e.getSource() == addZipText) {
				addZipText.setForeground(Color.BLACK);
				if (addZipText.getText().equals(addZipTextPrompt)) {
					addZipText.setText("");
				}
			} else if (e.getSource() == emailText) {
				emailText.setForeground(Color.BLACK);
				if (emailText.getText().equals(emailTextPrompt)) {
					emailText.setText("");
				}
			} else if (e.getSource() == passwordText) {
				passwordText.setForeground(Color.BLACK);
				if (passwordText.getText().equals(passwordTextPrompt)) {
					passwordText.setText("");
				}
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (e.getSource() == searchBar) {
				if (searchBar.getText().length() == 0) {
					searchBar.setForeground(Color.GRAY);
					searchBar.setText(searchBarPrompt);
				}
			} else if (e.getSource() == phoneText) {
				if (phoneText.getText().length() == 0) {
					phoneText.setForeground(Color.GRAY);
					phoneText.setText(phoneTextPrompt);
				}
			} else if (e.getSource() == addressText) {
				if (addressText.getText().length() == 0) {
					addressText.setForeground(Color.GRAY);
					addressText.setText(addressTextPrompt);
				}
			} else if (e.getSource() == addCityText) {
				if (addCityText.getText().length() == 0) {
					addCityText.setForeground(Color.GRAY);
					addCityText.setText(addCityTextPrompt);
				}
			} else if (e.getSource() == addStateText) {
				if (addStateText.getText().length() == 0) {
					addStateText.setForeground(Color.GRAY);
					addStateText.setText(addStateTextPrompt);
				}
			} else if (e.getSource() == addZipText) {
				if (addZipText.getText().length() == 0) {
					addZipText.setForeground(Color.GRAY);
					addZipText.setText(addZipTextPrompt);
				}
			} else if (e.getSource() == emailText) {
				if (emailText.getText().length() == 0) {
					emailText.setForeground(Color.GRAY);
					emailText.setText(emailTextPrompt);
				}
			} else if (e.getSource() == passwordText) {
				if (passwordText.getText().length() == 0) {
					passwordText.setForeground(Color.GRAY);
					passwordText.setText(passwordTextPrompt);
				}
			}
		}
	}
}
