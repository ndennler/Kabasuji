package general.controller.anyLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import general.boundary.BoardPanel;
import interfaces.ILevel;
import interfaces.IMovingPiece;

public class RotateController implements ActionListener{

	ILevel level;
	boolean direction;
	BoardPanel boardView;
	
	public RotateController(ILevel l, BoardPanel b, boolean dir){
		level = l;
		boardView = b;
		direction = dir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IMovingPiece movingPiece = level.getBoard().getMovingPiece();
		if(movingPiece!= null && movingPiece.isFromBullpen()){
			if(direction){
				level.getBoard().getMovingPiece().getPiece().rotate(direction);
			}
			else{
				level.getBoard().getMovingPiece().getPiece().rotate(direction);
			}
			boardView.redraw(); boardView.repaint();
		}
	}
}
