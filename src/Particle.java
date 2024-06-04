import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Particle extends JPanel {
	private int x, y, radius;
	private double mass, charge;
	private double[] v, f;
	private Color c;
	private boolean passed; // See if the particle is outside electric field
	
	public Particle(int x, int y, double[] v, double m, double q, Color c) {
		this.x = x;
		this.y = y;
		this.v = v;
		mass = m;
		radius = (int) (5*m); // Bigger mass represented by bigger particles
		charge = q;
		this.c = c;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(c);
		g.fillOval(x, y, radius, radius);
	}
	
	public void move() {
		// Particle collides with the plate
		if (x<1090 && (y>650 || y<250))
			return;
		
		// Particle exits electric field
		if (x>=1090)
			passed = true;
		
		// Particle comes back, but doesn't reenter electric field
		if (passed && x<1090 && (y<650 || y>250))
			return;
		
		v[0] += f[0]/mass;
		v[1] += f[1]/mass;
		x += v[0];
		y += v[1];
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public double[] getF() {
		return f;
	}

	public void setF(double[] f) {
		this.f = f;
	}
	
	public double[] getV() {
		return v;
	}

	public void setV(double[] v) {
		this.v = v;
	}
}