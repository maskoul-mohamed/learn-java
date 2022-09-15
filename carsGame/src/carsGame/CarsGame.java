package carsGame;

import java.awt.Color;
import java.awt.GridLayout;

public class CarsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Piste p = new Piste("Formula 1", 500, 700);
		
		p.setLayout(new GridLayout(4,1));

		Thread[] threads = new Thread[4];
		Voiture[] voiture = new Voiture[4];
		
		voiture[0] = new Voiture(Color.red, "Hamid", 0, 360);
		voiture[1] = new Voiture(Color.black, "Hassan", 0, 360);
		voiture[2] = new Voiture(Color.green, "Said", 0, 360);
		voiture[3] = new Voiture(Color.blue, "Moad", 0, 360);
		
		for(int i = 0 ; i < 4 ; i++) {
			p.add(voiture[i]);
			threads[i] = new Thread(voiture[i]);
		}
		
		p.validate();
		
		for(int i = 0 ; i < 4 ; i++) {
			threads[i].start();
		}
	}

}
