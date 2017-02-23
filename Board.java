package myfirstapplication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * this class contain the logic of game.
	
 
 */
public class Board extends JPanel{
	
	private JPanel contentPane;
	private Plane plane; 
	private int Enemyleft=6;
	private Plane_enemy plane_enemy;
	private Graphics2D twoD; 
	private Misile misile;
	public ArrayList<Plane_enemy> enemies=new ArrayList<>();
	private Timer timer;
	final int DELAY = 5;	
	static private Boolean Playagin=false;
	public void drawenemy()
	{		
		for(int i=0;i<=6;i++)
		{
//		int tempx=enemies.get(i).getX();
//			enemies.get(i).setX(tempx-1);					
			twoD.drawImage(enemies.get(i).getImage(),enemies.get(i).getX() , enemies.get(i).getY(),this);		
			twoD.drawImage(misile.getImage(),misile.getX() , misile.getY(),this);								
		}
		for(int i=0;i<=6;i++)    //changing value of plnae.
		{
				if(enemies.get(i).getX()==1)
				{
					enemies.get(i).setX(enemies.get(4).getTempx());
				}
		}

//		twoD.drawImage(enemies.get(1).getImage(),enemies.get(1).getX() , enemies.get(1).getY(),this);		
//		twoD.drawImage(enemies.get(2).getImage(),enemies.get(2).getX() , enemies.get(2).getY(),this);		
//		twoD.drawImage(enemies.get(3).getImage(),enemies.get(3).getX() , enemies.get(3).getY(),this);		
//		twoD.drawImage(enemies.get(4).getImage(),enemies.get(4).getX() , enemies.get(4).getY(),this);	
//		twoD.drawImage(enemies.get(5).getImage(),enemies.get(5).getX() , enemies.get(5).getY(),this);			
//		twoD.drawImage(enemies.get(6).getImage(),enemies.get(6).getX() , enemies.get(6).getY(),this);	
	}
	public void checkcolesion()
	{		
		 Rectangle player = new Rectangle(plane.getX(), plane.getY(), plane.getHeight(), plane.getWidth());
	     for(int i=0;i<6;i++)
	     {
		     Rectangle enemy = new Rectangle(enemies.get(i).getX(), enemies.get(i).getY(), enemies.get(i).getHeight(), enemies.get(0).getWidth());	     
	   //  System.out.println(player.intersects(enemy));
		 	if(player.intersects(enemy))
		 	{		 
				if(Playagin==false)//when game over boom execute first time.
			   {
//					System.out.println("Welcome_screen.helicopter.setVisible(false");
					Welcome_screen.helicopter.setVisible(false);//it will run only one time when welcome will start helicopter game.			   			  
					Playagin=true;
//					System.out.println("playagin truebunty");
			   }
			   else//when game over boom second time and user selected playgain.
			   {
//			     System.out.println("Game_over_boom.helicopter.setVisible(false)");
			     Game_over_boom.helicopter.setVisible(false);
			   }
			   //			   Helicopter.helicopter.setVisible(false);  //when working  with main of Helicopter.
//			   System.out.println("timer stop.");
			   timer.stop();
//			   System.out.println("game over object create");
			   Game_over_boom boom=new Game_over_boom();
			   boom.setVisible(true);
//			   System.out.println("game over");		   		 		 		
		 		}
		 	else
		 	{
		 		//System.out.println("enemy left"+Enemyleft);
		 	}
	   }
	
	}
	public void updateGame(){
		timer = new Timer(DELAY,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{

				plane.Move();
				misile.Move();
				enemies.get(0).Move();
				enemies.get(1).Move();
				enemies.get(2).Move();
				enemies.get(3).Move();
				enemies.get(4).Move();
				enemies.get(5).Move();
				enemies.get(6).Move();		
			}
		});
		timer.start();
	}	
	
	@Override 
	public void paintComponent(Graphics g)  //it come from jpanel
	{
		super.paintComponent(g);       
		twoD = (Graphics2D)g;		
		if(plane.isVisible())   //isvisible like getter. using for getting value bolean.
		{					
			ImageIcon image=new ImageIcon(Board.class.getResource("earth.jpeg"));  											
			twoD.drawImage(image.getImage(),2,0,this);		
			image=new ImageIcon(Board.class.getResource("halicopter_2.gif"));   //player plane
//			twoD.drawImage(image.getImage(), 10, 70, this); //not working moving.
			twoD.drawImage(plane.getImage(), plane.getX(), plane.getY(), this);	
			drawenemy();
			checkcolesion();	
			repaint(); 			// we can use this method for calling paint component method.remember first time only jpanel call paincomponent.					
		}		
	}
	public Board() 
	{			
		
		this.setBounds(0,0,Helicopter.Board_width,Helicopter.Board_higth);
		this.setBackground(Color.BLACK);
		this.setFocusable(true);		
		//this will execute when any key pressed.
		//now create Plane(spacecreft) class which contain logic of whne keyrelead and keypressd.
			plane_enemy= new Plane_enemy(710,70);  //plane_enemy object create .						
			enemies.add(plane_enemy);
			plane_enemy= new Plane_enemy(800,130);  //plane_enemy object create .						
			enemies.add(plane_enemy);
			plane_enemy= new Plane_enemy(900,250);  //plane_eneymy object create .						
			enemies.add(plane_enemy);
			plane_enemy= new Plane_enemy(600,70);  ////plane_eneymy object create .						
			enemies.add(plane_enemy);
			plane_enemy= new Plane_enemy(700,230);  ////plane_eneymy object create .						
			enemies.add(plane_enemy);
			plane_enemy= new Plane_enemy(650,370);  ////plane_eneymy object create .						
			enemies.add(plane_enemy);
			plane_enemy= new Plane_enemy(550,220);  ////plane_eneymy object create .						
			enemies.add(plane_enemy);			
			System.out.println("plane enemy add");
			
		plane= new Plane();  //plane object create .		
		misile=new Misile();
		misile.setX(plane.getX()+misile.getX());
		misile.setY(plane.getY()+misile.getY());
		this.addKeyListener(new KeyAdapter() //keyadapter which contain all blank method .   //it will execute when any key pressed.
		{				
			
			@Override
			public void keyReleased(KeyEvent e) 
			{		
					plane.donotMove();											
			}			
			@Override
			public void keyPressed(KeyEvent e)  //keypressed also provide code(ascii) of key. other then keytyped does not prvoide code.
			{				
				
				plane.direction(e);			
				misile.direction(e);
			}			
		});		
		
		
		
		updateGame();		
	}
}
