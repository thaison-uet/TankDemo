package model;

import java.awt.Image;

import javax.swing.ImageIcon;

import gui.GUI;

public class MyTank extends Tank{
	
	protected static Image[] tankImgs = {
			new ImageIcon(MyTank.class.getResource("/images/player_green_left.png")).getImage(),
			new ImageIcon(MyTank.class.getResource("/images/player_green_up.png")).getImage(),
			new ImageIcon(MyTank.class.getResource("/images/player_green_right.png")).getImage(),
			new ImageIcon(MyTank.class.getResource("/images/player_green_down.png")).getImage()
		};
	
	private int currentOrientation;
	public MyTank(int x, int y, int width, int height, Image img, int orientation) {
		super(x, y, width, height, img, orientation);
		currentOrientation = orientation;
	}

	@Override
	protected void move() {
		switch(orientation){
		case LEFT:
			x-=3;
			if(x<=0){
				x = GUI.WIDTH_FRAME;
			}
			break;
		case RIGHT:
			x+=3;
			break;
		case UP:
			y-=3;
			if(y<=0){
				y = GUI.HEIGHT_FRAME;
			}
			break;
		case DOWN:
			y+=3;
			break;
		default:
			break;
		}
	}

	@Override
	public void setOrientation(int orientation) {
		super.setOrientation(orientation);
		if(currentOrientation!=orientation){
			img = MyTank.tankImgs[orientation];
			currentOrientation = orientation;
		}
	}
	
	

}
