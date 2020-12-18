package cy_lj.cfg;

import java.util.Scanner;
/**
 * Classe utilitaire facilitant la configuration d'une communaute à l'aide de méthode.
 * Cette classe regroupe les méthodes qui fournissent les options de configuration à l'utilisateur.
 */
public class Menu {

	/**
	 * Méthode qui va permettre de proposer de manière intéractive à l'utilisateur des commandes de
	 * résolution du problème de configuration d'ecole
	 * @param scanner permettant de recuperer le choix de l'utilisateur
	 */
	public static void menuUtilisateur(Scanner sc) {
		System.out.println("Démarrage du menu pour la résolution du problème des écoles !");


		int reponseUser;
		do {
			System.out.println("Donnez votre choix:");
			System.out.println("1) Résoudre manuellement");
			System.out.println("2) Résoudre automatiquement");
			System.out.println("3) Sauvegarder");
			System.out.println("4) Fin");
			reponseUser=sc.nextInt();
			switch(reponseUser) {
			case 1: 
				System.out.println("Vous avez choisi l'option 1");
				Communaute com=configureCommunaute(sc);
				configureRoutes(com,sc);
				configureEcoles(com,sc);
				break;
			case 2:
				System.out.println("Vous avez choisi l'option 2");
				break;
			case 3:
				System.out.println("Vous avez choisi l'option 3");
				break;
			case 4:
				System.out.println("Vous avez terminer le programme !");
			default:
				break;
			}
		}while(reponseUser!=4);
	}
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
		com.afficheEcoleVille();
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
		String ville1="", ville2="";

		while(nb<=26 && choix!=2) {
			System.out.println(" 1 : ajouter une route ");
			System.out.println(" 2 : Fin ");
			choix =sc.nextInt();
			switch (choix) {
			case 1:
				System.out.println(" Premiere ville : ");
				sc.nextLine();
				ville1=sc.nextLine();
				System.out.println(" Deuxieme ville : ");
				sc.nextLine();
				ville2=sc.nextLine();
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
		int choix=1;
		String ville1="", ville2="";
		while(choix>=1 && choix<=2) {
			com.afficheEcoleVille();
			System.out.println(" 1 : ajouter une ecole ");
			System.out.println(" 2 : supprimer une ecole ");
			System.out.println(" 3 : fin ");
			choix =sc.nextInt();
			switch(choix) {
			case 1:
				System.out.println(" Dans quelle ville ajouter l'ecole ?  ");
				ville1=sc.nextLine();
				com.getVilles()[com.getVilleKey(ville1)].addEcole();
				break;
				
			case 2:
				System.out.println(" Dans quelle ville supprimer l'ecole ?  ");
				ville2=sc.nextLine();
				com.getVilles()[com.getVilleKey(ville2)].supprEcole();
			default:
				break;
			}
		}
	}
	
	
	public static Communaute resolutionAutomatique(String fileName) {
		Communaute com =LectureFichier.Configure(fileName);
		AlgorithmeEcole.algoEcole(com);
		com.afficheEcoleVille();
		
		return com;
	}
}
