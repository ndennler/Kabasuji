package twoAndaHalfCoverUp;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;

import general.boundary.BoardPanel;
import interfaces.ILevel;
import interfaces.IPiece;

public class NumberPieceTileController implements MouseListener{

	ILevel level;
	BoardPanel boardView;
	JToggleButton colorTilesPieces;
	JComboBox<String> combo;
	
	public NumberPieceTileController(ILevel l, BoardPanel bv, JToggleButton c, JComboBox<String> co){
		level = l;
		boardView = bv;
		colorTilesPieces = c;
		combo = co;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(colorTilesPieces.isSelected()){
			Point rowCol = level.getBoard().getRowColumn(e.getPoint(), boardView.N, boardView.offset);
			if(rowCol == null){return;}
			CoverUpTile tile = (CoverUpTile) level.getBoard().getTiles()[rowCol.x][rowCol.y];
			if(tile == null){return;}
			SlantedPiece piece = (SlantedPiece) tile.getCoveredBy();
			if(piece == null){return;}
			Point colored = new Point(rowCol.x - piece.getRow(), rowCol.y - piece.getColumn());
			if(combo.getSelectedItem().equals("Blue")){
				piece.addColoredTile(colored, Color.BLUE);
				tile.setColor(Color.BLUE);
			}
			if(combo.getSelectedItem().equals("Yellow")){
				piece.addColoredTile(colored, Color.YELLOW);
				tile.setColor(Color.YELLOW);
			}
			if(combo.getSelectedItem().equals("Green")){
				piece.addColoredTile(colored, Color.GREEN);
				tile.setColor(Color.GREEN);
			}
			if(combo.getSelectedItem().equals("None")){
				piece.removeColoredTile(colored);
				tile.setColor(null);
			}
		}
		boardView.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;
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
