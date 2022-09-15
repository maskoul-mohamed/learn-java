package carsGame;

import javax.swing.JFrame;

public class Piste extends JFrame {
	public Piste(String titre, int largeur, int hauteur) {
		super(titre);
		setSize(largeur, hauteur);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
