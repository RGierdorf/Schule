package Raumschiffe;
import java.util.ArrayList;

public class Raumschiff {
	// Attribute
	private int photonentorpedoAnzahl;
	private int energieversorgungInProzent;
	private int schildeInProzent;
	private int huelleInProzent;
	private int lebenserhaltungssystemeInProzent;
	private int androidAnzahl;
	private String schiffsname;
	//private ArrayList<String> broadcastKommunikator;
	private ArrayList<Ladung> ladungsverzeichnis = new ArrayList<Ladung>();
	
	//Methoden
	
	public Raumschiff() {
		
	}
	/**
	 * Vollparametrisierter Konstruktor
	 * @param photonentorpedoAnzahl Anzahl der geladenen Photonentorpedos
	 * @param energieversorgungInProzent Energieversogung des Raumschiffs in Prozent
	 * @param zustandSchildeInProzent Zustand der Schilde des Rauschiffs in Prozent
	 * @param zustandHuelleInProzent Zustand der Huelle des Raumschiffs in Prozent
	 * @param zustandLebenserhaltungssystemeInProzent Zustand der Lebenserhaltungssystem des Raumschiffs in Prozent
	 * @param anzahlDroiden Anzahl der Reperatur Droiden die dem Raumschiff zur Verfügungen stehen 
	 * @param schiffsname Name des Raumschiffs
	 */
	public Raumschiff (int photonentorpedoAnzahl,int energieversorgungInProzent,
						int zustandSchildeInProzent,int zustandHuelleInProzent,
						int zustandLebenserhaltungssystemeInProzent,
						int anzahlDroiden,String schiffsname) {
		setPhotonentorpedoAnzahl(photonentorpedoAnzahl);
		setEnergieversorgungInProzent(energieversorgungInProzent);
		setSchildeInProzent(zustandSchildeInProzent);
		setHuelleInProzent(zustandHuelleInProzent);
		setLebenserhaltungssystemeInProzent(zustandLebenserhaltungssystemeInProzent);
		setAndroidAnzahl(anzahlDroiden);
		setSchiffsname(schiffsname);
		
	}
	/**
	 * addLadung ist eine Methode mit der man eine neue Ladung dem Ladungsverzeichnes hinzufügt.
	 * Eine Ladung besteht aus einer Bezeichnung (String) und einer Anzahl (int).
	 * @param neueLadung besteht aus String bezeichnung, int menge
	 */
	public void addLadung(Ladung neueLadung) {
		ladungsverzeichnis.add(neueLadung);
	}
	/**
	 * photonentorpedoSchiessen ist eine Methode bei der Raumschiffe beschossen werden können.
	 * Dabei werden Photonentorpedos des Raumschiffs aufgebraucht.
	 * Sind keine Photonentorpedos zum Abfeuern bereit bekommt man die Nachricht -*Click*-.
	 * Bei einem Trfeffer wird eine Nachricht an alle gesendet, welches Ziel getroffen worden ist.
	 * @param ziel Eine Instanz der Klasse Raumschiff
	 */
	public void photonentorpedoSchiessen(Raumschiff ziel) {
		String nachricht;
		if (getPhotonentorpedoAnzahl() > 0) {
			this.photonentorpedoAnzahl -= 1;
			nachricht= "Photonentorpedo abgeschossen";
			nachrichtAnAlle(nachricht);
			treffer(ziel);
		}
		else {
			nachricht = "-=*Click*=-";
			nachrichtAnAlle(nachricht);
		}
	}
	/**
	 * phaserkanoneSchiessen ist eine Methode bei der Raumschiffe beschossen werden können.
	 * Dabei wird energieversongungInProzent des Raumschiffs aufgebraucht.
	 * Ist energieversorgunfInProzent zu niedrig zum Abfeuern, bekommt man die Nachricht -*Click*-.
	 * Bei einem Trfeffer wird eine Nachricht an alle gesendet, welches Ziel getroffen worden ist.
	 * @param ziel Eine Instanz der Klasse Raumschiff
	 */
	public void phaserkanoneSchiessen(Raumschiff ziel) {
		String nachricht;
		if (getEnergieversorgungInProzent() > 0) {
			this.energieversorgungInProzent -= 50;
			nachricht= "Phaserkanone abgeschossen";
			nachrichtAnAlle(nachricht);
			treffer(ziel);
		}
		else {
			nachricht = "-=*Click*=-";
			nachrichtAnAlle(nachricht);
		}
	}
	/**
	 * Die Methode teffer berechnet den Schaden am getroffennen Raumschiff.
	 * Die Schilde des getroffenen Raumschiffs werden um 50% geschwächt.
	 * Sollte anschließend die Schilde vollständig zerstört worden sein, 
	 * so wird der Zustand der Hülle und der Energieversorgung jeweils um 50% abgebaut.
	 * Sollte danach der Zustand der Hülle auf 0% absinken,
	 * so sind die Lebenserhaltungssysteme vollständig zerstört und es wird eine Nachricht an Alle ausgegeben,
	 * dass die Lebenserhaltungssysteme vernichtet worden sind.
	 * @param ziel Instanz eines Raumschiffs
	 */
	private void treffer(Raumschiff ziel) {
		String name = ziel.getSchiffsname();
		System.out.println(name + " wurde getroffen!");
		if (ziel.getSchildeInProzent() >= 50) {
			ziel.schildeInProzent -= 50; 
		}
		else if (ziel.getSchildeInProzent() < 50 && ziel.getSchildeInProzent() > 0) {
			ziel.schildeInProzent = 0;
			ziel.huelleInProzent -= 50;
			ziel.energieversorgungInProzent -= 50;
		}
		else if (ziel.getSchildeInProzent() == 0 && ziel.getHuelleInProzent() > 50) {//geht nicht in die && Schleife
			ziel.huelleInProzent -= 50;
			ziel.energieversorgungInProzent -= 50;
		}
		else if (ziel.getSchildeInProzent() == 0 && ziel.getHuelleInProzent() <= 50) {
			ziel.huelleInProzent = 0;
			ziel.energieversorgungInProzent -= 50;
			ziel.nachrichtAnAlle("Die Lebenserhaltungssysteme wurden zersört!");
		}
		
	}
	/**
	 * Die Methode gibt Nachrichten auf der Konsole aus, die von Objekten der Klasse Raumschiff geschickt werden.
	 * @param nachricht String mit der zusendenden Nachricht
	 */
	public void nachrichtAnAlle(String nachricht) {
		String name = getSchiffsname();
		System.out.println("["+ name+ "]: " + nachricht);
		
	}
	/**
	 * Die Methode zustandRaumschiff gibt alle Attribute des Objekts auf der Konsole aus.
	 */
	public void zustandRaumschiff() {
		System.out.println(this.toString());
	}
	/**
	 * Die Methode ladungsverzeichnisAusgeben gibt alle Objekte der Klasse Ladung,
	 * aus der Liste ladungsverzeichnis,auf der Konsole aus.
	 */
	public void ladungsverzeichnisAusgeben() {
		for (int i = 0 ; i<this.ladungsverzeichnis.size(); i++) {
			System.out.println(this.ladungsverzeichnis.get(i));
		}
	}
	
