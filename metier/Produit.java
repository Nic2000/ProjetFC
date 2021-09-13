package metier;

import java.util.ArrayList;
import java.util.List;

public class Produit {
	private String Nom;
	private String Ref;
	private Double Prix;
	private Categorie cat;
	private int stock;
	
	public static List<Produit> initializeProduits() {	
		List<Produit> list = new ArrayList<Produit>();
		list.add(new Produit("Chaussure Nike","1HHT56",15.00,new Categorie("1","Chaussure",null),10) );
		list.add(new Produit("Robe femme","1HS2SQ6",20.00,new Categorie("2","Vetment",null),15) );
		list.add(new Produit("Casquette","1H2SA",35.00,new Categorie("3","Accéssoire",null),13) );
		return list;
		
	}

	public Produit() {
		super();
	}

	public Produit(String nom, String ref, Double prix, Categorie cat, int stock) {
		super();
		Nom = nom;
		Ref = ref;
		Prix = prix;
		this.cat = cat;
		this.stock = stock;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getRef() {
		return Ref;
	}

	public void setRef(String ref) {
		Ref = ref;
	}

	public Double getPrix() {
		return Prix;
	}

	public void setPrix(Double prix) {
		Prix = prix;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Produit produitDuJour() {
		return initializeProduits().get(0);
	}

}
