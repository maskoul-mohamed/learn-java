package carsGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Voiture extends Canvas implements Runnable {
	private String pilote;
	private Color color;
	private int position;
	private int vitesse;
	private int depart;
	private int arrivee;
	
	
	public Voiture(Color color, String pilote,int depart, int arrivee) {
		this.pilote = pilote;
		this.color = color;
		this.depart = depart;
		this.position = depart;
		this.arrivee = arrivee;
		
		vitesse = (int)Math.floor(Math.random() * 100);
		
		setSize(120,50);
	}
	
	public void avancer(int dx) {
		this.position += dx;
		repaint();
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRoundRect(position, 10, 120, 30, 10, 10);
		g.fillOval(position + 10, 32, 30, 30);
		g.fillOval(position + 75, 32, 30, 30);
		g.setColor(Color.white);
		g.drawString(pilote, position + 10, 30);
	}

	@Override
	synchronized  public void run() {
		// TODO Auto-generated method stub
		while(position <= arrivee) {
			avancer(1);
			 try {
					Thread.sleep(vitesse);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}        
		
	}
	
}
