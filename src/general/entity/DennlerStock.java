package general.entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import interfaces.IPiece;
import interfaces.IStock;

public class DennlerStock implements IStock{
	
	ArrayList<IPiece> pieces;

	
	SquarePiece P1 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(0, 4), new Point(0, 5), new Point(0,0) );

	SquarePiece P2 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(0, 4), new Point(1, 0), new Point(0,0) );

	SquarePiece P3 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(0, 4), new Point(-1, 3), new Point(0,0) );

	SquarePiece P4 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(0, 4), new Point(1, 2), new Point(0,0) );

	SquarePiece P5 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 3), new Point(1, 2), new Point(-1, 0), new Point(0,0) ); 

	SquarePiece P6 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 3), new Point(1, 2), new Point(1, 4), new Point(0,0) ); 

	SquarePiece P7 = new SquarePiece(new Point(0, 1), new Point(-1, 2), new Point(-1, 3), new Point(-1, 1), new Point(-1, 4), new Point(0,0) );

	SquarePiece P8 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 2), new Point(-1, 3), new Point(0,0) );

	SquarePiece P9 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(1, 3), new Point(-1, 0), new Point(0,0) );

	SquarePiece P10 = new SquarePiece(new Point(0, 1), new Point(1, 0), new Point(-1, 0), new Point(0, 2), new Point(0, 3), new Point(0,0) );

	SquarePiece P11 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 3), new Point(-2, 3), new Point(0,0) );

	SquarePiece P12 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0,0) );

	SquarePiece P13 = new SquarePiece(new Point(0, 1), new Point(1, 0), new Point(-1, 1), new Point(-1, 2), new Point(-1, 3), new Point(0,0) );

	SquarePiece P14 = new SquarePiece(new Point(0, 1), new Point(-1, 1), new Point(-1, 2), new Point(-2, 2), new Point(-2, 3), new Point(0,0) );

	SquarePiece P15 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 1), new Point(-1, 2), new Point(0,0) );

	SquarePiece P16 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 1), new Point(1, 1), new Point(0,0) );

	SquarePiece P17 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(1, 3), new Point(1, 1), new Point(0,0) );

	SquarePiece P18 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(2, 2), new Point(1, 3), new Point(0,0) );

	SquarePiece P19 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(-1, 2), new Point(-2, 2), new Point(-2, 3), new Point(0,0) );
	
	SquarePiece P20 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(1, 3), new Point(1, 1), new Point(0,0) ); 

	SquarePiece P21 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(-1, 0), new Point(-1, 1), new Point(0,0) );

	SquarePiece P22 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(-1, 1), new Point(-1, 2), new Point(1, 1), new Point(0,0) );

	SquarePiece P23 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 0), new Point(-1, 3), new Point(0,0) );

	SquarePiece P24 = new SquarePiece(new Point(0, 1), new Point(-1, 1), new Point(1, 1), new Point(-1, 2), new Point(1, 2), new Point(0,0) );

	SquarePiece P25 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(-1, 0), new Point(-2, 0), new Point(-2, 1), new Point(0,0) ); 

	SquarePiece P26 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 0), new Point(2, 0), new Point(1, 1), new Point(0,0) ); 
	
	SquarePiece P27 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 0), new Point(1, 1), new Point(0,0));

	SquarePiece P28 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 2), new Point(-2, 2), new Point(0,0) );

	SquarePiece P29 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 0), new Point(1, 2), new Point(1, 3), new Point(0,0) ); 
	
	SquarePiece P30 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(-1, 0), new Point(-1, 2), new Point(1, 2), new Point(0,0) ); 

	SquarePiece P31 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(1, 1), new Point(2, 1), new Point(0,0) ); 

	SquarePiece P32 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(-1, 3), new Point(-1, 2), new Point(1, 2), new Point(0,0) );

	SquarePiece P33 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(-1, 2), new Point(1, 0), new Point(0,0) ); 

	SquarePiece P34 = new SquarePiece(new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(1, 1), new Point(-1, 2), new Point(0,0) ); 

	SquarePiece P35 = new SquarePiece(new Point(0, 1), new Point(1, 1), new Point(1, 2), new Point(2, 2), new Point(1, 3), new Point(0,0) );
	
	public DennlerStock(){
		pieces = new ArrayList<IPiece>();
		pieces.add(P1);
		pieces.add(P2);
		pieces.add(P3);
		pieces.add(P4);
		pieces.add(P5);
		pieces.add(P6);
		pieces.add(P7);
		pieces.add(P8);
		pieces.add(P9);
		pieces.add(P10);
		pieces.add(P11);
		pieces.add(P12);
		pieces.add(P13);
		pieces.add(P14);
		pieces.add(P15);
		pieces.add(P16);
		pieces.add(P17);
		pieces.add(P18);
		pieces.add(P19);
		pieces.add(P20);
		pieces.add(P21);
		pieces.add(P22);
		pieces.add(P23);
		pieces.add(P24);
		pieces.add(P25);
		pieces.add(P26);
		pieces.add(P27);
		pieces.add(P28);
		pieces.add(P29);
		pieces.add(P30);
		pieces.add(P31);
		pieces.add(P32);
		pieces.add(P33);
		pieces.add(P34);
		pieces.add(P35);
	}
	@Override
	public ArrayList<IPiece> getPieces() {
		return pieces;
	}

	@Override
	public void drawStock(Graphics g, int tileSize, int offset) {
		int i = 0;
		for(IPiece p : pieces){
			Point point = new Point(offset + (i%2)*7*tileSize + tileSize, offset + (i/2)*7*tileSize);
			p.drawPiece(g, tileSize, point);
			i++;
		}
		
	}
	@Override
	public IPiece getPiece(Point p, int tileSize, int offset) {
		int i = 0;
		for(IPiece piece: pieces){
			for(Point tile: piece.getShape()){
				Rectangle r = new Rectangle(offset + (i%2)*7*tileSize + tileSize + tileSize*tile.x- tileSize/2, offset + (i/2)*7*tileSize  +tileSize*tile.y- tileSize/2, tileSize, tileSize);
				if(r.contains(p)){
					return pieces.get(i).clone();
				}
			}
			i++;
		}
		return null;
	}
	@Override
	public Dimension getStockDimension(int tileSize) {
		return new Dimension(tileSize*14, pieces.size()*tileSize*7/2 + 7*pieces.size()%2 + 2*tileSize + 20);
	}

}
