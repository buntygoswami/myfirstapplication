package myfirstapplication;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jaco.mp3.player.MP3Player;

public class Plane
{
	private int x=0;
	private int y=0;
	private Image image; 
	private int width;   
	private int height;  
	private boolean isVisible;
	private int velX;	
	private int velY;
	public void Move()  
	{		
		if(x<710)
		{		
		x=x+velX;			
		}
		else		
		{
			x=700;
		}
		if(y<450)
		{
			y=y+velY;			
		}		
		else
		{
			y=440;
		}		

		if(x<0)
		{		
				x=5;
		}
		if(y<0)
		{		
				y=5;
		}
	}
	public void donotMove()  
	{
		velX=0;  
		velY=0;  
	}
	public void direction(KeyEvent e)	
	{
		//upper arrow=38
		//down arrow=39
		//left arrow=37
		//right arrow=40
		if(e.getKeyCode()==e.VK_UP)  //38
		{
			velY=-1;		
		}
		else if(e.getKeyCode()==e.VK_DOWN)  //39
		{
			velY=1;
		}
		else if(e.getKeyCode()==e.VK_LEFT)  //37
		{
				velX=-1;			
		}
		else if(e.getKeyCode()==e.VK_RIGHT)  //40
		{							
				velX=1;		
		}		
		//Move();  //we do not call it because timer will call this function every 5 milisecond
	}
	
	public  Plane()
	{
		image=new ImageIcon(Plane.class.getResource("halicopter_2.gif")).getImage();
							//observer:- it execute when image hight width change.
		width=image.getWidth(null);//but we want null. we do not want to change higth.
		height=image.getHeight(null);
		isVisible=true;
	}	
	public int getX() 
	{
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	

}
