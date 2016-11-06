package release;

import java.util.ArrayList;

import general.entity.HorizontalBullpen;
import general.entity.LevelMemento;
import interfaces.IBoard;
import interfaces.IBullpen;
import interfaces.IHint;
import interfaces.ILevel;

public class ReleaseLevel implements ILevel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8087382882633632507L;
	ReleaseBoard board;
	IBullpen bullpen;
	ArrayList<IHint> hints;
	int stars;
	int number;
	
	boolean[] redCovered;
	boolean[] blueCovered;
	boolean[] greenCovered;
	
	public ReleaseLevel(){
		board = new ReleaseBoard();
		bullpen = new HorizontalBullpen();
		hints = new ArrayList<IHint>();
		stars = 0;
		redCovered = new boolean[]{false, false, false, false, false , false};
		greenCovered = new boolean[]{false, false, false, false, false , false};
		blueCovered = new boolean[]{false, false, false, false, false , false};
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
		return "Release";
	}

	@Override
	public void update() {
		board.getCoveredNumbers(redCovered, blueCovered, greenCovered);
		
		int star = 3;
		for(boolean b: redCovered){
			if(!b){
				star--;
				break;
			}
		}
		for(boolean b: blueCovered){
			if(!b){
				star--;
				break;
			}
		}
		for(boolean b: greenCovered){
			if(!b){
				star--;
				break;
			}
		}
		stars = star;
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
		board = (ReleaseBoard) l.getBoard();
		bullpen = l.getBullpen();
		hints = l.getHints();
		number = l.getNumber();
		stars = l.getStars();
		redCovered = (boolean[]) l.getExtraLogic().get(0);
		blueCovered = (boolean[]) l.getExtraLogic().get(1);
		greenCovered = (boolean[]) l.getExtraLogic().get(2);

	}

	@Override
	public LevelMemento createMemento() {
		ArrayList<Object> extraLogic = new ArrayList<Object>();
		extraLogic.add(redCovered);
		extraLogic.add(blueCovered);
		extraLogic.add(greenCovered);		
		return new LevelMemento(board, bullpen, hints, stars, number, extraLogic, getType());
	}
	
	public String getRedText(){
		String s = "";
		Integer number = 1;
		boolean prevCovered = false;
		for(int i = 0; i < 6; i++){
			if(redCovered[i]){
				if(number > 1 && prevCovered){
					s = s + ", ";
				}
				s = s + number.toString();
				prevCovered = true;
			}
			number = number + 1;
		}
		return s;
	}
	
	public String getBlueText(){
		String s = "";
		Integer number = 1;
		boolean prevCovered = false;
		for(int i = 0; i < 6; i++){
			if(blueCovered[i]){
				if(number > 1 && prevCovered){
					s = s + ", ";
				}
				s = s + number.toString();
				prevCovered = true;
			}
			number = number + 1;
		}
		return s;
	}
	
	public String getGreenText(){
		String s = "";
		Integer number = 1;
		boolean prevCovered = false;
		for(int i = 0; i < 6; i++){
			if(greenCovered[i]){
				if(number > 1 && prevCovered){
					s = s + ", ";
				}
				s = s + number.toString();
				prevCovered = true;
			}
			number = number + 1;
		}
		return s;
	}


	@Override
	public void setNumber(int savedLevelNum) {
		number = savedLevelNum;
	}


	@Override
	public String getDescription() {
		return "Cover the sets of numbers.";
	}


	@Override
	public ArrayList<Object> getExtraLogic() {
		ArrayList<Object> extraLogic = new ArrayList<Object>();
		extraLogic.add(redCovered);
		extraLogic.add(blueCovered);
		extraLogic.add(greenCovered);
		return extraLogic;
	}


	@Override
	public void setStars(int s) {
		stars = s;
		
	}

}
