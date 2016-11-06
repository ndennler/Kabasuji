package general.boundary;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import interfaces.IStock;

public class StockPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4435343012567804774L;
	IStock stock;
	public final int N;
	public final int offset;
	
	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	/**
	 * Create the panel.
	 */
	public StockPanel(IStock s, int tileSize, int off) {
		stock = s;
		N = tileSize;
		offset = off;
	}
	
	
	
	/** 
	 * Swing thing. We must be large enough to draw all Kabasuji pieces. 
	 */
	@Override
	public Dimension getMinimumSize() {
		return stock.getStockDimension(N);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Kabasuji pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		return stock.getStockDimension(N);
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
		if (stock == null) { return; }
		
		//draw the stock
		stock.drawStock(g, N, offset);
	}
	
	
	public void redraw() {

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);

		
		//draw the stock
		stock.drawStock(offScreenGraphics, N, offset);
	}
	public IStock getStock(){
		return stock;
	}
}
