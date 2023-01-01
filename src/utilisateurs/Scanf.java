package utilisateurs;
import java.util.Scanner;
public class Scanf {
	
	/*Classe Scanf
	 * Classe qui gère la lecture des données transmise par l'utilisateur de l'interface
	 * */
	
	public static Scanner scan;
	
	public static void openScanner() {
		scan = new Scanner(System.in);
	}
	
	public static void closeScanner() {
		scan.close();
	}
	
	public static String getInput() {
		 return scan.next();
	}
	
	public static int getInputInt() {
		 return scan.nextInt();
	}
}