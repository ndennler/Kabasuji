package lightning;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import general.controller.anyLevel.EndLevelController;
import general.entity.Kabasuji;

public class TimeDecrementController implements ActionListener{
	
	LightningLevel level;
	JLabel timeLeft;
	LightningLevelGUI application;
	Kabasuji game;
	
	public TimeDecrementController(LightningLevel l, JLabel t, LightningLevelGUI app, Kabasuji k){
		level = l;
		timeLeft = t;
		application = app;
		game = k;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(level.timeLeft >= 0 && level.stars < 3 && application.isVisible()){
			level.timeUpdate();
			timeLeft.setText(level.timeLeft.toString());
		}
		if(level.timeLeft == 0){
			level.timeUpdate();
			new EndLevelController(level, application, game);
		}
	}
}
