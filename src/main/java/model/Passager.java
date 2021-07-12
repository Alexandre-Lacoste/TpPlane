package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passager")
public class Passager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="numeroID")
	private String numeroIdentite;
	
	@Column(name="typeIdentite")
	private TypeIdentite TypeIdentite;
	
	@OneToOne(mappedBy = "passager")
	private Reservation reservation;

	public Passager()
	{
		super();
	}

	public Passager(Long id, String nom, String prenom, String numeroIdentite, model.TypeIdentite typeIdentite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroIdentite = numeroIdentite;
		TypeIdentite = typeIdentite;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumeroIdentite() {
		return numeroIdentite;
	}

	public void setNumeroIdentite(String numeroIdentite) {
		this.numeroIdentite = numeroIdentite;
	}

	public TypeIdentite getTypeIdentite() {
		return TypeIdentite;
	}

	public void setTypeIdentite(TypeIdentite typeIdentite) {
		TypeIdentite = typeIdentite;
	}
	
	
}
