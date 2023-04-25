package Figuren;

public class FigurMain {

	public static void main(String[] args) {
		Kreis k1 = new Kreis("\u001B[35m", 4);
		System.out.println(k1);
		Dreieck d1 = new Dreieck("\u001B[32m",2.0,2.0,3.0);
		System.out.println(d1);
		Dreieck d2 = new Dreieck("\u001B[34m",1.0,1.0,3.0);
		System.out.println(d2);
	}

}
