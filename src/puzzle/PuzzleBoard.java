package puzzle;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import interfaces.IBoard;
import interfaces.IMovingPiece;
import interfaces.IMovingTile;
import interfaces.IPiece;
import interfaces.ITile;

public class PuzzleBoard implements IBoard, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4081067273900896344L;
	ITile[][] tiles;
	ArrayList<IPiece> pieces;
	IMovingTile movingTile;
	IMovingPiece movingPiece;
	
	public PuzzleBoard(){
		tiles = new PuzzleTile[12][12];
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				tiles[i][j] = new PuzzleTile(i, j, null);
			}
		}
		pieces = new ArrayList<IPiece>();
	}
	
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
		return new PuzzleTile(row, column, null);
	}

	@Override
	public void removeTile(int i, int j) {
		tiles[i][j] = null;
	}

	@Override
	public Point getRowColumn(Point p, int tileSize, int offset) {
		if((p.x- offset)/tileSize < 0 || (p.x- offset)/tileSize > tiles.length-1){return null;}
		if((p.y - offset)/tileSize < 0 || (p.y - offset)/tileSize > tiles.length-1){return null;}
		return new Point((p.x- offset)/tileSize, (p.y - offset)/tileSize);
	}

	@Override
	public void placeTile(int row, int col, ITile t) {
		t.setRowCol(new Point(row,col));
		tiles[row][col] = t;
		
	}



}

