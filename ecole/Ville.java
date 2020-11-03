package ecole;

public class Ville {
	private String nom;
	private boolean ecole;
	private Communaute com;
	
	/**
	 * Constructeur d'une ville permettant  d'initialiser les attributs
	 * @param ecole indique si un ecole est presente dans la ville
	 * @param nom   donne un nom a la ville 
	 * @param com   donne la communaute associee a la ville
	 */

	public Ville(boolean ecole, String nom, Communaute com) {
		this.com=com;
		this.nom=nom;
		this.ecole=ecole;
	} 
	
	/**
	 * Constructeur d'une ville permettant  d'initialiser les attributs
	 * @param nom   donne un nom a la ville 
	 * @param com   donne la communaute associee a la ville
	 */
	public Ville(String nom, Communaute com) {
		this.com=com;
		this.nom=nom;
		ecole=true;
	}
	
		
		
	
	/**Méthode permettant d'ajouter une ecole a la ville
	 */
	public void addEcole() {
		if (isEcole()==false)
		ecole=true;
		else
			System.out.println(" Deja une ecole dans la ville");
	}
	/**Méthode permettant de supprimer une ecole a la ville
	 */
	public void supprEcole() {
		if (isEcole()==true) {
			int access=1;
			for(int i=0;i<com.getVillesTab().length && access==1;i++) {
				if(com.estVoisins(this.getNom(),com.getVillesTab()[i].getNom())) {
					ecole=true;
					if(!(com.getVillesTab()[i].isEcole())) {
						for(int j=0;j<com.getVillesTab().length;j++) {
							if(com.estVoisins(com.getVillesTab()[i].getNom(), com.getVillesTab()[j].getNom())) {
								if(com.getVillesTab()[j].getNom()!=this.getNom() && (com.getVillesTab()[j].isEcole())) {
									ecole=false;
								}
								else access=0;
							}
						}
					}
					else ecole=false;
				}
			}
		}
		else 
			System.out.println(" Aucune ecole dans la ville");
	}
	
	
	@Override
	public boolean equals(Object object) {
		boolean result = false;
			Ville ville = (Ville) object;
			if (this.isEcole() == ville.isEcole() ) {
				result = true;
			}
			return result;
	}
	
	/**Getter 
	 * @return ecole*/
	public boolean isEcole() {
		return ecole;
	}

	/**Getter
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

}
