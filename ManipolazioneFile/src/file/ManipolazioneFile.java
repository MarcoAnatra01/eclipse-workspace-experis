package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipolazioneFile {
	
	public static void creaFile() {		
		File fileDiTesto = new File("testo.txt");
		
		try {			
			boolean riuscito = fileDiTesto.createNewFile();
			
			if(riuscito == true) {
				System.out.println("file testo.txt creato");
			}else {
				System.out.println("creazione file fallita");
			}
		} catch (IOException e) {
			System.out.println("Errore nella creazione del file");
		}
	}
	
	
	public static void verificaEsistenzaFile() {
		File f = new File("testo.txt");
		
		if (f.exists()) {
			System.out.println("il file esiste");
		}else {
			System.out.println("file non presente");
		}
	}
	
	
	public static void leggiFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("testo.txt"));
			
			String linea;
			
			while((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			
			reader.close();
		} catch (IOException e) {
			System.out.println("errore di lettura del file");
		}
	}
	
	
	public static void inserisciTesto() {
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("testo.txt"));
			
			w.write("\r\nNuovo testo aggiunto ora.");
			
			w.close();
			
			System.out.println("\nnuovo testo aggiunto al file testo.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void eliminaFile() {
		File f = new File("testo.txt");
		
		boolean risposta = f.delete();
		
		if(risposta == true) {
			System.out.println("file testo.txt eliminato con successo");
		}else {
			System.out.println("errore durante l'eliminazione del file");
		}
	}
	

	public static void main(String[] args) {
		creaFile();
		verificaEsistenzaFile();
		leggiFile();
		inserisciTesto();
		//eliminaFile();
	}

}
