package general.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import interfaces.IMovingPiece;
import interfaces.IPiece;

public class SquarePiece implements IPiece{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3456737605699263675L;
	protected ArrayList<Point> shape = new ArrayList<Point>();
	protected int identity;
	protected int row;
	protected int column;
	protected Color color;
	
	public SquarePiece(ArrayList<Point> shape, Color c){
		this.shape = shape;
		color = c;
	}
	public SquarePiece(Point a, Point b, Point c, Point d, Point e, Point f){
		shape = new ArrayList<Point>();
		shape.add(a);
		shape.add(b);
		shape.add(c);
		shape.add(d);
		shape.add(e);
		shape.add(f);
		
		Random rand = new Random();
		color = new Color(rand.nextInt(255),rand.nextInt(255), rand.nextInt(255));
	}
	@Override
	public ArrayList<Point> getShape() {
		return shape;
	}

	@Override
	public int getIdentity() {
		return identity;
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
	public IPiece clone() {
		ArrayList<Point> newPoints = new ArrayList<Point>();
		for(Point p: shape){
			newPoints.add(new Point(p.x,p.y));
		}
		return new SquarePiece(newPoints, color);
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
		
	}
	private void shiftRight(int x) {
		for(Point p: shape){
			p.x += x;
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
		center();
	}

	@Override
	public void setXY(Point p) {
		row = p.x;
		column = p.y;
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
		}
	}
	
	@Override
	public Color getColor() {
		return color;
	}
	@Override
	public IMovingPiece makeMoving(Point p, boolean fromBullpen) {
			return new MovingSquarePiece(this, p, fromBullpen);
	}

}
