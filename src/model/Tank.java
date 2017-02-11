package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Tank extends DynamicObject{
	private BulletManager bulletManager;
	
	public Tank(int x, int y, int width, int height, Image img, int orientation) {
		super(x, y, width, height, img, orientation);
		bulletManager = new BulletManager();
	}
	
	public void setOrientation(int orientation){
		this.orientation = orientation;
	}
	public void addBullet(){
		int xBullet = x;
		int yBullet = y;
		int sizeBullet = 12;
		switch(orientation){
		case LEFT:
			xBullet = x - sizeBullet;
			yBullet = y + (height - sizeBullet)/2;
			break;
		case RIGHT:
			xBullet = x + width;
			yBullet = y + (height - sizeBullet)/2;
			break;
		case UP:
			xBullet = x + (height - sizeBullet)/2;
			yBullet = y - sizeBullet;
			break;
		case DOWN:
			xBullet = x + (height - sizeBullet)/2;
			yBullet = y + height;
			break;
		default : break;
		}
		Bullet bullet = new Bullet(xBullet, yBullet, sizeBullet,sizeBullet,Bullet.img,orientation);
		bulletManager.addBullet(bullet);
	}
	
	public void drawAllBullet(Graphics2D g2d){
		bulletManager.drawAllBullet(g2d);
	}
	
	public void moveAllBullet(){
		bulletManager.moveAllBullet();
	}
	
}
