package lightning;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SetTimeController implements ChangeListener {

	JSpinner timeLeft;
	LightningLevel level;
	
	public SetTimeController(JSpinner time, LightningLevel l){
		timeLeft = time;
		level = l;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int timeAllotted = (int)timeLeft.getValue();
		level.setTimeLeft(timeAllotted);
	}

}
