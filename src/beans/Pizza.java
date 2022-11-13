package beans;

public class Pizza {
	private String nom;
	private double prix;
	public Pizza(String nom, double prix) {
		
		this.nom = nom;
		this.prix = prix;
	}
	public Pizza() {}
	
	public String getNom() {
		return nom;
	}
    void setNom(String nom) {
		this.nom = nom;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
	
}
