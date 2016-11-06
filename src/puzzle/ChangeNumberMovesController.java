package puzzle;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeNumberMovesController implements ChangeListener{

	JSpinner moves;
	PuzzleLevel level;
	
	public ChangeNumberMovesController(JSpinner m, PuzzleLevel l){
		level = l;
		moves = m;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int movesLeft = (int) moves.getValue();
		level.setMovesLeft(movesLeft);
	}
}
