
public class SchokoTafel {
	
	private int breite;
	private int hoehe;	

	
	// Ausgabe der Tafel
	public void ausgebeTafel() {
		
		System.out.println();
		
		for(int i = 0; i < hoehe ; i++) {
			for (int j= 0; j < breite; j++){
				if(i == 0 && j == 0)
					System.out.print('X'+" ");
				else
					System.out.print('O'+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Löschen von der Höhe
	public void loescheZeile(int stueckgrosse) {
		
		this.hoehe = this.hoehe - stueckgrosse;
	}
	
	// Löschen von der Breite
	public void loescheSpalte(int stueckgrosse) {
		
		this.breite = this.breite - stueckgrosse;
	}
	

	// Setter and Getter
	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		
		this.breite = breite;
	}
	
	public void setHoehe(int hoehe) {
				
		this.hoehe = hoehe;
	}

	public int getHoehe() {
		
		return hoehe;
	}
	
}
