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
@Table(name="article")
public class Article {
	@Id
	@Column(name = "auteur")
	private String auteur;
	
	@Column(name = "coauteur")
	private String coauteur;
	
	@Column(name = "soumisLe")
	private Date soumisLe;
	
	@Column(name = "departement")
	private String departement;
	
	
	public String getAuteur() {
		return auteur;
	}
	
	public String getCoauteur() {
		return coauteur;
	}
	
	public Date getSoumisLe() {
		return soumisLe;
	}
	
	public String getDepartement() {
		return departement;
	}
	
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public void setCoauteur(String coauteur) {
		this.coauteur = coauteur;
	}
	
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	
}
