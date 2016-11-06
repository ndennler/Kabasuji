package general.controller.anyLevel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import general.boundary.BoardPanel;
import general.boundary.BullpenPanel;
import interfaces.ILevel;
import interfaces.IMovingPiece;
import interfaces.IPiece;

public class PlayerSelectPieceController implements MouseListener{

	BoardPanel boardView;
	BullpenPanel bullpenView;
	ILevel level;
	
	public PlayerSelectPieceController(BoardPanel b, BullpenPanel bp, ILevel l){
		boardView = b;
		bullpenView = bp;
		level = l;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(true){
			IPiece selected = level.getBullpen().getPieceAt(e.getPoint(), bullpenView.N, bullpenView.offset);
			IMovingPiece current = level.getBoard().getMovingPiece();
			if(current != null){
				level.getBullpen().getPieces().add(current.getPiece());
				level.getBoard().setMovingPiece(null);
			}
			if (selected != null){
				level.getBullpen().getPieces().remove(selected);
				level.getBoard().setMovingPiece(selected.makeMoving(e.getPoint(),true));
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
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
