package metier;

public class LigneCommande {
	
	
	private Produit produit;
	private int quantite;
	private Double montant;

	public LigneCommande() {
		//super();
	}

	public LigneCommande(Produit produit, int quantite, Double montant) {
		//super();
		this.produit = produit;
		this.quantite = quantite;
		this.montant = montant;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	
	 


}
