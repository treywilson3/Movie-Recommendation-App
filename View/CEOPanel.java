package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import Controller.CEOFunctions;

package View;

/**
 * @author Trey Employee Panel has all buttons that an amployee will need.
 *
 */
public class CEOPanel extends JPanel {

	// Choices
	private JButton addMembers;
	private JButton addMovies;
	private JButton addEmployees;
	private JButton addActors;
	private JButton settings;

	// Add/Delete Choices
	private JButton addMovie;
	private JButton deleteMovie;
	private JButton addMember;
	private JButton deleteMember;
	private JButton employeeInformation;
	private JButton addEmployee;
	private JButton deleteEmployee;

	// Add movie
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

	// Table to present all employees and button to
	// delete an employee
	private JTable getAllEmployeesTable;
	private JButton submitDeleteEmployee;

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

	// Add employee
	private TextField addEmployeeEmail;
	private String addEmployeeEmailPrompt;
	private TextField addEmployeePassword;
	private String addEmployeePasswordPrompt;
	private TextField addHireDateText;
	private String addHireDateTextPrompt;
	private TextField addEmployeeFirstNameText;
	private String addEmployeeFirstNameTextPrompt;
	private TextField addEmployeeLastNameText;
	private String addEmployeeLastNameTextPrompt;
	private TextField addJobLocationText;
	private String addJobLocationTextPrompt;
	private TextField addPositionText;
	private String addPositionTextPrompt;
	private TextField addSalaryText;
	private String addSalaryTextPrompt;
	private JButton submitAddEmployee;


	// Add Actor
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

	// Employee info
	private String employeeEmail;
	private String employeePassword;
	private CEOFunctions ceoFunctions;

	// Home button and optional label
	private JButton homeButton;
	private JLabel restartLabel;

	// Layout
	private GridBagConstraints c;

	// Add delete actor
	private JButton addActorButton;
	private JButton deleteActorButton;

	// Listeners
	private ActionListener onClick;
	private FocusListener onFocus;

	/**
	 * Constructor get employee Email and password. See if employee is ceo, if
	 * ceo, then load ceo page else employee page Ceo also has more functions
	 * than employee which will be properly opened
	 *
	 * @param employeeEmail
	 * @param employeePassword
	 */
	public CEOPanel(String employeeEmail, String employeePassword) {
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		ceoFunctions = new CEOFunctions(employeeEmail, employeePassword);
		onClick = new Click(this);
		//onFocus = new Focus(this);
		ceoPage();

	}

