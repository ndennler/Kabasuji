package lightning;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import general.entity.MovingTile;
import interfaces.IMovingTile;
import interfaces.IPiece;
import interfaces.ITile;

public class LightningTile implements ITile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2225501884930586660L;
	int row;
	int column;
	IPiece coveredBy;
	
	public LightningTile(int r, int c, IPiece p){
		row = r;
		column = c;
		coveredBy = p;
	}
	
	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public IPiece getCoveredBy() {
		return coveredBy;
	}

	@Override
	public boolean tileAvailable() {
		return true;
	}

	@Override
	public void drawTile(Graphics g, int tileSize, Point p) {
		g.setColor(Color.white);
		g.fillRect(p.y, p.x, tileSize, tileSize);
		if(coveredBy != null){
			g.setColor(Color.green);
			g.fillRect(p.y, p.x, tileSize, tileSize);
		}
		g.setColor(Color.black);
		g.drawRect(p.y, p.x, tileSize, tileSize);
	}

	@Override
	public void setCoveredBy(IPiece piece) {
		coveredBy = piece;
	}

	@Override
	public void setRowCol(Point p) {
		row = p.x;
		column = p.y;
	}

	@Override
	public IMovingTile makeMovingTile(Point p) {
		return new MovingTile(this, p);
	}

}
