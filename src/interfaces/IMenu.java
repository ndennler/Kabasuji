package interfaces;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public interface IMenu {

	public JTextArea getTextArea();
	public JLabel getImageLabel();
	public ILevel getPreppedLevel();
	public void setPreppedLevel(ILevel l);
	public void setStarsLabel(int stars);
}
