/*
b  		//relative path

 


		//meta information:- about class member and etc.
		//resource : - every file.vlc file,audio file.
		//Timer class:- it is basically used for mulitithreading.
		// thread :- each main() generate is thread.
		//progress bar:- we need to write code for running progress bar.
		 * 				-- also use counter for increase the value of progress bar. 
 		//add songs on welcome screen
 		 * jacomp3 jar download
 		 * http://jacomp3player.sourceforge.net/
 		 * 
 		  
 */
package myfirstapplication;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.UIManager;

import jaco.mp3.player.MP3Player;

public class Introductio_screen extends JWindow {
	JLabel lblLoading = new JLabel("Please wait...");
	JProgressBar progressBar = new JProgressBar();
	
	private JPanel contentPane;
	JLabel lblNewLabel = new JLabel("");
	Timer timer;         //we will  timer class. it will use for multithreading.
	private final int DELAY = 200;  //1 second
	private boolean isVisible1 = false;
	private boolean isVisible = false;
	private int counter_progress=0;
    MP3Player player;  
	private void songs()
	{
		player=new MP3Player(Introductio_screen.class.getResource("Taio_Cruz.mp3"));	    
	    player.play();	   	    
	    //or
	    	
//		player=new MP3Player(new File("Taio_Cruz.mp3"));  
//		player.play();  //play sound
	}	
	private void animation()
	{
		ActionListener action=new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				lblLoading.setVisible(isVisible1);
				isVisible1=!isVisible1;
				progressBar.setValue(counter_progress++);
				if(counter_progress>=100)
				{
					timer.stop();  //close thread
					player.stop();  //stop sound.
					Introductio_screen.this.setVisible(false);  //closing Inroduction screen.
					LoginForm form=new LoginForm();				//opening login frame.
					form.setVisible(true);					
				}
			}
		};				
					//1 second  //what to do .
		
		timer=new Timer(DELAY,action);								
		timer.start(); //new thread start.
						//Animation(action listerner code will execute) will be start.
		
	
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		
		Introductio_screen introductio_screen=new Introductio_screen();
		introductio_screen.setVisible(true);
		introductio_screen.animation();
		introductio_screen.songs();
	}

	/**
	 * Create the frame.
	 */
	public Introductio_screen() {
		//setTitle("Loading...");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setBounds(320, 140, 630, 524);
		contentPane = new JPanel();
		contentPane.requestFocusInWindow();  //set focus on introduction screen . if i will not use that when use press alt+f4 then introduction screen will be close.
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setIcon(new ImageIcon(Introductio_screen.class.getResource("animation.gif")));
		lblNewLabel.setBounds(10, 11, 604, 449);
		contentPane.add(lblNewLabel);
		
		lblLoading.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoading.setForeground(Color.RED);
		lblLoading.setBackground(Color.CYAN);
		lblLoading.setBounds(269, 452, 256, 47);
		contentPane.add(lblLoading);
		progressBar.setBackground(Color.BLACK);
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.CYAN);
		progressBar.setBounds(57, 485, 504, 14);
		contentPane.add(progressBar);
		
		//relative path 
		//meta information:- about class member and etc.
		//resource : - every file.vlc file,audio file.

		
	}
}
