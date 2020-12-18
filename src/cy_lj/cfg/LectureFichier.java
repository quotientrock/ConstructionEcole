package ecole;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectureFichier {
		
	public static Communaute Configure(String file) {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		ArrayList<Character> ecole= new ArrayList<Character>();
		boolean access=true;
		Communaute com = null;
		FileReader fReader = null;
		try {
			fReader = new FileReader(file );
		} catch (FileNotFoundException e1) {
			System.out.println("Le fichier n'a pas ete trouve");
			e1.printStackTrace();
		}
		BufferedReader bReader=new BufferedReader( fReader ) ;
		String ligne= null ;
		try {
			while ((ligne = bReader.readLine()) != null && ligne.startsWith("ville")) {
					villes.add(new Ville(ligne.charAt(7),com));
				}
			com = new Communaute((Ville[]) villes.toArray(),villes.size());
			while ((ligne = bReader.readLine()) != null && ligne.startsWith("route")) {
				com.addRoad(ligne.charAt(7),ligne.charAt(9));
			}
			while ((ligne = bReader.readLine()) != null && ligne.startsWith("ecole")) {
					ecole.add(ligne.charAt(7));
			}
			for(int i=0;i<com.getVilles().length && access==true;i++) {
				if(!ecole.contains(com.getVilles()[i].getName())){
					com.getVilles()[i].supprEcole();
					if(com.getVilles()[i].hasEcole()) {
						access=false;
					}
				}
			}
			if( access==false) {
				for(int i=0;i<com.getVilles().length;i++) {
					com.getVilles()[i].addEcole();
				}
			}

			bReader.close();
		} catch (IOException e) {
			System.out.print("Probleme de reader");
			e.printStackTrace();
	}
		return com;
	}

}
