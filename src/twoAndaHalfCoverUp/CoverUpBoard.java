package twoAndaHalfCoverUp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import interfaces.IBoard;
import interfaces.IMovingPiece;
import interfaces.IMovingTile;
import interfaces.IPiece;
import interfaces.ITile;
import release.ReleaseTile;

public class CoverUpBoard implements IBoard{

	ITile[][] tiles;
	ArrayList<IPiece> pieces;
	IMovingTile movingTile;
	IMovingPiece movingPiece;
	
	public CoverUpBoard(){
		tiles = new CoverUpTile[12][12];
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				tiles[i][j] = new CoverUpTile(i, j, null, null);
			}
		}
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
	public void removeTile(int row, int col) {
		tiles[row][col] = null;
	}

	@Override
	public void placeTile(int row, int col, ITile t) {
		t.setRowCol(new Point(row,col));
		tiles[row][col] = t;
	}

	@Override
	public void drawBoard(Graphics g, int tileSize, int offset) {
		int j = 0;
		for(ITile[] row: tiles){
			int i = 0;
			for(ITile tile: row){
				if(tile != null){
				tile.drawTile(g, tileSize, new Point(i*tileSize/2 + offset/7,j*tileSize + offset - i*tileSize/2));
				}
				i++;
			}
			j++;
		}
	}

	@Override
	public Dimension getBoardDimension(int tileSize) {
		return new Dimension(tileSize*12, tileSize*12);
	}

	@Override
	public ITile getTile(Point p, int tileSize, int offset) {
		if((p.y - offset/7 -tileSize/4)*2/tileSize < 0 || (p.y - offset/7 -tileSize/4)*2/tileSize > tiles.length-1){return null;}
		int j = (p.y - offset/7 -tileSize/4)*2/tileSize;
		if((p.x- offset + j*tileSize/2 -tileSize/4)/tileSize < 0 || (p.x- offset + j*tileSize/2 -tileSize/4)/tileSize > tiles.length-1){return null;}
		int i = (p.x- offset + j*tileSize/2 -tileSize/4)/tileSize ;
		return tiles[i][j];
	}

	@Override
	public Point getRowColumn(Point p, int tileSize, int offset) {
		if((p.y - offset/7 -tileSize/4)*2/tileSize < 0 || (p.y - offset/7 -tileSize/4)*2/tileSize > tiles.length-1){return null;}
		int j = (p.y - offset/7 -tileSize/4)*2/tileSize;
		if((p.x- offset + j*tileSize/2 -tileSize/4)/tileSize < 0 || (p.x- offset + j*tileSize/2 -tileSize/4)/tileSize > tiles.length-1){return null;}
		int i = (p.x- offset + j*tileSize/2 -tileSize/4)/tileSize ;
		return new Point(i,j);
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
		p.setXY(new Point(row, column));
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
		p.setXY(new Point(0,0));
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
		return new CoverUpTile(row, column, null, null);
	}

}
