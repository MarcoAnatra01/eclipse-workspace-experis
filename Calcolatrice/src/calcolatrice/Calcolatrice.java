package calcolatrice;
import java.util.Scanner;
import java.lang.Math;

public class Calcolatrice {
	// conversione da binario a decimale
	
	public String binaryNum = "00000000";

	public int decimalNum = 0;

	public Scanner scan = new Scanner(System.in);
	
	// esponente della base 2
	public int esponente = 0;
	
	public int currentChar;
	
	public int binaryToInt() {
		System.out.println("inserisci il byte da convertire in decimale:");
		binaryNum = scan.nextLine();
		
		for(int i = (binaryNum.length() - 1); i >= 0; i--) {
			// converto il char in int
			// currentChar conterrà 0 o 1
			currentChar = Character.getNumericValue(binaryNum.charAt(i));
			
			decimalNum += currentChar * Math.pow(2, esponente);
			esponente++;
		}
		System.out.println("numero decimale corrispondente: " + decimalNum);
		return decimalNum;
	}
	
	public static void main(String[] args) {
		Calcolatrice calcolatrice = new Calcolatrice();
		calcolatrice.binaryToInt();
	}

}
