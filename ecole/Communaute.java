package ecole;

public class Communaute {
	
	private boolean Agglomeration[][];
	private Ville villesList[];
	public Communaute() {
		Agglomeration=new boolean[26][26];
		villesList=new Ville[26];
		//initialization ?
	}
	public Communaute(Ville vList[]) {
		Agglomeration=new boolean[26][26];
		villesList=vList;
		//veri
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
	public boolean estVoisins(int a, int b) {
		return Agglomeration[a][b];
	}
	
	public void addVille(Ville ville) {
	//exception ville max	
		villesList[villesList.length+1]=ville;
		
	}
}
