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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.EmployeeFunctions;

/**
 * @author Trey Employee Panel has all buttons that an amployee will need.
 * 
 */
public class EmployeePanel extends JPanel {

	// Choices
	private JButton addMembers;
	private JButton addMovies;
	private JButton addActors;
	private JButton settings;

	// Add/Delete Choices
	private JButton addMovie;
	private JButton deleteMovie;
	private JButton addMember;
	private JButton deleteMember;
	private JButton employeeInformation;
	
	// Adding a movie
	private TextField movieIDText;
	private String movieIDTextPrompt;
	private TextField movieTitleText;
	private String movieTitleTextPrompt;
	private TextField movieRatingText;
	private String movieRatingTextPrompt;
	private TextField movieGenreText;
	private String movieGenreTextPrompt;
	private TextField movieReleaseDateText;
	private String movieReleaseDateTextPrompt;
	private JButton submitAddMovie;

	// Add member
	private TextField addMemberEmail;
	private String addMemberEmailPrompt;
	private TextField addMemberPassword;
	private String addMemberPasswordPrompt;
	private TextField addMemberFirstNameText;
	private String addMemberFirstNameTextPrompt;
	private TextField addMemberLastNameText;
	private String addMemberLastNameTextPrompt;
	private TextField addPhoneText;
	private String addPhoneTextPrompt;
	private TextField addAddressText;
	private String addAddressTextPrompt;
	private TextField addCityText;
	private String addCityTextPrompt;
	private TextField addStateText;
	private String addStateTextPrompt;
	private TextField addZipText;
	private String addZipTextPrompt;
	private JButton submitAddMember;

	// Table presented for all movies and button
	// to delete movie
	private JTable getAllMovies;
	private JButton submitDeleteMovie;
	
	// Table to present all members and button to 
	// delete a member
	private JTable getAllMembers;
	private JButton submitDeleteMember;
	
	// Table to present all actors and button to
	// delete an actor
	private JTable getAllActors;
	private JButton submitDeleteActor;

	// Buttons and fields need for adding actor
	private TextField addActorIDText;
	private String addActorIDTextPrompt;
	private TextField addActorFirstNameText;
	private String addActorFirstNameTextPrompt;
	private TextField addActorLastNameText;
	private String addActorLastNameTextPrompt;
	private JButton submitAddActor;

	// Settings
	private JButton updateEmail;
	private JButton updatePassword;
	private TextField emailText;
	private String emailTextPrompt;
	private JButton submitEmail;
	private TextField passwordText;
	private String passwordTextPrompt;
	private JButton submitPassword;

	// Functions employee can do
	private EmployeeFunctions employeeFunctions;

	// Home button and optional label
	private JButton homeButton;
	private JLabel restartLabel;

	// Layout
	private GridBagConstraints c;

	// Add delete actor buttons
	private JButton addActorButton;
	private JButton deleteActorButton;

	// Listeners
	private ActionListener myInnerClass;
	private FocusListener myFocusListener;

	/**
	 * Constructor get employee Email and password. See if employee is ceo, if
	 * ceo, then load ceo page else employee page Ceo also has more functions
	 * than employee which will be properly opened
	 * 
	 * @param employeeEmail
	 * @param employeePassword
	 */
	public EmployeePanel(String employeeEmail, String employeePassword) {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		myInnerClass = new MyActionListener();
		myFocusListener = new MyFocusListener();
		employeeFunctions = new EmployeeFunctions(employeeEmail, employeePassword);
		employeePage();

	}

