package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy="villes")
	private List<AeroportVille> villeAeroport;
	
	public Ville() {
		super();
	}	
	

	public Ville(Long id, String nom, List<AeroportVille> villeAeroport) {
		super();
		this.id = id;
		this.nom = nom;
		this.villeAeroport = villeAeroport;
	}


	public List<AeroportVille> getVilleAeroport() {
		return villeAeroport;
	}


	public void setVilleAeroport(List<AeroportVille> villeAeroport) {
		this.villeAeroport = villeAeroport;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	
}
