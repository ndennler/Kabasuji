package general.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import general.boundary.BuilderMenu;
import interfaces.ILevel;
import interfaces.IMenu;

public class SelectedLevelController implements ActionListener {

	IMenu application;
	ILevel level;
	
	public SelectedLevelController(IMenu app, ILevel l){
		application = app;
		level = l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		application.getTextArea().setText(level.getDescription());
		application.setStarsLabel(level.getStars());
		application.setPreppedLevel(level);
	}
}
