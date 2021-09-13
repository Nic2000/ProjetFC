package metier;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String nom;
	private String prenom;
	private String pseudo;
	private String mdp;
	
	public Client() {
		super();
	}
	
	public static List <Client> initializeClients() {
		List <Client>listClient = new ArrayList<Client>() ;
		
		listClient.add(new Client("andry","Razafy","a","z"));
		listClient.add(new Client("andry2","Razafy2","and.r2","abcde"));
		listClient.add(new Client("andry3","Razafy3","and.r3","emrp"));
		listClient.add(new Client("andr4","Razafy4","and.r4","aj12"));
		
		return listClient;
	}
	
	public Client(String nom, String prenom, String pseudo, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.mdp = mdp;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public static Client rechercheClientParPseudo(String pseudo, String mdp) {
		Client leClient = null;
		List <Client> listClient= initializeClients();
		for(int i=0; i < listClient.size(); i++){
			if (pseudo.equals(listClient.get(i).pseudo) && mdp.equals(listClient.get(i).mdp)){
				leClient = listClient.get(i);
			}
		}
		return leClient;
	}

}
