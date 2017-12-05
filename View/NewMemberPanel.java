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
import javax.swing.JPanel;
import Database.DatabaseModel;
import Database.EmployeeDatabase;

/**
 * @author Trey
 * The NewMemberPanel has all the textfields needed to 
 * make a new account. 
 * The member will enter all their information and this class
 * will call the DatabaseModel and make a new member
 */
public class NewMemberPanel extends JPanel {

	// All Textfields and Strings (which are the prompts)
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
	// Layout
	private GridBagConstraints c;
	
	/**
	 * Set the Layout and constraints then call
	 * newMember method
	 */
	public NewMemberPanel(){
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		newMember();
	}
	/**
	 * Add all Textfields and activate prompts
	 * Call FocusListener and ActionListener
	 * 
	 */
	public void newMember() {
		// Create Action and Focus Listeners
		FocusListener myFocusListener = new MyFocusListener();
		ActionListener myInnerClass = new MyActionListener();
		
		// Do this to update Frame
		resetScreen();
		
		
		// Create Textfields and set prompts
		addMemberEmail = new TextField(20);
		addMemberEmail.setForeground(Color.GRAY);
		addMemberEmailPrompt = "Enter Your Email";
		addMemberEmail.setText(addMemberEmailPrompt);
		addMemberPassword = new TextField(20);
		addMemberPassword.setForeground(Color.GRAY);
		addMemberPasswordPrompt = "Enter Your Password";
		addMemberPassword.setText(addMemberPasswordPrompt);
		addMemberFirstNameText = new TextField(20);
		addMemberFirstNameTextPrompt = "Enter Your First Name";
		addMemberFirstNameText.setForeground(Color.GRAY);
		addMemberFirstNameText.setText(addMemberFirstNameTextPrompt);
		addMemberLastNameText = new TextField(20);
		addMemberLastNameTextPrompt = "Enter Your Last Name";
		addMemberLastNameText.setForeground(Color.GRAY);
		addMemberLastNameText.setText(addMemberLastNameTextPrompt);
		addPhoneText = new TextField(20);
		addPhoneText.setForeground(Color.GRAY);
		addPhoneTextPrompt = "Enter Your Phone";
		addPhoneText.setText(addPhoneTextPrompt);
		addAddressText = new TextField(40);
		addAddressText.setForeground(Color.GRAY);
		addAddressTextPrompt = "Enter Your Address";
		addAddressText.setText(addAddressTextPrompt);
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
		submitAddMember = new JButton("Submit");
		
		// Add all componets
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
		
		// Add Listeners
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
	 * resetScreen is needed to update screen
	 */
	public void resetScreen(){
		removeAll();
		repaint();
		revalidate();
	}
	/**
	 * @author Trey
	 * Once submit is pressed, all entered information 
	 * Will be passed to the DatabaseModel class to make
	 * a new member. 
	 */
	public class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submitAddMember) {
				String email = (String) addMemberEmail.getText();
				String password = (String) addMemberPassword.getText();
				String fnameFinal = (String) addMemberFirstNameText.getText();
				String lnameFinal = (String) addMemberLastNameText.getText();
				String phoneFinal = (String) addPhoneText.getText();
				String addressFinal = (String) addAddressText.getText();
				String cityFinal = (String) addCityText.getText();
				String stateFinal = (String) addStateText.getText();
				String zipFinal = (String) addZipText.getText();
				// call method
				EmployeeDatabase.newUser(email, password, fnameFinal, lnameFinal, phoneFinal, addressFinal, cityFinal,
						stateFinal, zipFinal);
				LoginPanel loginPanel = new LoginPanel();
				removeAll();
				revalidate();
				repaint();
				add(loginPanel);
			}
		}
	}
	/**
	 * @author Trey
	 * If the textbox is clicked, then set the text to empty
	 * so the user doesn't have to clear it. Also, set the
	 * text color to black (it was gray for the prompt) that 
	 * way it is more aesthetically pleasing. 
	 * If the textbox was clicked in but the user did not type
	 * anything, then set the color back to gray and present
	 * the prompt. 
	 */
	public class MyFocusListener implements FocusListener{
		@Override
		public void focusGained(FocusEvent e){
			if (e.getSource() == addMemberEmail){
				addMemberEmail.setForeground(Color.BLACK);
				if (addMemberEmail.getText().equals(addMemberEmailPrompt)){
				addMemberEmail.setText("");
				}
			} else if (e.getSource() == addMemberPassword){
				addMemberPassword.setForeground(Color.BLACK);
				if (addMemberPassword.getText().equals(addMemberPasswordPrompt)){
				addMemberPassword.setText("");
				}
			} else if (e.getSource() == addMemberFirstNameText){
				addMemberFirstNameText.setForeground(Color.BLACK);
				if (addMemberFirstNameText.getText().equals(addMemberFirstNameTextPrompt)){
				addMemberFirstNameText.setText("");
				}
			} else if (e.getSource() == addMemberLastNameText){
				addMemberLastNameText.setForeground(Color.BLACK);
				if (addMemberLastNameText.getText().equals(addMemberLastNameTextPrompt)){
					addMemberLastNameText.setText("");
					}
			} else if (e.getSource() == addPhoneText){
				addPhoneText.setForeground(Color.BLACK);
				if (addPhoneText.getText().equals(addPhoneTextPrompt)){
				addPhoneText.setText("");
				}
			} else if (e.getSource() == addAddressText){
				addAddressText.setForeground(Color.BLACK);
				if (addAddressText.getText().equals(addAddressTextPrompt)){
					addAddressText.setText("");
					}
			} else if (e.getSource() == addCityText){
				addCityText.setForeground(Color.BLACK);
				if (addCityText.getText().equals(addCityTextPrompt)){
					addCityText.setText("");
					}
			} else if (e.getSource() == addStateText){
				addStateText.setForeground(Color.BLACK);
				if (addStateText.getText().equals(addStateTextPrompt)){
					addStateText.setText("");
					}
			} else if (e.getSource() == addZipText){
				addZipText.setForeground(Color.BLACK);
				if (addZipText.getText().equals(addZipTextPrompt)){
					addZipText.setText("");
					}
			} 
		}
		@Override
		public void focusLost(FocusEvent e){
			if (e.getSource() == addMemberEmail){
				if (addMemberEmail.getText().length() == 0){
					addMemberEmail.setForeground(Color.GRAY);
					addMemberEmail.setText(addMemberEmailPrompt);
				}
			} else if (e.getSource() == addMemberPassword){
				if (addMemberPassword.getText().length() == 0){
					addMemberPassword.setForeground(Color.GRAY);
					addMemberPassword.setText(addMemberPasswordPrompt);
				}
			} else if (e.getSource() == addMemberFirstNameText){
				if (addMemberFirstNameText.getText().length() == 0){
					addMemberFirstNameText.setForeground(Color.GRAY);
					addMemberFirstNameText.setText(addMemberFirstNameTextPrompt);
				}
			} else if (e.getSource() == addMemberLastNameText){
				if (addMemberLastNameText.getText().length() == 0){
					addMemberLastNameText.setForeground(Color.GRAY);
					addMemberLastNameText.setText(addMemberLastNameTextPrompt);
				}
			} else if (e.getSource() == addPhoneText){
				if (addPhoneText.getText().length() == 0){
					addPhoneText.setForeground(Color.GRAY);
					addPhoneText.setText(addPhoneTextPrompt);
				}
			} else if (e.getSource() == addAddressText){
				if (addAddressText.getText().length() == 0){
					addAddressText.setForeground(Color.GRAY);
					addAddressText.setText(addAddressTextPrompt);
				}
			} else if (e.getSource() == addCityText){
				if (addCityText.getText().length() == 0){
					addCityText.setForeground(Color.GRAY);
					addCityText.setText(addCityTextPrompt);
				}
			} else if (e.getSource() == addStateText){
				if (addStateText.getText().length() == 0){
					addStateText.setForeground(Color.GRAY);
					addStateText.setText(addStateTextPrompt);
				}
			} else if (e.getSource() == addZipText){
				if (addZipText.getText().length() == 0){
					addZipText.setForeground(Color.GRAY);
					addZipText.setText(addZipTextPrompt);
				}
			} 
			
		}
	}

}
