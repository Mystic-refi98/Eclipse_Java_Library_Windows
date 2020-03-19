package helper;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class PanelImage extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image img;
	
	public PanelImage(Image gambar) {
		this.img = gambar;
	}
	
	public void setImage(Image gambar){
		this.img = gambar;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 10, 10, getWidth() - 20, getHeight() - 20, this);
	}
}
