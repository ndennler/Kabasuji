package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public interface IPiece extends Serializable{

	public ArrayList<Point> getShape();
	public int getIdentity();
	public int getRow();
	public int getColumn();
	public Color getColor();
	
	/**
	 * returns an identical copy of the current piece.
	 * @return
	 */
	public IPiece clone();
	/**returns a moving piece with the same piece and at point p.
	 * 
	 * @param p
	 * @param b - if the piece is from the bullpen, this is true.
	 * @return
	 */
	public IMovingPiece makeMoving(Point p, boolean fromBullpen);
	
	/**
	 * Edits the points so that they are relatively balanced about the point (0,0)
	 */
	public void center();
	/**
	 * Flips each point in the piece so that the entire piece is flipped.
	 * @param direction - true if vertical false if horizontal.
	 */
	public void flip(boolean direction);
	/**
	 * Rotates each point in the piece so that the entire piece is rotated.
	 * @param direction - true if clockwise false if counter clockwise.
	 */
	public void rotate(boolean direction);
	public void setXY(Point p);
	public void drawPiece(Graphics g, int tileSize, Point p);
}
