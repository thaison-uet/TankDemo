package model;

import java.awt.Graphics2D;
import java.awt.Image;

import gui.GUI;

public abstract class GameObject2D {
	protected int x,y,width,height;
	protected Image img;
	
	public GameObject2D(int x,int y,int width,int height,Image img){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = img;
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(img,x%GUI.WIDTH_FRAME,y%GUI.HEIGHT_FRAME,width,height,null);
	}
}
