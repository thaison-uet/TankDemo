package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class GUI extends JFrame{
	public static final int WIDTH_FRAME = 800;
	public static final int HEIGHT_FRAME = 600;
	
	private Container container;
	public GUI(){
		initGUI();
		initComponents();
		addComponents();
	}
	
	private void initGUI(){
		setTitle("Day 15");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLayout(new CardLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initComponents(){
		container = new Container(WIDTH_FRAME,HEIGHT_FRAME);
	}
	private void addComponents(){
		add(container);
	}
	
}
