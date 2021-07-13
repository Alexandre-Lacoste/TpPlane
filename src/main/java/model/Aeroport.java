package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity

public class Aeroport {
	@Id
	private String code;
	private String nom;
	@OneToMany(mappedBy="aeroports")
	private List<AeroportVille> aeroportVille;
	
	public Aeroport() {
		super();
	}

	public Aeroport(String code, String nom, List<AeroportVille> aeroportVille) {
		super();
		this.code = code;
		this.nom = nom;
		this.aeroportVille = aeroportVille;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<AeroportVille> getAeroportVille() {
		return aeroportVille;
	}

	public void setAeroportVille(List<AeroportVille> aeroportVille) {
		this.aeroportVille = aeroportVille;
	}

	
}
