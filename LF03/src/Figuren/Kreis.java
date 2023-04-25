package Figuren;

import java.lang.Math;
import java.text.*;

public class Kreis extends Figur {
	private double radius;

	public Kreis(String farbe, double radius) {
		super(farbe);
		setRadius(radius);
	}

	// Getter & Setter
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius > 0) {
		this.radius = radius;
		}
		else {
			this.radius = 1;
		}
	}
	// Methoden
	
	@Override
	public double umfang() {
		double umfang;
		radius = getRadius();
		umfang = 2 * Math.PI * radius;
		return umfang;
	}
	@Override
	public double flaeche() {
		double flaeche;
		radius = getRadius();
		flaeche = Math.PI * Math.pow(radius, 2);
		return flaeche;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###.##");
		return getFarbe() + "Kreis mit dem Radius: " + getRadius() + "\n" + "Kreisumfang: " + df.format(umfang()) + "\n"
				+ "Kreisfläche: " + df.format(flaeche()) + "\u001B[0m";
	}

}
