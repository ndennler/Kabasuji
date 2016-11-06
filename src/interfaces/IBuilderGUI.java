package interfaces;

import general.entity.Kabasuji;
import general.entity.LevelMemento;

public interface IBuilderGUI{

	public String getLevelName();
	public String getDescription();
	public void restore(LevelMemento m);
	public void newBuilder(ILevel l);
	public ILevel newLevel();
	public ILevel getLevel();
	public void dispose();
	public void setVisible(boolean b);
	public void setGame(Kabasuji k);
}
