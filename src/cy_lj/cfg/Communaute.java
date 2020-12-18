package cy_lj.cfg;
/**
 * Classe permettant de représenter et manipuler une communauté
 * d'ensemble de villes
 * Les villes et leurs routes sont 
 * représentées par une matrice d'adjacence
 * Le nom d'une villes est associé au numéro  d'index du tableau où il est stocké.
 * @author christophe yang
 * @version 1.0
 */
public class Communaute {
	
	private boolean agglomeration[][];
	private Ville villesTab[];
	/**
	 * Constructeur d'une communauté permettant de d'initialiser les attributs
	 * @param size donne le nombre de villes de la communauté
	 */
	public Communaute(int size) {
		char name;
		this.agglomeration=new boolean[size][size];
		this.villesTab=new Ville[size];
		this.villesTab[0]= new Ville(true,'A',this);
		for(int i=1;i<size;i++) {
			name =(char) (villesTab[0].getName()+i);
			this.villesTab[i]= new Ville(true,name,this);
		}
	}
	/**
	 * Constructeur d'une communauté permettant de d'initialiser les attributs
	 * @param vTab une liste
	 * @param size donne le nombre de villes de la communauté
	 */
	public Communaute(Ville vTab[],int size) {
		this.agglomeration=new boolean[size][size];
		if (vTab.length==size) {
			this.villesTab=vTab;
		}
		else {
			System.out.println("La taille du tableau ville donnée n'est pas égale à la taille donné en arguments.");
			System.out.println("Le tableau ville est alors initialisé par défaut.");
			this.villesTab=new Ville[size];
		}
	}
	/**
	 * Constructeur d'une communauté permettant de d'initialiser les attributs
	 * @param agglo la matrice d'adjacence représentant la communauté
	 * @param vTab le tableau de noms des villes
	 */
	public Communaute(boolean agglo[][],Ville vTab[]) {
		if(agglo[0].length==vTab.length && isSymetric(agglo)) {
		this.agglomeration=agglo;
		this.villesTab=vTab;
		}
		else {
			System.out.println("Les dimensions ne sont pas respectés ou la matrice n'est pas symmétrique");
			System.out.println("L'agglomeration et le tableau de villes ont été initialisé par défaut de taille"+agglo[0].length);
			int size=agglo[0].length;
			this.agglomeration=new boolean[size][size];
			this.villesTab=new Ville[size];
		}
	}
	/**
	* Méthode retournant le tableau des villes de la communaute
	*/
	public Ville[] getVilles() {
		return villesTab;
		
	}
	/**
	 * Méthode permettant de vérifier la symétrie d'une matrice de booléen
	 * @param matrice de booleen
	 * @return true si la matrice est symétrique
	 */
	private static boolean isSymetric(boolean matrix[][]) {
		if (matrix[0].length!=matrix[1].length) {
			return false;
		}
		else {
		for (int i=0;i<matrix[0].length;i++){
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
	 * Méthode permettant d'ajouter une route entre deux villes
	 * équivalent à rendre true l'arrête entre les deux villes
	 * @param nom d'une ville
	 * @param nom d'une autre ville à relié
	 */
	public void addRoad(char nomA, char nomB) {
		addRoad(getVilleKey(nomA),getVilleKey(nomB));
	}
	/**
	 * Méthode permettant d'ajouter une route entre deux villes
	 * équivalent à rendre true l'arrête entre les deux villes
	 * @param numéro représentant une ville
	 * @param numéro représentant une autre ville à relié
	 */
	public void addRoad(int a,int b) {
		this.agglomeration[a][b]=true;
		this.agglomeration[b][a]=true;
	}
	/**
	 * Méthode permettant de recupérer le numéro d'une ville 
	 * à partir de son nom
	 * @param nom  nom d'une ville
	 * @return numéro  numero d'une ville
	 */
	public int getVilleKey(char nom) {
		for (int i=0;i<this.villesTab.length;i++) {
			if(nom==villesTab[i].getName()) {
				return i;
			}
		}
		System.out.println("Nous n'avons pas reussi à trouver le nom dans la liste des villes.");
		return -1;
	}
	/**
	 * Méhode permettant de récupérer le nom d'une ville à partir d'un numéro
	 * @param numéro d'une ville
	 * @return nom de la ville
	 */
	public char getVilleName(int i) {
		return villesTab[i].getName();
	}
	/**
	 * Méthode permettant de vérifier si deux villes sont voisines
	 * @param nom d'une ville
	 * @param nom de la ville à relié
	 * @return true si les deux villes sont voisines
	 */
	public boolean estVoisins(char nomA, char nomB){
		return estVoisins(getVilleKey(nomA),getVilleKey(nomB));
	}
	/**
	 * Méthode permettant de vérifier si deux villes sont voisines
	 * @param numéro d'une ville
	 * @param numéro de la ville à relié
	 * @return true si les deux villes sont voisines
	 */
	public boolean estVoisins(int a, int b) {
		return agglomeration[a][b];
	}
	/**
	 * Méthode permettant d'afficher les villes ayant une école et leur nombre
	 */
	public void afficheEcoleVille(int nb) {
		 String ecole="";
		for(int i=0;i<nb;i++) {
			if(villesTab[i].hasEcole()==true)
				ecole=ecole+" "+villesTab[i].getName();
				
		}
		System.out.println("Les villes ayant une école sont " + ecole);
		}
	/**
	 * Méthode permettant d'ajouter une ville à la communaute
	 * @param la ville à ajouter
	 * @return si la ville a été ajouté ou non
	 */
	public boolean addVille(Ville uneVille) {
		boolean ajoutVille=false;
		for(int i=0;i<this.villesTab.length;i++) {
			if (this.villesTab[i]==null) {
				this.villesTab[i]=uneVille;
				ajoutVille=true;
				break;
			}
		}
		if (!ajoutVille) {
			System.out.println("L'ajout de la ville n'a pas été effectué.");
		}
		return ajoutVille;
	}
	/**
	 * Méthode permettant d'obtenir le nombre de voisins d'une ville
	 * @param ville où on veut obtenir le nombre de voisins
	 * @return nombre de voisins de la ville données en paramètres
	 * à check
	 */
	public int nbVoisins(Ville uneVille) {
		int indiceVille=getVilleKey(uneVille.getName());
		int nbVoisinsVille=0;
		for(boolean voisins : agglomeration[indiceVille]) {
			if(voisins) {
				nbVoisinsVille++;
			}
		}
		return nbVoisinsVille;
	}
	/**
	 * Methode qui trie un tableau par selection et la renvoie. Le tri par selection consiste a
	 * chercher l'element le plus petit du tableau, et a l'echanger avec le premier
	 * element. Le processus est reitere pour le deuxieme plus petit qui est echange
	 * avec le deuxieme element du tableau, etc, jusqu'a ce que le tableau soit
	 * trie.
	 * L'element le plus petit ici est l'indice de la ville dont le nombre de voisins est le plus petit
	 * PS:Ces méthodes ont été faite Jean-Guy-mally mais ont été modifiées
	 * @param tab le tableau a trier.
	 * @return le tableau des indices d'une villes trié par odre croissant du nombre de voisins d'une ville
	 */
	public Ville[] getTabSortedByDegree() {
		Ville[] tab=this.getVilles();
		
		for (int i = 0; i < tab.length - 1; i++) {
			int indiceMin = rechercheIndicePlusPetit(tab, i);
			if (indiceMin != i) {
				echanger(tab, i, indiceMin);
			}
		}
		return tab;
	}

	/**
	 * Methode qui permet d'obtenir l'indice du plus petit element d'un tableau a
	 * partir d'une position donnee
	 * L'element le plus petit ici est l'indice de la ville dont le nombre de voisins est le plus petit
	 * 
	 * @param tab       le tableau dont on cherche le plus petit element
	 * @param indiceMin la position a partir de laquelle on recherche le plus petit
	 *                  element
	 * @return l'indice du plus petit element de tab situe apres la position
	 *         indiceMin
	 */
	private int rechercheIndicePlusPetit(Ville[] tab, int indiceMin) {
		for (int j = indiceMin + 1; j < tab.length; j++) {
			if (nbVoisins(tab[j]) < nbVoisins(tab[indiceMin])) {
				indiceMin = j;
			}
		}
		return indiceMin;
	}

	/**
	 * Methode qui echange deux elements d'un tableau, donnes par leur position
	 * 
	 * @param tab le tableau dans lequel on echange deux elements
	 * @param i   l'indice du premier element a echanger
	 * @param j   l'indice du second element a echanger
	 */
	private static void echanger(Ville[] tab, int i, int j) {
		Ville tmpVal = tab[i];
		tab[i] = tab[j];
		tab[j] = tmpVal;
	}
}
