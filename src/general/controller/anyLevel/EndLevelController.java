package general.controller.anyLevel;

import javax.swing.JOptionPane;

import general.boundary.PlayerMenu;
import general.entity.Kabasuji;
import interfaces.ILevel;
import interfaces.ILevelGUI;

public class EndLevelController {

	ILevel level;
	ILevelGUI from;
	Kabasuji game;
	
	public EndLevelController(ILevel l, ILevelGUI g, Kabasuji k){
		level = l;
		game = k;
		from = g;
		if(l.isCompleted()){
		endLevel();
		}
	}
	
	void endLevel(){
		JOptionPane.showMessageDialog(from.getFrame(),
			    "You have Completed This Level!",
			    "Level Completed",
			    JOptionPane.PLAIN_MESSAGE);
		if(game.getLevel(level.getNumber()).getStars() < level.getStars()){
			if(level.getNumber() == game.getCurrLevel()){
				game.incrementCurrLevel();
			}
			game.setStars(level.getNumber(), level.getStars());
		}
		from.dispose();
		new PlayerMenu(game).setVisible(true);
	}
}
