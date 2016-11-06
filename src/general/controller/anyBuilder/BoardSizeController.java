package general.controller.anyBuilder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import general.boundary.BoardPanel;
import interfaces.ILevel;
import interfaces.ITile;

public class BoardSizeController implements ChangeListener {

	ILevel level;
	BoardPanel boardView;
	JSpinner boardSize;

	public BoardSizeController(ILevel l, BoardPanel b, JSpinner s){
		level = l; 
		boardView = b; 
		boardSize = s;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int size = (int) boardSize.getValue();
		int currsize = level.getBoard().numberofTiles();
		ITile[][] boardShape = level.getBoard().getTiles();
		if(currsize < size){//when size requested is larger
			for(int i = 0; i<12; i++){
				for(int j = 0; j<12; j++){
					if(currsize < size && boardShape[i][j] == null){
						boardShape[i][j] = level.getBoard().makeBlankTile(i, j);
						currsize++;
					}
				}
			}
		}
		if(currsize > size){
			for(int i = 0; i<12; i++){
				for(int j = 0; j<12; j++){
					ITile t = boardShape[11-i][11-j];
					if(t != null){
					if(currsize > size && t.getCoveredBy() == null){
						boardShape[11-i][11-j] = null;
						currsize--;
					}
					}
				}
			}
		}
		if(currsize != size){
			boardSize.setValue(currsize);
		}
		boardView.redraw();
		boardView.repaint();
	}

	
}
