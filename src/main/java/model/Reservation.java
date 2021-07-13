package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name="DateReservation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtReservation;
	
	@Column(name="confirme")
	private StatutReservation confirme;
	
	@OneToMany(mappedBy="reservation")
	private List<Billet> billet;
	
	@OneToOne
	@JoinColumn(name="passager")
	private Passager passager;
	@ManyToOne
	@JoinColumn(name="client_ID")
	private Client client;

	
	//@ManyToOne
	// @JoinColumn(name="client")
	// private Client client;

	public Reservation()
	{
		super();
	}

	public Reservation(Long id, Integer numero, Date dtReservation, StatutReservation confirme) {
		super();
		this.id = id;
		this.numero = numero;
		this.dtReservation = dtReservation;
		this.confirme = confirme;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDtReservation() {
		return dtReservation;
	}

	public void setDtReservation(Date dtReservation) {
		this.dtReservation = dtReservation;
	}

	public StatutReservation getConfirme() {
		return confirme;
	}

	public void setConfirme(StatutReservation confirme) {
		this.confirme = confirme;
	}
	
	
	
}
