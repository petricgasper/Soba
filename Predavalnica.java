/*
	Ime datoteke: 	Predavalnica.java
	Avtor:			Gašper Petrič
    Opis:           Predavalnica je podrazred razreda Soba.
                    Posebna lastnost: jeRezervirana. Predavalnico lahko rezerviramo, če le-ta ni že rezervirana. 
                    Lahko jo tudi odrezerviramo. 
                    Vrača tudi poseben niz/izpis o vrednostih nekega objekta.
*/

// Deklariramo javni razred Predavalnica, ki razširja razred Soba in implementira vmesnik PredavalnicaVmesnik
public class Predavalnica extends Soba implements PredavalnicaVmesnik {
    private boolean jeRezervirana;

    // Javni konstruktor
	// Vhodni parametri: nazivSobe in maxKapacitetaSobe
	// Potek/opis: ustvari nov objekt tipa Predavalnica
	// Vrne vrednost: nov objekt
	public Predavalnica(String nazivSobe, int maxKapacitetaSobe) {
		
		// Pokličemo konstruktor nadrazreda - ustvarimo prazno sobo
		super(nazivSobe, maxKapacitetaSobe);

        // Določimo podlastnosti Predavalnice
        jeRezervirana = false;
	}

    // Nov javni konstruktor, ki sprejme več parametrov (za gui primer)
    public Predavalnica(String nazivSobe, String barvaPredavalnice, boolean aliJeRezervirana, int maxKapacitetaSobe) {
		
		// Pokličemo konstruktor nadrazreda - ustvarimo prazno sobo
		super(nazivSobe, barvaPredavalnice, maxKapacitetaSobe);

        // Določimo podlastnosti Predavalnice
        jeRezervirana = aliJeRezervirana;
	}



    // Funkcija rezerviraj(), ki spremeni vrednost spremenljivke jeRezervirana in ne vrača ničesar
    public void rezerviraj(){
        // Če je predavalnica že rezervirana, je ne moremo rezervirati.
        if(jeRezervirana){
            // System.out.println("Funkcija Predavalnica.rezerviraj(). Napaka: predavalnica " +imePredavalnice+ " je že rezervirana.");    
            System.out.println("Funkcija Predavalnica.rezerviraj(). Napaka: predavalnica " +nazivSobe+ " je že rezervirana.");    
        }
        else{
            jeRezervirana = true;
            // System.out.println("Funkcija Predavalnica.rezerviraj(): Predavalnica " +imePredavalnice + " je sedaj rezervirana.");
            System.out.println("Funkcija Predavalnica.rezerviraj(): Predavalnica " +nazivSobe + " je sedaj rezervirana.");
        }
    }

    // Funkcija odRezerviraj(), ki spremeni vrednost spremenljivke jeRezervirana in ne vrača ničesar
    public void odRezerviraj(){
        if(!jeRezervirana){
            // System.out.println("Funkcija Predavalnica.odRezerviraj(): Napaka. Predavalnica " +imePredavalnice + " ni bila rezervirana.");
            System.out.println("Funkcija Predavalnica.odRezerviraj(): Napaka. Predavalnica " +nazivSobe + " ni bila rezervirana.");
        }
        else{
            // System.out.println("Funkcija Predavalnica.odRezerviraj(): Predavalnica " +imePredavalnice + " je sedaj uspešno odrezervirana.");
            System.out.println("Funkcija Predavalnica.odRezerviraj(): Predavalnica " +nazivSobe + " je sedaj uspešno odrezervirana.");
            jeRezervirana = false;
        }
    }

    // Funkcija pridobiPodatkeSobe(), ki izpiše lastnosti sobe.
    public String pridobiPodatkePredavalnice(){
        String podatkiSobe = "\n Ime: " + nazivSobe+ ". \n";
        podatkiSobe += " Barva sobe: " + barvaSobe + ". \n";
        podatkiSobe += " Trenutno število oseb: " + trenutnoSteviloOseb + ". \n";
        podatkiSobe += " Max kapaciteta: " + maxKapaciteta + ". \n";
        podatkiSobe += " Je rezervirana: " + jeRezervirana + ". \n";
        return podatkiSobe;
    }

    // Funkcija, ki vrne naziv predavalnice
    public String getNaziv(){
        return nazivSobe;
    }

    // Funkcija, ki vrne barvo predavalnice
    public String getBarva(){
        return barvaSobe;
    }

    // Funkcija, ki vrne status rezervacije
    public boolean getRezervirana(){
        return jeRezervirana;
    }

    // Funkcija, ki vrne max kapaciteto predavalnice
    public int getMaxKapaciteta(){
        return maxKapaciteta;
    }

}