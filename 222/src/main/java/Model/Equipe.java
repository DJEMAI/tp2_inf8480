package Model;

import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.Order;

@Entity
@Table(name="equipe")
public class Equipe {
	@Id
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "datecreation")
	private Date dateCreation;
	
	@Column(name = "departement")
	private String departement;
	
	@Column(name = "responsable")
	private String responsable;
	
	@Column(name = "nbrProjets")
	private Integer nbrProjets;
	
	public String getName() {
		return nom;
	}
	
	public Date getCreationDate() {
		return dateCreation;
	}
	
	public String getDepartement() {
		return departement;
	}
	
	public String getResponsable() {
		return responsable;
	}
	
	public Integer getNbrProjets() {
		return nbrProjets;
	}
	
	public void setName(String name) {
		nom = name;
	}
	
	public void setCreationDate(Date date) {
		dateCreation = date;
	}
	
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public void setNbrProjets(Integer nbrProjets) {
		this.nbrProjets = nbrProjets;
	}
	
}
