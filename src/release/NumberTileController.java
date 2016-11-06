package release;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaces.ITile;

public class NumberTileController implements MouseListener{
	
	ReleaseBuilderGUI application;
	ReleaseLevel level;
	
	NumberTileController(ReleaseBuilderGUI app, ReleaseLevel l){
		application = app;
		level = l;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void mousePressed(MouseEvent e) {
		if(application.getNumberTiles().isSelected()){
			int number = (int)application.getNumberSpinner().getValue();
			String col = (String) application.getColorCombo().getSelectedItem();
			Color color = null;
			if(col.equals("Red")){
				color = Color.red;
			}
			if(col.equals("Green")){
				color = Color.green;
			}
			if(col.equals("Blue")){
				color = color.blue;
			}
			ITile t = level.getBoard().getTile(e.getPoint(), application.getBoardView().N, application.getBoardView().offset);
			if(t != null){
				//then we are clicking on a valid tile, and we know it is a release tile because we are in a release Level.
				((ReleaseTile)t).setNumberColor(number, color);
				level.getBoard().removeTile(t.getRow(), t.getColumn());
				level.getBoard().placeTile(t.getRow(), t.getColumn(), t);
				application.getBoardView().repaint();
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
