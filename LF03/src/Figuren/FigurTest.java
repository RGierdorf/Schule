package Figuren;

public class FigurTest {

	public static void main(String[] args) {
			Kreis k1 = new Kreis("\u001B[35m", 4);
			System.out.println(k1);
			Kreis k2 = new Kreis("\u001B[33m", -2);
			System.out.println(k2);
			/*
			Dreieck d1 = new Dreieck("\u001B[32m",2.0,2.0,3.0);
			System.out.print(d1);
			System.out.println(d1.alpha());
			System.out.println(d1.hoeheA());
			System.out.println(d1.grad(d1.alpha()));
			System.out.println(d1.istDreieck());
			System.out.println(d1.grad(d1.alpha()) + d1.grad(d1.beta()) + d1.grad(d1.gamma()));
	*/
	}

}
