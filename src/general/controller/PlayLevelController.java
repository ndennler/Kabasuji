package general.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import general.boundary.PlayerMenu;
import general.entity.Kabasuji;
import general.entity.Loader;
import interfaces.IBuilderGUI;
import interfaces.ILevel;
import interfaces.ILevelGUI;

public class PlayLevelController implements ActionListener{

	Kabasuji game;
	ILevel level;
	PlayerMenu fromPanel;
	Loader load = new Loader();
	
	public PlayLevelController(Kabasuji k, PlayerMenu p){
		game = k;
		fromPanel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level = fromPanel.getPreppedLevel();
		if(level == null){return;}
		
		for(ILevelGUI g: game.getLGUIS()){
			if(g.getLevelType().equals(level.getType())){
				g.restore(load.getLevel(level.getNumber()));
				fromPanel.dispose();
			}
		}
	}
}
