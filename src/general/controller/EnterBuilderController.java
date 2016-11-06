package general.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import general.boundary.BuilderMenu;
import general.entity.Kabasuji;
import general.entity.Loader;
import interfaces.IBuilderGUI;
import interfaces.ILevel;

public class EnterBuilderController implements ActionListener{

	Kabasuji game;
	ILevel level;
	BuilderMenu fromPanel;
	Loader load = new Loader();
	
	public EnterBuilderController(Kabasuji g, BuilderMenu f){
		game = g;
		fromPanel = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level = fromPanel.getPreppedLevel();
		if(level == null){return;}
		if(level.getNumber() == 0){
			//if the level number is zero, you are trying to create a new level.
			for(IBuilderGUI g: game.getBGUIS()){
				if(g.getLevelName().equals(level.getType())){
					g.newBuilder(level);
					fromPanel.dispose();
				}
			}
		}else{
			//otherwise you are loading a level
			for(IBuilderGUI g: game.getBGUIS()){
				if(g.getLevelName().equals(level.getType())){
					g.restore(load.getLevel(level.getNumber()));
					fromPanel.dispose();
				}
			}
		}

	}
}
