  package cy_lj.cfg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectureFichier2 {
		
	public static Communaute Configure(String file) {
		ArrayList<Ville> villes = new ArrayList<Ville>();

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
					villes.add(new Ville(false,(ligne.substring(6,7)),com));
				}
			Ville villesTab[]= new Ville[villes.size()];
			villesTab= villes.toArray(villesTab);
			com = new Communaute( villesTab,villes.size());

			while ((ligne = bReader.readLine()) != null && ligne.startsWith("route")) {
				com.addRoad(ligne.substring(6,7),ligne.substring(8,9));
			}
			while ((ligne = bReader.readLine()) != null && ligne.startsWith("ecole")) {
					com.getVilles()[com.getVilleKey(ligne.substring(6,7))].addEcole();
			}

			bReader.close();
		} catch (IOException e) {
			System.out.print("Probleme de reader");
			e.printStackTrace();
	}
		return com;
	}

}
