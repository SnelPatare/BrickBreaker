import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	    int score = 0;
	    int bricks = 12;
	    int X = 210;
	    int ball_X = 100;
	    int ball_Y = 250; 
	    int dir_X = -1;
	    int dir_Y = -2;
	    Ball gameBall;
	    Paddle gamePaddle;
	    Clock gameClock;
	    public static boolean isPlay;
	    ArrayList<Brick> brickList = new ArrayList<Brick>();

	    final int WIDTH_OFFSET = 100;
	    final int HEIGHT_OFFSET = 80;
	    final int BRICK_WIDTH = 80;
	    final int BRICK_SPACING = 4;
	    final int BRICK_HEIGHT = 12;
	    final int BRICKS_PER_ROW = 5;
	
	//Inherited method from Observer
		public void update() {
			
		}
		
		public Board(Ball gameBall, int numBricks) {
			//this.setSize(getWidth(), getHeight());
			this.gameBall = gameBall;
			this.isPlay=true;
			
			//gameBall.addObserver(this);
			this.add(gameBall);
			
			///gameBall.move();
			this.bricks = numBricks;
			int brickX = 50;
			int brickY = 200;
			
			//Populates the board with bricks
			for(int i = 0; i < numBricks; i++) {
				Brick newBrick = new Brick((i%BRICKS_PER_ROW)*(BRICK_WIDTH+BRICK_SPACING)+WIDTH_OFFSET, 
						HEIGHT_OFFSET-((i/BRICKS_PER_ROW)*(BRICK_HEIGHT+BRICK_SPACING)),
						BRICK_WIDTH, BRICK_HEIGHT);
				brickList.add(newBrick);
				this.add(newBrick);
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
			gameBall.addObserver(gamePaddle);
			//repaint();
			
			gameClock = new Clock();
			this.add(gameClock);
			start();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			gameBall.paintComponent(g);
			gamePaddle.paintComponent(g);
			for(Brick brick:brickList) {
				brick.paintComponent(g);
			}
		}
		
		public void start() {
		Thread thread = new Thread() {
			private boolean isplay = Board.isPlay;
	      public void run() {
		        while (Board.isPlay) {
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
