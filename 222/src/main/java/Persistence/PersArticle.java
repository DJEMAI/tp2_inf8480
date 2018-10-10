package Persistence;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Article;

public class PersArticle {

	private static EntityManagerFactory managerFactory = null;
	static EntityManager manager = null;

	public void setUp() {
		if(managerFactory == null)
			managerFactory = Persistence.createEntityManagerFactory("TP5");
	
		if(manager == null)
			manager = managerFactory.createEntityManager();
		
	}
	
	public Article read(String matricule) {
		return manager.find(Article.class, matricule);
	}
	
	public Article findByDate(String date) {
		Query query = manager.createQuery("select a from Article a where soumisLe = '" 
	+ date + "'");
	return (Article) query.getSingleResult();
		
	}
	
	public List<Article> selectAll(){
		Query query = manager.createQuery("select a from Article a");
		return query.getResultList();
	}
	
	public List<Article> selectByMatricule(String matricule) {
		Query query = manager.createQuery("select a from Article a where auteur = '" 
	+ matricule + "'");
		return query.getResultList();
	}
	
	public void delete(Article article) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.remove(article);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	
	public void deleteWithDepartement(String departement) {
		Query query = manager.createQuery("select a from Article a where departement = '"+ departement+"'");
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.remove(query.getSingleResult());
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}
	
}
