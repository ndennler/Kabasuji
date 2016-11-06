package interfaces;

import java.io.Serializable;
import java.util.ArrayList;
import general.entity.LevelMemento;

public interface ILevel extends Serializable{

	public IBoard getBoard();
	public IBullpen getBullpen();
	public ArrayList<IHint> getHints();
	public int getStars();
	public int getNumber();
	public String getType();
	public String getDescription();
	public ArrayList<Object> getExtraLogic();
	
	public void update();
	public void timeUpdate();
	public boolean isCompleted();
	
	public void restore(LevelMemento l);
	public LevelMemento createMemento();
	public void setNumber(int savedLevelNum);
	public void setStars(int s);
}
