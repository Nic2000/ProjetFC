package controleur;
import metier.Client;
import metier.Commande;
import metier.Produit;
public class Session {
	
	public TraiterConnexionReponse traiterConnexion(){
		TraiterConnexionReponse reponse = new TraiterConnexionReponse();
		reponse.typeEcran = EnumTypeEcran.ECRAN_ACCUEIL;
		return reponse;
	}
	
	public TraiterIdentificationReponse traiterIdentification(String pseudo,String mdp){
		TraiterIdentificationReponse reponse = new TraiterIdentificationReponse();
		reponse.typeEcran = EnumTypeEcran.ECRAN_ACCUEIL_PERSO;
		reponse.leClient = Client.rechercheClientParPseudo(pseudo,mdp);
		reponse.leProduit = new Produit().produitDuJour();
		return reponse;
		
	}
	
	public TraiterAjoutPanierReponse traiterAjoutPanier(Produit produit, int quantite,Client client) throws Exception {
		TraiterAjoutPanierReponse reponse = new TraiterAjoutPanierReponse();
		reponse.typeEcran = EnumTypeEcran.ECRAN_PANIER;
		reponse.laCommande = Commande.ajoutProduit(produit, quantite,client);
		return reponse;
	}
	
	public TraiterAnnulationCommandeReponse traiterAnnulerCommande(Commande commande) {
		TraiterAnnulationCommandeReponse reponse = new TraiterAnnulationCommandeReponse();
		reponse.typeEcran = EnumTypeEcran.ECRAN_ACCUEIL_PERSO;
		reponse.leClient = commande.getClient();
		reponse.leProduit = commande.annulerCommande();
		return reponse;
	}

}
