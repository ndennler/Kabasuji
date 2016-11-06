package interfaces;

import javax.swing.JFrame;

import general.entity.Kabasuji;
import general.entity.LevelMemento;

public interface ILevelGUI {

	public String getLevelType();
	public ILevel getGenericLevel();
	public JFrame getFrame();
	public void setProgressBar(int p);
	public void dispose();
	public void setGame(Kabasuji k);
	public void restore(LevelMemento level);
}
