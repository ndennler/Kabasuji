package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public interface IBullpen extends Serializable{

	public ArrayList<IPiece> getPieces();
	
	public void drawBullpen(Graphics g, int tileSize, int offset);
	public Dimension getBullpenPanelSize(int tileSize, int offset);
	public IPiece getPieceAt(Point p, int tileSize, int offset);
	
}
