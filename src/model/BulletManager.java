package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class BulletManager {
	private List<Bullet> bullets;
	
	public BulletManager(){
		bullets = new ArrayList<>();	
	}
	
	public void addBullet(Bullet bullet){
		bullets.add(bullet);
	}
	
	public void drawAllBullet(Graphics2D g2d){
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).draw(g2d);
		}
	}
	
	public void moveAllBullet(){
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).move();
		}
	}
	
}

