package myfirstapplication;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.wb.swing.FocusTraversalOnArray;


/*
  		-- In this we will see how to move from one screen to another screen.you need to create object of other screen in a actionperformed method.
  		-- dispose();  //dispose will remove frame from memory								
	--component_name.requestfocus(); :-  it will help to focus on that.
 */
public class LoginForm extends JFrame {
	
	private JTextField textField;
	public static Welcome_screen screen;
	JLabel lblNewLabel = new JLabel("");
	JLabel lblNewLabel_1 = new JLabel("");	
	private JPasswordField passwordField;
	private void loginCheck()
	{
			String userid=textField.getText();
			String password=passwordField.getText();			
						
				if(userid.equals(password)  &&  (!(userid.equals("") && password.equals(""))))
					{
							Welcome_screen screen=new Welcome_screen(userid);
							this.screen=screen;
							screen.setVisible(true);
							this.setVisible(false);
							this.dispose();  //dispose will remove frame from memory								
					}
					
				if((userid.length()==0)  || (password.length()==0))
				{	
								if(userid.length()==0)
								{
									lblNewLabel.setText("*  User id can not be blank");									
										lblNewLabel.setForeground(Color.red);
										
								}
								else
								{
									lblNewLabel.setText("");
									lblNewLabel.setForeground(Color.white);
								}
								if(password.length()==0)
								{
										lblNewLabel_1.setText("*  Password can not be blank ");
										lblNewLabel_1.setForeground(Color.red);										
								}
								else
								{
									lblNewLabel_1.setText("");
									lblNewLabel_1.setForeground(Color.white);
								}
				}
				else if(!(userid.equals(password)))
				{
					lblNewLabel.setText("");
					lblNewLabel_1.setText("");
					textField.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(this, "Ivalid userid Or password !");			
				}
				else
				{			
					
				}					

	}
	
//	public static void main(String[] args) {
//		LoginForm form=new LoginForm();
//		form.setVisible(true);
//	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		try
	    {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //set look and feel depend os.
		} 
	    catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\root\\Downloads\\Untitled.png"));
		setTitle("Login");
		setResizable(false);
		setLocation(500, 200);
		getContentPane().setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 401, 300);
		getContentPane().setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setBackground(Color.RED);
		lblLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLoginForm.setForeground(Color.RED);
		lblLoginForm.setBounds(150, 23, 116, 21);
		getContentPane().add(lblLoginForm);
		
		JLabel lblUserId = new JLabel("User id");
		lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserId.setBounds(48, 77, 78, 17);
		getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(167, 74, 145, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(48, 124, 88, 21);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 124, 145, 24);
		getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
					
				loginCheck();
			}
		});
		btnLogin.setBounds(78, 186, 89, 23);
		getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("");
				lblNewLabel.setForeground(Color.white);
				lblNewLabel_1.setText("");
				lblNewLabel_1.setForeground(Color.white);				
				passwordField.setText("");
				textField.setText("");
				
				
				textField.requestFocusInWindow();
			//	passwordField.requestFocus();
				
			}
		});
		btnReset.setBounds(223, 186, 89, 23);
		getContentPane().add(btnReset);
		
		lblNewLabel.setBounds(150, 99, 197, 14);
		getContentPane().add(lblNewLabel);
		
		
		lblNewLabel_1.setBounds(150, 161, 207, 14);
		getContentPane().add(lblNewLabel_1);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblLoginForm, lblUserId, textField, passwordField, lblPassword, btnLogin, btnReset, lblNewLabel, lblNewLabel_1}));
	}
}
