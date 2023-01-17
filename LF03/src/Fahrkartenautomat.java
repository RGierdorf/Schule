import java.util.Scanner;

class Fahrkartenautomat
{
    public static void main(String[] args)
    {
       Scanner tastatur = new Scanner(System.in);
      
       double zuZahlenderBetrag; 
       double eingezahlterGesamtbetrag;
       boolean On = true;
    
       while(On == true)
       {zuZahlenderBetrag= fahrkartenbestellungErfassen(tastatur);

       eingezahlterGesamtbetrag= fahrkartenBezahlen(tastatur,zuZahlenderBetrag);
       
       fahrscheinausgabe();
       
       rückgabe(eingezahlterGesamtbetrag,zuZahlenderBetrag);       
  
       System.out.println("\nBenötigen Sie noch weitere Karten?\n"+
        		 "Tipen Sie ein: Y / N \n");
         
       On = ausschalten(tastatur);
       }
       System.out.println("\nVergessen Sie nicht, den Fahrschein\n"+
               "vor Fahrtantritt entwerten zu lassen!\n"+
               "Wir wünschen Ihnen eine gute Fahrt.");
       }
       
         
       
       
    
    public static void fahrscheinausgabe() {
       // Fahrscheinausgabe
       // -----------------
       System.out.println("\nFahrschein wird ausgegeben");
       for (int i = 0; i < 8; i++)
       {
          System.out.print("=");
          try {
      Thread.sleep(250);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
       }
       System.out.println("\n\n");
    }
    public static void rückgabe(double eingezahlterGesamtbetrag,double zuZahlenderBetrag) {

       // Rückgeldberechnung und -Ausgabe
       // -------------------------------
       double rückgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
       if(rückgabebetrag > 0.0)
       {
         System.out.format("Der Rückgabebetrag in Höhe von %4.2f € %n" , rückgabebetrag );
         System.out.println("wird in folgenden Münzen ausgezahlt:");

           while(rückgabebetrag >= 2.0) // 2 EURO-Münzen
           {
            System.out.println("2 EURO");
            rückgabebetrag -= 2.0;
           }
           while(rückgabebetrag >= 1.0) // 1 EURO-Münzen
           {
            System.out.println("1 EURO");
            rückgabebetrag -= 1.0;
           }
           while(rückgabebetrag >= 0.5) // 50 CENT-Münzen
           {
            System.out.println("50 CENT");
            rückgabebetrag -= 0.5;
           }
           while(rückgabebetrag >= 0.2) // 20 CENT-Münzen
           {
            System.out.println("20 CENT");
            rückgabebetrag -= 0.2;
           }
           while(rückgabebetrag >= 0.1) // 10 CENT-Münzen
           {
            System.out.println("10 CENT");
            rückgabebetrag -= 0.1;
           }
           while(rückgabebetrag >= 0.05)// 5 CENT-Münzen
           {
            System.out.println("5 CENT");
            rückgabebetrag -= 0.05;
           }
       }
    }

    public static double fahrkartenbestellungErfassen(Scanner in) {
    	double ticketPreis = 0, zuZahlenderBetrag = 0 ,zwischensumme;
    	int ticketArt,ticketAnzahl;
    	boolean Auswahl = true;
    	System.out.print("Einzelfahrschein Regeltarif AB [2,90 EUR] (1)\n"+
        		"Tageskarte Regeltarif AB [8,60 EUR] (2)\n"+
        		"Kleingruppen-Tageskarte Regeltarif AB [23,50 EUR] (3)\n"+
        		"Wählen Sie die Ticketnummer: ");
    	
    	ticketArtArray = {"Einzelfahrschein Berlin AB","Einzelfahrschein Berlin BC","Einzelfahrschein Berlin ABC","Kurzstrecke"
    	ticketPreisArray = {2.90, 3.30 , 3.60, 1.90, 8.60, 9.00, 9.60, 23.50, 24.30, 24.90};
    	ticketArt = in.nextInt();
    	
        do {
        do {
    	switch(ticketArt){
        	case 1:
        		ticketPreis = 2.90;
        		Auswahl = true;
        		break;
        	case 2:
        		ticketPreis = 8.60;
        		Auswahl = true;
        		break;
        	case 3:
        		ticketPreis = 23.50;
        		Auswahl = true;
        		break;
        	case 9:
        		Auswahl = true;
        		break;
        	default :
        		System.out.print("Falsche Eingabe\n"+
        	"Geben Sie eine neue gültige Auswahl ein: ");
        		ticketArt = in.nextInt();
        		Auswahl = false;
        	    	};
    	}while (Auswahl == false );
        System.out.print("Anzahl der Tickets: ");
        ticketAnzahl = in.nextInt();
        while(ticketAnzahl>10  || ticketAnzahl<1 )
        {System.out.println("Ticket Anzahl ungültig!");
        System.out.println("Wählen Sie eine gülzige Ahnzahl (zwischen 1 und 10): ");
        ticketAnzahl = in.nextInt();
        }
        
        zwischensumme = ticketPreis * ticketAnzahl;
        zuZahlenderBetrag += zwischensumme;
        System.out.println("Zu zahlende zwischen Summe: " + zuZahlenderBetrag + " €" );
        System.out.println("Wählen Sie ein neues Ticket oder beenden Sie die Eingabe(9): ");
        ticketArt = in.nextInt();
        }while (ticketArt != 9);
        return zuZahlenderBetrag;
    }
    public static double fahrkartenBezahlen(Scanner in,double zuZahlenderBetrag) {
        // Geldeinwurf
        // -----------
        double eingezahlterGesamtbetrag = 0.0;
        while(eingezahlterGesamtbetrag < zuZahlenderBetrag)
        {
          System.out.format("Noch zu zahlen: %4.2f €%n" , (zuZahlenderBetrag - eingezahlterGesamtbetrag));
          System.out.print("Eingabe (mind. 5Ct, höchstens 2 Euro): ");
          double eingeworfeneMünze = in.nextDouble();
            eingezahlterGesamtbetrag += eingeworfeneMünze;
         }
         return eingezahlterGesamtbetrag;
    }
    
    public static boolean ausschalten(Scanner in) {
    	String Input;
    	Input = in.next();
    	boolean On;
    	switch (Input) 
    	{
    	case "y": 
    		On = true;
    		break;
    	case "n":
    		On = false;
    		break;
    	default:
    		System.out.println("Fehler");
    		On = false;
    		break;}
    	return On;
    }
}

