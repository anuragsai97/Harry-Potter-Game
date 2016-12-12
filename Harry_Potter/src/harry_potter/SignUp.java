package harry_potter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javafx.stage.Stage;

public class SignUp extends JFrame {

	/**
	 * 
        
	 */
   
   //Player pl=new Player("k",8,"l");
  user p;
     
	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField Name;
	public JPasswordField password;
	public JTextField IDfield;
	
	int id = 0;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public  SignUp() {
		String filename="Saveit.txt";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllWizardsAre = new JLabel("ALL WIZARDS ARE WELCOME");
		lblAllWizardsAre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAllWizardsAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllWizardsAre.setBounds(10, 11, 414, 26);
		contentPane.add(lblAllWizardsAre);
		
		Name = new JTextField();
		Name.setBounds(213, 75, 86, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
               
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(157, 78, 46, 14);
		contentPane.add(lblName);
		
		
		password = new JPasswordField();
		password.setBounds(213, 102, 86, 20);
		contentPane.add(password);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(129, 105, 74, 14);
		contentPane.add(lblPassword);
		
		IDfield = new JTextField();
		IDfield.setBounds(213, 133, 86, 20);
		contentPane.add(IDfield);
		IDfield.setColumns(10);
		
		try{
			
                       
		}catch(NumberFormatException e){
			System.out.println("Exception found");
		};
		
		JLabel lblIdinteger = new JLabel("ID(Integer):");
		lblIdinteger.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdinteger.setBounds(129, 136, 74, 14);
		contentPane.add(lblIdinteger);
		
		
		JButton btnEnterTheRealm = new JButton("Enter the Realm of Magic");
		btnEnterTheRealm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnterTheRealm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
                                    id=Integer.parseInt(IDfield.getText());
                                    String name=Name.getText();
                                    String pswrd=password.getPassword().toString();
                                    //System.out.println(name);
                                    //System.out.println(id);
                                    //System.out.println(pswrd);
                                   
                                      p=user.SignUp(filename, name, id, pswrd);
                                      
                                       
                                       Test t=new Test();
                                        t.setdetails(p);
					LoadedGame lg=new LoadedGame(true);
					lg.setVisible(true);
                                  //  Stage theStage = null;
                                        //t.start(theStage);
                                     //   Test.main(String[] args);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnEnterTheRealm.setBounds(129, 186, 198, 23);
		contentPane.add(btnEnterTheRealm);
	}

}
