package puzzle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import general.boundary.BoardPanel;
import general.controller.anyLevel.EndLevelController;
import general.entity.Kabasuji;
import interfaces.ILevelGUI;
import interfaces.IMovingPiece;
import interfaces.IPiece;
import interfaces.ITile;

public class PlacePuzzlePieceController implements MouseListener{
	
	PuzzleLevel level;
	BoardPanel boardView;
	JLabel moves;
	Kabasuji game;
	ILevelGUI parent;
	
	public PlacePuzzlePieceController(PuzzleLevel l, BoardPanel b, JLabel m, Kabasuji k, ILevelGUI p){
		level = l;
		boardView = b;
		moves = m;
		game= k;
		parent = p;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		IMovingPiece placing = level.getBoard().getMovingPiece();
		ITile tile = level.getBoard().getTile(e.getPoint(), boardView.N, boardView.offset);
		if(placing == null){
			//you are trying to pick up a piece
			if(tile != null){
				//you are clicking on a place that might have a piece
				if(tile.getCoveredBy() != null){
					//there is a piece at the tile, so you pick it up and make it moving
					IPiece p = level.getBoard().pickUpPiece(tile.getRow(), tile.getColumn());
					level.getBoard().setMovingPiece(p.makeMoving(e.getPoint(), false));
					level.update();
					parent.setProgressBar(level.getStars());
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
					level.update();
					moves.setText(level.movesLeft.toString());
					parent.setProgressBar(level.getStars());
					if(level.isCompleted()){
						new EndLevelController(level, parent, game);
					}
				}
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
