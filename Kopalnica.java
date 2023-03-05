/*
	Ime datoteke: 	Kopalnica.java
	Avtor:			Gašper Petrič
    Opis:           Razred Kopalnica razširja razred Soba z dodatnimi funkcijami in lastnostmi:
                    Kopalnica je lahko zaklenjena. Odklepamo in zaklepamo jo lahko s funkcijami. 
                    V kopalnico lahko vstopimo le, če je odklenjena in v njej ni nikogar, sicer se izpiše napaka. 
*/

// Deklariramo javni razred Kopalnica, ki razširja razred Soba
public class Kopalnica extends Soba {
    private boolean jeZaklenjena;

    // Javni konstruktor
	public Kopalnica(String nazivSobe) {
		// Pokličemo konstruktor nadrazreda - ustvarimo prazno kopalnico (vedno kapaciteta 1)
		super(nazivSobe, 1);
        jeZaklenjena = false;
	}

    // Funkcija: v kopalnico lahko vstopimo le, če ni zaklenjena
    public void vstopi_v_kopalnico(){
        System.out.print("Funkcija Kopalnica.vstopi_v_kopalnico() --> ");

        if(jeZaklenjena){
            System.out.println("Napaka: kopalnica " +nazivSobe+ " je zaklenjena.");    
        }
        else{
            if(trenutnoSteviloOseb == maxKapaciteta){
                System.out.println("Napaka: kopalnica " +nazivSobe+ " je že polna/zasedena.");    
            }
            else{
                trenutnoSteviloOseb += 1;
                System.out.println("Vstopili ste v " +nazivSobe + ". Kopalnica je sedaj zaklenjena.");
            }
        }
    }

    // Funkcija odRezerviraj(), ki spremeni vrednost spremenljivke jeRezervirana in ne vrača ničesar
    public void izstopi_iz_kopalnice(){
        System.out.print("Funkcija Kopalnica.izstopi_iz_kopalnice() --> ");

        if(jeZaklenjena){
            System.out.println("Napaka. Pred izstopom odklenite vrata!");
        }
        else{
            trenutnoSteviloOseb -= 1;
            System.out.println("Kopalnica " +nazivSobe + " je sedaj prosta.");
        }
    }

    public void zakleniVrata(){
        System.out.print("Funkcija Kopalnica.zakleniVrata() --> ");

        if(jeZaklenjena){
            System.out.println("Napaka: Kopalnica " +nazivSobe + " je že zaklenjena.");    
        }
        else {
            jeZaklenjena = true;
            System.out.println("Kopalnica " +nazivSobe + " je sedaj zaklenjena.");
        }
    }

    public void odkleniVrata(){
        System.out.print("Funkcija Kopalnica.odkleniVrata() --> ");

        if(jeZaklenjena){
            jeZaklenjena = false;
            System.out.println("Kopalnica " +nazivSobe + " je sedaj odklenjena.");
        }
        else{
            System.out.println("Napaka: Kopalnica " +nazivSobe + " je že odklenjena.");    
        }
    }

    // Funkcija pridobiPodatkeSobe(), ki izpiše lastnosti sobe.
    public String pridobiPodatkeKopalnice(){
        String podatkiKopalnica = "\n Ime: " + nazivSobe+ ". \n";
        podatkiKopalnica += " Barva sobe: " + barvaSobe + ". \n";
        podatkiKopalnica += " Trenutno število oseb: " + trenutnoSteviloOseb + ". \n";
        podatkiKopalnica += " Max kapaciteta: " + maxKapaciteta + ". \n";
        podatkiKopalnica += " Je zaklenjena: " + jeZaklenjena + ". \n";
        return podatkiKopalnica;
    }

}