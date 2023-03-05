/*
	Ime datoteke: 	PredavalnicaVmesnik.java
	Avtor:			Gašper Petrič
*/

//Deklariramo javni vmesnik
public interface PredavalnicaVmesnik {
	
	// Deklariramo javno metodo, rezervira predavalnico
	// Vhodni parametri: 
	// Potek/opis: Določenemu objektu Predavalnica spremeni vrednost jeRezervirana na true.
	// Vrne vrednost: /
	public void rezerviraj();

    // Deklariramo javno metodo, rezervira predavalnico
	// Vhodni parametri: /
	// Potek/opis: Določenemu objektu Predavalnica spremeni vrednost jeRezervirana na false.
	// Vrne vrednost: /
    public void odRezerviraj();

    // Deklariramo javno metodo, rezervira predavalnico
	// Vhodni parametri: /
	// Potek/opis: Določenemu objektu Predavalnica spremeni vrednost jeRezervirana na true.
	// Vrne vrednost: spremenljivko tipa String v kateri so izpisane lastnosti predavalnice.
    public String pridobiPodatkePredavalnice();
	
}	