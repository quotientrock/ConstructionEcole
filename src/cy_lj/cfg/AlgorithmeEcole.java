package cy_lj.cfg;
/**
 * Classe permettant de résoudre automatiquement le problème des écoles
 * @author christophe
 *
 */
public class AlgorithmeEcole {
	
	public static Communaute algoEcole(Communaute comu) {
		Communaute com=comu;
		Ville[] tabVilles=com.getTabSortedByDegree();
		
		//Initialisation tel que toutes les villes ont une écoles!
		for (int  j=0;j<tabVilles.length;j++) {
			//System.out.println(tabVilles[j].getName());
			if(!tabVilles[j].hasEcole()) {
				tabVilles[j].addEcole();
			}
		}
		//System.out.println("ok");
		for (int i=0;i<tabVilles.length;i++) {
			tabVilles[i].supprEcole();
		//	System.out.println(tabVilles[i].getName());
		}
		return com;
	}
	
	
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
