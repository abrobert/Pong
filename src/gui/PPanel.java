package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Ball;
import model.Player;

public class PPanel extends JPanel implements KeyListener, ActionListener{

	private Player user, computer;
	private Ball ball;
	private boolean reset = true;
	public PPanel() {

		user = new Player(false);
		computer = new Player(true);
		ball = new Ball();
		
		setBackground(Color.BLACK);
		addKeyListener(this);
		setFocusable(true);
		
		Timer timer = new Timer(1000/60, this);
	    timer.start();
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("User: "+user.getScore(), user.getX() + 100, 50);
		g.drawString("Computer: "+computer.getScore(), computer.getX() - 100, 50);

        g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
        
        g.fillRect(user.getX(), user.getY(), user.getWidth(), user.getHeight());
        g.fillRect(computer.getX(), computer.getY(), computer.getWidth(), computer.getHeight());

        
	
	}

	@Override//This is our game loop
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == (KeyEvent.VK_DOWN)) {
			user.setLocation(user.getX(), user.getY() + user.getPaddleSpeed());
			
		} else {
			if (arg0.getKeyCode() == (KeyEvent.VK_UP)) {
				user.setLocation(user.getX(), user.getY() - user.getPaddleSpeed());
			}	
		}
		
		if (reset) { //Game over
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
				System.out.println("enter");
				reset = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override//Every 60 
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (reset) {//if someone scored, reset all positions
			ball.setLocation(230, 200, user, computer);
			computer.setLocation(400, 250 - computer.getHeight());
			user.setLocation(50, 250 - user.getHeight());
			ball.resetDeltas();
			
		} else { 
			if (ball.getX() < 30) { // computer scored
				reset = true;
				computer.incScore();
			} 
			if (ball.getX() > computer.getRightX() + 20) {//user scored
				reset = true;
				user.incScore();
			}
			
			if (!reset) { // Lets move the ball
				ball.setLocation(ball.getX() + ball.getDeltaX(), ball.getY() + ball.getDeltaY(), user, computer);
			}
			Random x = new Random();
			int r = Math.round(x.nextInt(20));
			if (r > 8) { //make computer a little easier to beat
				if (ball.getY() < computer.getY()) {
					computer.setLocation(computer.getX(), computer.getY() - computer.getPaddleSpeed() );
				} 
				if (ball.getY() > computer.getBottomY()) {
					computer.setLocation(computer.getX(), computer.getY() + computer.getPaddleSpeed() );
				}
			}
			
		}
		repaint();
		
	}

}
