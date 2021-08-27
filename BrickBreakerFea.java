package BrickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BrickBreakerFea {
    public static class Play extends JPanel implements KeyListener, ActionListener {
        int score = 0;
        int bricks = 12;
        int X = 210;
        int ball_X = 100;
        int ball_Y = 250;
        int dir_X = -1;
        int dir_Y = -2;

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

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                if(X>=650){
                    X = 650;
                }
                else{
                    moveRight();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                if(X>=10){
                    X = 10;
                }
                else{
                    moveLeft();
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Play gameplay = new Play();

        frame.setSize(800,600);
        frame.setTitle("Brick Breaker");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
        frame.add(gameplay);

    }
}
