package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuGame extends BaseContainer{
	private JButton btnPlay;
	private CardLayout cardLayout;
	IShowPanel iShowPanel;
	public MenuGame(int width, int height) {
		super(width, height);
	}

	@Override
	protected void initPanel() {
		setSize(width,height);
		setBackground(Color.BLUE);
		setLayout(null);
	}

	@Override
	protected void initComponents() {
		btnPlay = new JButton();
		btnPlay.setText("Play");
		btnPlay.setBounds((GUI.WIDTH_FRAME-150)/2,(GUI.HEIGHT_FRAME-100)/2,150,100);
		
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(getParent(),Container.PLAY);
				iShowPanel.showPanel();
			}
		});
	}

	@Override
	protected void addComponents() {
		add(btnPlay);
	}
	
	public void setIShowPanel(IShowPanel iShowPanel){
		this.iShowPanel  = iShowPanel;
	}
	public void setCardLayout(CardLayout cardLayout){
		this.cardLayout = cardLayout;
	}
	

}
