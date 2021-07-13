package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@OneToMany(mappedBy="vols")
	private List<Billet> billet;
	@OneToMany(mappedBy="vols")
	private List<CompagnieAerienneVol> volCompagnieAerienne;
	@OneToOne
	@JoinColumn(name="aeroportDepart_id")
	private Aeroport depart;
	@OneToOne
	@JoinColumn(name="aeroportArrive_id")
	private Aeroport arrive;
	
	
	
	public Vol(Long id, Date dtDepart, Date dtArrivee, StatutVol statut, Integer nbPlaceDispo,
			List<CompagnieAerienneVol> volCompagnieAerienne, Aeroport depart, Aeroport arrive) {
		super();
		this.id = id;
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.statut = statut;
		this.nbPlaceDispo = nbPlaceDispo;
		this.volCompagnieAerienne = volCompagnieAerienne;
		this.depart = depart;
		this.arrive = arrive;
	}
	
	public Vol() {
		super();
	}
	
	public List<Billet> getBillet() {
		return billet;
	}

	public void setBillet(List<Billet> billet) {
		this.billet = billet;
	}

	public List<CompagnieAerienneVol> getVolCompagnieAerienne() {
		return volCompagnieAerienne;
	}

	public void setVolCompagnieAerienne(List<CompagnieAerienneVol> volCompagnieAerienne) {
		this.volCompagnieAerienne = volCompagnieAerienne;
	}

	public Aeroport getDepart() {
		return depart;
	}

	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}

	public Aeroport getArrive() {
		return arrive;
	}

	public void setArrive(Aeroport arrive) {
		this.arrive = arrive;
	}

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