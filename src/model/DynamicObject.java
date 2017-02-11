package model;

import java.awt.Image;

public abstract class DynamicObject extends GameObject2D{
	
	public static final int LEFT = 0;
	public static final int RIGHT = 2;
	public static final int UP = 1;
	public static final int DOWN = 3;
	public static final int BULLET = 4;
	
	protected int orientation = 0;
	
	public DynamicObject(int x, int y, int width, int height, Image img,int orientation) {
		super(x, y, width, height, img);
		this.orientation = orientation;
	}

	protected abstract void move();
}
