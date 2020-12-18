package cy_lj.cfg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	 * @param chemin du fichier contenant la communaute
	 */
	public static void menuUtilisateur(Scanner sc,String fileName) {
		System.out.println("Démarrage du menu pour la résolution du problème des écoles !");

		Communaute com=configureCommunaute(fileName);
		//com.afficheEcoleVille();
		//com.afficheVille();
		// try
		int reponseUser;
		do {
			System.out.println("Quel option voulez vous choisir ?:");
			System.out.println("1) Résoudre manuellement");
			System.out.println("2) Résoudre automatiquement");
			System.out.println("3) Sauvegarder");
			System.out.println("4) Fin");
			try {
			reponseUser=sc.nextInt();
			sc.nextLine();
			}catch(Exception e) {
				System.out.println("Erreur entrée");
				reponseUser=0;
				sc.next();
			}
			switch(reponseUser) {
			case 1: 
				System.out.println("Vous avez choisi l'option 1");
				resolutionManuelle(com,sc);
				break;
			case 2:
				System.out.println("Vous avez choisi l'option 2");
				resolutionAutomatique(com);
				break;
			case 3:
				System.out.println("Vous avez choisi l'option 3");
				sauvegarde(com,sc);
				break;
			case 4:
				System.out.println("Vous avez terminer le programme !");
				break;
			default:
				System.out.println("Vous avez choisi l'option :"+reponseUser+"!");
				System.out.println("Aucune option trouvé !");
				System.out.println("Veuillez reitérez votre choix !");
				break;
			}
		}while(reponseUser!=4);
	}
	/**
	 * Méthode créeant une communaute selon les instructions de l'utilisateur
	 * @param fileName chemin du fichier contenant la communaute
	 * @return Communaute voulu par l'utilisateur
	 */
	public static Communaute configureCommunaute(String fileName) {
		Communaute com= LectureFichier.Configure(fileName);
		com.afficheEcoleVille();
		return com;
	}
	/**
	 * Méthode permettant de configurer les routes d'une communauté jusqu'a l'interruption de l'utilisateur,
	 * on peut ainsi ajouter des routes entres 2 villes de manière intéractive
	 * @param communaute qui doit être configuré
	 * @param sc scanner pour récuper une entrée utilisateur
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
	 * @param com dont on souhaite rajouter des écoles
	 * @param sc scanner pour récuper une entrée utilisateur
	 */
	private static void resolutionManuelle(Communaute com,Scanner sc) {
		int choix=1;
		String ville1="", ville2="";
		while(choix>=1 && choix<=2) {
			System.out.println(" 1 : ajouter une ecole ");
			System.out.println(" 2 : supprimer une ecole ");
			System.out.println(" 3 : fin ");
			try {
			choix =sc.nextInt();
			sc.nextLine();
			}catch(Exception e) {
				System.out.println("Erreur entrée");
				choix=0;
				sc.next();
			}
			
			switch(choix) {
			case 1:
				System.out.println(" Dans quelle ville ajouter l'ecole ?  ");
				com.afficheVille();
				com.afficheEcoleVille();
				try {
					sc.next();
					ville1=sc.nextLine();
				}catch(Exception e) {
					System.out.println("Erreur entrée");
					break;
				}
				try {
				com.getVilles()[com.getVilleKey(ville1)].addEcole();
				}catch(Exception e) {
					System.out.println("Problème d'entrée");
				}
				break;
				
			case 2:
				System.out.println(" Dans quelle ville supprimer l'ecole ?  ");
				ville2=sc.nextLine();
				com.getVilles()[com.getVilleKey(ville2)].supprEcole();
				break;
			default:
				System.out.println("Vous avez choisi une entrée incorrecte !");
				break;
			}
		}
	}
	
	/**
	 * Méthode permet de donner une solution optimale du problème des ecoles.
	 * 
	 * @param com la communaute ou il faut trouver une solution
	 */
	private static void resolutionAutomatique(Communaute com) {
		Communaute solution=AlgorithmeEcole.algo2Sujet(com, 1);
		solution.afficheEcoleVille();
	}
	
	/**
	 * Méthode permet de sauvegarder la solution dans un fichier.
	 * 
	 * @param com la communaute de la solution
	 * @param sc scanner pour recuperer l'emplacement du fichier 
	 */
	private static void sauvegarde(Communaute com, Scanner sc) {
		System.out.println("Emplacement du fichier ? ");
		sc.nextLine();
		try {
			BufferedWriter bW= new BufferedWriter(new FileWriter(sc.nextLine()));
			for(int i=0;i<com.getVilles().length;i++) {
				bW.write("ville(" +com.getVilles()[i].getName()+").\n");
			}
			for(int i=0;i<com.getVilles().length;i++) {
				for( int j=0+i;j<com.getVilles().length;j++) {
					if (com.estVoisins(i, j)) {
						bW.write("route(" +com.getVilles()[i].getName()+","+com.getVilles()[j].getName()+").\n");
					}
				}
			}
			for(int i=0;i<com.getVilles().length;i++) {
				if(com.getVilles()[i].hasEcole()) {
					bW.write("ecole(" +com.getVilles()[i].getName()+").\n");
				}	
			}
			bW.close();
		} catch (IOException e) {
			System.out.println("Probleme lors de l'ecriture");
			e.printStackTrace();
		}
	}
}