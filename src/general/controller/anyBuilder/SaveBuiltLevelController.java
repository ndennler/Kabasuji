package general.controller.anyBuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import general.boundary.BuilderMenu;
import general.entity.Kabasuji;
import general.entity.LevelMemento;
import interfaces.IBuilderGUI;
import interfaces.ILevel;

public class SaveBuiltLevelController implements ActionListener{

	IBuilderGUI original;
	Kabasuji game;
	
	public SaveBuiltLevelController(IBuilderGUI o, Kabasuji g){
		original = o;
		game = g;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ILevel level = original.getLevel();
		try {
			LevelMemento memento = level.createMemento();
			String fileName = "";
			if(level.getNumber() == 0){
				//you were creating a new level
				fileName = "Level"+game.getSavedLevelNum()+".ext";
				//set the level's number and make a new memento
				level.setNumber(game.getSavedLevelNum());
				memento = level.createMemento();
				game.addLevel(level);
			}
			else{
				//you were editing an existing level
				fileName = "Level"+level.getNumber()+".ext";
			}
			File saveFile = new File (fileName);
			
			FileOutputStream saving = new FileOutputStream(saveFile);
			ObjectOutputStream save = new ObjectOutputStream(saving);
			save.writeObject(memento);
			save.close();
			
			original.dispose();
			game.reload();
			BuilderMenu b = new BuilderMenu(game);
			b.setVisible(true);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
