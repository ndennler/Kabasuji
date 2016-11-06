package general.boundary;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import general.controller.SelectedLevelController;
import general.entity.Kabasuji;
import interfaces.IBuilderGUI;

public class NewLevelButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1380429934048039276L;
	ButtonGroup group;
	Kabasuji game;
	
	
	@Override
	public Dimension getMinimumSize() {
		int length = game.getBGUIS().size();
		return new Dimension(length*110 - 7, 67);
	}


	/** 
	 * Swing thing. We must be large enough to draw all buttons. 
	 */
	@Override
	public Dimension getPreferredSize() {
		int length = game.getBGUIS().size();
		return new Dimension(length*110 - 7, 67);
	}
	
	public NewLevelButtonPanel(BuilderMenu m, Kabasuji k) {
		game = k;
		group = m.getButtonGroup();
		int i = 0;
		for(IBuilderGUI gui: game.getBGUIS()){
			JToggleButton newBtn = new JToggleButton(gui.getLevelName());
			newBtn.setBackground(new Color(245, 245, 245));
			newBtn.setBounds(110*i, 0, 103, 67);
			group.add(newBtn);
			this.add(newBtn);
			newBtn.addActionListener(new SelectedLevelController(m, gui.newLevel()));
			i++;
		}
	}

}
