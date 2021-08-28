import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements Observer{
	
	    int score = 0;
	    int bricks = 12;
	    int X = 210;
	    int ball_X = 100;
	    int ball_Y = 250;
	    int dir_X = -1;
	    int dir_Y = -2;
	    Ball gameBall;
	    Paddle gamePaddle;

	
	//Inherited method from Observer
		public void update() {
			
		}
		
		public Board(Ball gameBall, int numBricks) {
			//this.setSize(getWidth(), getHeight());
			this.gameBall = gameBall;
			
			gameBall.addObserver(this);
			this.add(gameBall);
			
			///gameBall.move();
			this.bricks = numBricks;
			int brickX = 50;
			int brickY = 200;
			
			//Populates the board with bricks
			for(int i = 0; i < numBricks; i++) {
				Brick newBrick = new Brick(gameBall);
				gameBall.addObserver(newBrick);
				//this.add(newBrick, brickX, brickY);
				brickX += 50;
				//Every 5 bricks move to create a new row
				if(i % 5 == 0) {
					brickY += 50;
					brickX = 50;
				}
			}
			
			//Adds the Paddle
			
			gamePaddle = new Paddle();			
			this.add(gamePaddle);
			repaint();
			start();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			gameBall.paintComponent(g);
			gamePaddle.paintComponent(g);
		}
		
		public void start() {
		Thread thread = new Thread() {
	      public void run() {
		        while (true) {
		          gameBall.move();
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
	    

}
