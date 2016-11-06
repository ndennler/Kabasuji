package general.entity;

import java.awt.Graphics;
import java.awt.Point;

import interfaces.IMovingTile;
import interfaces.ITile;

public class MovingTile implements IMovingTile {

	ITile tile;
	Point location;
	
	public MovingTile(ITile t, Point l){
		tile = t;
		location = l;
	}
	@Override
	public void drawMovingTile(int tileSize, Graphics g) {
		Point drawn = new Point(location.y-tileSize/2, location.x-tileSize/2);
		tile.drawTile(g, tileSize, drawn);

	}

	@Override
	public void setPoint(Point p) {
		location = p;
	}

	@Override
	public ITile getTile() {
		return tile;
	}

}
