package Figuren;

import java.text.DecimalFormat;

public class Dreieck extends Figur {
	private double seiteA;
	private double seiteB;
	private double seiteC;
	

	
	public Dreieck(String farbe, double seiteA,double seiteB, double seiteC) {
		super(farbe);
		setSeiteA(seiteA);
		setSeiteB(seiteB);
		setSeiteC(seiteC);
	}
	
	public double alpha() {
		double zaeler = Math.pow(seiteC, 2)+ Math.pow(seiteB, 2) - Math.pow(seiteA, 2);
		double nenner = 2*seiteB*seiteC;
		double winkel = zaeler/nenner;
		double alpha = Math.acos(winkel);
		return alpha;
	}
	public double beta() {
		double zaeler = Math.pow(seiteA, 2)+ Math.pow(seiteC, 2) - Math.pow(seiteB, 2);
		double nenner = 2*seiteA*seiteC;
		double winkel = zaeler/nenner;
		double beta = Math.acos(winkel);
		return beta;	
	}
	public double gamma() {
		double zaeler = Math.pow(seiteA, 2)+ Math.pow(seiteB, 2) - Math.pow(seiteC, 2);
		double nenner = 2*seiteA*seiteB;
		double winkel = zaeler/nenner;
		double gamma = Math.acos(winkel);
		return gamma;		
	}
	public double hoeheA() {
		double hoehe= seiteC * Math.sin(beta());
		return hoehe;
	}
	
	public double hoeheB() {
		double hoehe= seiteC * Math.sin(alpha());
		return hoehe;
	}
	
	public double hoeheC() {
		double hoehe= seiteA * Math.sin(beta());
		return hoehe;
	}
	public double grad(double rad) {
		double grad = (rad/Math.PI)*180;
		return grad;
	}
	public boolean istDreieck() {
		boolean istDreieck;
		if (grad(alpha()) + grad(beta()) + grad(gamma()) == 180 ) {
			 istDreieck = true; 
		}
		else {
			istDreieck = false;
		}
		return istDreieck;
	}
	@Override
	public double umfang() {
		double umfang = seiteA + seiteB + seiteC;
		return umfang;
	}

	@Override
	public double flaeche() {
		double flaeche = seiteA * hoeheA()* 0.5;
		return flaeche;
	}

	@Override
	public String toString() {
			   DecimalFormat df = new DecimalFormat("###.##");
			   String result = getFarbe() + "Dreieck Seitenlänge A: " + getSeiteA() + " B: "
			                   + getSeiteB() + " C: " + getSeiteC() + "\n" ;
		
			   result += istDreieck()
			          ? "Dreieck Winkel Alpha: " + df.format(grad(alpha())) + "°" + " Beta: " +
			          df.format(grad(beta())) + "°" + " Gamma: " + df.format(grad(gamma())) +
			          "° \n" + "Dreieck Höhen h_a: " + df.format(hoeheA()) + " h_b: " +
			          df.format(hoeheB()) + " h_c: " + df.format(hoeheC()) + "\n" +
			          "Dreiecksumfang: " + df.format(umfang()) + "\n" + "Dreiecksfläche: " +
			          df.format(flaeche()) + "\u001B[0m"
			          :
			          "Keine gültigen Seitenlängen für ein Dreieck.";
	
			    return result;
	
	}
	
	//Getter & Setter
	public double getSeiteA() {
		return seiteA;
	}

	public void setSeiteA(double seiteA) {
		if(seiteA > 0) {
			this.seiteA = seiteA;
			}
			else {
			this.seiteA = 1;
			}
	}

	public double getSeiteB() {
		return seiteB;
	}

	public void setSeiteB(double seiteB) {
		if(seiteB > 0) {
		this.seiteB = seiteB;
		}
		else {
		this.seiteB = 1;
		}
	}
	public double getSeiteC() {
		return seiteC;
	}

	public void setSeiteC(double seiteC) {
		if(seiteC > 0) {
			this.seiteC = seiteC;
			}
			else {
			this.seiteC = 1;
			}
	}


}
