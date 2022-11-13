package beans;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private int id;
	private String nom;
	private String prénom;
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
	
	public String getPrénom() {
		return prénom;
	}
	
	public void setPrénom(String prénom) {
		this.prénom = prénom;
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
