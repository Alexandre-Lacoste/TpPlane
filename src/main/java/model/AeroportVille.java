package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class AeroportVille {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="aeroportVille_id")
	private Aeroport aeroports;
	@ManyToOne
	@JoinColumn(name="ville_id")
	private Ville villes;
	
	
	public AeroportVille() {
		super();
	}
	
	
	public AeroportVille(Long id, Aeroport aeroports, Ville villes) {
		super();
		this.id = id;
		this.aeroports = aeroports;
		this.villes = villes;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Aeroport getAeroports() {
		return aeroports;
	}
	public void setAeroports(Aeroport aeroports) {
		this.aeroports = aeroports;
	}
	public Ville getVilles() {
		return villes;
	}
	public void setVilles(Ville villes) {
		this.villes = villes;
	}
	

	
	
}