	/**
	 * If not ceo, load employeepage. Home screen for employee
	 */
	public void employeePage() {
		resetScreen();

		addMovies = new JButton("Add/Delete Movies");
		addMembers = new JButton("Add/Delete Members");
		addActors = new JButton("Add/Delete Actors");
		settings = new JButton("Settings");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addMovies, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(addMembers, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 0;
		add(addActors, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 3;
		c.gridy = 0;
		add(settings, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 4;
		c.gridy = 0;

		addMovies.addActionListener(myInnerClass);
		addMembers.addActionListener(myInnerClass);
		addActors.addActionListener(myInnerClass);
		settings.addActionListener(myInnerClass);
	}

	/**
	 * Take ceo or employee back to their home page
	 * 
	 * @param text
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
		c.gridx = 0;
		c.gridy = 2;
		add(homeButton, c);

		homeButton.addActionListener(myInnerClass);

	}

	/**
	 * panel that shows buttons to add or delete a movie
	 */
	public void addMoviesPanel() {
		resetScreen();

		addMovie = new JButton("Add Movie");
		deleteMovie = new JButton("Delete Movie");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addMovie, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(deleteMovie, c);

		addMovie.addActionListener(myInnerClass);
		deleteMovie.addActionListener(myInnerClass);

	}

	/**
	 * Panel to have textfield to enter movie information
	 */
	public void addMovie() {
		resetScreen();

		movieIDText = new TextField(10);
		movieIDText.setForeground(Color.GRAY);
		movieIDTextPrompt = "Enter Movie ID (5)";
		movieIDText.setText(movieIDTextPrompt);
		movieTitleText = new TextField(40);
		movieTitleText.setForeground(Color.GRAY);
		movieTitleTextPrompt = "Enter Movie Title";
		movieTitleText.setText(movieTitleTextPrompt);
		movieRatingText = new TextField(10);
		movieRatingText.setForeground(Color.GRAY);
		movieRatingTextPrompt = "Enter Movie Rating (3)";
		movieRatingText.setText(movieRatingTextPrompt);
		movieGenreText = new TextField(10);
		movieGenreText.setForeground(Color.GRAY);
		movieGenreTextPrompt = "Enter Movie Genre";
		movieGenreText.setText(movieGenreTextPrompt);
		movieReleaseDateText = new TextField(10);
		movieReleaseDateText.setForeground(Color.GRAY);
		movieReleaseDateTextPrompt = "Enter Movie Release Date (yyyy)";
		movieReleaseDateText.setText(movieReleaseDateTextPrompt);
		submitAddMovie = new JButton("Submit");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(movieIDText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 1;
		add(movieTitleText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 2;
		add(movieRatingText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 3;
		add(movieGenreText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 4;
		add(movieReleaseDateText, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 5;
		add(submitAddMovie, c);

		submitAddMovie.addActionListener(myInnerClass);
		movieIDText.addFocusListener(myFocusListener);
		movieTitleText.addFocusListener(myFocusListener);
		movieRatingText.addFocusListener(myFocusListener);
		movieGenreText.addFocusListener(myFocusListener);
		movieReleaseDateText.addFocusListener(myFocusListener);
	}

	/**
	 * textfield and enter information to delete movie
	 * 
	 * @return
	 */
	public JButton deleteMovie() {
		submitDeleteMovie = new JButton("Delete");
		add(submitDeleteMovie, c);
		submitDeleteMovie.addActionListener(myInnerClass);
		return submitDeleteMovie;
	}

	/**
	 * panel to have buttons to add or delete members
	 */
	public void addMembersPanel() {
		resetScreen();

		addMember = new JButton("Add Member");
		deleteMember = new JButton("Delete Member");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addMember, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(deleteMember, c);

		addMember.addActionListener(myInnerClass);
		deleteMember.addActionListener(myInnerClass);
	}

	/**
	 * textfield to enter new member information
	 */
	public void addMember() {
		resetScreen();

		addMemberEmail = new TextField(20);
		addMemberEmail.setForeground(Color.GRAY);
		addMemberEmailPrompt = "Enter Member Email";
		addMemberEmail.setText(addMemberEmailPrompt);
		addMemberPassword = new TextField(20);
		addMemberPassword.setForeground(Color.GRAY);
		addMemberPasswordPrompt = "Enter Member Password";
		addMemberPassword.setText(addMemberPasswordPrompt);
		addMemberFirstNameText = new TextField(20);
		addMemberFirstNameText.setForeground(Color.GRAY);
		addMemberFirstNameTextPrompt = "Enter Member First Name";
		addMemberFirstNameText.setText(addMemberFirstNameTextPrompt);
		addMemberLastNameText = new TextField(20);
		addMemberLastNameText.setForeground(Color.GRAY);
		addMemberLastNameTextPrompt = "Enter Member Last Name";
		addMemberLastNameText.setText(addMemberLastNameTextPrompt);
		addPhoneText = new TextField(20);
		addPhoneText.setForeground(Color.GRAY);
		addPhoneTextPrompt = "Enter Member Phone";
		addPhoneText.setText(addPhoneTextPrompt);
		addAddressText = new TextField(40);
		addAddressText.setForeground(Color.GRAY);
		addAddressTextPrompt = "Enter Member Address";
		addAddressText.setText(addAddressTextPrompt);
		addCityText = new TextField(20);
		addCityText.setForeground(Color.GRAY);
		addCityTextPrompt = "Enter Member City";
		addCityText.setText(addCityTextPrompt);
		addStateText = new TextField(10);
		addStateText.setForeground(Color.GRAY);
		addStateTextPrompt = "Enter Member State (2)";
		addStateText.setText(addStateTextPrompt);
		addZipText = new TextField(10);
		addZipText.setForeground(Color.GRAY);
		addZipTextPrompt = "Enter Member Zipcode (5)";
		addZipText.setText(addZipTextPrompt);
		submitAddMember = new JButton("Submit");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addMemberEmail, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 1;
		add(addMemberPassword, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 2;
		add(addMemberFirstNameText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 3;
		add(addMemberLastNameText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 4;
		add(addPhoneText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 5;
		add(addAddressText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 6;
		add(addCityText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 7;
		add(addStateText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 8;
		add(addZipText, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 9;
		add(submitAddMember, c);

		submitAddMember.addActionListener(myInnerClass);
		addMemberEmail.addFocusListener(myFocusListener);
		addMemberPassword.addFocusListener(myFocusListener);
		addMemberFirstNameText.addFocusListener(myFocusListener);
		addMemberLastNameText.addFocusListener(myFocusListener);
		addPhoneText.addFocusListener(myFocusListener);
		addAddressText.addFocusListener(myFocusListener);
		addCityText.addFocusListener(myFocusListener);
		addStateText.addFocusListener(myFocusListener);
		addZipText.addFocusListener(myFocusListener);
	}

	/**
	 * textfield to enter delete member
	 */
	public JButton deleteMember() {
		submitDeleteMember = new JButton("Delete");
		add(submitDeleteMember, c);
		submitDeleteMember.addActionListener(myInnerClass);
		return submitDeleteMember;
	}

	/**
	 * panel that shows buttons to add or delete actors
	 */
	public void addActorPanel() {
		resetScreen();

		addActorButton = new JButton("Add Actor");
		deleteActorButton = new JButton("Delete Actor");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addActorButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(deleteActorButton, c);

		addActorButton.addActionListener(myInnerClass);
		deleteActorButton.addActionListener(myInnerClass);
	}

	/**
	 * textfield to enter new actor information
	 */
	public void addActor() {
		resetScreen();

		addActorIDText = new TextField(25);
		addActorIDText.setForeground(Color.GRAY);
		addActorIDTextPrompt = "Enter Actor ID (5)";
		addActorIDText.setText(addActorIDTextPrompt);
		addActorFirstNameText = new TextField(25);
		addActorFirstNameText.setForeground(Color.GRAY);
		addActorFirstNameTextPrompt = "Enter Actor First Name";
		addActorFirstNameText.setText(addActorFirstNameTextPrompt);
		addActorLastNameText = new TextField(25);
		addActorLastNameText.setForeground(Color.GRAY);
		addActorLastNameTextPrompt = "Enter Actor Last Name";
		addActorLastNameText.setText(addActorLastNameTextPrompt);
		submitAddActor = new JButton("Submit");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addActorIDText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 1;
		add(addActorFirstNameText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 2;
		add(addActorLastNameText, c);
		c.fill = GridBagConstraints.SOUTH;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 4;
		add(submitAddActor, c);

		submitAddActor.addActionListener(myInnerClass);
		addActorIDText.addFocusListener(myFocusListener);
		addActorFirstNameText.addFocusListener(myFocusListener);
		addActorLastNameText.addFocusListener(myFocusListener);
	}

	/**
	 * textfield to delete actor
	 */
	public JButton deleteActor() {
		submitDeleteActor = new JButton("Delete");
		add(submitDeleteActor, c);
		submitDeleteActor.addActionListener(myInnerClass);
		return submitDeleteActor;
	}

	/**
	 * panel that shows employee able to update information or get employee
	 * informaton
	 */
	public void settingsPanel() {
		resetScreen();

		updateEmail = new JButton("Update Email");
		updatePassword = new JButton("Update Password");
		employeeInformation = new JButton("Employee Information");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(updateEmail, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(updatePassword, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 0;
		add(employeeInformation, c);
		employeeInformation.addActionListener(myInnerClass);

		updateEmail.addActionListener(myInnerClass);
		updatePassword.addActionListener(myInnerClass);
	}

	/**
	 * allows employee to update email
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
	 * allows employee to update password
	 */
	public void updatePassword() {
		resetScreen();

		passwordText = new TextField(40);
		passwordText.setForeground(Color.GRAY);
		passwordTextPrompt = "Enter New Password";
		passwordText.setText(passwordTextPrompt);

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
	 * resetScreen is needed to update screen
	 */
	public void resetScreen() {
		removeAll();
		repaint();
		revalidate();
	}

	public void confirmMessage(String prompt) {
		JOptionPane.showMessageDialog(this, prompt);
	}

	public JTable getAllMembers() {
		return getAllMembers;
	}

	public JTable getAllMovies() {
		return getAllMovies;
	}

	public JTable getAllActors() {
		return getAllActors;
	}

	/**
	 * @author Trey If submit button is pressed, then the correct Database
	 *         method will be called to enter the database information If not
	 *         submit button, then the correct method will be called
	 */
	public class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addMovies) {
				addMoviesPanel();
			} else if (e.getSource() == addMembers) {
				addMembersPanel();
			} else if (e.getSource() == addActors) {
				addActorPanel();
			} else if (e.getSource() == settings) {
				settingsPanel();
			} else if (e.getSource() == addMovie) {
				addMovie();
			} else if (e.getSource() == employeeInformation) {
				homeButton("");

				JTable table = employeeFunctions.getEmployeeInformation();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				add(pane);
			} else if (e.getSource() == submitAddMovie) {
				String movieIDFinal = (String) movieIDText.getText();
				String titleFinal = (String) movieTitleText.getText();
				String ratingFinal = (String) movieRatingText.getText();
				String genreFinal = (String) movieGenreText.getText();
				String releaseDateFinal = (String) movieReleaseDateText.getText();
				// call employee method
				employeeFunctions.addMovie(movieIDFinal, titleFinal, ratingFinal, genreFinal, releaseDateFinal);
				confirmMessage(titleFinal + " has been added");
				homeButton("");
			} else if (e.getSource() == deleteMovie) {
				homeButton("");
				getAllMovies = employeeFunctions.getAllMovies();
				JScrollPane pane = new JScrollPane(getAllMovies, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				getAllMovies.setAutoResizeMode(getAllMovies.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
				c.fill = GridBagConstraints.NONE;
				c.ipady = 10;
				c.ipadx = 20;
				// c.insets = new Insets(0, 20, 20, 0); // side padding
				c.gridx = 0;
				c.gridy = 1;
				add(deleteMovie(), c);

			} else if (e.getSource() == submitDeleteMovie) {
				if (getAllMovies().getSelectedRow() != -1) {
					String movieIDFinal = getAllMovies().getValueAt(getAllMovies().getSelectedRow(), 0).toString();
					employeeFunctions.deleteMovie(movieIDFinal);
					((DefaultTableModel) getAllMovies().getModel()).removeRow(getAllMovies().getSelectedRow());
					confirmMessage(movieIDFinal + " has been removed from the Company Database");
				}
			} else if (e.getSource() == addMember) {
				addMember();
			} else if (e.getSource() == submitAddMember) {
				String memberE = (String) addMemberEmail.getText();
				String memberP = (String) addMemberPassword.getText();
				String fnameFinal = (String) addMemberFirstNameText.getText();
				String lnameFinal = (String) addMemberLastNameText.getText();
				String phoneFinal = (String) addPhoneText.getText();
				String addressFinal = (String) addAddressText.getText();
				String cityFinal = (String) addCityText.getText();
				String stateFinal = (String) addStateText.getText();
				String zipFinal = (String) addZipText.getText();
				// call method
				employeeFunctions.addMember(memberE, memberP, fnameFinal, lnameFinal, phoneFinal, addressFinal,
						cityFinal, stateFinal, zipFinal);
				confirmMessage(fnameFinal + " " + lnameFinal + " has been added");
				homeButton("");
			} else if (e.getSource() == deleteMember) {
				homeButton("");
				getAllMembers = employeeFunctions.getAllMembers();
				JScrollPane pane = new JScrollPane(getAllMembers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				getAllMembers.setAutoResizeMode(getAllMembers.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
				c.fill = GridBagConstraints.NONE;
				c.ipady = 10;
				c.ipadx = 20;
				// c.insets = new Insets(0, 20, 20, 0); // side padding
				c.gridx = 0;
				c.gridy = 2;
				add(deleteMember(), c);
			} else if (e.getSource() == submitDeleteMember) {
				if (getAllMembers().getSelectedRow() != -1) {
					int memberID = (int) getAllMembers().getValueAt(getAllMembers().getSelectedRow(), 0);
					employeeFunctions.deleteMember(memberID);
					((DefaultTableModel) getAllMembers().getModel()).removeRow(getAllMembers().getSelectedRow());
					confirmMessage(memberID + " has been removed from the Company Database");
				}
			} else if (e.getSource() == addActorButton) {
				addActor();
			} else if (e.getSource() == deleteActorButton) {
				homeButton("");
				getAllActors = employeeFunctions.getAllActors();
				JScrollPane pane = new JScrollPane(getAllActors, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				getAllActors.setAutoResizeMode(getAllActors.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
				c.fill = GridBagConstraints.NONE;
				c.ipady = 10;
				c.ipadx = 20;
				// c.insets = new Insets(0, 20, 20, 0); // side padding
				c.gridx = 0;
				c.gridy = 2;
				add(deleteActor(), c);
			} else if (e.getSource() == submitAddActor) {
				String actorIDFinal = (String) addActorIDText.getText();
				String actorFirstNameFinal = (String) addActorFirstNameText.getText();
				String actorLastNameFinal = (String) addActorLastNameText.getText();
				employeeFunctions.addActor(actorIDFinal, actorFirstNameFinal, actorLastNameFinal);
				confirmMessage(actorFirstNameFinal + " " + actorLastNameFinal + " has been added");
				homeButton("");
			} else if (e.getSource() == submitDeleteActor) {
				if (getAllActors().getSelectedRow() != -1) {
					String actorIDFinal = getAllActors().getValueAt(getAllActors().getSelectedRow(), 0).toString();
					employeeFunctions.deleteActor(actorIDFinal);
					((DefaultTableModel) getAllActors().getModel()).removeRow(getAllActors().getSelectedRow());
					confirmMessage(actorIDFinal + " has been removed from the Company Database");
				}
			} else if (e.getSource() == updateEmail) {
				updateEmail();
			} else if (e.getSource() == submitEmail) {
				String email = (String) emailText.getText();
				employeeFunctions.updateEmail(email);
				confirmMessage("Your email has been updated");
				homeButton("");
			} else if (e.getSource() == updatePassword) {
				updatePassword();
			} else if (e.getSource() == submitPassword) {
				String password = (String) passwordText.getText();
				employeeFunctions.updatePassword(password);
				confirmMessage("Your password has been updated");
				homeButton("");
			} else if (e.getSource() == homeButton) {
				employeePage();
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
			if (e.getSource() == addMemberEmail) {
				addMemberEmail.setForeground(Color.BLACK);
				if (addMemberEmail.getText().equals(addMemberEmailPrompt)) {
					addMemberEmail.setText("");
				}
			} else if (e.getSource() == addMemberPassword) {
				addMemberPassword.setForeground(Color.BLACK);
				if (addMemberPassword.getText().equals(addMemberPasswordPrompt)) {
					addMemberPassword.setText("");
				}
			} else if (e.getSource() == addMemberFirstNameText) {
				addMemberFirstNameText.setForeground(Color.BLACK);
				if (addMemberFirstNameText.getText().equals(addMemberFirstNameTextPrompt)) {
					addMemberFirstNameText.setText("");
				}
			} else if (e.getSource() == addMemberLastNameText) {
				addMemberLastNameText.setForeground(Color.BLACK);
				if (addMemberLastNameText.getText().equals(addMemberLastNameTextPrompt)) {
					addMemberLastNameText.setText("");
				}
			} else if (e.getSource() == addPhoneText) {
				addPhoneText.setForeground(Color.BLACK);
				if (addPhoneText.getText().equals(addPhoneTextPrompt)) {
					addPhoneText.setText("");
				}
			} else if (e.getSource() == addAddressText) {
				addAddressText.setForeground(Color.BLACK);
				if (addAddressText.getText().equals(addAddressTextPrompt)) {
					addAddressText.setText("");
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
			} else if (e.getSource() == movieIDText) {
				movieIDText.setForeground(Color.BLACK);
				if (movieIDText.getText().equals(movieIDTextPrompt)) {
					movieIDText.setText("");
				}
			} else if (e.getSource() == movieTitleText) {
				movieTitleText.setForeground(Color.BLACK);
				if (movieTitleText.getText().equals(movieTitleTextPrompt)) {
					movieTitleText.setText("");
				}
			} else if (e.getSource() == movieRatingText) {
				movieRatingText.setForeground(Color.BLACK);
				if (movieRatingText.getText().equals(movieRatingTextPrompt)) {
					movieRatingText.setText("");
				}
			} else if (e.getSource() == movieGenreText) {
				movieGenreText.setForeground(Color.BLACK);
				if (movieGenreText.getText().equals(movieGenreTextPrompt)) {
					movieGenreText.setText("");
				}
			} else if (e.getSource() == movieReleaseDateText) {
				movieReleaseDateText.setForeground(Color.BLACK);
				if (movieReleaseDateText.getText().equals(movieReleaseDateTextPrompt)) {
					movieReleaseDateText.setText("");
				}
			} else if (e.getSource() == addActorIDText) {
				addActorIDText.setForeground(Color.BLACK);
				if (addActorIDText.getText().equals(addActorIDTextPrompt)) {
					addActorIDText.setText("");
				}
			} else if (e.getSource() == addActorFirstNameText) {
				addActorFirstNameText.setForeground(Color.BLACK);
				if (addActorFirstNameText.getText().equals(addActorFirstNameTextPrompt)) {
					addActorFirstNameText.setText("");
				}
			} else if (e.getSource() == addActorLastNameText) {
				addActorLastNameText.setForeground(Color.BLACK);
				if (addActorLastNameText.getText().equals(addActorLastNameTextPrompt)) {
					addActorLastNameText.setText("");
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
			if (e.getSource() == addMemberEmail) {
				if (addMemberEmail.getText().length() == 0) {
					addMemberEmail.setForeground(Color.GRAY);
					addMemberEmail.setText(addMemberEmailPrompt);
				}
			} else if (e.getSource() == addMemberPassword) {
				if (addMemberPassword.getText().length() == 0) {
					addMemberPassword.setForeground(Color.GRAY);
					addMemberPassword.setText(addMemberPasswordPrompt);
				}
			} else if (e.getSource() == addMemberFirstNameText) {
				if (addMemberFirstNameText.getText().length() == 0) {
					addMemberFirstNameText.setForeground(Color.GRAY);
					addMemberFirstNameText.setText(addMemberFirstNameTextPrompt);
				}
			} else if (e.getSource() == addMemberLastNameText) {
				if (addMemberLastNameText.getText().length() == 0) {
					addMemberLastNameText.setForeground(Color.GRAY);
					addMemberLastNameText.setText(addMemberLastNameTextPrompt);
				}
			} else if (e.getSource() == addPhoneText) {
				if (addPhoneText.getText().length() == 0) {
					addPhoneText.setForeground(Color.GRAY);
					addPhoneText.setText(addPhoneTextPrompt);
				}
			} else if (e.getSource() == addAddressText) {
				if (addAddressText.getText().length() == 0) {
					addAddressText.setForeground(Color.GRAY);
					addAddressText.setText(addAddressTextPrompt);
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
			} else if (e.getSource() == movieIDText) {
				if (movieIDText.getText().length() == 0) {
					movieIDText.setForeground(Color.GRAY);
					movieIDText.setText(movieIDTextPrompt);
				}
			} else if (e.getSource() == movieTitleText) {
				if (movieTitleText.getText().length() == 0) {
					movieTitleText.setForeground(Color.GRAY);
					movieTitleText.setText(movieTitleTextPrompt);
				}
			} else if (e.getSource() == movieRatingText) {
				if (movieRatingText.getText().length() == 0) {
					movieRatingText.setForeground(Color.GRAY);
					movieRatingText.setText(movieRatingTextPrompt);
				}
			} else if (e.getSource() == movieGenreText) {
				if (movieGenreText.getText().length() == 0) {
					movieGenreText.setForeground(Color.GRAY);
					movieGenreText.setText(movieGenreTextPrompt);
				}
			} else if (e.getSource() == movieReleaseDateText) {
				if (movieReleaseDateText.getText().length() == 0) {
					movieReleaseDateText.setForeground(Color.GRAY);
					movieReleaseDateText.setText(movieReleaseDateTextPrompt);
				}
			} else if (e.getSource() == addActorIDText) {
				if (addActorIDText.getText().length() == 0) {
					addActorIDText.setForeground(Color.GRAY);
					addActorIDText.setText(addActorIDTextPrompt);
				}
			} else if (e.getSource() == addActorFirstNameText) {
				if (addActorFirstNameText.getText().length() == 0) {
					addActorFirstNameText.setForeground(Color.GRAY);
					addActorFirstNameText.setText(addActorFirstNameTextPrompt);
				}
			} else if (e.getSource() == addActorLastNameText) {
				if (addActorLastNameText.getText().length() == 0) {
					addActorLastNameText.setForeground(Color.GRAY);
					addActorLastNameText.setText(addActorLastNameTextPrompt);
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
