package calcolatrice;
import java.util.Scanner;
import java.lang.Math;

public class Calcolatrice {


	public Scanner scan = new Scanner(System.in);
	public Scanner scanNum = new Scanner(System.in);
	
	
	// conversione da binario a decimale
	
	public int binaryToInt() {
		System.out.println("\ninserisci il numero binario da convertire in decimale:");
		String binaryNum = scan.nextLine();
		
		// risultato
		int decimalNum = 0;
		
		// esponente della base 2
		int esponente = 0;
		
		int currentChar;
		
		for(int i = (binaryNum.length() - 1); i >= 0; i--) {
			// converto il singolo char binario in int
			// currentChar conterrà 0 o 1
			currentChar = Character.getNumericValue(binaryNum.charAt(i));
			
			decimalNum += currentChar * Math.pow(2, esponente);
			esponente++;
		}
		System.out.println("numero decimale corrispondente: " + decimalNum);
		return decimalNum;
	}
	
	
	// conversione da decimale a binario
	
	public void decimalToBinary() {
		System.out.println("\ninserisci il numero decimale da convertire in binario:");
		int decimal = scanNum.nextInt();
		
		StringBuilder binaryNum = new StringBuilder();
		
		if (decimal == 0) {  // caso di input 0
			
            binaryNum.append(0); 
        } else {
            while (decimal > 0) {
                int resto = decimal % 2;
                decimal = decimal / 2;
                
                binaryNum.append(resto);
            }
        }
		System.out.println("numero binario corrispondente: " + binaryNum.reverse().toString());
	}
	
	
	public static void main(String[] args) {
		Calcolatrice calcolatrice = new Calcolatrice();
		
		//calcolatrice.binaryToInt();
		
		calcolatrice.decimalToBinary();
	}

}
