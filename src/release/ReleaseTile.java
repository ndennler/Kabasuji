package release;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import general.entity.MovingTile;
import interfaces.IMovingTile;
import interfaces.IPiece;
import interfaces.ITile;

public class ReleaseTile implements ITile {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3432058864868757064L;
	int row;
	int column;
	IPiece coveredBy;
	/** must be one of Color.red, Color.Blue, Color.Green */
	Color color;
	Integer number;
	
	public ReleaseTile(int ro, int col, IPiece c, Color co, int num){
		row = ro;
		column = col;
		coveredBy = c;
		color = co;
		number = num;
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
		return coveredBy == null;
	}

	@Override
	public void drawTile(Graphics g, int tileSize, Point p) {
		g.setColor(Color.white);
		g.fillRect(p.y, p.x, tileSize, tileSize);
		if(coveredBy == null && color != null && number > 0 && number < 7){
			g.setColor(color);
			g.setFont(new Font("Constantia", Font.PLAIN, 12));
			g.drawString(number.toString(), p.y+tileSize/2, p.x+tileSize/2);
		}
		if(coveredBy != null){
			g.setColor(coveredBy.getColor());
			g.fillRect(p.y, p.x, tileSize, tileSize);
		}
		g.setColor(Color.black);
		g.drawRect(p.y, p.x, tileSize, tileSize);
	}

	@Override
	public void setCoveredBy(IPiece piece) {
		coveredBy = piece;
	}
	
	public void setNumberColor(int n, Color c){
		number = n;
		color = c;
	}

	@Override
	public IMovingTile makeMovingTile(Point p) {
		return new MovingTile(this, p);
	}

	@Override
	public void setRowCol(Point p) {
		row = p.x;
		column = p.y;	
	}

}
