package myfirstapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Tik_tak extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		Tik_tak tak=new Tik_tak();
		tak.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Tik_tak() 
	{
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		setBackground(Color.ORANGE);
		setResizable(false);
		setTitle("Tik-Tak");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setBounds(500, 100, 411, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Tik_tak.class.getResource("/myfirstapplication/right.jpg")));
		button.setBounds(0, 0, 136, 143);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Tik_tak.class.getResource("/myfirstapplication/cross.png")));
		button_1.setBounds(0, 142, 136, 143);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(0, 285, 136, 143);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(137, 285, 136, 143);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(137, 142, 136, 143);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(137, 0, 136, 143);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(273, 285, 136, 143);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(273, 142, 136, 143);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setBounds(273, 0, 136, 143);
		contentPane.add(button_8);
	}
}
