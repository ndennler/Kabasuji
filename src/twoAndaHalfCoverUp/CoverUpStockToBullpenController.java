package twoAndaHalfCoverUp;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import general.boundary.BullpenPanel;
import general.boundary.StockPanel;
import interfaces.ILevel;
import interfaces.IMove;
import interfaces.IPiece;

public class CoverUpStockToBullpenController implements IMove, MouseListener{
	
	protected ArrayList<Point> shape = new ArrayList<Point>();
	protected int identity;
	protected int row;
	protected int column;
	protected Color color;

	StockPanel stockView;
	BullpenPanel bullpenView;
	ILevel level;
	
	public CoverUpStockToBullpenController(StockPanel s, BullpenPanel b, ILevel l){
		stockView = s;
		bullpenView = b;
		level = l;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		IPiece adding = stockView.getStock().getPiece(e.getPoint(), stockView.N, stockView.offset);
		if(adding != null){
			SquareCoverUpPiece newPiece = new SquareCoverUpPiece(adding.getShape(), adding.getColor());
		level.getBullpen().getPieces().add(newPiece);
		}
		bullpenView.revalidate();
		bullpenView.redraw();
		bullpenView.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
	}

	@Override
	public void push() {
		return;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public void doMove() {
		return;
		
	}
}
