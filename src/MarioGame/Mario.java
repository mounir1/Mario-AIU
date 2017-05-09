package MarioGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Mario {
	
	
	int x,y;
	String MarioDir = "Down";
	Image Mario;
	ImageIcon iMarioDown  = new ImageIcon ("Images/mario_down.gif");
	ImageIcon iMarioRight = new ImageIcon ("Images/mario_right.gif");
	ImageIcon iMarioUp    = new ImageIcon ("Images/mario_up.gif");
	ImageIcon iMarioLeft  = new ImageIcon ("Images/mario_left.gif");
	
	
	public Mario(int startx,int starty){
		x=startx;
		y=starty;
		
	}
	public Rectangle getBounds(){
		Rectangle Box = new Rectangle(x,y,34,34);
		return Box;
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String getDir(){
		return MarioDir;
	}
	public void setX(int newX){
		this.x = newX;
	}
	public void setY(int newY){
		this.y = newY;
	}
	public void SetDir(String newDir){
		this.MarioDir = newDir;
	}
	public Image getImage(){
		if (MarioDir == "Down")
			Mario = iMarioDown.getImage();
		else if (MarioDir == "Right")
			Mario = iMarioRight.getImage();
		else if (MarioDir == "Left")
			Mario = iMarioLeft.getImage();
		else if (MarioDir == "Up")
			Mario = iMarioUp.getImage();
		
		return Mario;
	}
	public void Move (){
		if (MarioDir == "Down")
			this.y+=34;
		else if (MarioDir == "Right")
			this.x +=34;
		else if (MarioDir == "Left")
			this.x -=34;
		else if (MarioDir == "Up")
			this.y -=34;
	}




}