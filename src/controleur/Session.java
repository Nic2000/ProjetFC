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
		reponse.leProduit = Produit.getNom();
		return reponse;
		
	}
	public TraiterAjoutPanierReponse traiterAjoutPanier(Produit produit, Integer intg) {
		TraiterAjoutPanierReponse reponse = new TraiterAjoutPanierReponse();
		reponse.typeEcran = EnumTypeEcran.ECRAN_PANIER;
		Produit leProduit = Produit.getNom();
		Integer quantite = 0;
		reponse.laCommande = Commande.ajoutProduit(leProduit, quantite);;
		return reponse;
	}

}
