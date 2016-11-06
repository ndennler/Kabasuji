package general.entity;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.*;

public class LevelMemento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6702998304594920993L;
	
	String type;
	IBoard board;
	IBullpen bullpen;
	ArrayList<IHint> hints;
	int stars;
	int number;
	/**
	 * this is where you store all the logic specific to the level.
	 * you have to remember how you store it when you load it. 
	 */
	ArrayList<Object> extraLogic;
	
	public LevelMemento(IBoard bd, IBullpen bp, ArrayList<IHint> h, int s, int n, ArrayList<Object> logic, String t){
		board = bd;
		bullpen = bp;
		hints = h;
		stars = s;
		number = n;
		extraLogic = logic;
		type = t;
	}
	
	public IBoard getBoard(){
		return board;
	}
	public IBullpen getBullpen(){
		return bullpen;
	}
	public ArrayList<IHint> getHints(){
		return hints;
	}
	public int getStars(){
		return stars;
	}
	public int getNumber(){
		return number;
	}
	public ArrayList<Object> getExtraLogic(){
		return extraLogic;
	}
	public String getType(){
		return type;
	}
}
