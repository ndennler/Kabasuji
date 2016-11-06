package general.controller.anyBuilder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JToggleButton;

import general.boundary.BoardPanel;
import general.boundary.BullpenPanel;
import interfaces.ILevel;
import interfaces.IMovingPiece;
import interfaces.IPiece;

public class BuilderSelectPieceController implements MouseListener{

	BoardPanel boardView;
	BullpenPanel bullpenView;
	ILevel level;
	JToggleButton valid;
	
	public BuilderSelectPieceController(BoardPanel b, BullpenPanel bp, ILevel l, JToggleButton btn){
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
