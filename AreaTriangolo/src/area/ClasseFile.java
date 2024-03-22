package area;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClasseFile implements Calcolo{
	
	@Override
	public int calcoloArea() throws IOException{
		// creo il file area.txt 
		creaFile();
		
		// inserisce in area.txt base e altezza ricavati da input utente
		inserisciBaseAltezza();
		
		// linea del file area.txt
		String linea;  
		
		BufferedReader reader = new BufferedReader(new FileReader("area.txt"));
		
		// array di 2 posizioni che conterrà base e altezza presi dal file
		int [] baseAltezza = new int[2];
		
		int i = 0;
		while((linea = reader.readLine()) != null) {
			// converto la String linea in i tipo int e la inserisco nell'array baseAltezza
			baseAltezza[i] = Integer.parseInt(linea);
			i++;
		}
		return (baseAltezza[0] * baseAltezza[1]) / 2;
	}
	
	

	public static void creaFile() {		
		File fileArea = new File("area.txt");
		
		if (fileArea.exists()) {
			System.out.println("il file area.txt già esiste");
		}else {
			System.out.println("\nil file area.text non è presente");
			
			System.out.println("\ncreazione del file area.txt in corso...");
			try {			
				boolean creato = fileArea.createNewFile();
				
				if(creato == true) {
					System.out.println("\nfile area.txt creato");
				}else {
					System.out.println("\ncreazione file fallita");
				}
			} catch (IOException e) {
				System.out.println("\nErrore nella creazione del file area.txt");
			}
		}
	}
	
	
	public static void inserisciBaseAltezza() {
		int base = 0;
		int altezza = 0;
		boolean datiValidi = true;
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("\ninserisci la base:");
			base = scan.nextInt();
			
			System.out.println("\ninserisci l'altezza:");
			altezza = scan.nextInt();			
		} catch (InputMismatchException e) {
			System.out.println("errore durante l'inserimento dati: inserire solo numeri interi");
			datiValidi = false;
		}
		
		if (datiValidi) {
			try {
				// il true in FileWriter() indica la modalità append, cioè il nuovo testo viene inserito alla fine del file
				BufferedWriter w = new BufferedWriter(new FileWriter("area.txt", true));
				
				w.write("\r\nbase = " + base + "\r\naltezza = " + altezza);
				
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nbase e altezza aggiunti al file area.txt");
	}
}
