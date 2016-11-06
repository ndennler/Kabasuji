package interfaces;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public interface ITile extends Serializable{

	public int getRow();
	public int getColumn();
	public IPiece getCoveredBy();
	
	
	public boolean tileAvailable();
	public void drawTile(Graphics g, int tileSize, Point p);
	public void setCoveredBy(IPiece piece);
	public void setRowCol(Point p);
	public IMovingTile makeMovingTile(Point p);
}
