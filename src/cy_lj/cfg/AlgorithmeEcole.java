package cy_lj.cfg;
/**
 * Classe permettant de résoudre automatiquement le problème des écoles
 * @author christophe
 *
 */
public class AlgorithmeEcole {
	
	public static void algoEcole(Communaute com) {
		
		Ville[] tabVilles=com.getTabSortedByDegree();
		//Initialisation tel que toutes les villes ont une écoles!
		for (int  j=0;j<tabVilles.length;j++) {
			if(!tabVilles[j].hasEcole()) {
				tabVilles[j].addEcole();
			}
		}

		for (int i=0;i<tabVilles.length;i++) {
			tabVilles[i].supprEcole();
		}
	}
	
	
	public static void algo2Sujet(Communaute com,int k) {
		int i=0;
		int scoreCourant=com.getNbEcoles();
		while(i<k) {
			int indiceVilleAleatoire=(int)(Math.random() * (com.getVilles().length));
			if(com.getVilles()[indiceVilleAleatoire].hasEcole()) {
				
			}
		}
	}
}
