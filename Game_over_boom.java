package myfirstapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;

public class Game_over_boom extends JWindow {

	private JPanel contentPane;
	private JButton btnNewButton;
	public static Helicopter helicopter=null;
//public static void main(String[] args) {
//	Game_over_boom boom=new Game_over_boom();
//	boom.setVisible(true);
//}

	public Game_over_boom() 
	{
		setLocationRelativeTo(null);
//		setTitle("Game over");
//		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 170, 504, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("play AGAIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				System.out.println("play again call");
				dispose();  //Releases all of the native screen resources used by this Window, its subcomponents, and all of its owned children
				helicopter=new Helicopter();
				//Helicopter.helicopter=helicopter;			//when working with main helicopter
				helicopter.setVisible(true);			
			}
		});
		
		btnNewButton.setIcon(new ImageIcon(Game_over_boom.class.getResource("/myfirstapplication/play again.gif")));
		btnNewButton.setBounds(138, 141, 258, 58);
		contentPane.add(btnNewButton);		
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{				
				System.out.println("game close");
		//		dispose();              //Releases all of the native screen resources used by this Window, its subcomponents, and all of its owned children
				System.exit(1);
			}
		});
		
		
		btnNewButton_1.setIcon(new ImageIcon(Game_over_boom.class.getResource("/myfirstapplication/exit.png")));
		btnNewButton_1.setBounds(200, 210, 123, 52);
		contentPane.add(btnNewButton_1);
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Game_over_boom.class.getResource("game over.gif")));
		lblNewLabel.setBounds(0, 0, 540, 314);
		contentPane.add(lblNewLabel);
	}
}
