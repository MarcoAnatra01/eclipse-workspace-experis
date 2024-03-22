package dep;

/**
 * @author Davide Cavallini
 * 
 *         Dependency Injection nel costruttore: Nel metodo main(), viene
 *         istanziata la classe ReadStringApp passando un'istanza di
 *         ReadStringInterface tramite il costruttore. Questa tecnica è
 *         conosciuta come dependency injection nel costruttore, che consiste
 *         nel fornire le dipendenze di un oggetto attraverso il suo costruttore
 *         anziché crearle all'interno dell'oggetto stesso.
 * 
 *         Vantaggi nell'usarla: Decoupling (disaccoppiamento): La dependency
 *         injection riduce l'accoppiamento tra classi, consentendo loro di
 *         essere più modulari e facili da testare. In questo esempio,
 *         ReadStringApp non è direttamente vincolata all'implementazione di
 *         ReadStringInterface, ma piuttosto riceve un'istanza di essa,
 *         rendendola più flessibile e facilmente sostituibile. Testabilità:
 *         Facilita il testing delle classi. È più semplice fornire
 *         implementazioni di dipendenze di test per l'oggetto in esame, poiché
 *         possono essere sostituite più facilmente attraverso l'iniezione di
 *         dipendenze. Riusabilità: Le classi diventano più riusabili poiché
 *         sono disaccoppiate dalle loro dipendenze concrete, consentendo loro
 *         di essere utilizzate in contesti diversi senza dover modificare il
 *         codice sorgente. Manutenibilità: Il codice diventa più chiaro e
 *         manutenibile poiché le dipendenze sono esplicitamente dichiarate e
 *         gestite al di fuori delle classi stesse.
 * 
 *         Questa classe rappresenta il punto di ingresso dell'applicazione.
 *         Illustra l'uso della dependency injection nel costruttore e i suoi
 *         vantaggi.
 */

public class Main {
	public static void main(String[] args) {
		
		ReadStringInterface uno = new ReadStringTwo();
		
		ReadStringApp app = new ReadStringApp(uno);
		
		System.out.println(app.read());
	}
}
