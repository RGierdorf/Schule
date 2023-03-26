package Raumschiffe;

public class RaumschiffTest {
	public static void main(String[] args) {
		Raumschiff klingonen = new Raumschiff(1, 100, 100, 100, 100, 2, "IKS Heght'ta");
		klingonen.addLadung(new Ladung("Ferengi Schneckensaft", 200));
		
		System.out.println(klingonen.getSchiffsname());
		System.out.println(klingonen.toString());
		klingonen.ladungsverzeichnisAusgeben();
		
		Raumschiff romulaner = new Raumschiff(5, 100, 100, 100, 100, 2, "IRW Khazara");
		
		romulaner.photonentorpedoSchiessen(klingonen);
		romulaner.photonentorpedoSchiessen(klingonen);
		romulaner.photonentorpedoSchiessen(klingonen);
		romulaner.photonentorpedoSchiessen(klingonen);
		romulaner.photonentorpedoSchiessen(klingonen);
		System.out.println(klingonen.toString());
		System.out.println(romulaner.toString());
		
	}
}
