package ordinamento;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Bubblesort {

	public static LinkedList<Integer> numbers = new LinkedList<>();
	public static Scanner scan = new Scanner(System.in);
	
	public Bubblesort() {
		numbers.add(1);
		numbers.add(2);
		numbers.add(10);
		numbers.add(15);
		numbers.add(27);
		numbers.add(31);
		numbers.add(37);
	}
	
	// metodo per la ricerca binaria all'interno di una lista
	// deve ritornare l'indice del numero inserito dall'utente se presente, altrimenti ritorna -1
	public static int binarySearch(LinkedList<Integer> lista) {
		System.out.println("\n" + lista);
		System.out.println("\ninserisci il numero della lista di cui vuoi conoscere l'indice:");
		int numToFind = scan.nextInt();
		
		int left = 0;
		int right = lista.size()-1;
				
		for(int i = left; i <= right; i++) {
			// calcolo l'indice del punto medio dell'intervallo di ricerca
			// punto in cui si effettua il confronto per vedere se l'elemento cercato è presente
			int midpointIndex = (left + right) / 2;
			
			
			if(lista.get(midpointIndex) == numToFind) {
				// se il numero da cercare è uguale al numero situato sull'indice medio, l'indice da ritornare è l'indice medio
				System.out.println("\nindice del numero " + numToFind + " : " + midpointIndex);
				return midpointIndex;
			}
			
			// se l'elemento nel punto medio è maggiore del numero cercato
			// si aggiorna l'indice destro right in modo che l'intervallo di ricerca sia nella metà sinistra dell'array
			if (lista.get(midpointIndex) > numToFind) {
				right = midpointIndex - 1;
			}
			
			
			// se l'elemento nel punto medio è minore del numero cercato
			// l'elemento da cercare sarà nella metà destra dell'array 
			// si aggiorna l'indice sinistro left in modo che l'intervallo di ricerca sia nella metà detra dell'array
			if (lista.get(midpointIndex) < numToFind) {
				left = midpointIndex + 1;
			}
		}
		// se l'elemento non è presente nell'array
		System.out.println("\nil numero indicato non è presente");
		return -1;
	}
	
	
	public static void main(String[] args) {
		Bubblesort ricercaBinaria = new Bubblesort();
		
		ricercaBinaria.binarySearch(numbers);
	}
}
