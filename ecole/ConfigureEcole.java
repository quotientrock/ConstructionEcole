package ecole;


public class ConfigureEcole {

	public static void main(String[] args) {
		
		Communaute com=Menu.configureCommunaute();
		Menu.configureRoutes(com);
		Menu.configureEcoles(com);
		
	}
	


}
