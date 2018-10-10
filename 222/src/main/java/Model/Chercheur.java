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
@Table(name="chercheur")
public class Chercheur {
	@Id
	@Column(name = "matricule")
	private String matricule;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "equipe")
	private String equipe;
	
	@Column(name = "salaire")
	private Integer salaire;
	
	
	public String getMatricule() {
		return matricule;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	
	public String getName() {
		return nom;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String getEquipe() {
		return equipe;
	}
	
	public Integer getSalaire() {
		return salaire;
	}
	
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public void setName(String name) {
		nom = name;
	}
	
	public void setPostion(String position) {
		this.position = position;
	}
	
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}
	
	
}
