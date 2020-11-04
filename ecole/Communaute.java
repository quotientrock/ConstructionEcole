package ecole;

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
	
	private boolean Agglomeration[][];
	private Ville villesTab[];
	/**
	 * Constructeur d'une communauté permettant de d'initialiser les attributs
	 * @param size donne le nombre de villes de la communauté
	 */
	public Communaute(int size) {
		this.Agglomeration=new boolean[size][size];
		this.villesTab=new Ville[size];
		for(int i=0;i<size;i++) {
			this.villesTab[i]=Ville(true,"ville"+Integer.toString(i),this);
		}
	}
	/**
	 * Constructeur d'une communauté permettant de d'initialiser les attributs
	 * @param vTab une liste
	 * @param size donne le nombre de villes de la communauté
	 */
	public Communaute(Ville vTab[],int size) {
		this.Agglomeration=new boolean[size][size];
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
	 * @param Agglo la matrice d'adjacence représentant la communauté
	 * @param vTab le tableau de noms des villes
	 */
	public Communaute(boolean Agglo[][],Ville vTab[]) {
		if(Agglo[0].length==vTab.length && isSymetric(Agglo)) {
		this.Agglomeration=Agglo;
		this.villesTab=vTab;
		}
		else {
			System.out.println("Les dimensions ne sont pas respectés ou la matrice n'est pas symmétrique");
			System.out.println("L'agglomeration et le tableau de villes ont été initialisé par défaut de taille"+Agglo[0].length);
			int size=Agglo[0].length;
			this.Agglomeration=new boolean[size][size];
			this.villesTab=new Ville[size];
		}
	}
	
	public Ville getVilles() {
		return this.VillesTab;
		
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
	 * Méthode permettant d'ajouter une route entre deux villes
	 * équivalent à rendre true l'arrête entre les deux villes
	 * @param nom d'une ville
	 * @param nom d'une autre ville à relié
	 */
	public void addRoad(String nomA, String nomB) {
		addRoad(getVilleKey(nomA),getVilleKey(nomB));
	}
	/**
	 * Méthode permettant d'ajouter une route entre deux villes
	 * équivalent à rendre true l'arrête entre les deux villes
	 * @param numéro représentant une ville
	 * @param numéro représentant une autre ville à relié
	 */
	public void addRoad(int a,int b) {
		this.Agglomeration[a][b]=true;
		this.Agglomeration[b][a]=true;
	}
	/**
	 * Méthode permettant de recupérer le numéro d'une ville 
	 * à partir de son nom
	 * @param nom d'une ville
	 * @return numéro d'une ville
	 */
	public int getVilleKey(String nom) {
		int i=0;
		for (i=0;i<this.villesTab.length;i++) {
			if(nom==villesTab[i]) {
				return i;
			}
			else {
				System.out.println("Nous n'avons pas reussi à trouver le nom dans la liste des villes.")
				return -1;
			}
		}
	}
	/**
	 * Méhode permettant de récupérer le nom d'une ville à partir d'un numéro
	 * @param numéro d'une ville
	 * @return nom de la ville
	 */
	public String getVilleName(int i) {
		return villesTab[i].getName();
	}
	/**
	 * Méthode permettant de vérifier si deux villes sont voisines
	 * @param nom d'une ville
	 * @param nom de la ville à relié
	 * @return true si les deux villes sont voisines
	 */
	public boolean estVoisins(String nomA, String nomB){
		return estVoisins(getVilleKey(nomA),getVilleKey(nomB));
	}
	/**
	 * Méthode permettant de vérifier si deux villes sont voisines
	 * @param numéro d'une ville
	 * @param numéro de la ville à relié
	 * @return true si les deux villes sont voisines
	 */
	public boolean estVoisins(int a, int b) {
		return Agglomeration[a][b];
	}
	/**
	 * Méthode permettant d'afficher les villes ayant une écoles et leur nombre
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
		System.out.println("\n Le nombre de villes ayant une école est:"+sum);
	}
	/**
	 * Méthode permettant d'ajouter une ville à la communaute
	 * @param la ville à ajouter
	 * @return si la ville a été ajouté ou non
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
			System.out.println("L'ajout de la ville n'a pas été effectué.");
		}
		return ajoutVille;
	}
}
