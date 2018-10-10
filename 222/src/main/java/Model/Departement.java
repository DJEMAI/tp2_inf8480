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
@Table(name="departement")
public class Departement {
	@Id
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "datecreation")
	private Date dateCreation;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "telephone")
	private String telephone;
	
	public String getName() {
		return nom;
	}
	
	public Date getCreationDate() {
		return dateCreation;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setName(String name) {
		nom = name;
	}
	
	public void setCreationDate(Date date) {
		dateCreation = date;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
