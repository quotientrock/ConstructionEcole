package cy_lj.cfg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Classe utilitaire facilitant la configuration d'une communaute � l'aide de m�thode.
 * Cette classe regroupe les m�thodes qui fournissent les options de configuration � l'utilisateur.
 */
public class Menu {

	/**
	 * M�thode qui va permettre de proposer de mani�re int�ractive � l'utilisateur des commandes de
	 * r�solution du probl�me de configuration d'ecole
	 * @param scanner permettant de recuperer le choix de l'utilisateur
	 * @param chemin du fichier contenant la communaute
	 */
	public static void menuUtilisateur(Scanner sc,String fileName) {
		System.out.println("D�marrage du menu pour la r�solution du probl�me des �coles !");

		Communaute com=configureCommunaute(fileName);
		// try
		int reponseUser;
		do {
			System.out.println("Quel option voulez vous choisir ?:");
			System.out.println("1) R�soudre manuellement");
			System.out.println("2) R�soudre automatiquement");
			System.out.println("3) Sauvegarder");
			System.out.println("4) Fin");
			reponseUser=sc.nextInt();
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
			default:
				System.out.println("Vous avez choisi l'option :"+reponseUser+"!");
				System.out.println("Aucune option trouv� !");
				System.out.println("Veuillez reit�rez votre choix !");
				break;
			}
		}while(reponseUser!=4);
	}
	/**
	 * M�thode cr�eant une communaute selon les instructions de l'utilisateur
	 * @param fileName chemin du fichier contenant la communaute
	 * @return Communaute voulu par l'utilisateur
	 */
	public static Communaute configureCommunaute(String fileName) {
		Communaute com= LectureFichier2.Configure(fileName);
		com.afficheEcoleVille();
		return com;
	}
	/**
	 * M�thode permettant de configurer les routes d'une communaut� jusqu'a l'interruption de l'utilisateur,
	 * on peut ainsi ajouter des routes entres 2 villes de mani�re int�ractive
	 * @param communaute qui doit �tre configur�
	 * @param sc scanner pour r�cuper une entr�e utilisateur
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
	 * M�thode permettant de configurer les �coles d'une communaut�,
	 * elle ajoute des �coles dans une ville choisi de mani�re int�ractive
	 * @param com dont on souhaite rajouter des �coles
	 * @param sc scanner pour r�cuper une entr�e utilisateur
	 */
	private static void resolutionManuelle(Communaute com,Scanner sc) {
		int choix=1;
		String ville1="", ville2="";
		while(choix>=1 && choix<=2) {
			com.afficheVille();
			com.afficheEcoleVille();
			System.out.println(" 1 : ajouter une ecole ");
			System.out.println(" 2 : supprimer une ecole ");
			System.out.println(" 3 : fin ");
			choix =sc.nextInt();
			sc.nextLine();
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
				System.out.println("Vous avez choisi une entrée incorrecte !");
				break;
			}
		}
	}
	
	/**
	 * M�thode permet de donner une solution optimale du probl�me des ecoles.
	 * 
	 * @param com la communaute ou il faut trouver une solution
	 */
	private static void resolutionAutomatique(Communaute com) {
		Communaute solution=AlgorithmeEcole.algo2Sujet(com, 10000000);
		solution.afficheEcoleVille();
	}
	
	/**
	 * M�thode permet de sauvegarder la solution dans un fichier.
	 * 
	 * @param com la communaute de la solution
	 * @param sc scanner pour recuperer l'emplacement du fichier 
	 */
	private static void sauvegarde(Communaute com, Scanner sc) {
		System.out.println("Emplacement du fichier ? ");
		try {
			BufferedWriter bW= new BufferedWriter(new FileWriter(sc.nextLine()));
			for(int i=0;i<com.getVilles().length;i++) {
				bW.write("ville(" +com.getVilles()[i].getName()+").\n");
			}
			for(int i=0;i<com.getVilles().length;i++) {
				for( int j=0+i;j<com.getVilles().length;i++) {
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