package metier;

import java.util.ArrayList;

public class Commande extends LigneCommande{
	
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static void initializeCommandes() {
		
	}
	
	public static Commande ajoutProduit(Produit leProduit,int quantite,Client client) throws Exception{
		if(quantite>leProduit.getStock()){
			throw new Exception ("Quantité non disponible en stock !");
		}
		Commande c=new Commande();
		c.setProduit(leProduit);
		c.setQuantite(quantite);
		c.setMontant(leProduit.getPrix()*quantite);
		c.setClient(client);
		leProduit.setStock(leProduit.getStock()-quantite);
		return c;
	}
	
	public  Produit annulerCommande() {
		this.getLesLignesCommande().get(0).getProduit().setStock(this.getLesLignesCommande().get(0).getProduit().getStock()+this.getLesLignesCommande().get(0).getQuantite());
		return this.getLesLignesCommande().get(0).getProduit();
	}
	
	public ArrayList<LigneCommande> getLesLignesCommande() {
		Produit p = new Produit().produitDuJour();
		ArrayList<LigneCommande> lc= new ArrayList<LigneCommande>();
		lc.add( new LigneCommande(p,this.getQuantite(),p.getPrix()*this.getQuantite() ));
		return lc;
	}
	
	public static void main(String[] args) {
		 LigneCommande c=  new LigneCommande(new Produit("Chaussure Nike","1HHT56",15.00,new Categorie("1","Chaussure",null),12),2,15.00 );
		 System.out.print(c.getQuantite());
	 }
	
	
	
}
