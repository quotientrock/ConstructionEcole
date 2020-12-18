package cy_lj.cfg;

import java.util.Scanner;
/**
 * Classe utilitaire facilitant la configuration d'une communaute à l'aide de méthode.
 */
public class Menu {

	
	/**
	 * Méthode créeant une communaute selon les instructions de l'utilisateur
	 * @param scanner un objet permettant de récupérer une entrée utilisateur
	 * @return Communaute voulu par l'utilisateur
	 */
	public static Communaute configureCommunaute(Scanner sc) {
		int nb=0;
		do{
		System.out.println("nombre de villes(entre 1 et 26) : ");
		nb = sc.nextInt();
		}while(nb<1 && nb>26);
		Communaute com= new Communaute(nb);
		com.afficheEcoleVille(nb);
		return com;
	}
	/**
	 * Méthode permettant de configurer les routes d'une communauté jusqu'a l'interruption de l'utilisateur,
	 * on peut ainsi ajouter des routes entres 2 villes de manière intéractive
	 * @param communaute qui doit être configuré
	 */
	public static void configureRoutes(Communaute com,Scanner sc) {
		int nb=com.getVilles().length;
		int choix=1;
		char ville1=' ', ville2=' ';

		while(nb<=26 && choix!=2) {
			System.out.println(" 1 : ajouter une route ");
			System.out.println(" 2 : Fin ");
			choix =sc.nextInt();
			switch (choix) {
			case 1:
				System.out.println(" Premiere ville : ");
				sc.nextLine();
				ville1=sc.next().charAt(0);
				System.out.println(" Deuxieme ville : ");
				sc.nextLine();
				ville2=sc.next().charAt(0);
				com.addRoad(ville1,ville2);
				break;
					
			default:
				break;
			}
		}
	}
	/**
	 * Méthode permettant de configurer les écoles d'une communauté,
	 * elle ajoute des écoles dans une ville choisi de manière intéractive
	 * @param communaute dont on souhaite rajouter des écoles
	 */
	public static void configureEcoles(Communaute com,Scanner sc) {
		int nb=com.getVilles().length;
		int choix=1;
		char ville1=' ', ville2=' ';
		while(choix>=1 && choix<=2) {
			com.afficheEcoleVille(nb);
			System.out.println(" 1 : ajouter une ecole ");
			System.out.println(" 2 : supprimer une ecole ");
			System.out.println(" 3 : fin ");
			choix =sc.nextInt();
			switch(choix) {
			case 1:
				System.out.println(" Dans quelle ville ajouter l'ecole ?  ");
				ville1=sc.next().charAt(0);
				com.getVilles()[com.getVilleKey(ville1)].addEcole();
				break;
				
			case 2:
				System.out.println(" Dans quelle ville supprimer l'ecole ?  ");
				ville2=sc.next().charAt(0);
				com.getVilles()[com.getVilleKey(ville2)].supprEcole();
			default:
				break;
			}
		}
	}
}
