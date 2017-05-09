package MarioGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Box {
	int x,y;
	String State = "Normal";
	Image Box;
	ImageIcon iBoxNormal = new ImageIcon("Images/Box.jpg");
	ImageIcon iBoxGoal = new ImageIcon("Images/Box_ok.jpg");
	boolean BoxTrue = false;
	
	public Box(int startx , int starty){
		x = startx;
		y = starty;
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
	public void setX(int newX){
		this.x = newX;
	}
	public void setY(int newY){
		this.y = newY;
	}
	public boolean getTrue(){
		return BoxTrue;
	}
	public void setTrue (boolean newTrue){
		this.BoxTrue = newTrue;
	}
	public void setState(String newState){
            if (newState == "Goal")
                    this.State = newState;
	}
	public String getState(){
		return State;
	}
	
	public Image getImage(){
		if(State == "Normal")
			Box = iBoxNormal.getImage();
		else if (State == "Goal")
			Box = iBoxGoal.getImage();
		return Box;
	}
}
