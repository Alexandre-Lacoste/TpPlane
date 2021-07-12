package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class CompagnieAerienne {
	@Id
	private String code;
	private String nom;
	@OneToMany(mappedBy="compagnieAeriennes")
	private List<CompagnieAerienneVol> compagnieAerienneVols;
	
	public CompagnieAerienne() {
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


	
	
}
