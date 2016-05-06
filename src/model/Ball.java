package model;

import java.util.Random;

public class Ball {
	
	private boolean onContact = false;
	
	private int deltaX = 4;
	private int deltaY = 0;
	private int ballX = 230;
	private int ballY = 200;
	
	private int lastX = 5;
	private int lastY = 5; //balls last position
	
	
	
	private final int diameter = 20;
	

	
	
	public Ball() {
		
	}
	
	/**
	 * Checks if the check parameter is in between bottom and top
	 */
	
	public boolean intBetween(int check, int bottom, int top) {
		return ((check > bottom) && (check < top));
	}
	
	/**
	 * Sets the balls location if all criteria is met. 
	 * It will check if it hits the north or south wall and change direction and angle appropriately
	 * Also checking to see if collision between either paddle is being made, and acting accordingly.
	 * @param x
	 * @param y
	 * @param user
	 * @param comp
	 * @author Aaron Roberts
	 */
	public void setLocation(int x, int y, Player user, Player comp) { 	
		Random rr = new Random();
		int ra = rr.nextInt(3); 
		if ((y - diameter) < 0) { //If the ball hit the top wall, change ydelta with randomness			
				deltaY = deltaY * -1;  
				
			
		}
		if (y > (455 - diameter) ) {//if ball hit bottom wall, change ydelta and inverse randomness
			ra = ra * - 1;
			deltaY = deltaY * -1;

		}
		if (x < user.getRightX()) {//Check if ball is hitting the user
			if (intBetween(y, user.getTopY() - diameter, user.getBottomY())){//paddle
					if (deltaX < 0) { //moving right
						ballX = lastX;
						ballY = lastY;
						deltaX = deltaX * -1;
						deltaY = deltaY + Math.round(ra);
					}
					
				
			}
		}
		
		if (x > (comp.getLeftX() - diameter) ) {//check to see if the ball is hitting pc paddle
			if (intBetween(y, comp.getTopY(), comp.getBottomY())){
				if (deltaX > 0) { //Make sure ball is moving to the right before switching directions
					ballX = lastX;
					ballY = lastY;
					deltaX = deltaX * -1;
					deltaY = deltaY + Math.round(ra);
				}
					
			}
			
		}
	
		lastX = ballX;
		lastY = ballY;
		
		ballX = x; //Set ball position
		ballY = y;
	}
	
	public int getDiameter() {
		return diameter;
	}
	
	public int getDeltaX () {
		return deltaX;
	}
	
	public int getDeltaY() {
		return deltaY;
	}
	
	
	public int getX() {
		return ballX;
	}
	
	public int getY() {
		return ballY;
	}

	public void resetDeltas() {
		deltaX = 4;
		deltaY = 0;
	}
}
