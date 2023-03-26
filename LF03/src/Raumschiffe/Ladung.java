package Raumschiffe;

public class Ladung {
	private String bezeichnung;
	private int menge;
	
	//Methoden
	
	//public Ladung() {
		
	//}
	public Ladung (String bezeichnung, int menge) {
		setBezeichnung(bezeichnung) ;
		setMenge(menge) ;
		
	}
	
	//getter
	public String getBezeichnung() {
		return this.bezeichnung;
	}
	public int getMenge() {
		return this.menge;
	}
	
	//setter
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	@Override
	public String toString() {
		return "Ladung {"+
				"Bezeichnung "+ this.bezeichnung +
				" Menge "+ this.menge +
				"}";
		
	}
		
		
}
