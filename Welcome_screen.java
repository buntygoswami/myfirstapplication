package myfirstapplication;
//audio no 22
 //audio no 23

//
//  setExtendedState(MAXIMIZED_BOTH); it will open window on full screen.
	/*
		jmeunu bar
			--jmenu1				--jmenu2
		    		--jmenu item1		--jmenu item1
		    		--jmenu item2		--jmenu item2
		    		
		window action listerner for conforamtion of closing of cross.
		adapter class : - it is class who implments all the method of interface and all the method are blank. so we have to use adapter class instead of window lister. this abstract implmentd all the method window action action lister.
	*/

//
/*
 	
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class Welcome_screen extends JFrame 
{
	private JPanel contentPane;
	public static Helicopter helicopter;
//	public static void main(String[] args) 
//	{
//		Welcome_screen screen=new Welcome_screen("demo");
//		screen.setVisible(true);
//	}
	private void askforclosing()
	{
		int retur=0;
		int choice=JOptionPane.showConfirmDialog(this, "Do you want to exit", "Confirm", JOptionPane.YES_NO_OPTION);		
		if(choice==JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(this, "Thanks for using Gameing application");
			this.setVisible(false);		
		}		
	}

	private void askforlogout() 
	{
		int choice=JOptionPane.showConfirmDialog(this, "Are you Sure you want to Logout", "Confirm", JOptionPane.YES_NO_OPTION);
		if(choice==JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(this, "Thanks for Using Gameing Application");
			LoginForm loginForm=new LoginForm();
			loginForm.setVisible(true);
			LoginForm.screen.setVisible(false);
		}		
	}
	private void start_Tik_tak()
	{	
			Tik_tak tak=new Tik_tak();
			tak.setVisible(true);
	}
	private void start_helicopter()
	{
		
		helicopter=new Helicopter();
		helicopter.setVisible(true);		
	}

	private void help()
	{
		JOptionPane.showMessageDialog(this, "Version 1.0 \n Gaming application \n For more information visit www.google.com or contact [Pro]");
	}
	/**
	 * Create the frame.
	 */
	public Welcome_screen(String userid)
	{
		try
	    {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //set look and feel depend os.
		} 
	    catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			  askforclosing();
			}
		});
		setTitle("Welcome "+userid);
		setForeground(Color.RED);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("About");
		menuBar.setBackground(SystemColor.textHighlight);
		menuBar.setForeground(SystemColor.textHighlight);
		this.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setForeground(Color.ORANGE);
		mnFile.setBackground(Color.ORANGE);
		mnFile.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnFile);
		
		JMenuItem mntmTiktak = new JMenuItem("       Tik-Tak");
		mntmTiktak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
					start_Tik_tak();
			}
		});
		mnFile.add(mntmTiktak);
		
		JMenuItem mntmTiktak2 = new JMenuItem("       Helicopter ");
		mntmTiktak2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start_helicopter();				
			}
		});
		mnFile.add(mntmTiktak2);
		
		JMenuItem mntmExit = new JMenuItem("       Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				askforclosing();
				
			}
		});
		mnFile.add(mntmExit);
		JMenu mnLogout = new JMenu(userid.toUpperCase());
		mnLogout.setForeground(Color.ORANGE);
		mnLogout.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnLogout);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  	askforlogout();
							
			}

		});
		mnLogout.add(mntmNewMenuItem_1);
		
		JMenu mnAbout = new JMenu("Help");
		mnAbout.setForeground(Color.ORANGE);
		mnAbout.setBackground(Color.LIGHT_GRAY);
		mnAbout.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnAbout);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("      About");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				help();
			}
		});		
		mnAbout.add(mntmNewMenuItem);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		JLabel lblWelcome = new JLabel("Welcome "+userid);
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setFont(new Font("Palace Script MT", Font.BOLD | Font.ITALIC, 86));
		lblWelcome.setBackground(Color.ORANGE);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcome, BorderLayout.CENTER);				
	}
}
