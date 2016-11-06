package puzzle;

import java.util.ArrayList;


import general.entity.HorizontalBullpen;
import general.entity.LevelMemento;
import interfaces.IBoard;
import interfaces.IBullpen;
import interfaces.IHint;
import interfaces.ILevel;

public class PuzzleLevel implements ILevel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1354431603391070891L;
	IBoard board;
	IBullpen bullpen;
	ArrayList<IHint> hints;
	int stars;
	int number;
	Integer movesLeft;
	
	public PuzzleLevel(){
		board = new PuzzleBoard();
		bullpen = new HorizontalBullpen();
		hints = new ArrayList<IHint>();
		stars = 0;
		number = 0;
		movesLeft = 15;
	}
	
	public void setMovesLeft(int m){
		movesLeft = m;
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
	public int getStars() {
		return stars;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void update() {
		if(movesLeft > 0){
			movesLeft = movesLeft - 1;
		}
		int hovering = 0;
		if(board.getMovingPiece() != null){hovering = 1;}
		if(bullpen.getPieces().size() + hovering== 0){
			stars = 3;
		}
		if(bullpen.getPieces().size() + hovering == 1){
			stars = 2;
		}
		if(bullpen.getPieces().size() + hovering == 2){
			stars = 1;
		}
	}

	@Override
	public boolean isCompleted() {
		return movesLeft == 0 || stars == 3;
	}

	@Override
	public ArrayList<IHint> getHints() {
		return hints;
	}

	@Override
	public void timeUpdate() {
		return;
	}

	@Override
	public void restore(LevelMemento l) {
		board = l.getBoard();
		bullpen = l.getBullpen();
		hints = l.getHints();
		stars = l.getStars();
		number = l.getNumber();
		movesLeft = (int) l.getExtraLogic().get(0);
	}

	@Override
	public LevelMemento createMemento() {
		ArrayList<Object> logic = new ArrayList<Object>();
		logic.add(movesLeft);
		return new LevelMemento(board, bullpen, hints, stars, number, logic, getType());
	}

	@Override
	public String getType() {
		return "Puzzle";
	}

	@Override
	public void setNumber(int savedLevelNum) {
		number = savedLevelNum;	
	}

	@Override
	public String getDescription() {
		return "Fit all the pieces on the board.";
	}

	@Override
	public ArrayList<Object> getExtraLogic() {
		ArrayList<Object> logic = new ArrayList<Object>();
		logic.add(movesLeft);
		return logic;
	}

	@Override
	public void setStars(int s) {
		stars = s;
		
	}

}
