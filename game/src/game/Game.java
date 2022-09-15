package game;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ball b = new Ball();
		b.setNumber(1);
		Player p1 = new Player("Hamid", b);
		Player p2 = new Player("Ali", b);
		Player p3 = new Player("Yassin", b);
		
		
			p1.start();
			p2.start();
			p3.start();
		
	}

}
