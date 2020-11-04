package ecole;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		int choix=1;
		int ville1, ville2;
		String ecole;
		System.out.println("nombre de villes(entre 1 et 25) : ");
		Scanner sc = new Scanner(System.in);
		int nb = sc.nextInt();
		//Communaute com= new Communaute(nb);
		//Creation ville et ajout ville
		System.out.println("nombre ville"+nb);
		Communaute com=new Communaute(nb);

		//fin creation ville et ajout ville
		while(nb<26 && choix!=2) {
			System.out.println(" 1 : ajouter une route ");
			System.out.println(" 2 : Fin ");
			choix =sc.nextInt();
			switch (choix) {
			case 1:
				System.out.println(" Premiere ville : ");
				ville1=sc.nextInt();
				System.out.println(" Deuxieme ville : ");
				ville2=sc.nextInt();
				Communaute.addRoad(ville1,ville2);
				break:
					
			default:
				break;
			}
		}
		while(choix>=1 || choix<=2) {
			com.afficheEcoleVille();
			System.out.println(" 1 : ajouter une ecole ");
			System.out.println(" 2 : supprimer une ecole ");
			System.out.println(" 3 : fin ");
			choix =sc.nextInt();
			switch(choix) {
			case 1:
				System.out.println(" Dans quelle ville ajouter l'ecole ?  ");
				ville1=sc.nextInt();
				com.getVilles()[ville1].addEcole();
				break;
				
			case 2:
				System.out.println(" Dans quelle ville supprimer l'ecole ?  ");
				ville2=sc.nextInt();
				com.getVilles()[ville2].supprEcole();
			default:
				break;
			}
			ecole="";
			for(int i=0;i<nb;i++) {
				if(com.getVilles()[i].hasEcole==true)
					ecole=ecole+" "+i;
					
			}
			System.out.println(ecole);
		}
	}

}
