package general.boundary;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import general.controller.SelectedLevelController;
import general.entity.Kabasuji;
import interfaces.ILevel;

public class ExistingLevelButtonPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8611744890852203001L;
	ButtonGroup group;
	Kabasuji game;
	
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
	
	/**
	 * Create the panel.
	 */
	public ExistingLevelButtonPanel(BuilderMenu b, Kabasuji k) {
		group = b.getButtonGroup();
		game = k;
		int i = 0;
		for(ILevel l: game.getLevels()){
			JToggleButton newBtn = new JToggleButton(l.getType() + " " + l.getNumber());
			newBtn.setBackground(new Color(245, 245, 245));
			newBtn.setBounds(0, 60*i, 134, 60);
			group.add(newBtn);
			this.add(newBtn);
			newBtn.addActionListener(new SelectedLevelController(b, l));
			i++;
		}
	}

}
