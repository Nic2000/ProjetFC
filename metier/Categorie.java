package metier;

public class Categorie {
	private String refCat;
	private String nom;
	private String soucat;
	
	public Categorie() {
		super();
	}

	public Categorie(String refCat, String nom, String soucat) {
		super();
		this.refCat = refCat;
		this.nom = nom;
		this.soucat = soucat;
	}

	public String getRefCat() {
		return refCat;
	}

	public void setRefCat(String refCat) {
		this.refCat = refCat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSoucat() {
		return soucat;
	}

	public void setSoucat(String soucat) {
		this.soucat = soucat;
	}
	
	
	
}
