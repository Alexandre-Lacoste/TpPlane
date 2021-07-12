package model;

import javax.persistence.*;

@DiscriminatorValue("private")
public class Particulier extends Client {
	@Column(name="firstName")
	private String prenom;

	public Particulier(int id, String nom, String prenom) {
		super(id, nom);
		this.prenom = prenom;
	}

	public Particulier() {
		super();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Particulier [prenom=" + prenom + "]";
	}
	
	
	
	
}
