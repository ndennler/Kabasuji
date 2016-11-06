package release;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import general.boundary.BoardPanel;
import general.controller.anyLevel.EndLevelController;
import general.entity.Kabasuji;
import interfaces.ILevelGUI;
import interfaces.IMovingPiece;
import interfaces.ITile;

public class PlaceReleasePieceController implements MouseListener{
	
	ReleaseLevel level;
	BoardPanel boardView;
	JLabel[] rgbNumbers;
	ILevelGUI parent;
	Kabasuji game;
	
	public PlaceReleasePieceController(ReleaseLevel l, BoardPanel b, JLabel[] m, ILevelGUI p, Kabasuji k){
		level = l;
		boardView = b;
		rgbNumbers = m;
		parent = p;
		game = k;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		IMovingPiece placing = level.getBoard().getMovingPiece();
		ITile tile = level.getBoard().getTile(e.getPoint(), boardView.N, boardView.offset);
		if(placing == null){
			//you are trying to pick up a piece
			return;
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
					rgbNumbers[0].setText(level.getRedText());
					rgbNumbers[1].setText(level.getGreenText());
					rgbNumbers[2].setText(level.getBlueText());
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
