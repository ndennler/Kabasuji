package puzzle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import general.boundary.BoardPanel;
import general.boundary.BullpenPanel;
import interfaces.IMovingPiece;
import interfaces.IPiece;

public class PuzzleSelectPieceController implements MouseListener{

	BoardPanel boardView;
	BullpenPanel bullpenView;
	PuzzleLevel level;
	JLabel movesLabel;
	
	public PuzzleSelectPieceController(BoardPanel b, BullpenPanel bp, PuzzleLevel l, JLabel moves){
		boardView = b;
		bullpenView = bp;
		level = l;
		movesLabel = moves;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(true){
			IPiece selected = level.getBullpen().getPieceAt(e.getPoint(), bullpenView.N, bullpenView.offset);
			IMovingPiece current = level.getBoard().getMovingPiece();
			if(current != null){
				if(!current.isFromBullpen()){
					level.update();
					movesLabel.setText(level.movesLeft.toString());
				}
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
