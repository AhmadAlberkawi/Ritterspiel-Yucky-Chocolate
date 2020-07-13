import java.util.Scanner;
import java.util.Random;
public class Ritterspiel1 {
	
	static Scanner scr = new Scanner(System.in);
	static SchokoTafel tafel = new SchokoTafel();
	static int  breite ,hoehe, anzhalSpieler, stueckgrosse;
	static long rek;
	static char vh;
	static String aktuellspieler = "Keiner";
	
	public static void main(String[] args) {
		
		// Berechnung der Möglichkeiten bei (2,2) und (3,4) 
		
		rek = rekurs(2,2);
		System.out.println("Die Anzhal der Möglichkeiten (2,2): "+rek);
		
		rek = rekurs(3,4);
		System.out.println("Die Anzhal der Möglichkeiten (3,4): "+rek);
		
		// Eingabe von Benutzer 
		
		anzhalSpieler = eingabe();
		
		if(anzhalSpieler == 1)
			einzelSpieler();
		
		else if(anzhalSpieler == 2)
			zweiSpieler();
		
	}
	
	public static int eingabe() {
		
		System.out.println("\n============================Das Ritterspiel============================");
		
		do {
			System.out.print("\nBreite der Tafel (zwischen 2 und 10): ");
			breite = scr.nextInt();
		}
		while(breite < 2  || breite > 10);
		tafel.setBreite(breite);
		
		do {
			System.out.print("Höhe der Tafel (zwischen 2 und 10): ");
			hoehe = scr.nextInt();
		}
		while(hoehe < 2  || hoehe > 10) ;
		tafel.setHoehe(hoehe);		
		
		do {
			System.out.print("Anzahl der menschlichen Spieler (1 oder 2): ");
			anzhalSpieler= scr.nextInt();
		}
		while(anzhalSpieler != 1 && anzhalSpieler != 2);	
	
		tafel.ausgebeTafel();	
		
		return anzhalSpieler;
	}
	
	public static void zweiSpieler() {
		
		while(tafel.getBreite() != 1 || tafel.getHoehe() != 1)
		{	
			// Am Anfang wird festgelegt, wer das Spiel beginnt, jenach breite und höhe der Tafel
			if(aktuellspieler.equals("Keiner")) 
			{
				// Breite und höhe sind ungleich, dann fängt der König an.
				if(tafel.getBreite() != tafel.getHoehe()) {	
					aktuellspieler = "Ich";
					System.out.print("Ich: Wollen sie horizontal oder vertikal abbrechen (Eingabe H oder V): ");
				}
				else 
				{
					aktuellspieler = "Gegner";
					System.out.print("Gegner: Wollen sie horizontal oder vertikal abbrechen (Eingabe H oder V): ");
				}
			}
			// jenach aktueller Spieler wird entschieden, wer dran ist.
			else {
				if(aktuellspieler.equals("Ich")) 
				{
					aktuellspieler = "Gegner";
					System.out.print("Gegner: Wollen sie horizontal oder vertikal abbrechen (Eingabe H oder V): ");
				}
				else 
				{
					aktuellspieler = "Ich";
					System.out.print("Ich: Wollen sie horizontal oder vertikal abbrechen (Eingabe H oder V): ");
				}
			}
			
			// einlesen der Eingabe horizontal oder vertikal
			
			vh = scr.next().charAt(0);
			
			while(vh != 'H' && vh != 'h' && vh != 'V' && vh != 'v') {
				System.out.println("(Eingabe H oder V): ");
				vh = scr.next().charAt(0);
			}
			
			// einlesen das abgebrochene Stück von Höhe
			if(vh == 'h' || vh =='H') 
			{
				System.out.println("Wie hoch ist das abgebrochene Stück? ");
				
				stueckgrosse = scr.nextInt();
				while(stueckgrosse >= tafel.getHoehe()) {
					System.out.print("das Stück darf nicht großer oder gleich der Hoehe!, geben Sie wieder ein: ");
					stueckgrosse = scr.nextInt();
				}
				// lösche die Stücke von Höhe und gib die Tafel aus!
				tafel.loescheZeile(stueckgrosse);
				tafel.ausgebeTafel();
			}
			// einlesen das abgebrochene Stück von Breite
			else	
			{
				System.out.println("Wie breit ist das abgebrochene Stück? ");
				
				stueckgrosse = scr.nextInt();
				while(stueckgrosse >= tafel.getBreite()) {
					System.out.print("das Stück darf nicht großer oder gleich der Breite!, geben Sie wieder ein: ");
					stueckgrosse = scr.nextInt();
				}
				// lösche die Stücke von Breite und gib die Tafel aus!
				tafel.loescheSpalte(stueckgrosse);
				tafel.ausgebeTafel();
			}		
	} 	
		// wer gewinnt, jenach 	aktueller Spieler
		 
		if(aktuellspieler.equals("Ich")) {
			 System.out.println("Du hast gewonnen.");
		 }
		 else 
			 System.out.println("Gegner hat gewonnen.");
		
	}
	