	/**
	 * CEO home page
	 */
	public void ceoPage() {
		resetScreen();

		addMovies = new JButton("Add/Delete Movies");
		addMembers = new JButton("Add/Delete Members");
		addActors = new JButton("Add/Delete Actors");
		addEmployees = new JButton("Add/Delete Employees");
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
		add(addEmployees, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 4;
		c.gridy = 0;
		add(settings, c);

		addMovies.addActionListener(onClick);
		addMembers.addActionListener(onClick);
		addActors.addActionListener(onClick);
		addEmployees.addActionListener(onClick);
		settings.addActionListener(onClick);

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
		c.gridx = 7;
		c.gridy = 1;
		add(homeButton, c);

		homeButton.addActionListener(onClick);

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

		addMovie.addActionListener(onClick);
		deleteMovie.addActionListener(onClick);

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

		submitAddMovie.addActionListener(onClick);
		movieIDText.addFocusListener(onFocus);
		movieTitleText.addFocusListener(onFocus);
		movieRatingText.addFocusListener(onFocus);
		movieGenreText.addFocusListener(onFocus);
		movieReleaseDateText.addFocusListener(onFocus);
	}

	/**
	 * textfield and enter information to delete movie
	 *
	 * @return
	 */
	public JButton deleteMovie() {
		submitDeleteMovie = new JButton("Delete");
		add(submitDeleteMovie, c);
		submitDeleteMovie.addActionListener(onClick);
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

		addMember.addActionListener(onClick);
		deleteMember.addActionListener(onClick);
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

		submitAddMember.addActionListener(onClick);
		addMemberEmail.addFocusListener(onFocus);
		addMemberPassword.addFocusListener(onFocus);
		addMemberFirstNameText.addFocusListener(onFocus);
		addMemberLastNameText.addFocusListener(onFocus);
		addPhoneText.addFocusListener(onFocus);
		addAddressText.addFocusListener(onFocus);
		addCityText.addFocusListener(onFocus);
		addStateText.addFocusListener(onFocus);
		addZipText.addFocusListener(onFocus);
	}

	/**
	 * textfield to enter delete member
	 */
	public JButton deleteMember() {
		submitDeleteMember = new JButton("Delete");
		add(submitDeleteMember, c);
		submitDeleteMember.addActionListener(onClick);
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

		addActorButton.addActionListener(onClick);
		deleteActorButton.addActionListener(onClick);
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

		submitAddActor.addActionListener(onClick);
		addActorIDText.addFocusListener(onFocus);
		addActorFirstNameText.addFocusListener(onFocus);
		addActorLastNameText.addFocusListener(onFocus);
	}

	/**
	 * textfield to delete actor
	 */
	public JButton deleteActor() {
		submitDeleteActor = new JButton("Delete");
		add(submitDeleteActor, c);
		submitDeleteActor.addActionListener(onClick);
		return submitDeleteActor;
	}

	/**
	 * panel to show buttons to add or delete employees only available for ceo
	 */
	public void addEmployeesPanel() {
		resetScreen();

		addEmployee = new JButton("Add Employee");
		deleteEmployee = new JButton("Delete Employee");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addEmployee, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(deleteEmployee, c);

		addEmployee.addActionListener(onClick);
		deleteEmployee.addActionListener(onClick);

	}

	/**
	 * textfields to enter new employee informatoin
	 */
	public void addEmployee() {
		resetScreen();

		addEmployeeEmail = new TextField(20);
		addEmployeeEmail.setForeground(Color.GRAY);
		addEmployeeEmailPrompt = "Enter Employee Email";
		addEmployeeEmail.setText(addEmployeeEmailPrompt);
		addEmployeePassword = new TextField(20);
		addEmployeePassword.setForeground(Color.GRAY);
		addEmployeePasswordPrompt = "Enter Employee Password";
		addEmployeePassword.setText(addEmployeePasswordPrompt);
		addEmployeeFirstNameText = new TextField(20);
		addEmployeeFirstNameText.setForeground(Color.GRAY);
		addEmployeeFirstNameTextPrompt = "Enter Employee First Name";
		addEmployeeFirstNameText.setText(addEmployeeFirstNameTextPrompt);
		addEmployeeLastNameText = new TextField(20);
		addEmployeeLastNameText.setForeground(Color.GRAY);
		addEmployeeLastNameTextPrompt = "Enter Employee Last Name";
		addEmployeeLastNameText.setText(addEmployeeLastNameTextPrompt);
		addHireDateText = new TextField(20);
		addHireDateText.setForeground(Color.GRAY);
		addHireDateTextPrompt = "Enter Hire Date (yyyy-MM-dd)";
		addHireDateText.setText(addHireDateTextPrompt);
		addJobLocationText = new TextField(20);
		addJobLocationText.setForeground(Color.GRAY);
		addJobLocationTextPrompt = "Enter Employee Job Location";
		addJobLocationText.setText(addJobLocationTextPrompt);
		addPositionText = new TextField(20);
		addPositionText.setForeground(Color.GRAY);
		addPositionTextPrompt = "Enter Employee Position";
		addPositionText.setText(addPositionTextPrompt);
		addSalaryText = new TextField(20);
		addSalaryText.setForeground(Color.GRAY);
		addSalaryTextPrompt = "Enter Employee Salary";
		addSalaryText.setText(addSalaryTextPrompt);
		submitAddEmployee = new JButton("Submit");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(addEmployeeEmail, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 1;
		add(addEmployeePassword, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 2;
		add(addEmployeeFirstNameText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 3;
		add(addEmployeeLastNameText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 4;
		add(addHireDateText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 5;
		add(addJobLocationText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 6;
		add(addPositionText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 7;
		add(addSalaryText, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 8;
		add(submitAddEmployee, c);

		submitAddEmployee.addActionListener(onClick);
		addEmployeeEmail.addFocusListener(onFocus);
		addEmployeePassword.addFocusListener(onFocus);
		addEmployeeFirstNameText.addFocusListener(onFocus);
		addEmployeeLastNameText.addFocusListener(onFocus);
		addHireDateText.addFocusListener(onFocus);
		addJobLocationText.addFocusListener(onFocus);
		addPositionText.addFocusListener(onFocus);
		addSalaryText.addFocusListener(onFocus);
	}

	/**
	 * textfield to enter delete employee
	 */
	public JButton deleteEmployee() {
		submitDeleteEmployee = new JButton("Delete");
		add(submitDeleteEmployee, c);
		submitDeleteEmployee.addActionListener(onClick);
		return submitDeleteEmployee;
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
		employeeInformation.addActionListener(onClick);

		updateEmail.addActionListener(onClick);
		updatePassword.addActionListener(onClick);
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

		submitEmail.addActionListener(onClick);
		emailText.addFocusListener(onFocus);
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

		submitPassword.addActionListener(onClick);
		passwordText.addFocusListener(onFocus);
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

	public JTable getAllEmployeesTable() {
		return getAllEmployeesTable;
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

	public JButton getAddMembers() {
		return addMembers;
	}

	public void setAddMembers(JButton addMembers) {
		this.addMembers = addMembers;
	}

	public JButton getAddMovies() {
		return addMovies;
	}

	public void setAddMovies(JButton addMovies) {
		this.addMovies = addMovies;
	}

	public JButton getAddEmployees() {
		return addEmployees;
	}

	public void setAddEmployees(JButton addEmployees) {
		this.addEmployees = addEmployees;
	}

	public JButton getAddActors() {
		return addActors;
	}

	public void setAddActors(JButton addActors) {
		this.addActors = addActors;
	}

	public JButton getSettings() {
		return settings;
	}

	public void setSettings(JButton settings) {
		this.settings = settings;
	}

	public JButton getAddMovie() {
		return addMovie;
	}

	public void setAddMovie(JButton addMovie) {
		this.addMovie = addMovie;
	}

	public JButton getDeleteMovie() {
		return deleteMovie;
	}

	public void setDeleteMovie(JButton deleteMovie) {
		this.deleteMovie = deleteMovie;
	}

	public JButton getAddMember() {
		return addMember;
	}

	public void setAddMember(JButton addMember) {
		this.addMember = addMember;
	}

	public JButton getDeleteMember() {
		return deleteMember;
	}

	public void setDeleteMember(JButton deleteMember) {
		this.deleteMember = deleteMember;
	}

	public JButton getEmployeeInformation() {
		return employeeInformation;
	}

	public void setEmployeeInformation(JButton employeeInformation) {
		this.employeeInformation = employeeInformation;
	}

	public JButton getAddEmployee() {
		return addEmployee;
	}

	public void setAddEmployee(JButton addEmployee) {
		this.addEmployee = addEmployee;
	}

	public JButton getDeleteEmployee() {
		return deleteEmployee;
	}

	public void setDeleteEmployee(JButton deleteEmployee) {
		this.deleteEmployee = deleteEmployee;
	}

	public TextField getMovieIDText() {
		return movieIDText;
	}

	public void setMovieIDText(TextField movieIDText) {
		this.movieIDText = movieIDText;
	}

	public String getMovieIDTextPrompt() {
		return movieIDTextPrompt;
	}

	public void setMovieIDTextPrompt(String movieIDTextPrompt) {
		this.movieIDTextPrompt = movieIDTextPrompt;
	}

	public TextField getMovieTitleText() {
		return movieTitleText;
	}

	public void setMovieTitleText(TextField movieTitleText) {
		this.movieTitleText = movieTitleText;
	}

	public String getMovieTitleTextPrompt() {
		return movieTitleTextPrompt;
	}

	public void setMovieTitleTextPrompt(String movieTitleTextPrompt) {
		this.movieTitleTextPrompt = movieTitleTextPrompt;
	}

	public TextField getMovieRatingText() {
		return movieRatingText;
	}

	public void setMovieRatingText(TextField movieRatingText) {
		this.movieRatingText = movieRatingText;
	}

	public String getMovieRatingTextPrompt() {
		return movieRatingTextPrompt;
	}

	public void setMovieRatingTextPrompt(String movieRatingTextPrompt) {
		this.movieRatingTextPrompt = movieRatingTextPrompt;
	}

	public TextField getMovieGenreText() {
		return movieGenreText;
	}

	public void setMovieGenreText(TextField movieGenreText) {
		this.movieGenreText = movieGenreText;
	}

	public String getMovieGenreTextPrompt() {
		return movieGenreTextPrompt;
	}

	public void setMovieGenreTextPrompt(String movieGenreTextPrompt) {
		this.movieGenreTextPrompt = movieGenreTextPrompt;
	}

	public TextField getMovieReleaseDateText() {
		return movieReleaseDateText;
	}

	public void setMovieReleaseDateText(TextField movieReleaseDateText) {
		this.movieReleaseDateText = movieReleaseDateText;
	}

	public String getMovieReleaseDateTextPrompt() {
		return movieReleaseDateTextPrompt;
	}

	public void setMovieReleaseDateTextPrompt(String movieReleaseDateTextPrompt) {
		this.movieReleaseDateTextPrompt = movieReleaseDateTextPrompt;
	}

	public JButton getSubmitAddMovie() {
		return submitAddMovie;
	}

	public void setSubmitAddMovie(JButton submitAddMovie) {
		this.submitAddMovie = submitAddMovie;
	}

	public JTable getGetAllMovies() {
		return getAllMovies;
	}

	public void setGetAllMovies(JTable getAllMovies) {
		this.getAllMovies = getAllMovies;
	}

	public JButton getSubmitDeleteMovie() {
		return submitDeleteMovie;
	}

	public void setSubmitDeleteMovie(JButton submitDeleteMovie) {
		this.submitDeleteMovie = submitDeleteMovie;
	}

	public JTable getGetAllMembers() {
		return getAllMembers;
	}

	public void setGetAllMembers(JTable getAllMembers) {
		this.getAllMembers = getAllMembers;
	}

	public JButton getSubmitDeleteMember() {
		return submitDeleteMember;
	}

	public void setSubmitDeleteMember(JButton submitDeleteMember) {
		this.submitDeleteMember = submitDeleteMember;
	}

	public JTable getGetAllActors() {
		return getAllActors;
	}

	public void setGetAllActors(JTable getAllActors) {
		this.getAllActors = getAllActors;
	}

	public JButton getSubmitDeleteActor() {
		return submitDeleteActor;
	}

	public void setSubmitDeleteActor(JButton submitDeleteActor) {
		this.submitDeleteActor = submitDeleteActor;
	}

	public JTable getGetAllEmployeesTable() {
		return getAllEmployeesTable;
	}

	public void setGetAllEmployeesTable(JTable getAllEmployeesTable) {
		this.getAllEmployeesTable = getAllEmployeesTable;
	}

	public JButton getSubmitDeleteEmployee() {
		return submitDeleteEmployee;
	}

	public void setSubmitDeleteEmployee(JButton submitDeleteEmployee) {
		this.submitDeleteEmployee = submitDeleteEmployee;
	}

	public TextField getAddMemberEmail() {
		return addMemberEmail;
	}

	public void setAddMemberEmail(TextField addMemberEmail) {
		this.addMemberEmail = addMemberEmail;
	}

	public String getAddMemberEmailPrompt() {
		return addMemberEmailPrompt;
	}

	public void setAddMemberEmailPrompt(String addMemberEmailPrompt) {
		this.addMemberEmailPrompt = addMemberEmailPrompt;
	}

	public TextField getAddMemberPassword() {
		return addMemberPassword;
	}

	public void setAddMemberPassword(TextField addMemberPassword) {
		this.addMemberPassword = addMemberPassword;
	}

	public String getAddMemberPasswordPrompt() {
		return addMemberPasswordPrompt;
	}

	public void setAddMemberPasswordPrompt(String addMemberPasswordPrompt) {
		this.addMemberPasswordPrompt = addMemberPasswordPrompt;
	}

	public TextField getAddMemberFirstNameText() {
		return addMemberFirstNameText;
	}

	public void setAddMemberFirstNameText(TextField addMemberFirstNameText) {
		this.addMemberFirstNameText = addMemberFirstNameText;
	}

	public String getAddMemberFirstNameTextPrompt() {
		return addMemberFirstNameTextPrompt;
	}

	public void setAddMemberFirstNameTextPrompt(String addMemberFirstNameTextPrompt) {
		this.addMemberFirstNameTextPrompt = addMemberFirstNameTextPrompt;
	}

	public TextField getAddMemberLastNameText() {
		return addMemberLastNameText;
	}

	public void setAddMemberLastNameText(TextField addMemberLastNameText) {
		this.addMemberLastNameText = addMemberLastNameText;
	}

	public String getAddMemberLastNameTextPrompt() {
		return addMemberLastNameTextPrompt;
	}

	public void setAddMemberLastNameTextPrompt(String addMemberLastNameTextPrompt) {
		this.addMemberLastNameTextPrompt = addMemberLastNameTextPrompt;
	}

	public TextField getAddPhoneText() {
		return addPhoneText;
	}

	public void setAddPhoneText(TextField addPhoneText) {
		this.addPhoneText = addPhoneText;
	}

	public String getAddPhoneTextPrompt() {
		return addPhoneTextPrompt;
	}

	public void setAddPhoneTextPrompt(String addPhoneTextPrompt) {
		this.addPhoneTextPrompt = addPhoneTextPrompt;
	}

	public TextField getAddAddressText() {
		return addAddressText;
	}

	public void setAddAddressText(TextField addAddressText) {
		this.addAddressText = addAddressText;
	}

	public String getAddAddressTextPrompt() {
		return addAddressTextPrompt;
	}

	public void setAddAddressTextPrompt(String addAddressTextPrompt) {
		this.addAddressTextPrompt = addAddressTextPrompt;
	}

	public TextField getAddCityText() {
		return addCityText;
	}

	public void setAddCityText(TextField addCityText) {
		this.addCityText = addCityText;
	}

	public String getAddCityTextPrompt() {
		return addCityTextPrompt;
	}

	public void setAddCityTextPrompt(String addCityTextPrompt) {
		this.addCityTextPrompt = addCityTextPrompt;
	}

	public TextField getAddStateText() {
		return addStateText;
	}

	public void setAddStateText(TextField addStateText) {
		this.addStateText = addStateText;
	}

	public String getAddStateTextPrompt() {
		return addStateTextPrompt;
	}

	public void setAddStateTextPrompt(String addStateTextPrompt) {
		this.addStateTextPrompt = addStateTextPrompt;
	}

	public TextField getAddZipText() {
		return addZipText;
	}

	public void setAddZipText(TextField addZipText) {
		this.addZipText = addZipText;
	}

	public String getAddZipTextPrompt() {
		return addZipTextPrompt;
	}

	public void setAddZipTextPrompt(String addZipTextPrompt) {
		this.addZipTextPrompt = addZipTextPrompt;
	}

	public JButton getSubmitAddMember() {
		return submitAddMember;
	}

	public void setSubmitAddMember(JButton submitAddMember) {
		this.submitAddMember = submitAddMember;
	}

	public TextField getAddEmployeeEmail() {
		return addEmployeeEmail;
	}

	public void setAddEmployeeEmail(TextField addEmployeeEmail) {
		this.addEmployeeEmail = addEmployeeEmail;
	}

	public String getAddEmployeeEmailPrompt() {
		return addEmployeeEmailPrompt;
	}

	public void setAddEmployeeEmailPrompt(String addEmployeeEmailPrompt) {
		this.addEmployeeEmailPrompt = addEmployeeEmailPrompt;
	}

	public TextField getAddEmployeePassword() {
		return addEmployeePassword;
	}

	public void setAddEmployeePassword(TextField addEmployeePassword) {
		this.addEmployeePassword = addEmployeePassword;
	}

	public String getAddEmployeePasswordPrompt() {
		return addEmployeePasswordPrompt;
	}

	public void setAddEmployeePasswordPrompt(String addEmployeePasswordPrompt) {
		this.addEmployeePasswordPrompt = addEmployeePasswordPrompt;
	}

	public TextField getAddHireDateText() {
		return addHireDateText;
	}

	public void setAddHireDateText(TextField addHireDateText) {
		this.addHireDateText = addHireDateText;
	}

	public String getAddHireDateTextPrompt() {
		return addHireDateTextPrompt;
	}

	public void setAddHireDateTextPrompt(String addHireDateTextPrompt) {
		this.addHireDateTextPrompt = addHireDateTextPrompt;
	}

	public TextField getAddEmployeeFirstNameText() {
		return addEmployeeFirstNameText;
	}

	public void setAddEmployeeFirstNameText(TextField addEmployeeFirstNameText) {
		this.addEmployeeFirstNameText = addEmployeeFirstNameText;
	}

	public String getAddEmployeeFirstNameTextPrompt() {
		return addEmployeeFirstNameTextPrompt;
	}

	public void setAddEmployeeFirstNameTextPrompt(String addEmployeeFirstNameTextPrompt) {
		this.addEmployeeFirstNameTextPrompt = addEmployeeFirstNameTextPrompt;
	}

	public TextField getAddEmployeeLastNameText() {
		return addEmployeeLastNameText;
	}

	public void setAddEmployeeLastNameText(TextField addEmployeeLastNameText) {
		this.addEmployeeLastNameText = addEmployeeLastNameText;
	}

	public String getAddEmployeeLastNameTextPrompt() {
		return addEmployeeLastNameTextPrompt;
	}

	public void setAddEmployeeLastNameTextPrompt(String addEmployeeLastNameTextPrompt) {
		this.addEmployeeLastNameTextPrompt = addEmployeeLastNameTextPrompt;
	}

	public TextField getAddJobLocationText() {
		return addJobLocationText;
	}

	public void setAddJobLocationText(TextField addJobLocationText) {
		this.addJobLocationText = addJobLocationText;
	}

	public String getAddJobLocationTextPrompt() {
		return addJobLocationTextPrompt;
	}

	public void setAddJobLocationTextPrompt(String addJobLocationTextPrompt) {
		this.addJobLocationTextPrompt = addJobLocationTextPrompt;
	}

	public TextField getAddPositionText() {
		return addPositionText;
	}

	public void setAddPositionText(TextField addPositionText) {
		this.addPositionText = addPositionText;
	}

	public String getAddPositionTextPrompt() {
		return addPositionTextPrompt;
	}

	public void setAddPositionTextPrompt(String addPositionTextPrompt) {
		this.addPositionTextPrompt = addPositionTextPrompt;
	}

	public TextField getAddSalaryText() {
		return addSalaryText;
	}

	public void setAddSalaryText(TextField addSalaryText) {
		this.addSalaryText = addSalaryText;
	}

	public String getAddSalaryTextPrompt() {
		return addSalaryTextPrompt;
	}

	public void setAddSalaryTextPrompt(String addSalaryTextPrompt) {
		this.addSalaryTextPrompt = addSalaryTextPrompt;
	}

	public JButton getSubmitAddEmployee() {
		return submitAddEmployee;
	}

	public void setSubmitAddEmployee(JButton submitAddEmployee) {
		this.submitAddEmployee = submitAddEmployee;
	}

	public TextField getAddActorIDText() {
		return addActorIDText;
	}

	public void setAddActorIDText(TextField addActorIDText) {
		this.addActorIDText = addActorIDText;
	}

	public String getAddActorIDTextPrompt() {
		return addActorIDTextPrompt;
	}

	public void setAddActorIDTextPrompt(String addActorIDTextPrompt) {
		this.addActorIDTextPrompt = addActorIDTextPrompt;
	}

	public TextField getAddActorFirstNameText() {
		return addActorFirstNameText;
	}

	public void setAddActorFirstNameText(TextField addActorFirstNameText) {
		this.addActorFirstNameText = addActorFirstNameText;
	}

	public String getAddActorFirstNameTextPrompt() {
		return addActorFirstNameTextPrompt;
	}

	public void setAddActorFirstNameTextPrompt(String addActorFirstNameTextPrompt) {
		this.addActorFirstNameTextPrompt = addActorFirstNameTextPrompt;
	}

	public TextField getAddActorLastNameText() {
		return addActorLastNameText;
	}

	public void setAddActorLastNameText(TextField addActorLastNameText) {
		this.addActorLastNameText = addActorLastNameText;
	}

	public String getAddActorLastNameTextPrompt() {
		return addActorLastNameTextPrompt;
	}

	public void setAddActorLastNameTextPrompt(String addActorLastNameTextPrompt) {
		this.addActorLastNameTextPrompt = addActorLastNameTextPrompt;
	}

	public JButton getSubmitAddActor() {
		return submitAddActor;
	}

	public void setSubmitAddActor(JButton submitAddActor) {
		this.submitAddActor = submitAddActor;
	}

	public JButton getUpdateEmail() {
		return updateEmail;
	}

	public void setUpdateEmail(JButton updateEmail) {
		this.updateEmail = updateEmail;
	}

	public JButton getUpdatePassword() {
		return updatePassword;
	}

	public void setUpdatePassword(JButton updatePassword) {
		this.updatePassword = updatePassword;
	}

	public TextField getEmailText() {
		return emailText;
	}

	public void setEmailText(TextField emailText) {
		this.emailText = emailText;
	}

	public String getEmailTextPrompt() {
		return emailTextPrompt;
	}

	public void setEmailTextPrompt(String emailTextPrompt) {
		this.emailTextPrompt = emailTextPrompt;
	}

	public JButton getSubmitEmail() {
		return submitEmail;
	}

	public void setSubmitEmail(JButton submitEmail) {
		this.submitEmail = submitEmail;
	}

	public TextField getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(TextField passwordText) {
		this.passwordText = passwordText;
	}

	public String getPasswordTextPrompt() {
		return passwordTextPrompt;
	}

	public void setPasswordTextPrompt(String passwordTextPrompt) {
		this.passwordTextPrompt = passwordTextPrompt;
	}

	public JButton getSubmitPassword() {
		return submitPassword;
	}

	public void setSubmitPassword(JButton submitPassword) {
		this.submitPassword = submitPassword;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public CEOFunctions getCeoFunctions() {
		return ceoFunctions;
	}

	public void setCeoFunctions(CEOFunctions ceoFunctions) {
		this.ceoFunctions = ceoFunctions;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(JButton homeButton) {
		this.homeButton = homeButton;
	}

	public JLabel getRestartLabel() {
		return restartLabel;
	}

	public void setRestartLabel(JLabel restartLabel) {
		this.restartLabel = restartLabel;
	}

	public GridBagConstraints getC() {
		return c;
	}

	public void setC(GridBagConstraints c) {
		this.c = c;
	}

	public JButton getAddActorButton() {
		return addActorButton;
	}

	public void setAddActorButton(JButton addActorButton) {
		this.addActorButton = addActorButton;
	}

	public JButton getDeleteActorButton() {
		return deleteActorButton;
	}

	public void setDeleteActorButton(JButton deleteActorButton) {
		this.deleteActorButton = deleteActorButton;
	}

	public ActionListener getOnClick() {
		return onClick;
	}

	public void setOnClick(ActionListener onClick) {
		this.onClick = onClick;
	}

	public FocusListener getOnFocus() {
		return onFocus;
	}

	public void setOnFocus(FocusListener onFocus) {
		this.onFocus = onFocus;
	}
}
