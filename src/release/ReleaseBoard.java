package release;

import java.awt.Color;

import general.entity.StandardBoard;
import interfaces.ITile;


public class ReleaseBoard extends StandardBoard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2160008766965498077L;

	public ReleaseBoard(){
		tiles = new ReleaseTile[12][12];
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				tiles[i][j] = new ReleaseTile(i, j, null, null, 0);
			}
		}
	}

	public void getCoveredNumbers(boolean[] red, boolean[] blue, boolean[] green){
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				//you can only access this method from a release board, which is made of release tiles,
				//so we know the tiles are release tiles.
				ReleaseTile tile = (ReleaseTile) tiles[i][j];
				if(tile != null){
					if(tile.color != null && tile.number > 0 && tile.number < 7){
						if(tile.color.equals(Color.red) && tile.getCoveredBy() != null){
							red[tile.number - 1] = true;
						}
						if(tile.color.equals(Color.blue) && tile.getCoveredBy() != null){
							blue[tile.number - 1] = true;
						}
						if(tile.color.equals(Color.green) && tile.getCoveredBy() != null){
							green[tile.number - 1] = true;
						}
					}
				}
			}
		}
	}
	
	@Override
	public ITile makeBlankTile(int row, int column) {
		return new ReleaseTile(row, column, null, null, 0);
	}
}