	public static void einzelSpieler() {
		
		while(tafel.getBreite() != 1 || tafel.getHoehe() != 1)
		{
			// wenn die breite und hoehe ungleich sind, fange ich an.
			if(aktuellspieler.equals("Anfang")) 
			{
				if(tafel.getBreite() != tafel.getHoehe()) {	
					aktuellspieler = "Ich";
					System.out.print("Ich: Wollen sie horizontal oder vertikal abbrechen (Eingabe H oder V): ");
				}
				else 
				{
					aktuellspieler = "PC";
				}
			}
			else 
			{
				if(aktuellspieler.equals("Ich")) 
				{
					aktuellspieler = "PC";
				}
				else 
				{
					aktuellspieler = "Ich";
					System.out.print("Ich: Wollen sie horizontal oder vertikal abbrechen (Eingabe H oder V): ");
				}
			}
			
			// falls der König am Zug ist.
			
			if(aktuellspieler.equals("Ich")) 
			{	
				vh = scr.next().charAt(0);
				
				while(vh != 'H' && vh != 'h' && vh != 'V' && vh != 'v') {
					System.out.println("(Eingabe H oder V): ");
					vh = scr.next().charAt(0);
				}
								
				if(vh == 'h' || vh =='H') 
				{
					System.out.println("Wie hoch ist das abgebrochene Stück? ");
					
					stueckgrosse = scr.nextInt();
					while(stueckgrosse >= tafel.getHoehe()) {
						System.out.print("das Stück darf nicht großer oder gleich der Hoehe!, geben Sie wieder ein: ");
						stueckgrosse = scr.nextInt();
					}
					// lösche die Stücke von Hoehe!!
					tafel.loescheZeile(stueckgrosse);
					tafel.ausgebeTafel();
				}
				else	
				{
					System.out.println("Wie breit ist das abgebrochene Stück? ");
					
					stueckgrosse = scr.nextInt();
					while(stueckgrosse >= tafel.getBreite()) {
						System.out.print("das Stück darf nicht großer oder gleich der Breite!, geben Sie wieder ein: ");
						stueckgrosse = scr.nextInt();
					}
					tafel.loescheSpalte(stueckgrosse);
					tafel.ausgebeTafel();
				}		
			}
			
			// falls der PC am Zug ist.
			else
			{
				
				// wir geben die bessere Chancen für den König, aber der PC ist nicht dumm.
				// Und ist auf die Fehler angewiesen.
				
				
				// beim Fall, dass Breite und Höhe ungleich sind, nutzt den Pc die Chance und macht es gleich 
				if(tafel.getBreite() != tafel.getHoehe()) {
					
					if(tafel.getBreite() > tafel.getHoehe()) 
					{
						stueckgrosse = tafel.getBreite() - tafel.getHoehe();
						tafel.loescheSpalte(stueckgrosse);
						System.out.println("PC hat vertikal ausgewält mit große von Stück: "+stueckgrosse);
						tafel.ausgebeTafel();
					}
					else 
					{
						stueckgrosse = tafel.getHoehe() - tafel.getBreite();
						tafel.loescheZeile(stueckgrosse);
						System.out.println("PC hat horizontal ausgewält mit große von Stück: "+stueckgrosse);
						tafel.ausgebeTafel();
					}
				}
				// beim Fall, dass Breite und Höhe ungleich sind, löscht zufällig einer Zeiele oder Spalte
				else 
				{
					Random r = new Random();
						 
					if(r.nextInt(2) == 1) {
						tafel.loescheSpalte(1);
						System.out.println("PC hat vertikal ausgewält mit große von Stück: "+1);
						tafel.ausgebeTafel();		
					}
					else 
					{
						tafel.loescheZeile(1);
						System.out.println("PC hat horizontal ausgewält mit große von Stück: "+1);
						tafel.ausgebeTafel();
					}	
				}
			}	
		} 	
		
		// wer gewinnt, jenach 	aktueller Spieler
		
		 if(aktuellspieler.equals("Ich")) {
			 System.out.println("Du hast gewonnen.");
		 }
		 else 
			 System.out.println("PC hat gewonnen.");
		

	}

	public static long rekurs(int hoehe, int breite){
		
		long erg=1;
		
		for(int i=1;i<breite;i++){
			erg+=rekurs(i,hoehe);
		}
		
		for(int i=1;i<hoehe;i++){
			erg+=rekurs(breite,i);
		}
		
		return erg;
	}
}
