package general.controller.anyBuilder;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JToggleButton;

import general.boundary.BoardPanel;
import interfaces.ILevel;
import interfaces.ITile;

public class TileMovingController implements MouseListener, MouseMotionListener{

	ILevel level;
	BoardPanel boardView;
	JToggleButton moveTiles;

	public TileMovingController(ILevel l, BoardPanel b, JToggleButton mT){
		level = l;
		boardView = b;
		moveTiles = mT;
	}




	@Override
	public void mousePressed(MouseEvent e) {
		if(moveTiles.isSelected()){
			if(level.getBoard().getMovingTile() == null){
				ITile clicked = level.getBoard().getTile(e.getPoint(), boardView.N, boardView.offset);
				if(clicked != null){
					if(clicked.getCoveredBy() != null){return;}
					level.getBoard().removeTile(clicked.getRow(), clicked.getColumn());
					level.getBoard().setMovingTile(clicked.makeMovingTile(e.getPoint()));
					boardView.redraw();
					boardView.repaint();
				}
			}
		}

	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(moveTiles.isSelected()){
			if(level.getBoard().getMovingTile()!= null){
				level.getBoard().getMovingTile().setPoint(e.getPoint());
				boardView.redraw();
				boardView.repaint();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(moveTiles.isSelected() && level.getBoard().getMovingTile() != null){
			Point p = level.getBoard().getRowColumn(e.getPoint(), boardView.N, boardView.offset);
			if(p != null){
				if(level.getBoard().getTiles()[p.x][p.y] != null){
					ITile moving = level.getBoard().getMovingTile().getTile();
					level.getBoard().placeTile(moving.getRow(), moving.getColumn(), moving);
					level.getBoard().setMovingTile(null);
					boardView.redraw();
					boardView.repaint();
				}
				if(level.getBoard().getMovingTile() == null){return;}
				level.getBoard().placeTile(p.x, p.y, level.getBoard().getMovingTile().getTile());
				level.getBoard().setMovingTile(null);
				boardView.redraw();
				boardView.repaint();
			}
			else{
				ITile moving = level.getBoard().getMovingTile().getTile();
				level.getBoard().placeTile(moving.getRow(), moving.getColumn(), moving);
				level.getBoard().setMovingTile(null);
				boardView.redraw();
				boardView.repaint();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
