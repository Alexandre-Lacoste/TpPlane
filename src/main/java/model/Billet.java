package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Billet")
public class Billet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numeroPlace")
	private String numeroPlace;
	
	@Column(name="classe")
	private String classe;
	
	@Column(name="prix")
	private float prix;
	
	@ManyToOne
	@JoinColumn(name="reservationVol_id")
	private Reservation reservation = new Reservation();

	@ManyToOne
	@JoinColumn(name="billetReservation_id")
	private Vol vols = new Vol();

	
	public Billet()
	{
		super();
	}
	
	public Billet(Long id, String numeroPlace, String classe, float prix) {
		super();
		this.id = id;
		this.numeroPlace = numeroPlace;
		this.classe = classe;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPlace() {
		return numeroPlace;
	}

	public void setNumeroPlace(String numeroPlace) {
		this.numeroPlace = numeroPlace;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
}
