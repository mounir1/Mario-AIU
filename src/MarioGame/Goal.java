package MarioGame;


import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Goal {
	int x,y;
	Image Goal;
	boolean Cashtop = false;
	public Goal(int startx , int starty){
		x = startx;
		y = starty;
		
		ImageIcon iGoal = new ImageIcon ("Images/Goal.jpg");
		Goal = iGoal.getImage();
		
	}
	public Rectangle getBounds(){
		Rectangle Box = new Rectangle(x,y,34,34);
		return Box;
		
	}
	public boolean getCashtop(){
		return Cashtop;
	}
	public void setCashtop(boolean cashtop){
		this.Cashtop = cashtop;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Image getImage(){
		return Goal;
	}

}