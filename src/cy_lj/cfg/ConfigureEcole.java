package cy_lj.cfg;
import up.mi.jgm.td01.*;

import java.util.Scanner;

public class ConfigureEcole {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Menu.menuUtilisateur(sc);
		sc.close();
		
		double[] tab2 = { 18.2, 2.3, 5, 42, 23.7, 12 };
		int[] tab3 = { 18, 2, 5, 42, 23, 12 };
		UtilTab.triFusion(tab3, 0, tab2.length);
		System.out.print("triFusion(tab3) = " );
		for(int v : tab3)
			System.out.print(v + " ");
		System.out.println();
			
		System.out.println("moyennePonderee(tab2, tab3) = " + UtilTab.moyennePonderee(tab2, tab3));
		
	}
	


}
