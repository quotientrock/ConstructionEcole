 package cy_lj.cfg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectureFichier {
		
	public static Communaute Configure(String file) {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		ArrayList<String> ecole= new ArrayList<String>();
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
		String valeurs[];
		try {
  
			while ((ligne = bReader.readLine()) != null && ligne.startsWith("ville")) {
				valeurs=ligne.split("\\(|\\)");
					villes.add(new Ville(valeurs[1],com));
				}
			Ville villesTab[]= new Ville[villes.size()];
			villesTab= villes.toArray(villesTab);
			com = new Communaute( villesTab,villes.size());

			while ((ligne = bReader.readLine()) != null && ligne.startsWith("route")) {
				valeurs=ligne.split("\\(|\\)");
				valeurs=valeurs[1].split("\\,");
				com.addRoad(valeurs[0],valeurs[1]);
			}
			while ((ligne = bReader.readLine()) != null && ligne.startsWith("ecole")) {
				valeurs=ligne.split("(|)");
					ecole.add(valeurs[1]);
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