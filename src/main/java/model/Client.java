package model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Customer")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String nom;
	@ManyToOne
	@JoinColumn(name="adress_Id")
	private Adresse addresses;
	@OneToMany(mappedBy="client")
	private List<Reservation> reservation;
	
	public Client(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Client() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAddresses() {
		return addresses;
	}

	public void setAddresses(Adresse addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", addresses=" + addresses + "]";
	}

	
	
	
}
