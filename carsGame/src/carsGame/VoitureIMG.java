package carsGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class VoitureIMG extends Canvas implements Runnable {
	private String pilote;
	private Color color;
	private int position;
	private int vitesse;
	private int depart;
	private int arrivee;
	Image image;
	
	public VoitureIMG(Color color, String pilote,int depart, int arrivee) {
		this.pilote = pilote;
		this.color = color;
		this.depart = depart;
		this.position = depart;
		this.arrivee = arrivee;
		
		vitesse = (int)Math.floor(Math.random() * 100);
		image = Toolkit.getDefaultToolkit().getImage("car.png");
		setSize(120,50);
	}
	
	public void avancer(int dx) {
		this.position += dx;
		repaint();
	}

	public void paint(Graphics g) {
		g.drawImage(image, position, 10, 120, 60,  this);
		g.setColor(Color.black);
		g.drawString(pilote, position + 50, 30);
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
