package Figuren;

public abstract class Figur {
	private String farbe;
	
	public Figur(String farbe) {
		setFarbe(farbe);
	}
	

	public abstract double umfang();
	
	public abstract double flaeche();
	
	public abstract String toString();
	
	
	//Getter & Setter
	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
}
