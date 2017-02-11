package gui;

import javax.swing.JPanel;

public abstract class BaseContainer extends JPanel {
	protected int width;
	protected int height;
	
	public BaseContainer(int width,int height){
		this.width = width;
		this.height = height;
		initPanel();
		initComponents();
		addComponents();
	}
	
	protected abstract void initPanel();
	protected abstract void initComponents();
	protected abstract void addComponents();
}
