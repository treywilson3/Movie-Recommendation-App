package View;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
/**
 * @author Trey
 * Main creates Jframe and menu bar
 */
public class Main {
	private JFrame frame;
	private JMenuBar menuBar;

	/**
	 * Create frame, set menubar, and call guestPanel
	 */
	public Main() {
		frame = new JFrame();
		
		frame.setTitle("450");
		frame.setSize(1100,750);
		frame.setLayout(new GridBagLayout());
		frame.setJMenuBar(createMenuBar());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuestPanel guestPanel = new GuestPanel();
		frame.add(guestPanel);
		frame.setVisible(true);

	}
	public JMenuBar createMenuBar() {
		// Create menubar
		menuBar = new JMenuBar();
		// file will be added to menu bar
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		fileMenu.add(exitItem);
		// Have prompt so app doesn't automatically close
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you really want to exit the application?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		menuBar.add(fileMenu);
		return menuBar;
	}

	public static void main(String[] args) {
		// Create Nimubs Look and Feel
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    try {
		        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    } catch (Exception ex) {
		 
		    }
		}
		// Call Main
		new Main();
	}

}
