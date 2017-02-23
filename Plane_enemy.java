package myfirstapplication;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Plane_enemy
{
	private int x=400;
	private int y=270;
	private int tempx=400;
	private int tempy=270;	
	private Image image; 
	private int width;   
	private int height; 
	public void Move()  
	{
		x--;						
	}
	
	public Plane_enemy(int x,int y) 
	{
		tempx=this.x=x;
		tempy=this.y=y;
		image=new ImageIcon(Plane.class.getResource("ENEMY IMAGE.gif")).getImage();
		//observer:- it execute when image hight width change.
		width=image.getWidth(null);//but we want null. we do not want to change higth.
		height=image.getHeight(null);
	}
	public int getTempx() {
		return tempx;
	}

	public void setTempx(int tempx) {
		this.tempx = tempx;
	}

	public int getTempy() {
		return tempy;
	}

	public void setTempy(int tempy) {
		this.tempy = tempy;
	}


	public int getX() {
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

}
