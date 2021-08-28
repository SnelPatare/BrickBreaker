import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball extends JPanel implements Observable {
	
	// Box height and width
		  int width;
		  int height;
		 
		  // Ball Size
		  float radius = 10; 
		  float diameter = radius * 2;
		 
		  // Center of Call
		  float X = radius + 50;
		  float Y = radius + 20;
		 
		  // Direction
		  float dx = 5;
		  float dy = 5;
		  
		 
		  public Ball() {
			  
		  }
		  
		  public void move() {
			  Thread thread = new Thread() {
			      public void run() {
			        while (true) {
			 
			          width = getWidth();
			          height = getHeight();
			 
			          X = X + dx ;
			          Y = Y + dy;
			 
			          if (X - radius < 0) {
			            dx = -dx; 
			            X = radius; 
			          } else if (X + radius > width) {
			            dx = -dx;
			            X = width - radius;
			          }
			 
			          if (Y - radius < 0) {
			            dy = -dy;
			            Y = radius;
			          } else if (Y + radius > height) {
			            dy = -dy;
			            Y = height - radius;
			          }
			          repaint();
			 
			          try {
			            Thread.sleep(50);
			          } catch (InterruptedException ex) {
			          }
			 
			        }
			      }
			    };
			    thread.start();
		  }
		 
		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.setColor(Color.BLUE);
		    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
		  }
	
	public void addObserver(Observer o) {
		
	}
	
	public void removeObserver(Observer o) {
		
	}
	
	public void updateObserver(Observer o) {
		
	}

}
