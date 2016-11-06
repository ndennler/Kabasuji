package general.entity;

import java.util.ArrayList;

import interfaces.IBuilderGUI;
import interfaces.ILevel;
import interfaces.ILevelGUI;
import puzzle.PuzzleLevel;
import release.ReleaseLevel;

public class Kabasuji {

	ArrayList<ILevel> levels;
	ArrayList<ILevelGUI> levelGuis;
	ArrayList<IBuilderGUI> builderGuis;
	int currLevel;
	
	public Kabasuji(ArrayList<ILevel> g, ArrayList<IBuilderGUI> bGUIS, ArrayList<ILevelGUI> lGUIS){
		levels = g;
		levelGuis = lGUIS;
		builderGuis = bGUIS;
		currLevel = 1;
		refresh();
	}
	public Kabasuji(){
		levels = new ArrayList<ILevel>();
		currLevel = 1;
	}
	
	public void incrementCurrLevel(){
		currLevel++;
	}
	public int getCurrLevel(){
		return currLevel;
	}
	
	public ArrayList<IBuilderGUI> getBGUIS(){
		return builderGuis;
	}
	public ArrayList<ILevel> getLevels(){
		return levels;
	}
	public ArrayList<ILevelGUI> getLGUIS() {
		return levelGuis;
	}
	
	/** adds a level to the end of the level List */
	public void addLevel(ILevel l){
		levels.add(l);
	}
	
	/** removes a level by its number.*/
	public void deleteLevel(int i){
		levels.remove(i-1);
	}
	
	public ILevel getLevel(int i){
		return levels.get(i-1);
	}
	public void setStars(int levelNum, int stars){
		getLevel(levelNum).setStars(stars);
	}
	
	public int getSavedLevelNum(){
		return levels.size()+1;
	}
	
	/**
	 * reloads all the levels to make sure they are properly updated.
	 */
	public void reload(){
		Loader l = new Loader();
		
		for(int i = 1; i <= levels.size(); i++){
			for( IBuilderGUI gui: builderGuis){
				if(l.getLevel(i).getType().equals(gui.getLevelName())){
					ILevel level = gui.newLevel();
					level.restore(l.getLevel(i));
					levels.set(i-1, level);
				}
			}
			i++;
		}
	}
	
	public void refresh(){
		for(ILevelGUI gui : levelGuis){
			gui.setGame(this);
		}
		for(IBuilderGUI gui : builderGuis){
			gui.setGame(this);
		}
	}

}
