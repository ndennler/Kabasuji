package lightning;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import general.boundary.BoardPanel;
import general.boundary.BullpenPanel;
import general.controller.anyLevel.EndLevelController;
import general.entity.Kabasuji;
import interfaces.IMovingPiece;
import interfaces.IPiece;
import interfaces.ITile;
import puzzle.PuzzleLevel;

public class PlaceLightningPieceController implements MouseListener{

	LightningLevel level;
	LightningLevelGUI parent;
	Kabasuji game;
	
	BoardPanel boardView;
	BullpenPanel bullpenView;
	
	public PlaceLightningPieceController(LightningLevel l, LightningLevelGUI app, Kabasuji k){
		level = l;
		parent = app;
		game = k;
		boardView = parent.getBoardView();
		bullpenView = parent.getBullpenView();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		IMovingPiece placing = level.getBoard().getMovingPiece();
		ITile tile = level.getBoard().getTile(e.getPoint(), boardView.N, boardView.offset);
		if(placing == null){
			//you are trying to pick up a piece, but this is lightning ya silly.
			return;
		}
		else{
			//you are trying to add a piece	
			if(tile != null){
				//the tile clicked on exists
				if(level.getBoard().placePiece(tile.getRow(), tile.getColumn(), placing.getPiece())){
					//the piece was added to the board
					level.getBullpen().getPieces().add(level.getBoard().getMovingPiece().getPiece());
					level.getBoard().setMovingPiece(null);
					boardView.redraw(); boardView.repaint();
					bullpenView.redraw(); bullpenView.repaint();
					level.update();
					parent.setProgressBar(level.getStars());
					if(level.isCompleted()){
						new EndLevelController(level, parent, game);
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
