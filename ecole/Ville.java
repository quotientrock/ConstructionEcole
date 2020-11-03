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
		if (this.ecole) {
			int access=1;
			for(int i=0;i<com.getVilles().length && access==1;i++) {
				if(com.estVoisins(this.nom,this.com.getVilles()[i].getName())) {
					this.ecole=true;
					if(!(com.getVilles()[i].hasEcole())) {
						for(int j=0;j<com.getVillesTab().length;j++) {
							if(this.com.estVoisins(this.com.getVilles()[i].getName(), com.getVilles()[j].getName())) {
								if(com.getVilles()[j].getNom()!=this.getName() && (com.getVilles()[j].hasEcole())) {
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
	public boolean hasEcole() {
		return ecole;
	}

	/**Getter
	 * @return nom
	 */
	public String getName() {
		return nom;
	}

}
