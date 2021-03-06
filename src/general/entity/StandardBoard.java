package general.entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import interfaces.IBoard;
import interfaces.IMovingPiece;
import interfaces.IMovingTile;
import interfaces.IPiece;
import interfaces.ITile;

/**
 * Generic board model.
 * Override methods based on specific board type.
 * Be Sure to override make blank tile with the appropriate tile for your board type.
 * @author Nathan
 *
 */
public class StandardBoard implements IBoard{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4136777700135938139L;
	protected ITile[][] tiles;
	protected ArrayList<IPiece> pieces;
	protected IMovingTile movingTile;
	protected IMovingPiece movingPiece;
	
	@Override
	public ITile[][] getTiles() {
		return tiles;
	}

	@Override
	public ArrayList<IPiece> getPieces() {
		return pieces;
	}

	@Override
	public IMovingTile getMovingTile() {
		return movingTile;
	}

	@Override
	public IMovingPiece getMovingPiece() {
		return movingPiece;
	}
	
	@Override
	public void setMovingTile(IMovingTile t) {
		movingTile = t;
		
	}

	@Override
	public void setMovingPiece(IMovingPiece p) {
		movingPiece = p;
		
	}

	@Override
	public void drawBoard(Graphics g, int tileSize, int offset) {
		 int j = 0;
		for(ITile[] row: tiles){
			int i = 0;
			for(ITile tile: row){
				if(tile != null){
				tile.drawTile(g, tileSize, new Point(i*tileSize + offset,j*tileSize + offset));
				}
				i++;
			}
			j++;
		}

	}

	@Override
	public Dimension getBoardDimension(int tileSize) {
		return new Dimension(tiles.length*tileSize, tiles[0].length*tileSize);
	}

	@Override
	public ITile getTile(Point p, int tileSize, int offset) {
		if((p.x- offset)/tileSize < 0 || (p.x- offset)/tileSize > tiles.length-1){return null;}
		if((p.y - offset)/tileSize < 0 || (p.y - offset)/tileSize > tiles.length-1){return null;}
		return tiles[(p.x- offset)/tileSize][(p.y - offset)/tileSize];
	}

	@Override
	public boolean placePiece(int row, int column, IPiece p) {
		for(Point disp: p.getShape()){
			if(row+disp.x > tiles.length-1 || row+disp.x < 0 ||  column+disp.y > tiles.length-1 || column+disp.y < 0){return false;}
			if(tiles[row+disp.x][column+disp.y] == null){return false;}
			if(!tiles[row+disp.x][column+disp.y].tileAvailable()){
				return false;
			}
		}
		for(Point disp: p.getShape()){
			tiles[row+disp.x][column+disp.y].setCoveredBy(p);
			}
		return true;
		}
		


	@Override
	public IPiece pickUpPiece(int row, int column) {
		IPiece p = tiles[row][column].getCoveredBy();
		for(ITile[] rows: tiles){
			for(ITile tile: rows){
				if(tile != null){
					if(tile.getCoveredBy() == p){
						tile.setCoveredBy(null);
					}
				}
			}
		}
		return p;
	}

	@Override
	public int numberofTiles() {
		int number = 0;
		for(ITile[] row : tiles){
			for(ITile tile : row){
				if(tile != null){
					number++;
				}
			}
		}
		return number;
	}

	@Override
	public ITile makeBlankTile(int row, int column) {
		return null;
	}

	@Override
	public void removeTile(int i, int j) {
		tiles[i][j] = null;
	}

	/**
	 * returns a point in (row, column) form for the given point on the board.
	 */
	@Override
	public Point getRowColumn(Point p, int tileSize, int offset) {
		if((p.x- offset)/tileSize < 0 || (p.x- offset)/tileSize > tiles.length-1){return null;}
		if((p.y - offset)/tileSize < 0 || (p.y - offset)/tileSize > tiles.length-1){return null;}
		return new Point((p.x- offset)/tileSize,(p.y - offset)/tileSize);
	}

	@Override
	public void placeTile(int row, int col, ITile t) {
		t.setRowCol(new Point(row,col));
		tiles[row][col] = t;
		
	}
}
