package general.boundary;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import interfaces.IHint;
import interfaces.ILevel;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8039114876670132648L;

	ILevel level;
	
	public final int N;
	public final int offset;
	
	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(ILevel l, int tileSize, int offset) {
		level = l;
		N = tileSize;
		this.offset = offset;
	}
	
	/** 
	 * Swing thing. We must be large enough to draw all Kabasuji pieces. 
	 */
	@Override
	public Dimension getMinimumSize() {
		return level.getBoard().getBoardDimension(N);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Kabasuji pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		return level.getBoard().getBoardDimension(N);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

			redraw();
		}

		// if no offscreenImage, then Swing hasn't fully initialized; leave now
		if (offScreenImage == null) {
			System.err.println("Swing not ready for drawing.");
			return;
		}

		// copy image into place.
		g.drawImage(offScreenImage, 0, 0, this);

		//double check if no model (for WindowBuilder)
		if (level == null) { return; }
		
		//draw the board
		level.getBoard().drawBoard(g, N, offset);
		
		//draw the hints
		for(IHint h: level.getHints()){
			h.drawHint(g, N);
		}
		//draw the moving piece
		if(level.getBoard().getMovingPiece()!= null){
		level.getBoard().getMovingPiece().drawMovingPiece(N, g);
		}
		//draw the moving tile
		if(level.getBoard().getMovingTile() != null){
			level.getBoard().getMovingTile().drawMovingTile(N, g);
		}
	}
	
	
	public void redraw() {

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);

		
		//draw the board
		level.getBoard().drawBoard(offScreenGraphics, N, offset);

		//draw the hints
		for(IHint h: level.getHints()){
			h.drawHint(offScreenGraphics, N);
		}
		//draw the moving piece
		if(level.getBoard().getMovingPiece()!= null){
		level.getBoard().getMovingPiece().drawMovingPiece(N, offScreenGraphics);
		}
		//draw the moving tile
		if(level.getBoard().getMovingTile() != null){
		level.getBoard().getMovingTile().drawMovingTile(N, offScreenGraphics);
		}
	}
	
	public Graphics getOffScreenGraphics(){
		return offScreenGraphics;
	}

}
