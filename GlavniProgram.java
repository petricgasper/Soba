
/*
	Ime datoteke: GlavniProgram.java
	Avtor:			Gašper Petrič
	Vhodni podatki: /
	Opis: 			Aplikacija z grafičnim uporabniškim vmesnikom za delo s predavalnicami
	Izhodni podatki:Okno grafičnega uporabniškega vmesnika
*/

// Uvozimo paket za delo z GUI
import javax.swing.*;

// Uvozimo paket za delo z dogodki
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

// Deklariramo javni razred
public class GlavniProgram extends JFrame implements ActionListener {

	//Deklariramo zasebna lastnosti
	private JPanel povrsina;
	private JButton dodajJButton;
	private JTextField nazivPredavalnice, zasedenostPredavalnice, barvaPredavalnice, maxKapacitetaPredavalnice, trenutnaKapacitetaPredavalnice;
	private JTable tabela;
	private PredavalnicaTableModel modelTabele;

	// Deklariramo javno statično metodo, ki se izvede ob zagonu programa
	// Vhodni parametri: vhodni parametri iz konzole
	// Potek/opis: ustvari novo okno
	// Vrne vrednost: /
	public static void main(String[] args) {
		GlavniProgram p = new GlavniProgram("GUI Predavalnica");
	}

	// Javni konstruktor
	// Vhodni podatki: n - naslov okna
	// Potek/opis: vrne objekt tipa Predavalnica	
	public GlavniProgram(String n)  {
		
		// Kličemo konstruktor razreda
		super(n);
		
		// Inicializiramo JPanel povrsina
		povrsina = new JPanel();

		// Inicializiramo JButton dodajJButton
		dodajJButton = new JButton ("Dodaj predavalnico");		
		
		// Inicializiramo PredavalnicaTableModel in JTable
		modelTabele = new PredavalnicaTableModel();
		tabela = new JTable(modelTabele);
		
		// Površino dodamo na Mizo
		getContentPane().add(povrsina);
		
		//Gumbu za dodajanje dodamo action listener
		dodajJButton.addActionListener(this);
		
		// Naziv predavalnice: dodamo labelo in vnostno polje
		JLabel label_imePredavalnice = new JLabel("Ime Predavalnice:");
		label_imePredavalnice.setLabelFor(nazivPredavalnice);
		nazivPredavalnice = new JTextField(16);
		povrsina.add(label_imePredavalnice);
		povrsina.add(nazivPredavalnice);

		// Zasedenost predavalnice: dodamo labelo in vnosno polje
		zasedenostPredavalnice = new JTextField(8);
		povrsina.add(new JLabel("Rezervirana:"));
		povrsina.add(zasedenostPredavalnice);
		
		// Barva Predavalnice: dodamo labelo in vnosno polje
		JLabel label_barva = new JLabel("Barva:");
		barvaPredavalnice = new JTextField(8);
		povrsina.add(label_barva);
		povrsina.add(barvaPredavalnice);

		// Kapaciteta predavalnice: dodamo labeli in vnosni polji za max in trenutno kapaciteto predavalnice
		JLabel label_maxKapaciteta = new JLabel("Max Kapaciteta:");
		maxKapacitetaPredavalnice = new JTextField(3);
		povrsina.add(label_maxKapaciteta);
		povrsina.add(maxKapacitetaPredavalnice);

		// Dodamo Gumb in Tabelo na Površino
		povrsina.add (dodajJButton);
		povrsina.add(tabela);
		
		// Pokažemo okno
		setVisible(true);
		
		// Nastavimo velikost
		setSize (1000, 600);
		
		// Nastavimo obnašanje križca (x) - da konča aplikacijo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	

	// Metoda, ki jo predpisuje vmesnika ActionListener
	// Vhodni podatki: dogodek
	// Potek/opis: doda Predavalnico v tabelo
	// Vrne vrednost: /
	public void actionPerformed(ActionEvent ae) {
		
		// Izpis v konzolo
		System.out.println("Dodajam predavalnico...");
		System.out.println("Naziv predavalnice je " + nazivPredavalnice.getText());
		System.out.println("Maksimalna kapaciteta je " + zasedenostPredavalnice.getText());
		
		// Ustvarimo lokalno spremeljivko guiPredavalnica
		Predavalnica guiPredavalnica = new Predavalnica(nazivPredavalnice.getText(), barvaPredavalnice.getText(), Boolean.parseBoolean(zasedenostPredavalnice.getText()), Integer.parseInt(maxKapacitetaPredavalnice.getText()));

		// Dodamo objekt v seznam
		modelTabele.addPredavalnica(guiPredavalnica);
	}

}

