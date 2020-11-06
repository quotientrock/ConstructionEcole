package ecole;

import java.util.Scanner;

public class Menu {

	
	
	public static Communaute configureCommunaute() {

		System.out.println("nombre de villes(entre 1 et 25) : ");
		Scanner sc = new Scanner(System.in);
		int nb = sc.nextInt();
		Communaute com= new Communaute(nb);
		com.afficheEcoleVille(nb);
		sc.close();
		return com;
	}
	
	public static void configureRoutes(Communaute com) {
		int nb=com.getVilles().length;
		int choix=1;
		char ville1=' ', ville2=' ';
		Scanner sc = new Scanner(System.in);
		while(nb<26 && choix!=2) {
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
		sc.close();
	}
	public static void configureEcoles(Communaute com,int nb) {
		int nb=com.getVilles().length;
		Scanner sc = new Scanner(System.in);
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
		sc.close();
	}
}
