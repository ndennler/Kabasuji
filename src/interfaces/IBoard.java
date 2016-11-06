package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Interface that encapsulate generic board behavior.
 * 
 * @param tiles - shape of the board (ITile[][])
 * @param pieces - pieces on the board (ArrayLIst<IPiece>)
 * @param movingPiece - piece hovering over the board (IMovingPiece)
 * @param movingTile - tile hovering over the board (IMovingTile)
 * 
 * @author Nathan
 *
 */
public interface IBoard extends Serializable{

	/**
	 * return the array of tiles that dictates the shape of the board.
	 * @return
	 */
	public ITile[][] getTiles();
	/**
	 * return the pieces that are on the board.
	 * @return
	 */
	public ArrayList<IPiece> getPieces();
	/**
	 * return the current moving tile.
	 * You may return null if there is no moving tile.
	 * @return
	 */
	public IMovingTile getMovingTile();
	/**
	 * return the moving piece.
	 * you may return null if there is no moving piece.
	 * @return
	 */
	public IMovingPiece getMovingPiece();
	
	/**
	 * this is what you use to set the moving tile in a controller that changes the state of a moving tile.
	 * @param t - the tile that will be moving.
	 */
	public void setMovingTile(IMovingTile t);
	/**
	 * this is what you use to set the moving piece in a controller that changes the state of a moving piece.
	 * @param p - the piece that will be moving.
	 */
	public void setMovingPiece(IMovingPiece p);
	/**
	 * this is used in conjunction with setMovingtile when you are moving a board tile (in the builder).
	 * @param row - the tiles original row.
	 * @param col - the tiles original column.
	 */
	public void removeTile(int row, int col);
	/**
	 * placing the new tile in a different position when moving tiles in the builder. 
	 * @param row - row of the destination.
	 * @param col - column of the destination.
	 * @param t - the tile to be placed(may contain additional information other than row or column).
	 */
	public void placeTile(int row, int col, ITile t);
	/**
	 * Tells a graphics object how to draw the specific board.
	 * 
	 * @param g - graphics object.
	 * @param tileSize - size in pixels of a tile
	 * @param offset - the offset of the board in the panel
	 */
	public void drawBoard(Graphics g, int tileSize, int offset);
	/**
	 * returns the size of the board in pixels so the panel that will draw it will know what size to make itself.
	 * @param tileSize - the size of the tile.
	 * @return
	 */
	public Dimension getBoardDimension(int tileSize);
	
	/**
	 * return the tile 
	 * @param p - point in row column form.
	 * @param tileSize
	 * @param offset
	 * @return
	 */
	public ITile getTile(Point p, int tileSize, int offset);
	/**
	 * return a point in row column form that gives the row and column information of the place that has been clicked on the board.
	 * @param p
	 * @param tileSize
	 * @param offset
	 * @return
	 */
	public Point getRowColumn(Point p, int tileSize, int offset);
	/**
	 * place a piece at the row and column.
	 * return true if the piece was successfully placed, or false if it was not.
	 * @param row - the row at which you are adding the piece.
	 * @param column - the column at which you are adding the piece.
	 * @param p - the piece being added.
	 * @return
	 */
	public boolean placePiece(int row, int column, IPiece p);
	/**
	 * picks up a piece at a given row or column.
	 * @param row
	 * @param column
	 * @return the piece being picked up.
	 */
	public IPiece pickUpPiece(int row, int column);
	/**
	 * returns the total number of tiles currently on the board.
	 * a null tile does not count as a tile. i.e. return the number of tile objects on the board.
	 * @return
	 */
	public int numberofTiles();
	/**
	 * return the specific tile object that corresponds to the board type.
	 * i.e. return a Puzzle Tile if your board is made of puzzle tiles.
	 * @param row
	 * @param column
	 * @return
	 */
	public ITile makeBlankTile(int row, int column);
	
}
