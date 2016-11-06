package twoAndaHalfCoverUp;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JToggleButton;

import general.boundary.BoardPanel;
import general.boundary.BullpenPanel;
import general.entity.SquarePiece;
import interfaces.ILevel;
import interfaces.IMovingPiece;
import interfaces.IPiece;

public class SlantedSelectPieceController implements MouseListener{

	BoardPanel boardView;
	BullpenPanel bullpenView;
	ILevel level;
	JToggleButton valid;
	
	public SlantedSelectPieceController(BoardPanel b, BullpenPanel bp, ILevel l, JToggleButton btn){
		boardView = b;
		bullpenView = bp;
		level = l;
		valid = btn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(valid.isSelected()){
			IPiece selected = level.getBullpen().getPieceAt(e.getPoint(), bullpenView.N, bullpenView.offset);
			IMovingPiece current = level.getBoard().getMovingPiece();
			Point shifted = new Point(e.getX()-(boardView.N)/2, e.getY()-(boardView.N)/2);
			if(current != null){
				//since this controller applies only to a coverup selection, we know that the moving piece will always be a slanted one.
				SlantedPiece piece = (SlantedPiece) current.getPiece();
				level.getBullpen().getPieces().add(new SquareCoverUpPiece(piece));
				level.getBoard().setMovingPiece(null);
			}
			if (selected != null){
				level.getBullpen().getPieces().remove(selected);
				SlantedPiece piece = new SlantedPiece((SquareCoverUpPiece) selected);
				level.getBoard().setMovingPiece(piece.makeMoving(shifted,true));
			}
			boardView.revalidate();
			boardView.redraw();
			boardView.repaint();
			bullpenView.revalidate();
			bullpenView.redraw();
			bullpenView.repaint();
		}
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
	
	
}
