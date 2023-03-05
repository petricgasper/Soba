/*
	Ime datoteke:   PredavalnicaTableModel.java
	Avtor:          Gašper Petrič
*/
import javax.swing.table.*;


public class PredavalnicaTableModel extends DefaultTableModel {
	
	//Konstruktor
	public PredavalnicaTableModel() {
		
		//Kliče konstruktor nadrazrede
		super();
		
		// V tabelo dodamo stolpce
		addColumn("Naziv");
		addColumn("Barva");
		addColumn("Rezervirana");
		addColumn("Kapaciteta");
		
		//Ustvarimo statičen seznam objektov
		Object[] vrstica = new Object[] {"Naziv", "Barva", "Rezervirana", "Kapaciteta"};
		
        //Dodamo vrstico v tabelo
		addRow(vrstica);
	}
	
	
	// Vhodni parametri: p - Predavalnica
	// Potek/opis: Metoda, ki doda Predavalnico ActionListenerna seznam in tabelo
	// Vrne vrednost: /
	public void addPredavalnica(Predavalnica p)  {
		
		//Ustvarimo statičen seznam objektov
		Object[] vrstica = new Object[] {p.getNaziv(), p.getBarva(), p.getRezervirana(), p.getMaxKapaciteta()};
		
		//Dodamo vrstico v tabelo
		addRow(vrstica);
	}	
}	