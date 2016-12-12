 package harry_potter;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LogInOrSignUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInOrSignUp frame = new LogInOrSignUp();
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
	public LogInOrSignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlatform = new JLabel("PLATFORM 9 3/4");
		lblPlatform.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblPlatform.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlatform.setBounds(10, 11, 414, 46);
		contentPane.add(lblPlatform);
		
		JRadioButton nomuggle = new JRadioButton("I am not a MUGGLE");
		nomuggle.setFont(new Font("Tahoma", Font.BOLD, 15));
		nomuggle.setHorizontalAlignment(SwingConstants.CENTER);
		nomuggle.setBounds(124, 175, 206, 23);
		contentPane.add(nomuggle);
		
		JButton Enter = new JButton("ENTER");
		Enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nomuggle.isSelected()){
					LogInPanel log=new LogInPanel();
					log.setVisible(true);
				}
			}
		});
		Enter.setBounds(73, 128, 105, 23);
		contentPane.add(Enter);
		
		JButton Register = new JButton("REGISTER");
		Register.setBounds(270, 128, 105, 23);
		contentPane.add(Register);
		Register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nomuggle.isSelected()){
					SignUp signup=new SignUp();
					signup.setVisible(true);
				}
			}
		});
		
		
	
		/*ImageIcon icon = new ImageIcon("thefatlady.jpg");
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		contentPane.add(thumb);*/
	}
}
