package metier;

public class Client {

	
	public static Client nom;
	public static Client prenom;
	public static void initializeClients() {
		
	}
	
	public Client getPrenom() {
		return prenom;
	}
	
	public  Client getNom() {
		return nom;
	}

	public static Client rechercheClientParPseudo(String pseudo, String mdp) {
		Client leClient = new Client();
		String pseudo1[] = new String[4];
		pseudo1[0] = "User00";
		for(int i=0; i < pseudo1.length; i++){
			if (pseudo1[i] == pseudo){
				leClient.getNom();
				leClient.getPrenom();
			}
		}
		return leClient;
	}

}
