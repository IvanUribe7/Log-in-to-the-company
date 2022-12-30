package utilisateurs;
import java.util.Scanner;
public class Scanf {
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
}