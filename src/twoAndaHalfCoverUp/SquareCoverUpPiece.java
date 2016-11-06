package twoAndaHalfCoverUp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import general.entity.SquarePiece;

public class SquareCoverUpPiece extends SquarePiece{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7910547328891452517L;
	
	ArrayList<Point> yellowTiles = new ArrayList<Point>();
	ArrayList<Point> blueTiles = new ArrayList<Point>();
	ArrayList<Point> greenTiles = new ArrayList<Point>();
	
	public SquareCoverUpPiece(ArrayList<Point> shape, Color c){
		super(shape, c);
	}
	
	public SquareCoverUpPiece(SlantedPiece slanted){
		super(slanted.getShape(), slanted.getColor());
		for(Point tile: slanted.blueTiles){
			blueTiles.add(tile);
		}
		for(Point tile: slanted.yellowTiles){
			yellowTiles.add(tile);
		}
		for(Point tile: slanted.greenTiles){
			greenTiles.add(tile);
		}
	}
	
	@Override
	public void drawPiece(Graphics g, int tileSize, Point p) {
		if(p != null){
			for(Point tile: shape){
				g.setColor(color);
				g.fillRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
				g.setColor(Color.black);
				g.drawRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
			}
			for(Point tile: blueTiles){
				g.setColor(Color.BLUE);
				g.fillRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
				g.setColor(Color.black);
				g.drawRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
			}
			for(Point tile: yellowTiles){
				g.setColor(Color.yellow);
				g.fillRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
				g.setColor(Color.black);
				g.drawRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
			}
			for(Point tile: greenTiles){
				g.setColor(Color.green);
				g.fillRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
				g.setColor(Color.black);
				g.drawRect(p.x + tile.x*tileSize-tileSize/2, p.y+tile.y*tileSize-tileSize/2, tileSize, tileSize);
			}
		}
	}
	
	private boolean getAlreadyColored(Point p){
		for(Point point: yellowTiles){
			if(point.equals(p)){
				return true;
			}
		}
		for(Point point: blueTiles){
			if(point.equals(p)){
				return true;
			}
		}
		for(Point point: greenTiles){
			if(point.equals(p)){
				return true;
			}
		}
		return false;
	}
	
	public void addColoredTile(Point p, Color color){
		if(!getAlreadyColored(p)){
			if(color.equals(Color.YELLOW)){
				yellowTiles.add(p);
			}
			if(color.equals(Color.BLUE)){
				blueTiles.add(p);
			}
			if(color.equals(Color.GREEN)){
				greenTiles.add(p);
			}
		}
	}
}
