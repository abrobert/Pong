package model;

public class Player {
	
	private boolean onNorthWall = false;
	private boolean onSouthWall = false;
	
	private int playerX = 0;
	private int playerY = 100;
	
	private final int playerWidth = 15; //In pixels
	private final int playerHeight = 90; //In pixels
	
	private final int paddleSpeed = 10;
	
	private int score = 0;
	
	
	public Player(boolean cpu) {
		playerX = ((cpu) ? 400 : 50); //If were adding a CPU set the appropriate location
		playerY = 250 - playerHeight; //Needs to be changed
		
		
	}

	/**
	 * Checks to see if the player is touching a north or south wall.
	 * @param dir 'N' or 'S' for north or south wall
	 * @return returns true if player is touching wall
	 * @author Aaron Roberts
	 */
	public boolean onWall(char dir) {
		if (dir == 'N') 
			return onNorthWall;
		return onSouthWall;
	}
	
	public int getTopY() {
		return playerY;
	}
	
	public int getBottomY() {
		return playerY + playerHeight;
	}
	
	public int getRightX() {
		return playerX + playerWidth;
	}
	
	public int getLeftX() {
		return playerX;
	}
	
	
	public void setOnNorthWall() {
		onNorthWall = true;
	}
	
	public void setOnSouthWall() {
		onSouthWall = true;
	}
	
	public int getScore() {
		return score;
	}
	
	public void incScore() {
		score = score + 1;
	}
	
	public int getHeight() {
		return playerHeight;
	}
	
	public int getWidth() {
		return playerWidth;
	}
	
	
	public int getX() {
		return playerX;
	}
	
	public int getY() {
		return playerY;
	}
	
	public int getPaddleSpeed() {
		return paddleSpeed;
	}
	
	/**
	 * Sets location of the paddle, used for paddle movement.
	 * Restrictions on north and south walls.
	 * @param x
	 * @param y
	 */
	public void setLocation(int x, int y) { // X is useless in this case, but I left it in there
		if (y < playerY){
			if (y > 0) {
				playerX = x;
				playerY = y;
				onNorthWall = false;
			} else {
				onNorthWall = true;
			}
		} else {
			if (y < (461 - (playerHeight))) // 500 is window height/width (500 was a bit too big)
			{
				playerX = x;
				playerY = y;
			} else {
				onSouthWall = true;
			}
		}
			
	}
	
	
	

}
