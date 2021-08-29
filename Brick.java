import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Brick extends JPanel implements Observer {
	//Inherited method from Observer
	
	private int width, height, posX, posY;
	private boolean showBrick = true;
	public Brick(int posX, int posY, int width, int height) {
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
//		o.addObserver(this);
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(showBrick) {
			g.setColor(Color.cyan);
			g.drawRect(posX, posY, width, height);
			g.setColor(Color.magenta);
			g.fillRect(posX, posY, width, height);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(posX,posY,width,height);
	}

	@Override
	public void update() {
		showBrick=false;
		repaint();
	}
}
