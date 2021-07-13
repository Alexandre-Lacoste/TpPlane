package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class CompagnieAerienneVol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="vol_id")
	private Vol vols;
	@ManyToOne
	@JoinColumn(name="compagineAerienne_id")
	private CompagnieAerienne compagnieAeriennes;
	
	public CompagnieAerienneVol() {
		super();
	}
	public CompagnieAerienneVol(Long id, Vol vols, CompagnieAerienne compagnieAeriennes) {
		super();
		this.id = id;
		this.vols = vols;
		this.compagnieAeriennes = compagnieAeriennes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Vol getVols() {
		return vols;
	}
	public void setVols(Vol vols) {
		this.vols = vols;
	}
	public CompagnieAerienne getCompagnieAeriennes() {
		return compagnieAeriennes;
	}
	public void setCompagnieAeriennes(CompagnieAerienne compagnieAeriennes) {
		this.compagnieAeriennes = compagnieAeriennes;
	}
	
}
