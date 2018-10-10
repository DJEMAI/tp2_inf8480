package Persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Chercheur;
import Model.Departement;
public class PersChercheur {

	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;

	public void setUp () {
		if (managerFactory == null) 
			managerFactory = Persistence.
					createEntityManagerFactory("TP5");
		
		if (manager == null) 
			manager = managerFactory.createEntityManager();
		
	}

	public Chercheur read (String matricule) {
		return manager.find(Chercheur.class, matricule);
	}
	public List<Chercheur> selectAll() {
		Query query = manager.createQuery("select c from Chercheur c");
		return query.getResultList();
	}
	public List<Chercheur> selectAllByEquipe(String equipe) {
		Query query = manager.createQuery("select c from Chercheur c where equipe = '" + equipe+"'");
		return query.getResultList();
	}
	
	public void deleteByMatricule(String matricule) {
		Query query = manager.createQuery("select c from Chercheur c where matricule = '" + matricule + "'");
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.remove(query.getSingleResult());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	public void delete(Chercheur chercheur) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.remove(chercheur);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	public void update(Chercheur chercheur) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(chercheur);
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