package twoAndaHalfCoverUp;

import java.awt.Color;
import java.util.ArrayList;

import general.entity.HorizontalBullpen;
import general.entity.LevelMemento;
import interfaces.IBoard;
import interfaces.IBullpen;
import interfaces.IHint;
import interfaces.ILevel;
import interfaces.ITile;
import lightning.LightningBoard;

public class CoverUpLevel implements ILevel{

	CoverUpBoard board;
	IBullpen bullpen;
	ArrayList<IHint> hints;
	int stars;
	int number;
	boolean bluesCovered;
	boolean greensCovered;
	boolean yellowsCovered;
	
	public CoverUpLevel(){
		board = new CoverUpBoard();
		bullpen = new HorizontalBullpen();
		hints = new ArrayList<IHint>();
		stars = 0;
		number = 0;
		bluesCovered = false;
		greensCovered = false;
		yellowsCovered = false;
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
		return "Cover Up";
	}

	@Override
	public String getDescription() {
		return "Cover all the colored squares with the colored squares in the pieces";
	}

	@Override
	public ArrayList<Object> getExtraLogic() {
		ArrayList<Object> logic = new ArrayList<Object>();
		logic.add(bluesCovered);
		logic.add(greensCovered);
		logic.add(yellowsCovered);
		return logic;
	}

	@Override
	public void update() {
		int s = 0;
		if(bluesCovered){
			s++;
		}
		if(greensCovered){
			s++;
		}
		if(yellowsCovered){
			s++;
		}
		stars = s;
	}

	@Override
	public void timeUpdate() {
		return;
	}

	@Override
	public boolean isCompleted() {
		return stars == 3 || bullpen.getPieces().isEmpty();
	}

	@Override
	public void restore(LevelMemento l) {
		board = (CoverUpBoard) l.getBoard();
		bullpen = l.getBullpen();
		hints = l.getHints();
		stars = l.getStars();
		number = l.getNumber();
		bluesCovered = (boolean) l.getExtraLogic().get(0);
		greensCovered = (boolean) l.getExtraLogic().get(1);
		yellowsCovered = (boolean) l.getExtraLogic().get(2);
		
	}

	@Override
	public LevelMemento createMemento() {
		return new LevelMemento(board, bullpen, hints, stars, number, getExtraLogic(), getType());
	}

	@Override
	public void setNumber(int savedLevelNum) {
		number = savedLevelNum;
	}

	@Override
	public void setStars(int s) {
		stars = s;
	}

	public String getBlueText() {
		int total = 0;
		int covered = 0;
		for(ITile[] rows: board.tiles){
			for(ITile tile: rows){
				if(tile != null){
					if(((CoverUpTile)tile).color == Color.BLUE){
						total++;
					}
					if(tile.getCoveredBy() != null){
						covered++;
					}
				}
			}
		}
		return "" + covered + " / " + total;
	}

	public String getGreenText() {
		int total = 0;
		int covered = 0;
		for(ITile[] rows: board.tiles){
			for(ITile tile: rows){
				if(tile != null){
					if(((CoverUpTile)tile).color == Color.GREEN){
						total++;
					}
					if(tile.getCoveredBy() != null){
						covered++;
					}
				}
			}
		}
		return "" + covered + " / " + total;
	}

	public String getYellowText() {
		int total = 0;
		int covered = 0;
		for(ITile[] rows: board.tiles){
			for(ITile tile: rows){
				if(tile != null){
					if(((CoverUpTile)tile).color == Color.YELLOW){
						total++;
					}
					if(tile.getCoveredBy() != null){
						covered++;
					}
				}
			}
		}
		return "" + covered + " / " + total;
	}

}
