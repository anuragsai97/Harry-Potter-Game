package harry_potter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoadedGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadedGame frame = new LoadedGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public LoadedGame(boolean done) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheGame = new JLabel("The Game");
		lblTheGame.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblTheGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheGame.setBounds(10, 45, 414, 45);
		contentPane.add(lblTheGame);
		
		JLabel lblIs = new JLabel("is ");
		lblIs.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblIs.setBounds(10, 101, 414, 41);
		contentPane.add(lblIs);
		
		JLabel lblSet = new JLabel("SET");
		lblSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSet.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblSet.setBounds(10, 153, 414, 68);
		contentPane.add(lblSet);
	}

}
