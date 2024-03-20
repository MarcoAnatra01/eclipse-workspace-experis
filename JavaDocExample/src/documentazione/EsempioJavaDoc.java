package documentazione;

/**
 * @version 1.3
 */
public class EsempioJavaDoc {

	/**
	 * @throws Exception eccezione generica
	 * @hidden nasconde il metodo
	 */
	public static void esempio() throws Exception{
		
	}
	
	
	/**
	 * 
	 * @param nome stringa
	 * @param eta intero
	 * @param stipendio double
	 * @return ritorna un intero
	 * @since 1.1
	 * <p><strong>paragrafo di prova</strong></p>
	 */
	public static int prova(String nome, int eta, double stipendio) {
		/**
		 * @opzione variabile char 
		 */
		char opzione = 'a';
		return 0;
	}
	
	
	/** 
	 * @param args è l'argomento del metodo main 
	 */
	public static void main(String[] args) {
		
	}
}
