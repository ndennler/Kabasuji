package lightning;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import general.entity.StandardBoard;
import interfaces.IBoard;
import interfaces.IMovingPiece;
import interfaces.IMovingTile;
import interfaces.IPiece;
import interfaces.ITile;
import release.ReleaseTile;

public class LightningBoard extends StandardBoard implements IBoard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2332218090575897250L;
	
	public LightningBoard(){
		tiles = new LightningTile[12][12];
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				tiles[i][j] = new LightningTile(i, j, null);
			}
		}
	}
	
	public int calculateUncovered(){
		int uncovered = 0;
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				ITile t = tiles[i][j];
				if(t != null && t.getCoveredBy() == null){
					uncovered++;
				}
			}
		}
		return uncovered;
	}

}
