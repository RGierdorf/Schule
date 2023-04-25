package Raumschiffe;
/**
 * Das Programm RaumschiffEndzustand, soll verschiedene Methoden 
 * der Klassen Raumschiffe und Ladung testen.
 * @author raffael
 *
 */
public class RaumschiffEndzustand {
	public static void main(String[] args) {
		Raumschiff klingonen = new Raumschiff(3, 100, 100, 100, 100, 2, "IKS Heght'ta");
		klingonen.addLadung(new Ladung("Ferengi Schneckensaft", 200));
		klingonen.addLadung(new Ladung("Bat'leth Klingonen Schwert ", 200));
		
		Raumschiff romulaner = new Raumschiff(2, 100, 100, 100, 100, 2, "IRW Khazara");
		romulaner.addLadung(new Ladung("Borg-Schrott",5));
		romulaner.addLadung(new Ladung("Rote Materie",2));
		romulaner.addLadung(new Ladung("Plasma-Waffe",50));
		
		Raumschiff vulkanier = new Raumschiff(0, 80, 80, 50, 100, 5, "Ni'Var");
		vulkanier.addLadung(new Ladung("Forschungssonde",35));
		vulkanier.addLadung(new Ladung("Photonentorpedo",3));
		
		
		klingonen.photonentorpedoSchiessen(romulaner);
		
		romulaner.phaserkanoneSchiessen(klingonen);
		
		vulkanier.nachrichtAnAlle("Gewalt ist nicht logisch");
		
		klingonen.zustandRaumschiff();
		klingonen.ladungsverzeichnisAusgeben();
		
		klingonen.photonentorpedoSchiessen(romulaner);
		klingonen.photonentorpedoSchiessen(romulaner);
		
		klingonen.zustandRaumschiff();
		klingonen.ladungsverzeichnisAusgeben();
		
		romulaner.zustandRaumschiff();
		romulaner.ladungsverzeichnisAusgeben();
		
		vulkanier.zustandRaumschiff();
		vulkanier.ladungsverzeichnisAusgeben();
		
		Raumschiff.logbuchEintraegeZurueckgeben();
		}
}
