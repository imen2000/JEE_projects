package beans;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private int id;
	private String nom;
	private String pr�nom;
	private String adresse;
	List <Pizza> listePizza = new ArrayList<>();
    private double prixTotal;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPr�nom() {
		return pr�nom;
	}
	
	public void setPr�nom(String pr�nom) {
		this.pr�nom = pr�nom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public List<Pizza> getListePizza() {
		return listePizza;
	}
	
	public void setListePizza(List<Pizza> p) {
		this.listePizza= p;
	}
	
	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
}
