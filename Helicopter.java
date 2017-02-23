package myfirstapplication;
/*
    Audio no:- amit sir audio 24

     --> Setlocationrelavetive(null):  that function will set my gaming panel based on my os window.  or open window on center. 
     --> Setfocusable(true) :- when application open focus cursur should be on appliction.
     --> board.
     --> Paint componenet call it self.
     --> panel contain life cycle of paint component. we will create board on panel.
     --> frame will contain panel.
     --> Graphics is parent class of 2d and 3d.
     	-> it contain lot of function.
     --> this class is not game launher class. 
     		--then create another class(normal class).
          
 */
	

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Helicopter extends JFrame {

	//size of board where game will run.  //step-1
	static final  int Board_width=770;  
	static final  int Board_higth=510;	
	private JPanel contentPane;		
//	public static Helicopter helicopter=null;  //when working with helicopter main.
	public  Board board;
	
//	public static void main(String[] args)
//	{
//		helicopter=new Helicopter();
//		helicopter.setVisible(true); 	
//	}	
	public Helicopter()
	{
	
	//	setResizable(false);		
		try 
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(board, "Unable to Get theme");
			//e.printStackTrace();
		}			   		
		setTitle("Helicopter - 2017 1.1");				
		//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //after comment Welcome window will not close.
		//		setBounds(100, 100, 450, 300);
		
		this.setSize(761, 502);   //step:-2         //BOARD HIGHT AND WIDTH
		this.setLocationRelativeTo(null);         //step:-3         //Board will open center of window		
				
		contentPane = new JPanel();  
		// it is only logically area.jpanel ka upar paint karta hai.
		// window and frame k upar paint component nahi hota.
		// panel have a paint compopent.
		// paint compoent k ander graphics pass hoga.
		
		Board board=new Board();               //step:-4
		board.setForeground(Color.RED);
		board.setBackground(Color.WHITE);
		this.getContentPane().setLayout(null);				
		this.getContentPane().add(board);      //step:-5 //set board(panel) on jframe		
	}
}
