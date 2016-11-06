package interfaces;

import java.awt.Graphics;
import java.awt.Point;
/**
 * A Moving Tile consists of an ITile and a Point at which it will be drawn in the boundary object.
 * @author Nathan
 *
 */
public interface IMovingPiece {
	
	public void drawMovingPiece(int tileSize, Graphics g);
	public void setPoint(Point p);
	
	public IPiece getPiece();
	
	public boolean isFromBullpen();
	public void setFromBullpen(boolean b);
}
