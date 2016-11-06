package lightning;

import java.util.ArrayList;

import general.entity.HorizontalBullpen;
import general.entity.LevelMemento;
import interfaces.IBoard;
import interfaces.IBullpen;
import interfaces.IHint;
import interfaces.ILevel;


public class LightningLevel implements ILevel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5301293320318204887L;
	LightningBoard board;
	IBullpen bullpen;
	ArrayList<IHint> hints;
	int stars;
	int number;
	Integer timeLeft;
	
	public LightningLevel(){
		board = new LightningBoard();
		bullpen = new HorizontalBullpen();
		hints = new ArrayList<IHint>();
		stars = 0;
		number = 0;
		timeLeft = 15;
	}
	
	@Override
	public IBoard getBoard() {
		return board;
	}

	@Override
	public IBullpen getBullpen() {
		return bullpen;
	}

	@Override
	public ArrayList<IHint> getHints() {
		return hints;
	}

	@Override
	public int getStars() {
		return stars;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public String getType() {
		return "Lightning";
	}

	@Override
	public String getDescription() {
		return "Cover all the Squares as fast as possible.";
	}

	@Override
	public ArrayList<Object> getExtraLogic() {
		ArrayList<Object> logic = new ArrayList<Object>();
		logic.add(timeLeft);
		return logic;
	}

	@Override
	public void update() {
		int uncovered = board.calculateUncovered();
		if(uncovered > 12){
			stars = 0;
		}
		if(uncovered > 6 && uncovered <= 12){
			stars = 1;
		}
		if(uncovered > 0 && uncovered <= 6){
			stars = 2;
		}
		if(uncovered == 0){
			stars = 3;
		}
	}

	@Override
	public void timeUpdate() {
		timeLeft--;
	}

	@Override
	public boolean isCompleted() {
		return timeLeft < 0 || stars == 3;
	}

	@Override
	public void restore(LevelMemento l) {
		board = (LightningBoard) l.getBoard();
		bullpen = l.getBullpen();
		hints = l.getHints();
		stars = l.getStars();
		number = l.getNumber();
		timeLeft = (int) l.getExtraLogic().get(0);
	}

	@Override
	public LevelMemento createMemento() {
		ArrayList<Object> logic = new ArrayList<Object>();
		logic.add(timeLeft);
		return new LevelMemento(board, bullpen, hints, stars, number, logic, getType());
	}

	@Override
	public void setNumber(int savedLevelNum) {
		number = savedLevelNum;
	}
	
	public void setTimeLeft(int t){
		timeLeft = t;
	}

	@Override
	public void setStars(int s) {
		stars = s;
		
	}

}
