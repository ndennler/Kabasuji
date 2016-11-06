package interfaces;

import java.awt.Graphics;
import java.awt.Point;

/**
 * A Moving Tile consists of an ITile and a Point at which it will be drawn in the boundary object.
 * @author Nathan
 *
 */
public interface IMovingTile {

	public void drawMovingTile(int tileSize, Graphics g);
	public void setPoint(Point p);
	
	public ITile getTile();
}
