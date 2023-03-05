/*
	Ime datoteke: 	Soba.java
	Avtor:			Gašper Petrič
    Opis:           Soba je nadrazred razredov Kopalnica in Predavalnica.
                    Lastnosti: naziv, ali je polna, barva, trenutna zasedenost in največja zasedenost.
                    Funkcije: Dodajanje oseb, odstranjevanje oseb in (pre)barvanje. 
                    Sobe ne moremo barvati, dokler ni prazna glede na število oseb.
                    Če v Sobo želimo dodati več oseb, kot jih Soba sprejme, se izpiše napaka. 
*/

// Deklariramo javni razred Soba
public class Soba {

	// Deklariramo zasebne lastnosti razreda Soba
    public String nazivSobe;
    public String barvaSobe;
    public boolean jePolna;
    public int maxKapaciteta;
    public int trenutnoSteviloOseb;
	
	// Javni konstruktor
	// Vhodni parametri: ime sobe in max kapaciteta sobe
	// Potek/opis: ustvari nov objekt tipa Soba
	// Vrne vrednost: nov objekt
	public Soba(String imeSobeInput, int maxKapacitetaSobeInput) {
		
		// Inicializiramo lastnosti objekta
		nazivSobe = imeSobeInput;
		maxKapaciteta = maxKapacitetaSobeInput;
        trenutnoSteviloOseb = 0;
		jePolna = false;
        barvaSobe = "Bela";
		
		System.out.println("Ustvarjen nov objekt tipa Soba (barva: " +barvaSobe+ ") z nazivom " + nazivSobe + " in s kapaciteto " + maxKapaciteta + ".");	
	}

    // Nov javni konstruktor, ki sprejme več parametrov (za gui primer)
    public Soba(String imeSobeInput, String barvaInput, int maxKapacitetaSobeInput) {
        //public Predavalnica(String nazivSobe, String barvaPredavalnice, boolean aliJeRezervirana, int maxKapacitetaSobe) {
		
		// Inicializiramo lastnosti objekta
		nazivSobe = imeSobeInput;
		maxKapaciteta = maxKapacitetaSobeInput;
        trenutnoSteviloOseb = 0;
		jePolna = false;
        barvaSobe = barvaInput;
		
		System.out.println("GUI: Ustvarjen nov objekt tipa Soba (barva: " +barvaSobe+ ") z nazivom " + nazivSobe + " in s kapaciteto " + maxKapaciteta + ".");	
	}

    // Funkcija za dodajanje več novih oseb v sobo
    public boolean dodajOsebe(int steviloNovihOseb) {
        System.out.println("Funkcija :: dodajam " +steviloNovihOseb+ " oseb v sobo " +nazivSobe+ ". ");

        // Izpišemo napako, če v sobi ni dovolj prostora za vse osebe
        if((steviloNovihOseb+trenutnoSteviloOseb) > maxKapaciteta){
            System.out.println("Napaka: Ni dovolj kapacitete v sobi " +nazivSobe+ ". Dodate lahko le " +(maxKapaciteta-trenutnoSteviloOseb)+ " oseb.");
			return false;
        }
        // Sicer, če je dovolj prostora, dodamo nove osebe
        else {
            // Povečamo trenutno kapaciteto
			trenutnoSteviloOseb += steviloNovihOseb;
            System.out.println("Število oseb v sobi  " +nazivSobe+ " je trenutno " +trenutnoSteviloOseb);

            // Preverimo, če je soba že polna
            if(trenutnoSteviloOseb == maxKapaciteta) {
                jePolna = true;
                System.out.println("Soba  " +nazivSobe+ " je sedaj polna.");
            }
			
			// Vrnemo true
			return true;
        }
    }

    // Funkcija za odstranjevanje ene ali več oseb iz sobe
    public boolean odstraniOsebe(int steviloOdstranjenihOseb){

        // Izpišemo napako, če odstranjujemo več oseb, kot jih je v sobi
        if((trenutnoSteviloOseb-steviloOdstranjenihOseb) < 0){
            System.out.println("Funkcija odstraniOsebe(). Napaka: Ne morete odstraniti več oseb, kot jih je trenutno v sobi.\n");
            return false;
        }
        // Sicer zmanjšamo trenutno število oseb in izpišemo njeno vrednost
        else{
            trenutnoSteviloOseb -= steviloOdstranjenihOseb;
            System.out.println("Funkcija odstraniOsebe(): Število oseb v sobi  " +nazivSobe+ " je trenutno " +trenutnoSteviloOseb+ ". \n");
            return true;
        }
    }

    // Funkcija za barvanje sobe.
    // Sobo lahko prebarvamo le, če je prazna.
    public boolean prebarvajSobo(String novaBarva){

        System.out.println("Funkcija: barvanje sobe " +nazivSobe);

        // Izpišemo napako, če sobe ne moremo prebarvati, ker ni prazna.
        if(trenutnoSteviloOseb != 0){
            System.out.println("Napaka: Vsi udeleženci morajo zapustiti sobo, predno jo lahko prebarvamo.");
            return false;
        }
        // Če v sobi ni drugih oseb, jo lahko prebarvamo na novo barvo.
        else{
            if(barvaSobe == novaBarva){
                System.out.println("Soba " +nazivSobe+ " je že barve: " +barvaSobe+ ". Vseeno smo jo na novo prebarvali.");
            }
            else{
                System.out.println("Soba " +nazivSobe+ " je sedaj prebarvana iz barve " +barvaSobe+ " na novo barvo " +novaBarva+ ".");
                barvaSobe = novaBarva;
            }
            return true;
        }
    }

    // Funkcija pridobiPodatkeSobe(), ki izpiše lastnosti sobe.
    public String pridobiPodatkeSobe(){
        String podatkiSobe = "\n Ime: " + nazivSobe+ ". \n";
        podatkiSobe += " Barva sobe: " + barvaSobe + ". \n";
        podatkiSobe += " Trenutno število oseb: " + trenutnoSteviloOseb + ". \n";
        podatkiSobe += " Max kapaciteta: " + maxKapaciteta + ". \n";
        return podatkiSobe;
    }
    
}
