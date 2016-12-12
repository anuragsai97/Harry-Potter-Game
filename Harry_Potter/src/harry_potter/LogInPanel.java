package harry_potter;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LogInPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Name;
	private JPasswordField passwordField;
	user P;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPanel frame = new LogInPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInPanel() {
		String filename="Savit.txt";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeBackTo = new JLabel("WELCOME BACK TO HOGWARTS");
		lblWelcomeBackTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblWelcomeBackTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBackTo.setBounds(10, 11, 414, 52);
		contentPane.add(lblWelcomeBackTo);
		
		Name = new JTextField();
		Name.setBounds(227, 104, 86, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		String name=Name.getText();
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(144, 107, 73, 14);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(120, 138, 97, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 135, 86, 20);
		contentPane.add(passwordField);
		String password=passwordField.getPassword().toString();
		
		JPanel LoadPanel = new JPanel();
		LoadPanel.setBounds(0, 0, 434, 261);
		contentPane.add(LoadPanel);
		LoadPanel.setLayout(null);
		
		JButton Loginbutton = new JButton("Log In");
		Loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Loginbutton.setBounds(183, 183, 89, 23);
		LoadPanel.add(Loginbutton);
		
		Loginbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					P=user.LogIn(filename, name, password);
					boolean done=false;
					if(P!=null)
						done=true;
					LoadedGame lg=new LoadedGame(done);
					lg.setVisible(true);
							//new Player(name, id, password);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//P=Player.LoadGame(filename,name);
				//Player P = logIn("Saveit.txt",name, password);
			}
		});
		
	}
}
