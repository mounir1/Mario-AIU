package MarioGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall {
	int x,y;
	Image wall;
	
	public Wall(int startx, int starty){
		x = startx;
		y = starty;
		
		ImageIcon iwall = new ImageIcon ("Images/wall.jpg");
		wall = iwall.getImage();
	
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
	public Image getImage(){
		return wall;
	}
	
}

