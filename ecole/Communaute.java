package ecole;

public class Communaute {
	
	private boolean Agglomeration[][];
	private Ville villesList[];
	public Communaute(int size) {
		this.Agglomeration=new boolean[size][size];
		this.villesList=new Ville[size];
		//initialization s?
	}
	public Communaute(Ville vList[],int size) {
		this.Agglomeration=new boolean[size][size];
		this.villesList=vList;
		//veri
	}

	public Communaute(boolean Agglo[][],Ville vList[]) {
		//Verifier la symétrie de la matrice
		this.Agglomeration=Agglot;
		this.villesList=vList;
	}
	public void addRoad(String nomA, String nomB) {
		addRoad(getVilleKey(nomA),getVilleKey(nomB));
	}
	
	private void addRoad(int a,int b) {
		this.Agglomeration[a][b]=true;
		this.Agglomeration[b][a]=true;
	}
	
	private int getVilleKey(String nom) {
		int i=0;
		for (i=0;i<this.villesList.length;i++) {
			if(nom==villesList[i]) {
				return i;
			}
			else {
				return -1;
			}
		}
	}
	public boolean estVoisins(String nomA, String nomB){
		return estVoisins(getVilleKey(nomA),getVilleKey(nomB));
	}
	private boolean estVoisins(int a, int b) {
		return Agglomeration[a][b];
	}
	public void addVille(Ville ville) {
	//exception ville max	2
		villesList[villesList.length+1]=ville;
		
	}
}
