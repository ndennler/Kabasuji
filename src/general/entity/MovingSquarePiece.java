package general.entity;

import java.awt.Graphics;
import java.awt.Point;

import interfaces.IMovingPiece;
import interfaces.IPiece;

public class MovingSquarePiece implements IMovingPiece{

	IPiece piece;
	Point location;
	boolean fromBullpen;
	
	public MovingSquarePiece(IPiece p, Point loc, boolean b){
		piece = p;
		location = loc;
		fromBullpen = b;
	}

	@Override
	public void drawMovingPiece(int tileSize, Graphics g) {
		piece.drawPiece(g, tileSize, location);
		
	}

	@Override
	public void setPoint(Point p) {
		location = p;
	}

	@Override
	public IPiece getPiece() {
		return piece;
	}

	@Override
	public boolean isFromBullpen() {
		return fromBullpen;
	}

	@Override
	public void setFromBullpen(boolean b) {
		fromBullpen = b;
	}
}
