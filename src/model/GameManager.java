package model;

import java.awt.Graphics2D;

public class GameManager {
	private MyTank myTank;
	
	public GameManager(){
		init();
	}
	
	private void init(){
		myTank = new MyTank(300,300,50,50,MyTank.tankImgs[0],DynamicObject.LEFT);
	}
	
	public void drawTank(Graphics2D g2d){
		myTank.draw(g2d);
	}
	
	public void setMyTankOrientation(int orientation){
		myTank.setOrientation(orientation);
	}
	
	public void moveMyTank(){
		myTank.move();
	}
	
	public void fireMyTank(){
		myTank.addBullet();
	}
	public void drawBulletTank(Graphics2D g2d){
		myTank.drawAllBullet(g2d);
	}
	public void moveAllBulletOfMyTank(){
		myTank.moveAllBullet();
	}
}
