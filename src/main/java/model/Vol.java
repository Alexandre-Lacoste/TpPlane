package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dtDepart;
	private Date dtArrivee;
	private StatutVol statut;
	private Integer nbPlaceDispo;
//	@ManyToOne
//	@JoinColumn(name="billet_id")
//	private Billet billet;
	@OneToMany(mappedBy="vols")
	private List<CompagnieAerienneVol> volCompagnieAerienne;
	@OneToOne
	@JoinColumn(name="aeroportDepart_id")
	private Aeroport depart;
	@OneToOne
	@JoinColumn(name="aeroportArrive_id")
	private Aeroport arrive;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDtDepart() {
		return dtDepart;
	}
	public void setDtDepart(Date dtDepart) {
		this.dtDepart = dtDepart;
	}
	public Date getDtArrivee() {
		return dtArrivee;
	}
	public void setDtArrivee(Date dtArrivee) {
		this.dtArrivee = dtArrivee;
	}
	public StatutVol getStatut() {
		return statut;
	}
	public void setStatut(StatutVol statut) {
		this.statut = statut;
	}
	public Integer getNbPlaceDispo() {
		return nbPlaceDispo;
	}
	public void setNbPlaceDispo(Integer nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}
	
}