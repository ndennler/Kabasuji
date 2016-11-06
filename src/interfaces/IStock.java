package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public interface IStock {

	public ArrayList<IPiece> getPieces();
	
	public void drawStock(Graphics g, int tileSize, int offset);
	
	public IPiece getPiece(Point p, int tileSize, int offset);
	public Dimension getStockDimension(int tileSize);
}
