package general.boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import general.controller.SelectedLevelController;
import general.entity.Kabasuji;
import interfaces.ILevel;

public class LevelSelectButtonPanel extends JPanel {

	Kabasuji game;
	PlayerMenu menu;
	
	/**
	 * Create the panel.
	 */
	public LevelSelectButtonPanel(PlayerMenu p, Kabasuji k) {
		menu = p;
		game = k;
		
		int i = 0;
		for(ILevel l: game.getLevels()){
			JToggleButton newBtn = new JToggleButton("" + l.getNumber());
			newBtn.setFont(new Font("Constantia", Font.PLAIN, 30));
			newBtn.setBackground(new Color(245, 245, 245));
			newBtn.setBounds(10 + 100*(i%2), 10 + 90*(i/2), 90, 80);
			menu.getButtonGroup().add(newBtn);
			this.add(newBtn);
			newBtn.addActionListener(new SelectedLevelController(menu, l));
			if(l.getNumber() > game.getCurrLevel()){
				newBtn.setText("");
				newBtn.setIcon(new ImageIcon(PlayerMenu.class.getResource("/images/Locked.png")));
				newBtn.setEnabled(false);
			}
			i++;
		}
	}

	@Override
	public Dimension getMinimumSize() {
		int height = game.getLevels().size();
		return new Dimension(134, height*60);
	}


	/** 
	 * Swing thing. We must be large enough to draw all buttons. 
	 */
	@Override
	public Dimension getPreferredSize() {
		int height = game.getLevels().size();
		return new Dimension(134, height*60);
	}
}
