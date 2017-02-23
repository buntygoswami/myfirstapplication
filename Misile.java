package myfirstapplication;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Misile
{

	private int x=0;
	private int y=0;
	private Image image; 	
	private int width;   
	private int height;  	private int velX;	
	public void Move()  
	{		
		x=x+velX;			
	}
	
	public void direction(KeyEvent e)	
	{
	
			if(e.getKeyCode()==e.VK_SPACE)
			{
				velX=1;
			}
	}
	
	public Misile() 
	{
		image=new ImageIcon(Plane.class.getResource("bullet.jpg")).getImage();							//observer:- it execute when image hight width change.
		width=image.getWidth(null);//but we want null. we do not want to change higth.
		height=image.getHeight(null);
	}	

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() 
	{
		return x;
	}
	public void setX(int x) {
		this.x = x;
		
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

	
}
