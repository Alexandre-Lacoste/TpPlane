package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("company")
public class Entreprise extends Client {
	@Column(name="siret",length=100)
	private String siret;
	@Column(name="numTva",length=100)
	private String numeroTva;
	@Enumerated(EnumType.STRING)
	@Column(name="legaStatus",length=20)
	private StatutJuridique statutJuridique;
	
	public Entreprise(int id, String nom, String siret, String numeroTva, StatutJuridique statutJuridique) {
		super(id, nom);
		this.siret = siret;
		this.numeroTva = numeroTva;
		this.statutJuridique = statutJuridique;
	}
	public Entreprise() {
		super();
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getNumeroTva() {
		return numeroTva;
	}
	public void setNumeroTva(String numeroTva) {
		this.numeroTva = numeroTva;
	}
	public StatutJuridique getStatutJuridique() {
		return statutJuridique;
	}
	public void setStatutJuridique(StatutJuridique statutJuridique) {
		this.statutJuridique = statutJuridique;
	}
	@Override
	public String toString() {
		return "Entreprise [siret=" + siret + ", numeroTva=" + numeroTva + ", statutJuridique=" + statutJuridique + "]";
	}
	
	
	
}
