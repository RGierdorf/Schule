
public class Artikel {
	// Atribute
	private String bezeichnung; 
	private int nummer; 
	private double einkaufspreisInEuro;
	private double verkauspreisInEuro;
	private int sollBestand;
	private int istBestand;

	//Methoden
	public Artikel() {
		
	}
	//Parametrisierter Konstruktor
	public Artikel(String name, int nummer, double einkaufspreisInEuro, double verauspreisInEuro) {
		setBezeichnung(name);
		setNummer(nummer);
		setEinkaufspreisInEuro(einkaufspreisInEuro);
		setVerkaufspreisInEuro(verauspreisInEuro);
	}
	public void bestellen() {
		if( getIstBestand() < getSollBestand() *0.8 ) {
			setIstBestand (getSollBestand());
		}
		
	}
	public double gewinnBerechnen() {
		public double gewinn;
		gewinn = getVerkaufspreisInEuro() - getEinkaufspreisInEuro();
		
	}
	
	
	public String getBezeichnung() {
		return this.bezeichnung;
	}
	public int getNummer() {
		return this.nummer;
	}
	public double getVerkaufspreisInEuro() {
		return this.verkauspreisInEuro;
	}
	public double getEinkaufspreisInEuro() {
		return this.einkaufspreisInEuro;
	}
	public int getSollBestand() {
		return this.sollBestand;
	}
	public int getIstBestand() {
		return this.istBestand;
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public void setEinkaufspreisInEuro(double einkaufspreisInEuro) {
		this.einkaufspreisInEuro = einkaufspreisInEuro;
	}
	public void setVerkaufspreisInEuro(double verkauspreisInEuro) {
		this.verkauspreisInEuro = verkauspreisInEuro;
	}
	public void setSollBestand(int sollBestand) {
		this.sollBestand = sollBestand;
	}
	public void setIstBestand(int istBestand) {
		this.istBestand = istBestand;
	}

}
