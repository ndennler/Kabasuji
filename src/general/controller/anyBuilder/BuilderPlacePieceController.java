package general.controller.anyBuilder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JToggleButton;

import general.boundary.BoardPanel;
import interfaces.ILevel;
import interfaces.IMovingPiece;
import interfaces.IPiece;
import interfaces.ITile;

public class BuilderPlacePieceController implements MouseListener{

	ILevel level;
	BoardPanel boardView;
	JToggleButton movingPieces;
	
	public BuilderPlacePieceController(ILevel l, BoardPanel b, JToggleButton m){
		level = l;
		boardView = b;
		movingPieces = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(movingPieces.isSelected()){
			IMovingPiece placing = level.getBoard().getMovingPiece();
			ITile tile = level.getBoard().getTile(e.getPoint(), boardView.N, boardView.offset);
			if(placing == null){
				//you are trying to pick up a piece
				if(tile != null){
					//you are clicking on a place that might have a piece
					if(tile.getCoveredBy() != null){
						//there is a piece at the tile, so you pick it up and make it moving
						IPiece p = level.getBoard().pickUpPiece(tile.getRow(), tile.getColumn());
						level.getBoard().setMovingPiece(p.makeMoving(e.getPoint(), true));//builder will still rotate/flip piece even if it isn't from the bullpen.
						boardView.redraw(); boardView.repaint();
					}
				}

			}
			else{
				//you are trying to add a piece	
				if(tile != null){
					//the tile clicked on exists
					if(level.getBoard().placePiece(tile.getRow(), tile.getColumn(), placing.getPiece())){
						//the piece was added to the board
						level.getBoard().setMovingPiece(null);
						boardView.redraw(); boardView.repaint();
					}
				}
			}
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
