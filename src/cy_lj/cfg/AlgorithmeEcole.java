package cy_lj.cfg;
/**
 * Classe permettant de résoudre automatiquement le problème des écoles
 * @author christophe
 *
 */
public class AlgorithmeEcole {
	/**
	 * Cette algorithme trouve une solution en supprimer les villes ayant le moins de voisins 
	 * jusqu'aux villes ayant les plus grands voisins
	 * @param comu Communaute où il faut trouver une solution
	 * @return Communaute avec la solution
	 */
	public static Communaute algoEcole(Communaute comu) {
		//Obtenir une liste trie par odre croissant en fonction du nombre de voisins des villes
		Communaute com=comu;
		Ville[] tabVilles=com.getTabSortedByDegree();
		
		//Initialisation tel que toutes les villes ont une écoles!
		for (int  j=0;j<tabVilles.length;j++) {
			//System.out.println(tabVilles[j].getName());
			if(!tabVilles[j].hasEcole()) {
				tabVilles[j].addEcole();
			}
		}
		//On supprime les villes ayant le moins de voisins
		//Le principe est d'avoir le plus de villes déservant un grand nombre d'autres villes
		for (int i=0;i<tabVilles.length;i++) {
			tabVilles[i].supprEcole();
		//	System.out.println(tabVilles[i].getName());
		}
		return com;
	}
	
	/**
	 * méthode du sujet permettant d'obtenir une solution au problème
	 * @param com communauté
	 * @param k nombre d'iteration pour l'algorithme
	 * @return commuanute avec une solution pour les ecoles
	 */
	public static Communaute algo2Sujet(Communaute com,int k) {
		int i=0;
		Communaute meilleurCom=com;
		Communaute courantCom=com;
		while(i<k) {
			int indiceVilleAleatoire=(int)(Math.random() * (courantCom.getVilles().length));
			if(courantCom.getVilles()[indiceVilleAleatoire].hasEcole()) {
				courantCom.getVilles()[indiceVilleAleatoire].supprEcole();
			}
			else {
				courantCom.getVilles()[indiceVilleAleatoire].addEcole();
			}
			if(courantCom.getNbEcoles()<meilleurCom.getNbEcoles()) {
				i=0;
				meilleurCom=courantCom;
			}
			else {
				i++;
			}
		}
		return meilleurCom;
	}
}
