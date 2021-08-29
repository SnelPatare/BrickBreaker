

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BrickBreakerMain{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Ball ball = new Ball();
        //Takes in Ball as a parameter to observe as well as number of bricks
        Board gameBoard = new Board(ball, 20); 
        //ball.addObserver(gameBoard);
        frame.setSize(800,600);
        frame.setTitle("Brick Breaker");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Paddle paddle = new Paddle();
        //frame.add(paddle);
        //frame.pack();
        frame.setVisible(true);
        frame.add(gameBoard);
        //frame.setContentPane(ball);
        frame.setContentPane(gameBoard);
       // ball.move();

    }
}
