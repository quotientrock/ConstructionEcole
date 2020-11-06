package ecole;
import java.util.Scanner;


public class ConfigureEcole {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Communaute com=Menu.configureCommunaute(sc);
		Menu.configureRoutes(com,sc);
		Menu.configureEcoles(com,sc);
		
		sc.close();
		
	}
	


}