	@Override
	public String toString() {
		return "Raumschiff {"+ 
				" Name: "+ getSchiffsname() + "\n"+
				" PhotonentorpedoAnzahl: " +getPhotonentorpedoAnzahl() +
				"\n EnergieversorgungInProzent: " + getEnergieversorgungInProzent()+
				"\n SchildeInProzent: " + getSchildeInProzent() +
				"\n HuelleInProzent: " + getHuelleInProzent() +
				"\n LebenserhaltungssystemeInProzent: " + getLebenserhaltungssystemeInProzent() +
				"\n AndroidAnzahl: " + getAndroidAnzahl() + "}";
	}
	//getter
	public int getPhotonentorpedoAnzahl() {
		return this.photonentorpedoAnzahl;
	}
	public int getEnergieversorgungInProzent() {
		return this.energieversorgungInProzent;
	}
	public int getSchildeInProzent() {
		return this.schildeInProzent;
	}
	public int getHuelleInProzent() {
		return this.huelleInProzent;
	}
	public int getLebenserhaltungssystemeInProzent() {
		return this.lebenserhaltungssystemeInProzent;
	}
	public int getAndroidAnzahl() {
		return this.androidAnzahl;
	}
	public String getSchiffsname() {
		return this.schiffsname;
	}
	
	//setter
	
	public void setPhotonentorpedoAnzahl(int photonentorpedoAnzahl) {
		this.photonentorpedoAnzahl = photonentorpedoAnzahl;
	}
	public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
		this.energieversorgungInProzent = energieversorgungInProzent;
	}
	public void setSchildeInProzent(int schildeInProzent) {
		this.schildeInProzent = schildeInProzent;
	}
	public void setHuelleInProzent(int huelleInProzent) {
		this.huelleInProzent = huelleInProzent;
	}
	public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
		this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
	}
	public void setAndroidAnzahl(int androidAnzahl) {
		this.androidAnzahl = androidAnzahl;
	}
	public void setSchiffsname(String schiffsname) {
		this.schiffsname = schiffsname;
	}
}
