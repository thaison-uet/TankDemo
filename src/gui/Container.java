package gui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class Container extends BaseContainer implements IShowPanel{
	public static final String MENU = "MENU";
	public static final String PLAY = "PLAY";
	
	private CardLayout cardLayout;
	private GameContainer gameContainer;
	private MenuGame menuGame;
	public Container(int width,int height){
		super(width,height);
	}
	
	@Override
	protected void initPanel() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
	}

	@Override
	protected void initComponents() {
		gameContainer = new GameContainer(width,height);
		menuGame = new MenuGame(width,height);
		menuGame.setIShowPanel(this);
	}

	@Override
	protected void addComponents() {
		add(menuGame,MENU);
		add(gameContainer,PLAY);
		cardLayout.show(this,MENU);
	}

	@Override
	public void showPanel() {
		cardLayout.show(this,Container.PLAY);
		gameContainer.requestFocus();
	}
	
	
}
