package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet extends DynamicObject {
	public static Image img = new ImageIcon(Bullet.class.getResource("/images/bullet.png")).getImage();
	public Bullet(int x, int y, int width, int height, Image img, int orientation) {
		super(x, y, width, height, img, orientation);
	}

	@Override
	protected void move() {
		switch(orientation){
		case LEFT :
			x-=4;
			break;
		case RIGHT:
			x+=4;
			break;
		case UP:
			y-=4;
			break;			
		case DOWN:
			y+=4;
			break;
		}
	}
	
}


