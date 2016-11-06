package twoAndaHalfCoverUp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import general.entity.MovingTile;
import interfaces.IMovingTile;
import interfaces.IPiece;
import interfaces.ITile;

public class CoverUpTile implements ITile {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 106916646234719946L;
	int row;
	int col;
	IPiece coveredBy;
	Color color;

	public CoverUpTile(int i, int j, IPiece p, Color c) {
		row = i;
		col = j;
		coveredBy = p;
		color = c;
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return col;
	}

	@Override
	public IPiece getCoveredBy() {
		return coveredBy;
	}

	@Override
	public boolean tileAvailable() {
		return coveredBy == null;
	}

	@Override
	public void drawTile(Graphics g, int tileSize, Point p) {
		Polygon tileShape = new Polygon();
		tileShape.addPoint(p.y + tileSize/4, p.x + tileSize/4);
		tileShape.addPoint(p.y + tileSize + tileSize/4, p.x + tileSize/4);
		tileShape.addPoint(p.y + tileSize/2 + tileSize/4, p.x+tileSize/2 + tileSize/4);
		tileShape.addPoint(p.y-tileSize/2 + tileSize/4, p.x + tileSize/2 + tileSize/4);
		g.setColor(Color.white);
		if(coveredBy != null){
			g.setColor(coveredBy.getColor());
		}
		if(color != null){
			g.setColor(color);
		}
		g.fillPolygon(tileShape);
		g.setColor(Color.black);
		g.drawPolygon(tileShape);
	}

	@Override
	public void setCoveredBy(IPiece piece) {
		coveredBy = piece;
	}

	@Override
	public void setRowCol(Point p) {
		row = p.x;
		col = p.y;

	}

	@Override
	public IMovingTile makeMovingTile(Point p) {
		return new MovingTile(this, p);
	}

	public void setColor(Color c){
		color = c;
	}
}
