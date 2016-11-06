package twoAndaHalfCoverUp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

import general.entity.MovingSquarePiece;
import general.entity.SquarePiece;
import interfaces.IMovingPiece;
import interfaces.IPiece;

public class SlantedPiece extends SquarePiece implements IPiece{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4095476193909284967L;
	ArrayList<Point> yellowTiles = new ArrayList<Point>();
	ArrayList<Point> blueTiles = new ArrayList<Point>();
	ArrayList<Point> greenTiles = new ArrayList<Point>();
	
	public SlantedPiece(ArrayList<Point> shape, Color c) {
		super(shape, c);
	}
	
	public SlantedPiece(SquareCoverUpPiece piece){
		super(piece.getShape(), piece.getColor());
		for(Point tile: piece.blueTiles){
			blueTiles.add(tile);
		}
		for(Point tile: piece.yellowTiles){
			yellowTiles.add(tile);
		}
		for(Point tile: piece.greenTiles){
			greenTiles.add(tile);
		}
	}

	@Override
	public void drawPiece(Graphics g, int tileSize, Point p) {
		if(p != null){
			
			for(Point tile: getShape()){
				Polygon tileShape = new Polygon();
				tileShape.addPoint(p.x + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y+tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x-tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				g.setColor(getColor());
				g.fillPolygon(tileShape);
				g.setColor(Color.black);
				g.drawPolygon(tileShape);
			}
			for(Point tile: greenTiles){
				Polygon tileShape = new Polygon();
				tileShape.addPoint(p.x + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y+tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x-tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				g.setColor(Color.GREEN);
				g.fillPolygon(tileShape);
				g.setColor(Color.black);
				g.drawPolygon(tileShape);
			}
			for(Point tile: blueTiles){
				Polygon tileShape = new Polygon();
				tileShape.addPoint(p.x + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y+tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x-tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				g.setColor(Color.BLUE);
				g.fillPolygon(tileShape);
				g.setColor(Color.black);
				g.drawPolygon(tileShape);
			}
			for(Point tile: yellowTiles){
				Polygon tileShape = new Polygon();
				tileShape.addPoint(p.x + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x + tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y+tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				tileShape.addPoint(p.x-tileSize/2 + tile.x*tileSize - tile.y*tileSize/2 - tileSize/4, p.y + tileSize/2 + tile.y*tileSize/2 - tileSize/4);
				g.setColor(Color.YELLOW);
				g.fillPolygon(tileShape);
				g.setColor(Color.black);
				g.drawPolygon(tileShape);
			}
		}
	}
	
	@Override
	public IMovingPiece makeMoving(Point p, boolean fromBullpen) {
			return new MovingSquarePiece(this, p, fromBullpen);
	}
	private void clearAlreadyColored(Point p){
		for(Point point: yellowTiles){
			if(point.equals(p)){
				yellowTiles.remove(p);
				return;
			}
		}
		for(Point point: blueTiles){
			if(point.equals(p)){
				blueTiles.remove(p);
				return;
			}
		}
		for(Point point: greenTiles){
			if(point.equals(p)){
				greenTiles.remove(p);
				return;
			}
		}
	}

	public void addColoredTile(Point p, Color color){
		clearAlreadyColored(p);
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

	public void removeColoredTile(Point p){
		for(Point point: yellowTiles){
			if(point.equals(p)){
				yellowTiles.remove(p);
				return;
			}
		}
		for(Point point: blueTiles){
			if(point.equals(p)){
				blueTiles.remove(p);
				return;
			}
		}
		for(Point point: greenTiles){
			if(point.equals(p)){
				greenTiles.remove(point);
				return;
			}
		}
	}
	
	@Override
	public void flip(boolean direction) {
		for(Point p : shape){
			if(direction){
				p.y = -p.y;
			}
			else{
				p.x = -p.x;
			}
		}
		for(Point p : blueTiles){
			if(direction){
				p.y = -p.y;
			}
			else{
				p.x = -p.x;
			}
		}
		for(Point p : yellowTiles){
			if(direction){
				p.y = -p.y;
			}
			else{
				p.x = -p.x;
			}
		}
		for(Point p : greenTiles){
			if(direction){
				p.y = -p.y;
			}
			else{
				p.x = -p.x;
			}
		}
		center();
	}

	@Override
	public void rotate(boolean direction) {
		for(Point p : shape){
			int tmp;
			if(direction){
				tmp = p.x;
				p.x = -p.y;
				p.y = tmp;
			}
			else{
				tmp = p.x;
				p.x = p.y;
				p.y = -tmp;
			}
		}
		for(Point p : blueTiles){
			int tmp;
			if(direction){
				tmp = p.x;
				p.x = -p.y;
				p.y = tmp;
			}
			else{
				tmp = p.x;
				p.x = p.y;
				p.y = -tmp;
			}
		}
		for(Point p : yellowTiles){
			int tmp;
			if(direction){
				tmp = p.x;
				p.x = -p.y;
				p.y = tmp;
			}
			else{
				tmp = p.x;
				p.x = p.y;
				p.y = -tmp;
			}
		}
		for(Point p : greenTiles){
			int tmp;
			if(direction){
				tmp = p.x;
				p.x = -p.y;
				p.y = tmp;
			}
			else{
				tmp = p.x;
				p.x = p.y;
				p.y = -tmp;
			}
		}
		center();
	}
	
	@Override
	public void center() {
			int minY = 0;
			int minX = 0;
			int maxX = 0;
			for(Point p : shape){
				int x = p.x;
				int y = p.y;
				if(x > maxX){maxX = x;}
				if(x < minX){minX = x;}
				if(y < minY){minY = y;}
			}
			if(minY < 0){
				shiftDown(-minY);
			}
		shiftRight(-(maxX+minX)/2);
		if(!shape.contains(new Point(0,0))){
			reshift();
		}
		}
	private void reshift() {
		int closestX = 0;
		for(Point p: shape){
			if(p.y == 0){
				if(Math.abs(p.x) < closestX || closestX == 0){
					closestX = p.x;
				}
			}
		}
		shiftRight(-closestX);
	}
	private void shiftDown(int y) {
		for(Point p: shape){
			p.y += y;
		}
		for(Point p: blueTiles){
			p.y += y;
		}
		for(Point p: greenTiles){
			p.y += y;
		}
		for(Point p: yellowTiles){
			p.y += y;
		}

	}
	
	private void shiftRight(int x) {
		for(Point p: shape){
			p.x += x;
		}
		for(Point p: blueTiles){
			p.x += x;
		}
		for(Point p: yellowTiles){
			p.x += x;
		}
		for(Point p: greenTiles){
			p.x += x;
		}
	}
}
