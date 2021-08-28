import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Board extends JPanel implements Observer,KeyListener,ActionListener{
	
	    int score = 0;
	    int bricks = 12;
	    int X = 210;
	    int ball_X = 100;
	    int ball_Y = 250;
	    int dir_X = -1;
	    int dir_Y = -2;

	
	//Inherited method from Observer
		public void update() {
			
		}
		
		public Board(Observable ball, int numBricks) {
			ball.addObserver(this);
			this.bricks = numBricks;
			int brickX = 50;
			int brickY = 200;
			
			//Populates the board with bricks
			for(int i = 0; i < numBricks; i++) {
				Brick newBrick = new Brick(ball);
				ball.addObserver(newBrick);
				this.add(newBrick, brickX, brickY);
				brickX += 50;
				//Every 5 bricks move to create a new row
				if(i % 5 == 0) {
					brickY += 50;
					brickX = 50;
				}
			}
			
			//Adds the Paddle
			Paddle paddle = new Paddle(ball);
			ball.addObserver(paddle);
			this.add(paddle, 50, 550);
			
		}
	

	        public void features (Graphics graph ){
	            graph.setColor(Color.cyan);                  //Background
	            graph.fillRect(10,10,700,500);
	            graph.setColor(Color.BLACK);                 //Border
	            graph.fillRect(0,0,3,500);
	            graph.fillRect(0,0,700,3);
	            graph.fillRect(699,0,3,500);
	            graph.setColor(Color.GREEN);                 //Paddle
	            graph.fillRect(dir_X,450,100,8);
	            graph.setColor(Color.red);                 //ball
	            graph.fillRect(ball_X,ball_Y,20,20);
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {

	        }

	        @Override
	        public void keyTyped(KeyEvent e) {
	        	if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
	            {
	            	System.out.println("Right");
	                if(X>=650){
	                    X = 650;
	                }
	                else{
	                    //moveRight();
	                }
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
	            	System.out.println("left");
	                if(X>=10){
	                    X = 10;
	                }
	                else{
	                    //moveLeft();
	                }
	            }
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	            {
	            	System.out.println("Right");
	                if(X>=650){
	                    X = 650;
	                }
	                else{
	                    //moveRight();
	                }
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT){
	            	System.out.println("left");
	                if(X>=10){
	                    X = 10;
	                }
	                else{
	                    //moveLeft();
	                }
	            }

	        }

	        @Override
	        public void keyReleased(KeyEvent e) {

	        }
	    

}
