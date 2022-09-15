package game;

public class Ball {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	synchronized public void recevoirLacher(Player p) {
		System.out.println(p.getNameString() + " recoit le ballon");
		
		try {
			Thread.sleep(1501);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p.getNameString() + " La lache le ballon");

	}
	
	
}
