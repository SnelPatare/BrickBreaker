import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Paddle extends JPanel implements Observer, KeyListener, ActionListener {
//public class Paddle1 implements Ball{
	//private int BallY
	//Inherited method from Observer
	public void update() {
		
	}
        int Loc_X;
        int Loc_Y;
        public Paddle() {
            Loc_X = 100;
            Loc_Y = 500;
            Timer tm = new Timer(10, this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            addKeyListener(this);
            tm.start();
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //this.setBackground(Color.GREEN);
            //g.setColor(Color.GREEN);
            g.setColor(Color.green);
            g.fillRect(Loc_X,Loc_Y,100,10);
            //g.dispose();
        }
        
        public int getX() {
        	return Loc_X;
        }
        
        public int getY() {
        	return Loc_Y;
        }
        
        public Rectangle getBounds() {
        	Rectangle paddle = new Rectangle(Loc_X, Loc_Y, 100, 10);
        	return paddle;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int Key=e.getKeyCode();
            if (Key == KeyEvent.VK_RIGHT) {
                if (Loc_X >= 675){
                    Loc_X = 675;
                }
                else {
                    //System.out.println(Loc_X+ ", after: "+ (Loc_X-1));
                    Loc_X = Loc_X + 20;
                }
            }

            if (Key == KeyEvent.VK_LEFT){
                if (Loc_X <= 10){
                    Loc_X = 10;
                }
                else {
                    //System.out.println(Loc_X+ ", after: "+ (Loc_X-1));
                    Loc_X = Loc_X - 20;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
        public boolean isFocusTraversal(){ 
        	return true;
    	}
		//o.addObserver(this);

}
