package cy_lj.cfg;
/**
 * Classe permettant de résoudre automatiquement le problème des écoles
 * @author christophe
 *
 */
public class AlgorithmeEcole {
	
	public static void algoEcole(Communaute com) {
		Ville[] tabVilles=com.getTabSortedByDegree();
		for (int i=0;i<0;i++) {
			tabVilles[i].supprEcole();
		}
	}
}
