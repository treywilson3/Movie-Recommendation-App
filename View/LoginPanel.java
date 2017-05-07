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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Model.Database;

/**
 * @author Trey
 * LoginPanel will be called if the user presses login
 * on the guestPanel
 */
public class LoginPanel extends JPanel {

	private TextField email;
	private JPasswordField password;
	private JButton loginButton;
	private String loginEmail;
	private String loginPassword;
	
	/**
	 * Call buttons method
	 */
	public LoginPanel() {

		buttons();
	}
	/**
	 * Where all textfields are made and actionlisteners 
	 * and focus listeners will be called when needed
	 */
	public void buttons() {
		
		JPanel control = new JPanel();
		
		control.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		MyFocusListener myFocusListener = new MyFocusListener();
		// Make textfields
		email = new TextField(20);
		email.setText("Enter Email");
		email.setForeground(Color.GRAY);
		email.addFocusListener(myFocusListener);
		password = new JPasswordField(20);
		password.setEchoChar((char) 0);
		password.setForeground(Color.GRAY);
		password.setText("Enter Password");
		password.addFocusListener(myFocusListener);
		loginButton = new JButton("Login");
		
		// Make constraints
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 1;
		control.add(email, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 2;
		control.add(password, c);
		c.fill = GridBagConstraints.SOUTH;
		c.ipady = 20;
		c.ipadx = 40;
		// c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 3;
		control.add(loginButton, c);
		
		// Add action listener for submit button
		// Check to see if entry is valid
		// If valid then see if member or employee
		// If employee then check to see if ceo
		// After verifying, call correct class
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginEmail = (String) email.getText();
				loginPassword = new String(password.getPassword());
				if (Database.verifiedMember(loginEmail, loginPassword) == true) {
					MemberPanel memberPanel = new MemberPanel(loginEmail, loginPassword);
					removeAll();
					repaint();
					add(memberPanel);
					revalidate();
				} else if (Database.verifiedEmployee(loginEmail, loginPassword)) {
					if (Database.ceo(loginEmail, loginPassword)){
						CEOPanel ceoPanel = new CEOPanel(loginEmail, loginPassword);
						removeAll();
						repaint();
						add(ceoPanel);
						revalidate();
					} else{
						EmployeePanel employeePanel = new EmployeePanel(loginEmail, loginPassword);
						removeAll();
						repaint();
						add(employeePanel);
						revalidate();
					}
					
				} else {
					confirmMessage("Wrong Information");
				}
			}
		});
		add(control);
	}
	public void confirmMessage(String prompt){
		JOptionPane.showMessageDialog(this, prompt);
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
			if (e.getSource() == email){
				email.setForeground(Color.BLACK);
				email.setText("");
			} else if (e.getSource() == password){
				password.setForeground(Color.BLACK);
				password.setText("");
				password.setEchoChar('*');
			}
		}
		@Override
		public void focusLost(FocusEvent e){
			if (e.getSource() == email){
				String length = (String) email.getText();
				if (length.length() == 0){
					email.setForeground(Color.GRAY);
					email.setText("Enter Email");
				}
			} else if (e.getSource() == password){
				String length = new String(password.getPassword());
				if (length.length() == 0) {
					password.setForeground(Color.GRAY);
					password.setEchoChar((char) 0);
					password.setText("Enter Password");
				}
			}
		}
	}
}
