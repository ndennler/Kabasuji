package general.controller.anyLevel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import general.boundary.BoardPanel;
import interfaces.ILevel;

public class MovePieceController extends MouseAdapter{

	
	ILevel level;
	BoardPanel boardView;
	
	public MovePieceController(ILevel l, BoardPanel b){
		level = l;
		boardView = b;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		return;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(level.getBoard().getMovingPiece() != null){
			level.getBoard().getMovingPiece().setPoint(e.getPoint());;
		}
		boardView.redraw();
		boardView.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(level.getBoard().getMovingPiece() != null){
			level.getBoard().getMovingPiece().setPoint(e.getPoint());
		}
		boardView.redraw();
		boardView.repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		return;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if(level.getBoard().getMovingPiece() != null){
			level.getBoard().getMovingPiece().setPoint(e.getPoint());
		}
		boardView.redraw();
		boardView.repaint();
		
		
	}
}
