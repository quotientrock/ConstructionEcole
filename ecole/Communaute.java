package ecole;

/**
 * Classe permettant de repr�senter et manipuler une communaut�
 * d'ensemble de villes
 * Les villes et leurs routes sont 
 * repr�sent�es par une matrice d'adjacence
 * Le nom d'une villes est associ� au num�ro  d'index du tableau o� il est stock�.
 * @author christophe yang
 * @version 1.0
 */
public class Communaute {
	
	private boolean Agglomeration[][];
	private Ville villesTab[];
	/**
	 * Constructeur d'une communaut� permettant de d'initialiser les attributs
	 * @param size donne le nombre de villes de la communaut�
	 */
	public Communaute(int size) {
		this.Agglomeration=new boolean[size][size];
		this.villesTab=new Ville[size];
		for(int i=0;i<size;i++) {
			this.villesTab[i]=Ville(true,"ville"+Integer.toString(i),this);
		}
	}
	/**
	 * Constructeur d'une communaut� permettant de d'initialiser les attributs
	 * @param vTab une liste
	 * @param size donne le nombre de villes de la communaut�
	 */
	public Communaute(Ville vTab[],int size) {
		this.Agglomeration=new boolean[size][size];
		if (vTab.length==size) {
			this.villesTab=vTab;
		}
		else {
			System.out.println("La taille du tableau ville donn�e n'est pas �gale � la taille donn� en arguments.");
			System.out.println("Le tableau ville est alors initialis� par d�faut.");
			this.villesTab=new Ville[size];
		}
	}
	/**
	 * Constructeur d'une communaut� permettant de d'initialiser les attributs
	 * @param Agglo la matrice d'adjacence repr�sentant la communaut�
	 * @param vTab le tableau de noms des villes
	 */
	public Communaute(boolean Agglo[][],Ville vTab[]) {
		if(Agglo[0].length==vTab.length && isSymetric(Agglo)) {
		this.Agglomeration=Agglo;
		this.villesTab=vTab;
		}
		else {
			System.out.println("Les dimensions ne sont pas respect�s ou la matrice n'est pas symm�trique");
			System.out.println("L'agglomeration et le tableau de villes ont �t� initialis� par d�faut de taille"+Agglo[0].length);
			int size=Agglo[0].length;
			this.Agglomeration=new boolean[size][size];
			this.villesTab=new Ville[size];
		}
	}
	
	public Ville getVilles() {
		return this.VillesTab;
		
	}
	/**
	 * M�thode permettant de v�rifier la sym�trie d'une matrice de bool�en
	 * @param matrice de booleen
	 * @return true si la matrice est sym�trique
	 */
	private static boolean isSymetric(boolean matrix[][]) {
		if (matrix[0].length!=matrix[1].length) {
			return false;
		}
		else {
		for (int i=0;i<matrix[0].length);i++){
			for (int j=0;j<matrix[j].length;j++) {
				if(matrix[i][j]!=matrix[j][i]) {
					return false;
				}
			}
		}
		return true;
		}
	}
	/**
	 * M�thode permettant d'ajouter une route entre deux villes
	 * �quivalent � rendre true l'arr�te entre les deux villes
	 * @param nom d'une ville
	 * @param nom d'une autre ville � reli�
	 */
	public void addRoad(String nomA, String nomB) {
		addRoad(getVilleKey(nomA),getVilleKey(nomB));
	}
	/**
	 * M�thode permettant d'ajouter une route entre deux villes
	 * �quivalent � rendre true l'arr�te entre les deux villes
	 * @param num�ro repr�sentant une ville
	 * @param num�ro repr�sentant une autre ville � reli�
	 */
	public void addRoad(int a,int b) {
		this.Agglomeration[a][b]=true;
		this.Agglomeration[b][a]=true;
	}
	/**
	 * M�thode permettant de recup�rer le num�ro d'une ville 
	 * � partir de son nom
	 * @param nom d'une ville
	 * @return num�ro d'une ville
	 */
	public int getVilleKey(String nom) {
		int i=0;
		for (i=0;i<this.villesTab.length;i++) {
			if(nom==villesTab[i]) {
				return i;
			}
			else {
				System.out.println("Nous n'avons pas reussi � trouver le nom dans la liste des villes.")
				return -1;
			}
		}
	}
	/**
	 * M�hode permettant de r�cup�rer le nom d'une ville � partir d'un num�ro
	 * @param num�ro d'une ville
	 * @return nom de la ville
	 */
	public String getVilleName(int i) {
		return villesTab[i].getName();
	}
	/**
	 * M�thode permettant de v�rifier si deux villes sont voisines
	 * @param nom d'une ville
	 * @param nom de la ville � reli�
	 * @return true si les deux villes sont voisines
	 */
	public boolean estVoisins(String nomA, String nomB){
		return estVoisins(getVilleKey(nomA),getVilleKey(nomB));
	}
	/**
	 * M�thode permettant de v�rifier si deux villes sont voisines
	 * @param num�ro d'une ville
	 * @param num�ro de la ville � reli�
	 * @return true si les deux villes sont voisines
	 */
	public boolean estVoisins(int a, int b) {
		return Agglomeration[a][b];
	}
	/**
	 * M�thode permettant d'afficher les villes ayant une �coles et leur nombre
	 */
	public void afficheEcoleVille() {
		int i=0;
		int sum=0;
		while(this.villesTab[i]!=NULL && i<this.villesTab.length) {
			if(this.villesTab.hasEcole()) {
				System.out.print(this.villesTab.getName()+" ");
				sum++;
			}
			i++;
		}
		System.out.println("\n Le nombre de villes ayant une �cole est:"+sum);
	}
	/**
	 * M�thode permettant d'ajouter une ville � la communaute
	 * @param la ville � ajouter
	 * @return si la ville a �t� ajout� ou non
	 */
	public boolean addVille(Ville uneVille) {
		boolean ajoutVille=false;
		for(int i=0;i<this.villesTab.length;i++) {
			if (this.villesTab[i]==NULL) {
				this.villesTab[i]=uneVille;
				ajoutVille=true;
				break;
			}
		}
		if (!ajoutVille) {
			System.out.println("L'ajout de la ville n'a pas �t� effectu�.");
		}
		return ajoutVille;
	}
}
