package com.jpa;


import java.util.Date;
import java.util.List;
import Persistence.PersArticle;
import Persistence.PersDepartement;
import Persistence.PersChercheur;
import Persistence.PersEquipe;


import Model.Departement;
import Model.Equipe;
import Model.Chercheur;
import Model.Article;


public class Main
{
    public static void main( String[] args )
    {
    	PersDepartement departement = new PersDepartement();
    	PersEquipe equipe = new PersEquipe();
    	PersChercheur chercheur = new PersChercheur();
    	PersArticle article = new PersArticle();
    	
    	departement.setUp();
    	equipe.setUp();
    	chercheur.setUp();
    	article.setUp();
    
    	//requeteA
    	System.out.println("Requete 1");
    	Departement requestA = departement.read("Informatique");
    	System.out.println(requestA.getName()+", "+ requestA.getCreationDate() + 
    			", " + requestA.getAdresse() + 
    			", " + requestA.getTelephone());
    	
    
    	
    	System.out.println();
		System.out.println();

		
		
    	//requeteB
    	System.out.println("Requete 2");
    	List<Chercheur> requestB = chercheur.selectAll();
		for (int i = 0 ; i < requestB.size(); i++) {
			System.out.println(requestB.get(i).getPrenom() + " "+requestB.get(i).getName());
		}
		
		
		System.out.println();
		System.out.println();

		
		//requeteC
		System.out.println("Requete 3");
		List<Chercheur> requestC = chercheur.selectAll();
		for (int i = 0 ; i < requestC.size(); i++) {
			List<Article> tmp = article.selectByMatricule(requestC.get(i).getMatricule());
			System.out.print(requestC.get(i).getPrenom() + " "+requestC.get(i).getName()+": ");
			for(int j = 0; j <  tmp.size(); j++) {
				System.out.print(tmp.get(j).getCoauteur()+", "+tmp.get(j).getDepartement()+", "+tmp.get(j).getSoumisLe());
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		//requeteD
		System.out.println("Requete 4");
		Chercheur requestD = chercheur.read("M22556");
		List<Article> requestD2 = article.selectByMatricule(requestD.getMatricule());
		System.out.println(requestD.getPrenom() + " "+requestD.getName() + ": ");
		for (int i = 0; i < requestD2.size();i++) {
			System.out.println(requestD2.get(i).getCoauteur()+", "+requestD2.get(i).getDepartement()+", "+requestD2.get(i).getSoumisLe());
		}
		
		//requeteE
		article.deleteWithDepartement("Mathematiques");
		
		//requeteF
		Article requestF = article.findByDate("2007-05-16");
		article.delete(requestF);
		Chercheur requestF2 = chercheur.read(requestF.getAuteur());
		chercheur.delete(requestF2);
		
		//requeteG
		Departement requestG = departement.read("Physique");
		requestG.setAdresse("Quebec");
		departement.update(requestG);
		
		//requeteH
		List<Equipe> requestH = equipe.selectAllOnDepartement("Mathematiques");
		for(int j = 0 ; j<requestH.size();j++) {
			List<Chercheur> requestH2 = chercheur.selectAllByEquipe(requestH.get(j).getName());
			for( int i = 0; i< requestH2.size();i++) {
				requestH2.get(i).setPostion("postdoc");
				chercheur.update(requestH2.get(i));
			}
		}
		//requeteI
		Departement newDepartement= new Departement();
		newDepartement.setAdresse("Gaspesie");
		newDepartement.setCreationDate(new Date(2018,03,01));
		newDepartement.setName("Medecine");
		newDepartement.setTelephone("514-512-4569");
		departement.update(newDepartement);
		
		//requeteJ
		Equipe newEquipe = new Equipe();
		newEquipe.setCreationDate(new Date(2018,03,01));
		newEquipe.setDepartement("Medecine");
		newEquipe.setNbrProjets(0);
		newEquipe.setName("Pediatre");
		newEquipe.setResponsable("SSGSS");
		equipe.update(newEquipe);
    	
		
		departement.close();
		article.close();
		chercheur.close();
		equipe.close();
    }
}
