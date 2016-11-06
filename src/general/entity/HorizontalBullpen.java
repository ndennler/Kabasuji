package general.entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import interfaces.IBullpen;
import interfaces.IPiece;

public class HorizontalBullpen implements IBullpen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 602906965410098056L;
	ArrayList<IPiece> pieces;
	
	public HorizontalBullpen(){
		pieces = new ArrayList<IPiece>();
	}
	
	@Override
	public ArrayList<IPiece> getPieces() {
		return pieces;
	}

	@Override
	public void drawBullpen(Graphics g, int tileSize, int offset) {
		int i = 0;
		for(IPiece p: pieces){
			p.drawPiece(g, tileSize, new Point(6*tileSize*i+offset+2*tileSize, offset));
			i++;
		}
	}

	@Override
	public IPiece getPieceAt(Point p, int tileSize, int offset) {
		int i = 0;
		for(IPiece piece : pieces){
			for(Point tile: piece.getShape()){
				Rectangle r = new Rectangle(6*tileSize*i+offset+2*tileSize+ tileSize*tile.x-tileSize/2, offset + tileSize*tile.y - tileSize/2, tileSize, tileSize);
				if(r.contains(p)){
					pieces.remove(piece);
					return piece;
				}
			}
			i++;
		}
		return null;

	}

	@Override
	public Dimension getBullpenPanelSize(int tileSize, int offset) {
		return new Dimension(offset+6*tileSize*(pieces.size()+1), 6*tileSize);
	}

}
