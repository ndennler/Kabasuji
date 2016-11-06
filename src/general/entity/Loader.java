package general.entity;

import java.io.FileInputStream;
import java.io.ObjectInputStream;



public class Loader {
	
	public Loader(){}
	
	
	public LevelMemento getLevel(int x){
		FileInputStream saveFile;
		try {
			saveFile = new FileInputStream("Level" + x +".ext");
		
		@SuppressWarnings("resource")
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		LevelMemento momento = (LevelMemento) restore.readObject();
		return momento;
		
		} catch (Exception e) {
			System.err.println("There is no Level " + x + " saved." );
			return null;
		}
	}
}
