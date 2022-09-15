package game;

public class Player extends Thread {
	private String name;
	private Ball ball;
	
	public String getNameString() {
		return this.name;
	}



	public Player(String name, Ball ball) {
		this.name =name;
		this.ball = ball;
		
	
	}
	
	 public void run() {
		 for(; ;) {
			 this.ball.recevoirLacher(this);
			 
		} 
		 
		 
	}
	
	
}
