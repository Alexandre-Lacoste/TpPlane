package model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Adresse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="street")
	private String rue;
	@Column(name="complement")
	private String complement;
	@Column(name="codePostal")
	private String codePostal;
	@Column(name="city")
	private String ville;
	@Column(name="pays")
	private String pays;
	@OneToMany(mappedBy="addresses")
	@Column(name="Customer")
	private List<Client> clients = new ArrayList<Client>();
	
	
	
	public Adresse(Long id, String rue, String complement, String codePostal, String ville, String pays) {
		super();
		this.id = id;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	
	public Adresse() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", complement=" + complement + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", pays=" + pays + "]";
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	
}
