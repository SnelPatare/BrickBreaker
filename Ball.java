import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
		  float dx = 8;
		  float dy = 8;
		  
		  //List of Observers
		  ArrayList<Observer> observers = new ArrayList<Observer>();
		  
		 
		  public Ball() {
			  
		  }
		  
		  public void move() {
			          width = 780;
			          height = 560;
			 
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
			         
			          for(Observer o: observers) {
			        	 Rectangle ball = new Rectangle((int)X, (int)Y, (int)diameter, (int)diameter);
			        	 if(ball.intersects(o.getBounds())){
			        		 //dx = -dx;
			        		 dy = -dy;
			        		 if(o instanceof Brick) {
			        			 o.update();
			        			 observers.remove(o);
			        			 if(observers.size() == 1) {
			     						JOptionPane jop = new JOptionPane("All Bricks Destroyed");
			     						JDialog dialog = jop.createDialog("Game Won");
			     						dialog.setLayout(new BorderLayout());
			     						dialog.setVisible(true);
			        			 }
			        			 repaint();
			        			 break;
			        		 }
			        	 }
			          }
		  }
		 
		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.setColor(Color.BLUE);
		    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
		  }
	
		  
	public float getRadius() {
		return radius;
	}
	
	public float getDiameter() {
		return diameter;
	}
	
	public float getBallX() {
		return X;
	}
	
	public float getBallY() {
		return Y;
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(observers.indexOf(o));
	}
	
	public void updateObserver(Observer o) {
		o.update();
	}

}
