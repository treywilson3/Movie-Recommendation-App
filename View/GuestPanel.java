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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Guest;

public class GuestPanel extends JPanel{
	
	// Guest Page
	private JButton random;
	private Guest guest;
	private JButton search;
	private TextField searchBar;
	
	// Home button and optional label
	private JButton homeButton;
	private JLabel restartLabel;
	
	// Login or Sign up buttons
	private JButton newMemberButton;
	private JButton login;
	
	// Used for random selection
	private DefaultComboBoxModel<String>  genreChoiceModel;
	private JComboBox<String> genreChoiceBox;
	private JButton randomButton;
	private JButton go;
	
	// Layout
	private GridBagConstraints c;
	
	// Listeners
	private ActionListener myInnerClass;
	private FocusListener myFocusListener;
	
	public GuestPanel(){
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		guest = new Guest();
		myInnerClass = new MyActionListener();
		myFocusListener = new MyFocusListener();
		guestPage();
	}
	
	public void guestPage(){
		resetScreen();
		
		random = new JButton("Random");
		search = new JButton("Search");
		searchBar = new TextField(40);
		searchBar.setForeground(Color.GRAY);
		searchBar.setText("Search any Title, Actor, Genre");
		searchBar.addFocusListener(myFocusListener);
		newMemberButton = new JButton("Sign Up");
		login = new JButton("Login");

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0,20,20,0);  // side padding
		c.gridx = 0;
		c.gridy = 1;
		//c.gridheight = 1;
		//c.gridwidth = 1;
		add(random, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 1;
		c.gridy = 1;
		//c.gridwidth = 3;
		//c.gridheight = 2;
		add(searchBar, c);
		//c.gridwidth = 1;
		//c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 1;
		add(search, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 8;
		c.ipadx = 16;
		//c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 2;
		c.gridy = 5;
		add(newMemberButton, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 8;
		c.ipadx = 16;
		//c.insets = new Insets(0, 20, 20, 0); // side padding
		c.gridx = 0;
		c.gridy = 5;
		add(login, c);
		search.addActionListener(myInnerClass);
		random.addActionListener(myInnerClass);
		newMemberButton.addActionListener(myInnerClass);
		login.addActionListener(myInnerClass);
	}
	public void homeButton(String text){
		resetScreen();
		
		restartLabel = new JLabel();
		restartLabel.setText(text);
		homeButton = new JButton("Home");

		c.fill = GridBagConstraints.CENTER;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0,20,20,0);  // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(restartLabel, c);	
		c.fill = GridBagConstraints.CENTER;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0,20,20,0);  // side padding
		c.gridx = 7;
		c.gridy = 1;
		add(homeButton, c);
		homeButton.addActionListener(myInnerClass);	
	}
	public void random(){
		resetScreen();
		
		randomButton = new JButton("Random");
		go = new JButton("Go");
		genreChoiceBox = new JComboBox<String>();
		genreChoiceModel = new DefaultComboBoxModel<String>();
		
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
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0,20,20,0);  // side padding
		c.gridx = 0;
		c.gridy = 0;
		add(randomButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0,20,20,0);  // side padding
		c.gridx = 1;
		c.gridy = 0;
		add(genreChoiceBox, c);
		c.fill = GridBagConstraints.NONE;
		c.ipady = 20;
		c.ipadx = 40;
		c.insets = new Insets(0,20,20,0);  // side padding
		c.gridx = 2;
		c.gridy = 0;
		add(go, c);
		randomButton.addActionListener(myInnerClass);
		go.addActionListener(myInnerClass);
		
	}
	/**
	 * resetScreen is needed to update screen
	 */
	public void resetScreen(){
		removeAll();
		repaint();
		revalidate();
	}
	public class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == random){
				random();
			} else if (e.getSource() == randomButton){
				homeButton("");
				JTable table = guest.randomMovie();
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);	
			} else if (e.getSource() == go){
				String genre = (String) genreChoiceBox.getSelectedItem();
				homeButton("");
				JTable table = guest.randomGenre(genre);
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == homeButton){
				guestPage();
			} else if (e.getSource() == search){
				String searchData = (String) searchBar.getText();
				homeButton("");
				c.fill = GridBagConstraints.CENTER;
				c.ipady = 500;
				c.ipadx = 700;
				c.insets = new Insets(0, 20, 20, 0); // side padding
				c.gridx = 0;
				c.gridy = 1;
				JTable table = guest.search(searchData);
				JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				pane.getViewport().setBackground(Color.WHITE);
				add(pane);
			} else if (e.getSource() == newMemberButton){
				NewMemberPanel newMemberPanel = new NewMemberPanel();
				removeAll();
				repaint();
				add(newMemberPanel);
				revalidate();
			} else if (e.getSource() == login){
				LoginPanel loginPanel = new LoginPanel();
				removeAll();
				repaint();
				add(loginPanel);
				revalidate();
			}
		}
	}
	public class MyFocusListener implements FocusListener{
		@Override
		public void focusGained(FocusEvent e){
			if (e.getSource() == searchBar){
				searchBar.setForeground(Color.BLACK);
				if (searchBar.getText().equals("Search any Title, Actor, Genre")){
				searchBar.setText("");
				}
			}
		}
		@Override
		public void focusLost(FocusEvent e){
			if (e.getSource() == searchBar){
				if (searchBar.getText().length() == 0){
					searchBar.setForeground(Color.GRAY);
					searchBar.setText("Search any Title, Actor, Genre");
				}
			}
		}
	}
}

