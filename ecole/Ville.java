package ecole;

import java.util.ArrayList;

public class Ville {
	
	public boolean ecole;
	public ArrayList<Ville> routes;
	
	
	public Ville(boolean ecole) {
		ecole=this.ecole;
		routes= new ArrayList<Ville>();
	} 
	
	public Ville() {
		ecole=false;
		routes= new ArrayList<Ville>();
	}
	/**Ajoute une ecole a la ville*/
	public void addEcole() {
		if (ecole==false)
		ecole=true;
		else
			System.out.println(" Deja une ecole dans la ville");
	}
	/**Supprime l'ecole de la ville*/
	public void supprEcole() {
		if (ecole==true)
			if(routes.contains(new Ville(true)))
				ecole=false;
		else 
			System.out.println(" Aucune ecole dans la ville");
	}
	
	@Override
	public boolean equals(Object object) {
		boolean result = false;
			Ville ville = (Ville) object;
			if (this.ecole == ville.ecole ) {
				result = true;
			}
			return result;
	}

}
